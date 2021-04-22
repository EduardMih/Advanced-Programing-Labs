package importtool;

import com.opencsv.CSVReader;
import model.Genre;
import model.Movie;
import model.Person;
import services.MovieServices;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ImportTool {
    private static MovieServices movieServices = new MovieServices();
    private final String filePath;

    public ImportTool(String filePath) {
        this.filePath = filePath;
    }

    public void importData() throws IOException, ParseException, SQLException
    {
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        List<String[]> lines = readLineByLine(reader);
        Movie movie;

        lines.remove(0);
        for(String[] line : lines)
        {
            movie = createMovie(line);

            movieServices.addMovie(movie);
        }

    }

    public List<String[]> readLineByLine(Reader reader) throws IOException
    {
        int i = 0;
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;

        while(((line = csvReader.readNext()) != null))
        {
            list.add(line);
            //System.out.println("->" + line[12]);
            i = i + 1;
        }

        reader.close();
        csvReader.close();

        return list;

    }

    private Movie createMovie(String[] line)
    {
        Integer duration;
        Float score;
        String title;
        Date releaseDate;
        List<Genre> genres = extractGenres(line);
        List<Person> actors = extractActors(line);
        List<Person> directors = extractDirectors(line);


        title = line[1];
        releaseDate = extractDate(line);
        duration = Integer.parseInt(line[6]);
        score = Float.parseFloat(line[14]);

        return new Movie(title, releaseDate, duration, score, genres, actors, directors);

    }

    private List<Person> extractActors(String[] line)
    {
        List<Person> actors = new ArrayList<>();
        String[] splitResult;
        line[12] = line[12].replace(", ", ",");
        splitResult = line[12].split(",");

        for(String actorName : splitResult)
        {
            actors.add(new Person(actorName));
        }

        return actors;

    }

    private List<Person> extractDirectors(String[] line)
    {
        List<Person> directors = new ArrayList<>();
        String[] splitResult;

        line[9] = line[9].replace(", ", ",");
        splitResult = line[9].split(",");

        for(String directorName : splitResult)
        {
            directors.add(new Person(directorName));
        }

        return directors;

    }

    private List<Genre>  extractGenres(String[] line)
    {
        List<Genre> genres = new ArrayList<>();
        String[] splitResult;
        line[5] = line[5].replace(" ", "");
        splitResult = line[5].split(",");

        for(String genreName : splitResult)
        {
            genres.add(new Genre(genreName));
        }

        return genres;

    }

    private Date extractDate(String[] line)
    {
        Date releaseDate = new Date();
        try
        {
            releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(line[4]);
        }
        catch (ParseException e)
        {
            try
            {
                releaseDate = new SimpleDateFormat("yyyy").parse(line[4]);
            }
            catch(ParseException e2)
            {
                releaseDate = null;
            }
        }

        return releaseDate;

    }

}
