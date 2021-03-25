//Hamza Eduard-Mihail, 2A4
package entries;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String location;

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {

        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {

        return location;

    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {

        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';

    }
}
