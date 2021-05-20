package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="relationships")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person1_id")
    private int person1Id;
    @Column(name = "person2_id")
    private int person2Id;

    public Relationship() {
    }

    public Relationship(int person1Id, int person2Id) {
        this.person1Id = person1Id;
        this.person2Id = person2Id;
    }

    public int getId()
    {

        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson1Id()
    {

        return person1Id;

    }

    public void setPerson1Id(int person1Id) {
        this.person1Id = person1Id;
    }

    public int getPerson2Id()
    {

        return person2Id;

    }

    public void setPerson2Id(int person2Id) {
        this.person2Id = person2Id;
    }

    @Override
    public String toString()
    {

        return "Relationship{" +
                "id=" + id +
                ", person1Id=" + person1Id +
                ", person2Id=" + person2Id +
                '}';

    }
}
