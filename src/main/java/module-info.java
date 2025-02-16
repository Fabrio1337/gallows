module org.example.gallows {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gallows to javafx.fxml;
    exports org.example.gallows;
}