module com.example.buscaminas {
    requires javafx.controls;
    requires javafx.fxml;


    opens juego to javafx.fxml;
    exports juego;
}