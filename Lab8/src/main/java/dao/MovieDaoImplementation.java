//Hamza Eduard-Mihail, 2A4
package dao;

import connection.DataBaseConection;
import model.Movie;

import java.sql.*;

public class MovieDaoImplementation implements MovieDao {

    private static final Connection conn = DataBaseConection.getConnection();

    @Override
    public void add(Movie movie) throws SQLException {
        String sql = "INSERT INTO movies (title, release_date, duration, score) VALUES(?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, movie.getTitle());
        pstmt.setDate(2, new Date(movie.getReleaseDate().getTime()));
        pstmt.setInt(3, movie.getDuration());
        pstmt.setShort(4, movie.getScore());

        pstmt.executeUpdate();

    }

    @Override
    public Movie findById(int id) throws SQLException {
        String sql = "SELECT * FROM movies WHERE id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Movie movie = new Movie();
        ResultSet result;

        psmt.setInt(1, id);
        result = psmt.executeQuery();

        while (result.next()) {
            putData(movie, result);
        }

        return movie;

    }

    @Override
    public Movie findByName(String name) throws SQLException {
        String sql = "SELECT * FROM movies WHERE title = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Movie movie = new Movie();
        ResultSet result;

        psmt.setString(1, name);
        result = psmt.executeQuery();

        while (result.next()) {
            putData(movie, result);
        }

        return movie;

    }

    private void putData(Movie movie, ResultSet result) throws SQLException {
        movie.setId(result.getInt("id"));
        movie.setTitle(result.getString("title"));
        movie.setReleaseDate(result.getDate("release_date"));
        movie.setDuration(result.getInt("duration"));
        movie.setScore(result.getShort("score"));
    }
}
