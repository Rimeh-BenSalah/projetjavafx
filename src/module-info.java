module ChessGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media; // pour les sons

    opens application to javafx.graphics, javafx.fxml;
    opens application.controller to javafx.fxml;
    opens application.model to javafx.fxml; // si tu utilises binding avec FXML
}