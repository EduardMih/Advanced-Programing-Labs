package services;

import dao.*;
import model.Genre;
import model.Movie;
import model.Person;

import java.sql.SQLException;
import java.util.List;

public class MovieServices {
    private static final MovieDao movieDao = new MovieDaoImplementation();
    private static final GenreDao genreDao = new GenreDaoImplementation();
    private static final MovieGenreDao movieGenreDao = new MovieGenreDaoImplementation();
    private static final PersonDao personDao = new PersonDaoImplementation();
    private static final MovieActorsDao movieActorsDao= new MovieActorsDaoImplementation();
    private static final MovieDirectorDao movieDirectorDao = new MovieDirectorDaoImplementation();

    public void addMovie(Movie movie) throws SQLException
    {
        movieDao.add(movie);
        setGenreIds(movie);
        movieGenreDao.addMovieGenres(movie);
        addMovieActors(movie);
        addMovieDirector(movie);
    }

    public Movie getMovieByName(String name) throws SQLException
    {
        Movie movie = new Movie();

        movie = movieDao.findByName(name);

        if(movie == null)

            return null;

        movie.setGenres(movieGenreDao.getMovieGenres(movie));
        movie.setActors(movieActorsDao.getMovieActors(movie.getId()));
        movie.setDirectors(movieDirectorDao.getMovieDirectors(movie.getId()));

        return movie;

    }

    public Movie getMovieById(Integer id) throws SQLException
    {
        Movie movie = new Movie();

        movie = movieDao.findById(id);

        if(movie == null)

            return null;

        movie.setGenres(movieGenreDao.getMovieGenres(movie));
        movie.setActors(movieActorsDao.getMovieActors(movie.getId()));
        movie.setDirectors(movieDirectorDao.getMovieDirectors(movie.getId()));

        return movie;

    }

    private void setGenreIds(Movie movie) throws SQLException
    {
        Integer genreId;
        for(Genre genre : movie.getGenres())
        {
            genreId = genreDao.findByName(genre.getName()).getId();

            if(genreId == null)
            {
                genreDao.add(genre);
            }

            else

                genre.setId(genreId);

        }
    }

    public void addMovieDirector(Movie movie) throws SQLException
    {
        setPersonsIds(movie.getDirectors());
        movieDirectorDao.addMovieDirectors(movie);
    }

    public void addMovieActors(Movie movie) throws SQLException
    {
        setPersonsIds(movie.getActors());
        movieActorsDao.addMovieActors(movie);

    }

    private void setPersonsIds(List<Person> persons) throws SQLException
    {
        Integer personId;
        for(Person person : persons)
        {
            personId = personDao.findByName(person.getName()).getId();

            if(personId == null)
                personDao.add(person);

            else

                person.setId(personId);

        }

    }
}
