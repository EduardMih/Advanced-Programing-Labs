package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persons", schema = "public", catalog = "cinema")
public class PersonEntity {
    private Integer id;
    private String name;
    private String birthName;
    private String spousesString;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
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

    @Basic
    @Column(name = "birth_name")
    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    @Basic
    @Column(name = "spouses_string")
    public String getSpousesString() {
        return spousesString;
    }

    public void setSpousesString(String spousesString) {
        this.spousesString = spousesString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birthName, that.birthName) && Objects.equals(spousesString, that.spousesString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthName, spousesString);
    }
}
