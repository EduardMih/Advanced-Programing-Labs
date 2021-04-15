//Hamza Eduard-Mihail, 2A4
package app;

import dao.GenreDao;
import dao.GenreDaoImplementation;
import dao.MovieDao;
import dao.MovieDaoImplementation;
import model.Genre;
import model.Movie;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Journal", new Date(105, 5, 19), 110, (short) (5));
        Movie movie2, movie3;
        Genre genre = new Genre("Action");
        MovieDao movieDao = new MovieDaoImplementation();
        GenreDao genreDao = new GenreDaoImplementation();

        try {
            movieDao.add(movie);
            genreDao.add(genre);
            movie2 = movieDao.findById(3);
            movie3 = movieDao.findByName("Journal");
            System.out.println(movie2);
            System.out.println(movie3);
            System.out.println(genreDao.findById(1));
            System.out.println(genreDao.findByName("Action"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
