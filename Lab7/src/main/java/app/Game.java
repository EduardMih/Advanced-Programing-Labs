//Hamza Eduard-Mihail, 2A4
package app;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {

        return players;

    }

    public Board getBoard() {

        return board;

    }
}
