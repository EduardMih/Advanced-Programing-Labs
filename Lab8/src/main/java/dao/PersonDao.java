package dao;

import model.Person;

import java.sql.SQLException;

public interface PersonDao {
    public void add(Person person) throws SQLException;
    public Person findById(Integer id) throws SQLException;
    public Person findByName(String name) throws SQLException;


}
