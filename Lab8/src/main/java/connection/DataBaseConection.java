//Hamza Eduard-Mihail, 2A4
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {
    private static DataBaseConection singleton = null;
    private Connection conn = null;

    public DataBaseConection() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/cinema", "postgres", "eduard");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (singleton == null)
            singleton = new DataBaseConection();

        return singleton.conn;

    }

}
