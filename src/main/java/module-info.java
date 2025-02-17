module org.example.gallows {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.beans;
    requires java.annotation;
    requires spring.core;


    opens org.example.gallows to javafx.fxml;
    exports org.example.gallows;
}