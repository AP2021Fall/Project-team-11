module com.example.projectteam11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectteam11 to javafx.fxml;
    exports com.example.projectteam11;
}