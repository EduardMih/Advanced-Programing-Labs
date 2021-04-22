package dao;

import model.Movie;
import model.Person;

import java.sql.SQLException;
import java.util.List;

public interface MovieActorsDao {
    void addMovieActors(Movie movie) throws SQLException;
    List<Person> getMovieActors(Integer movieId) throws SQLException;
}
