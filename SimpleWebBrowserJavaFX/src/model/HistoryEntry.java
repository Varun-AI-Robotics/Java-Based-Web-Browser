package model;

import java.sql.Timestamp;

// Model class representing a single entry in the browser history
public class HistoryEntry {
    
    // URL of the visited website
    private String url;
    
    // Timestamp indicating when the website was visited
    private Timestamp visitedAt;

    // Constructor to initialize the history entry with a URL
    public HistoryEntry(String url) {
        this.url = url;
    }

    // Getter for the URL
    public String getUrl() {
        return url;
    }

    // Getter for the visitedAt timestamp
    public Timestamp getVisitedAt() {
        return visitedAt;
    }

    // Setter for the visitedAt timestamp
    public void setVisitedAt(Timestamp visitedAt) {
        this.visitedAt = visitedAt;
    }
}
