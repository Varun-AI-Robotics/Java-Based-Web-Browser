package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class to handle database connections
public class DBUtil {

    // JDBC URL, username and password for the database connection
    private static final String URL = "jdbc:mysql://localhost:3306/browserdb";
    private static final String USER = "root";
    private static final String PASSWORD = "987765"; // Replace with actual password in production

    // Method to establish and return a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
