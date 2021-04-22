package pooling;

import connection.DataBaseConection;
import model.Movie;
import services.MovieServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Request implements Runnable{
    private int id;

    public Request(int id) {
        this.id = id;
    }

    @Override
    public void run()
    {

        try
        {
            //Keep next line for connection pool, comment following line for experimenting with singleton
            Connection conn = ConnectionPool.getConnection();
            //Keep next line for singleton, comment for experimenting with connection pooling
            //Connection conn = DataBaseConection.getConnection();
            String sql = "SELECT * FROM movies WHERE id = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            Movie movie = new Movie();
            ResultSet result;
            boolean exists = false;

            psmt.setInt(1, (int) (Math.random() * 16000));
            result = psmt.executeQuery();

            while (result.next()) {
                exists = true;
                putData(movie, result);
            }

            System.out.println(id + " -> " + movie);
            //System.out.println(conn);

            //Keep this line only in the case of singleton
            conn.close();

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }



    }

    private void putData(Movie movie, ResultSet result) throws SQLException {
        movie.setId(result.getInt("id"));
        movie.setTitle(result.getString("title"));
        movie.setReleaseDate(result.getDate("release_date"));
        movie.setDuration(result.getInt("duration"));
        movie.setScore(result.getFloat("score"));
    }
}
