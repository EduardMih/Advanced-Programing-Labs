//Hamza Eduard-Mihail, 2A4
package app;

import java.util.List;

public class Student {
    private String name;
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    public int getScore() {

        return score;

    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {

        return "Student{" +
                "name='" + name + '\'' +
                '}';

    }
}

