//Hamza Eduard-Mihail, 2A4
package Entities;

import java.util.List;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    @Override
    public String toString() {

        return "Student{" +
                "name='" + name + '\'' +
                '}';

    }
}
