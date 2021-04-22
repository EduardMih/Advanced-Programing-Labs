//Hamza Eduard-Mihail, 2A4
package dao;

import connection.DataBaseConection;
import model.Movie;

import java.sql.*;

public class MovieDaoImplementation implements MovieDao {
    private static final Connection conn = DataBaseConection.getConnection();

    @Override
    public void add(Movie movie) throws SQLException {
        Integer id = 0;
        String sql = "INSERT INTO movies (title, release_date, duration, score) VALUES(?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet result;


        pstmt.setString(1, movie.getTitle());
        pstmt.setDate(2, new Date(movie.getReleaseDate().getTime()));
        pstmt.setInt(3, movie.getDuration());
        pstmt.setFloat(4, movie.getScore());

        pstmt.executeUpdate();
        result = pstmt.getGeneratedKeys();

        while(result.next())
        {
            id = result.getInt(1);
        }

        movie.setId(id);
    }

    @Override
    public Movie findById(int id) throws SQLException {
        String sql = "SELECT * FROM movies WHERE id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Movie movie = new Movie();
        ResultSet result;
        boolean exists = false;

        psmt.setInt(1, id);
        result = psmt.executeQuery();

        while (result.next()) {
            exists = true;
            putData(movie, result);
        }

        if(!exists)

            return null;

        return movie;

    }

    @Override
    public Movie findByName(String name) throws SQLException {
        String sql = "SELECT * FROM movies WHERE title = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Movie movie = new Movie();
        ResultSet result;
        boolean exists = false;

        psmt.setString(1, name);
        result = psmt.executeQuery();

        while (result.next()) {
            exists = true;
            putData(movie, result);
        }

        if(!exists)

            return null;

        return movie;

    }

    private void putData(Movie movie, ResultSet result) throws SQLException {
        movie.setId(result.getInt("id"));
        movie.setTitle(result.getString("title"));
        movie.setReleaseDate(result.getDate("release_date"));
        movie.setDuration(result.getInt("duration"));
        movie.setScore(result.getFloat("score"));
    }
}
