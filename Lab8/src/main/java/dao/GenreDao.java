//Hamza Eduard-Mihail, 2A4
package dao;

import model.Genre;

import java.sql.SQLException;

public interface GenreDao {
    public void add(Genre genre) throws SQLException;

    public Genre findById(int id) throws SQLException;

    public Genre findByName(String name) throws SQLException;
}
