//Hamza Eduard-Mihail, 2A4
package app;

public class School implements Comparable<School>{
    private String name;
    private int capacity;

    public School(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    public int getCapacity() {

        return capacity;

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
