package dao;

import connection.DataBaseConection;
import model.Movie;
import model.Person;

import java.sql.*;

public class PersonDaoImplementation implements PersonDao{
    private static final Connection conn = DataBaseConection.getConnection();
    @Override
    public void add(Person person) throws SQLException
    {
        String sql = "INSERT INTO persons (name) VALUES(?);";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet result;


        pstmt.setString(1, person.getName());

        pstmt.executeUpdate();
        result = pstmt.getGeneratedKeys();

        while(result.next())
        {
            person.setId(result.getInt(1));
        }
    }

    @Override
    public Person findById(Integer id) throws SQLException
    {
        String sql = "SELECT * FROM persons WHERE id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Person person = new Person();
        ResultSet result;

        psmt.setInt(1, id);
        result = psmt.executeQuery();

        while (result.next()) {
            person.setId(result.getInt(1));
            person.setName(result.getString(2));
        }

        return person;



    }

    @Override
    public Person findByName(String name) throws SQLException
    {
        String sql = "SELECT * FROM persons WHERE name = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        Person person = new Person();
        ResultSet result;

        psmt.setString(1, name);
        result = psmt.executeQuery();

        while (result.next()) {
            person.setId(result.getInt(1));
            person.setName(result.getString(2));
        }

        return person;

    }
}

