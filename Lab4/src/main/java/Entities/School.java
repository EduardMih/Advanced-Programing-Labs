//Hamza Eduard-Mihail, 2A4
package Entities;

import java.util.List;
import java.util.Objects;

public class School implements Comparable<School>{
    private String name;

    public School(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    @Override
    public int compareTo(School o) {

        if(this.name == null)
            throw new NullPointerException("!!!School name is NULL");

        return this.name.compareTo(o.getName());

    }

    @Override
    public String toString() {

        return "School{" +
                "name='" + name + '\'' +
                '}';

    }
}

