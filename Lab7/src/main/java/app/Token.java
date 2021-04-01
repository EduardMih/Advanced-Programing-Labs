//Hamza Eduard-Mihail, 2A4
package app;

import javafx.util.Pair;

public class Token {
    private int left;
    private int right;
    private int value;

    public Token(int left, int right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getLeft() {

        return left;

    }

    public int getRight() {

        return right;

    }

    public int getValue() {

        return value;

    }

    @Override
    public String toString() {
        return "app.Token{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
