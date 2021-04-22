//Hamza Eduard-Mihail, 2A4
package dao;

import connection.DataBaseConection;
import model.Genre;

import java.sql.*;

public class GenreDaoImplementation implements GenreDao {
    private static final Connection conn = DataBaseConection.getConnection();

    @Override
    public void add(Genre genre) throws SQLException {
        String sql = "INSERT INTO genres (name) VALUES( ? );";
        PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet result;

        psmt.setString(1, genre.getName());
        psmt.executeUpdate();

        result = psmt.getGeneratedKeys();

        while(result.next())
        {
            genre.setId(result.getInt(1));
        }
    }

    @Override
    public Genre findById(int id) throws SQLException {
        String sql = "SELECT * FROM genres WHERE id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Genre genre = new Genre();
        ResultSet result;

        psmt.setInt(1, id);
        result = psmt.executeQuery();

        while (result.next()) {
            genre.setId(result.getInt("id"));
            genre.setName(result.getString("name"));
        }

        return genre;

    }

    @Override
    public Genre findByName(String name) throws SQLException {
        String sql = "SELECT * FROM genres WHERE name = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Genre genre = new Genre();
        ResultSet result;

        psmt.setString(1, name);
        result = psmt.executeQuery();

        while (result.next()) {
            genre.setId(result.getInt("id"));
            genre.setName(result.getString("name"));
        }

        return genre;

    }
}
