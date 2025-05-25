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

public class SimpleWebBrowser extends Application {

    private WebView webView;
    private WebEngine webEngine;
    private TextField urlField;
    private HistoryDAO historyDAO = new HistoryDAO();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Web Browser");

        webView = new WebView();
        webEngine = webView.getEngine();

        urlField = new TextField("https://www.google.com");
        urlField.setPrefWidth(600);
        Button goButton = new Button("Go");
        Button backButton = new Button("<");
        Button forwardButton = new Button(">");
        Button refreshButton = new Button("⟳");

        HBox toolbar = new HBox(8, backButton, forwardButton, refreshButton, urlField, goButton);
        toolbar.setPadding(new Insets(10));
        toolbar.setStyle("-fx-background-color: #eeeeee;");

        goButton.setOnAction(e -> loadPage());
        urlField.setOnAction(e -> loadPage());

        backButton.setOnAction(e -> {
            WebHistory history = webEngine.getHistory();
            if (history.getCurrentIndex() > 0) history.go(-1);
        });

        forwardButton.setOnAction(e -> {
            WebHistory history = webEngine.getHistory();
            if (history.getCurrentIndex() < history.getEntries().size() - 1) history.go(1);
        });

        refreshButton.setOnAction(e -> webEngine.reload());

        loadPage();

        BorderPane layout = new BorderPane();
        layout.setTop(toolbar);
        layout.setCenter(webView);

        Scene scene = new Scene(layout, 1024, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadPage() {
        String url = urlField.getText().trim();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        webEngine.load(url);

        // Save to history in DB
        historyDAO.insertHistory(new HistoryEntry(url));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
