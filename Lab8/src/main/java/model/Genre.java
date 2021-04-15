//Hamza Eduard-Mihail, 2A4
package model;

public class Genre {
    private Integer id;
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "model.Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }
}
