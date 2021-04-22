/*package services;

import dao.*;
import model.Movie;
import model.Person;

import java.sql.SQLException;
import java.time.Period;
import java.util.List;

public class MovieCrewService {
    private static final PersonDao personDao = new PersonDaoImplementation();
    private static final MovieActorsDao movieActorsDao= new MovieActorsDaoImplementation();
    private static final MovieDirectorDao movieDirectorDao = new MovieDirectorDaoImplementation();

    public void addMovieDirector(Movie movie, List<Person> directors) throws SQLException
    {
        setPersonsIds(directors);
        movieDirectorDao.addMovieDirectors(movie, directors);
    }

    public void addMovieActors(Movie movie, List<Person> actors) throws SQLException
    {
        setPersonsIds(actors);
        movieActorsDao.addMovieActors(movie, actors);

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

}*/
