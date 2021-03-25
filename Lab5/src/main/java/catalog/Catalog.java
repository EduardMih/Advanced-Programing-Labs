//Hamza Eduard-Mihail, 2A4
package catalog;

import entries.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {

        return path;

    }

    public List<Item> getItems() {

        return items;

    }

    public void setPath(String path) {
        this.path = path;
    }

    public void add(Item item)
    {
        items.add(item);
    }

    public void list()
    {
        System.out.println("Catalog " + this.getName() + ":");
        items.stream()
                .forEach(System.out::println);
    }

    public Item findById(String id)
    {

        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }
}
