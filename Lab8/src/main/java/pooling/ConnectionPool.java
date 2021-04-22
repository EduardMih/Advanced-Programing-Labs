package pooling;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ComboPooledDataSource conn = new ComboPooledDataSource();

    static
    {
        try
        {
            conn.setDriverClass("org.postgresql.Driver");
            conn.setJdbcUrl("jdbc:postgresql://localhost/cinema");
            conn.setUser("postgres");
            conn.setPassword("eduard");
        }
        catch(PropertyVetoException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException
    {

        return conn.getConnection();

    }
}
