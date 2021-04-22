package dao;

import connection.DataBaseConection;
import model.Movie;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDirectorDaoImplementation implements MovieDirectorDao{
    public static final Connection conn = DataBaseConection.getConnection();
    @Override
    public void addMovieDirectors(Movie movie) throws SQLException
    {
        String sql = "INSERT INTO movie_directors VALUES(?, ?)";
        PreparedStatement psmt = conn.prepareStatement(sql);

        psmt.setInt(1, movie.getId());

        for (Person person : movie.getDirectors())
        {
            psmt.setInt(2, person.getId());
            psmt.executeUpdate();
        }
    }

    @Override
    public List<Person> getMovieDirectors(Integer movieId) throws SQLException
    {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM persons WHERE id IN (SELECT person_id FROM movie_directors WHERE movie_id = ?)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet result;

        psmt.setInt(1, movieId);
        result = psmt.executeQuery();

        while(result.next())
        {
            persons.add(new Person(result.getInt("id"), result.getString("name")));
        }

        return persons;

    }
}
