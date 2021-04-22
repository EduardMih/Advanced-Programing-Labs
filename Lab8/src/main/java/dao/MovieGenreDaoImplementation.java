package dao;

import connection.DataBaseConection;
import model.Genre;
import model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieGenreDaoImplementation implements MovieGenreDao{
    private static final Connection conn = DataBaseConection.getConnection();

    @Override
    public List<Genre> getMovieGenres(Movie movie) throws SQLException
    {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genres WHERE id IN (SELECT genre_id FROM movie_genre WHERE movie_id = ?)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet result;

        psmt.setInt(1, movie.getId());
        result = psmt.executeQuery();

        while(result.next())
        {
            genres.add(new Genre(result.getInt("id"), result.getString("name")));
        }

        return genres;

    }

    @Override
    public void addMovieGenres(Movie movie) throws SQLException
    {
        String sql = "INSERT INTO movie_genre VALUES(?, ?)";
        PreparedStatement psmt = conn.prepareStatement(sql);

        psmt.setInt(1, movie.getId());

        for (Genre genre : movie.getGenres())
        {
            psmt.setInt(2, genre.getId());
            psmt.executeUpdate();
        }
    }
}
