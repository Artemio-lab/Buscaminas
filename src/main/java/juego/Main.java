package juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Controlador controlador = new Controlador(10, 10, 10); // filas, columnas, minas
        Scene scene = new Scene(controlador.getTablero().getGrid(), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/juego/estilos.css")).toExternalForm());
        primaryStage.setTitle("Mini-Buscaminas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}