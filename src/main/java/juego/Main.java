package juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Controlador controlador = new Controlador(5, 5, 8); // filas, columnas, minas
        Scene scene = new Scene(controlador.getTablero().getGrid(), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        primaryStage.setTitle("Mini-Buscaminas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}