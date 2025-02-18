module org.example.gallows {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.beans;
    requires java.annotation;
    requires spring.core;
    requires java.desktop;

    opens org.example.gallows to javafx.fxml, spring.core;
    exports org.example.gallows;
}