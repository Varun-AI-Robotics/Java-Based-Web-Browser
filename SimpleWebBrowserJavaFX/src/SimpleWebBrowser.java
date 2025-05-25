import dao.HistoryDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.HistoryEntry;

// Main class for the JavaFX web browser application
public class SimpleWebBrowser extends Application {

    // UI components and DAO
    private WebView webView;
    private WebEngine webEngine;
    private TextField urlField;
    private HistoryDAO historyDAO = new HistoryDAO();

    // JavaFX entry point
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Web Browser"); // Set window title

        webView = new WebView();               // WebView to display web content
        webEngine = webView.getEngine();       // Engine to control WebView

        urlField = new TextField("https://www.google.com"); // URL input field
        urlField.setPrefWidth(600);                        // Set preferred width

        // Navigation and control buttons
        Button goButton = new Button("Go");
        Button backButton = new Button("<");
        Button forwardButton = new Button(">");
        Button refreshButton = new Button("⟳");

        // Create toolbar with navigation controls
        HBox toolbar = new HBox(8, backButton, forwardButton, refreshButton, urlField, goButton);
        toolbar.setPadding(new Insets(10));                 // Add padding around toolbar
        toolbar.setStyle("-fx-background-color: #eeeeee;"); // Light background color

        // Load page when Go button or Enter key is pressed
        goButton.setOnAction(e -> loadPage());
        urlField.setOnAction(e -> loadPage());

        // Navigate back in browser history
        backButton.setOnAction(e -> {
            WebHistory history = webEngine.getHistory();
            if (history.getCurrentIndex() > 0) history.go(-1);
        });

        // Navigate forward in browser history
        forwardButton.setOnAction(e -> {
            WebHistory history = webEngine.getHistory();
            if (history.getCurrentIndex() < history.getEntries().size() - 1) history.go(1);
        });

        // Reload the current page
        refreshButton.setOnAction(e -> webEngine.reload());

        loadPage(); // Load initial page

        // Set up main layout with toolbar on top and WebView in center
        BorderPane layout = new BorderPane();
        layout.setTop(toolbar);
        layout.setCenter(webView);

        // Create and show the scene
        Scene scene = new Scene(layout, 1024, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to load a web page and save the URL in history
    private void loadPage() {
        String url = urlField.getText().trim();

        // Automatically prepend "https://" if not provided
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        webEngine.load(url); // Load the URL in the WebView

        // Save the visited URL in the history database
        historyDAO.insertHistory(new HistoryEntry(url));
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
