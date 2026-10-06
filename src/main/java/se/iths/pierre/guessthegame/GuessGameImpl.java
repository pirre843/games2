package se.iths.pierre.guessthegame;

import java.util.Random;

public class GuessGameImpl implements GuessGame {


    @Override
    public void startGame() {
        IO.println("Starta spelet");


        Random random = new Random();
        int nummer = random.nextInt(10) + 1;


        IO.readln("Gissa nummer mellan 1 och 10: ");

        int gissning = Integer.parseInt(IO.readln("Gissa nummer mellan 1 och 10: "));
        if (gissning == nummer) {
            IO.println("Det stämmer;)");
        } else {
            IO.println("Det var fel nummer: " + nummer);

        }

    }

    @Override
    public String makeGuess(String guess) {
        return "";
    }

    @Override
    public boolean finished() {
        return false;
    }

    @Override
    public String getInfo() {
        return "";
    }

    public boolean checkGuess(int guess) {
        return guess == 5;

    }
}


//void main() {
//}



