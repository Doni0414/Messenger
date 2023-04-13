module com.example.hichat_v1_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hichat_v1_1 to javafx.fxml;
    exports com.example.hichat_v1_1;
}