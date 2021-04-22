package dao;

import model.Movie;
import model.Person;

import java.sql.SQLException;
import java.util.List;

public interface MovieDirectorDao {
    void addMovieDirectors(Movie movie) throws SQLException;
    List<Person> getMovieDirectors(Integer movieId) throws SQLException;

}
