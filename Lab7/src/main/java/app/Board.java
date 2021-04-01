//Hamza Eduard-Mihail, 2A4
package app;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokens = new ArrayList<>();

    public Board(int nrOfTokens) {
        for (int i = 0; i < nrOfTokens; i++)
            for (int j = 0; j < nrOfTokens; j++) {
                tokens.add(new Token(i, j, (int) (Math.random() * 10)));
            }


    }

    public synchronized Token getToken(int index) throws IndexOutOfBoundsException {
        Token requested;

        requested = tokens.get(index);
        tokens.remove(index);

        return requested;

    }

    public boolean isEmpty() {

        return tokens.isEmpty();

    }

    @Override
    public String toString() {

        return "app.Board{" +
                "tokens=" + tokens +
                '}';

    }
}
