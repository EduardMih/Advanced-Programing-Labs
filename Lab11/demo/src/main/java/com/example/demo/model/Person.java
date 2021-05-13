package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer age;
    private String name;

    public Person() {
    }

    public Person(int id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId()
    {

        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge()
    {

        return age;

    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName()
    {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';

    }
}
