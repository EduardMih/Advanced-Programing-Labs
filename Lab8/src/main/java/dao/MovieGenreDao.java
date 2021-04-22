package dao;

import model.Genre;
import model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieGenreDao {
    List<Genre> getMovieGenres(Movie movie) throws SQLException;
    void addMovieGenres(Movie movie) throws SQLException;
}
