//Hamza Eduard-Mihail, 2A4
package app;

import dao.*;
import freemarker.template.TemplateException;
import importtool.ImportTool;
import model.Genre;
import model.Movie;
import model.Person;
import raport.HtmlRaportGenerator;
import services.MovieServices;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Movie movie = new Movie("Journal", new Date(105, 5, 19), 110, (float) (5), Arrays.asList(new Genre("Action"), new Genre("Comedy")));
        Movie movie2, movie3;
        Person person = new Person("John");
        PersonDao personDao = new PersonDaoImplementation();
        Genre genre = new Genre("Action");
        MovieDao movieDao = new MovieDaoImplementation();
        GenreDao genreDao = new GenreDaoImplementation();
        MovieServices movieServices = new MovieServices();

        try
        {
            movieServices.addMovie(movie);
            personDao.add(person);
            System.out.println(personDao.findByName("Charles Tait"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

        ImportTool importTool = new ImportTool("IMDb movies.csv");
        MovieServices movieServices = new MovieServices();
        HtmlRaportGenerator htmlRaportGenerator = new HtmlRaportGenerator();

        try
        {
            importTool.importData();
            System.out.println(movieServices.getMovieByName("Cl"));
            htmlRaportGenerator.generateMovieReport(movieServices.getMovieByName("Cleopatra"));
        }
        catch(SQLException | ParseException | IOException | TemplateException | URISyntaxException e)
        {
            System.out.println(e.getMessage());
        }



    }
}
