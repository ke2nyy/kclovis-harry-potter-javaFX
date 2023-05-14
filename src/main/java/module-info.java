module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.isep to javafx.fxml;
    exports com.isep;
}