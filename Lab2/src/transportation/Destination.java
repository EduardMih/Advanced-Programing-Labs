//Hamza Eduard-Mihail, 2A4
package transportation;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Objects;

public class Destination {
    private String name;

    public Destination() {
    }

    public Destination(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("!!! NULL argument");
        this.name = name;
    }

    @Override
    public String toString() {

        return "Destination{" +
                "name='" + name + '\'' +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
