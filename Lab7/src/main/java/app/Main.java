//Hamza Eduard-Mihail, 2A4
package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        Game game = new Game(board);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            game.addPlayer(new Player(game));
        }

        for (Player player : game.getPlayers()) {
            threads.add(new Thread(player));
        }

        for (Thread thread : threads)
            thread.start();

        for (Thread thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }

        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }

    }
}
