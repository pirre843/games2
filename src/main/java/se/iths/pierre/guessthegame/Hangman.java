package se.iths.pierre.guessthegame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Hangman implements GuessGame {


    private Set<Character> guesses;
    private int nGuess;
    private String[] words = {"kardemumma", "syltlök", "kanellbulle", "wasabi"};
    private String secret;
    private boolean finished = false;


    public static void main(String[] args) {


        showMenu();

        int choice = Integer.parseInt(IO.readln("Välj: "));

        if (choice == 1) {
            Hangman game = new Hangman();
            game.startGame();

        }
        if (choice == 2) {
            IO.println("Avsluta Spelet");
        }
    }

    public static void showMenu() {

        IO.println("Välkommen till Hangman");
        IO.println("Tryck 1: Starta Hangman");
        IO.println("Tryck 2: Avsluta Spelet");

    }


    public Hangman() {
        //välj secret word

        Random rand = new Random();
        guesses = new HashSet<>();
        secret = words[rand.nextInt(words.length)];
        nGuess = 0;

    }

    @Override
    public void startGame() {
        IO.println("Hangman startar");

        while (!finished) {
            String guess = IO.readln("gissa en bokstav: ");
            String resultat = makeGuess(guess);
            IO.println(resultat);
        }
    }


    @Override
    public String makeGuess(String guess) {

        char cGuess = guess.charAt(0);
        if (guesses.contains(cGuess)) {
            return "Allredy guesses that";
        }
        // kolla om gissning är gjord
        guesses.add(cGuess);
        String answer = "";
        finished = true;
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (guesses.contains(c)) {
                answer += c;

            } else {
                finished = false;
                answer += "_";

            }
        }
        //stoppa in gissning  Guess

        // generera svar secret med uttbytta tecken  om en gissning


        return answer;
    }

    @Override
    public boolean finished() {
        return finished;

    }

    @Override
    public String getInfo() {
        return "Hangman, guess char at a time!\n"
                + "_".repeat(secret.length());
    }

}
