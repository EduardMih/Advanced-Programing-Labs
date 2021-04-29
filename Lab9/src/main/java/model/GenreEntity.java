package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genres", schema = "public", catalog = "cinema")
public class GenreEntity {
    private Integer id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId()
    {

        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString()
    {

        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }
}
