package se.iths.pierre.guessthegame;

public interface GuessGame {
    void startGame();

    String makeGuess(String guess);

    boolean finished();

    String getInfo();

}
