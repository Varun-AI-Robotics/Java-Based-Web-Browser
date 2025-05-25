package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.HistoryEntry;
import util.DBUtil;

// Data Access Object (DAO) class for interacting with the browser history table in the database
public class HistoryDAO {

    // Method to insert a history entry into the database
    public void insertHistory(HistoryEntry entry) {
        // SQL statement to insert a URL into the 'history' table
        String sql = "INSERT INTO history (url) VALUES (?)";
        
        // Use try-with-resources to automatically close database resources
        try (Connection conn = DBUtil.getConnection(); // Get a connection to the database
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare the SQL statement
            
            stmt.setString(1, entry.getUrl()); // Set the URL parameter in the SQL statement
            stmt.executeUpdate(); // Execute the SQL update to insert the record
            
        } catch (SQLException e) {
            // Print the stack trace if a database error occurs
            e.printStackTrace();
        }
    }
}
