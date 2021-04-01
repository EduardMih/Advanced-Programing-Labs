package app;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private Game game;
    private String name;
    private List<Token> tokens = new ArrayList<>();


    public Player(Game game) {
        this.game = game;
    }

    public void play() {
        Token extracted;

        while (!game.getBoard().isEmpty()) {
            try {
                extracted = game.getBoard().getToken(0);
                tokens.add(extracted);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    @Override
    public void run() {
        play();
    }


    public int getNrOfTokens() {

        return tokens.size();

    }


    @Override
    public String toString() {

        return "app.Player{" +
                "name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';

    }
}
