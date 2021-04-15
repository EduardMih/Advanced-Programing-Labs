//Hamza Eduard-Mihail, 2A4
package dao;

import model.Movie;

import java.sql.SQLException;

public interface MovieDao {
    public void add(Movie movie) throws SQLException;

    public Movie findById(int id) throws SQLException;

    public Movie findByName(String name) throws SQLException;

}
