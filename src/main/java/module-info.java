module com.example.javaefx_vecina {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaefx_vecina to javafx.fxml;
    exports com.example.javaefx_vecina;
}