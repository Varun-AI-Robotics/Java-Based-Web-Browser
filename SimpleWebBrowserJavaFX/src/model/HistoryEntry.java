package model;

import java.sql.Timestamp;

public class HistoryEntry {
    private String url;
    private Timestamp visitedAt;

    public HistoryEntry(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Timestamp getVisitedAt() {
        return visitedAt;
    }

    public void setVisitedAt(Timestamp visitedAt) {
        this.visitedAt = visitedAt;
    }
}
