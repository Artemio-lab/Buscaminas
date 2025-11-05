package juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tablero {
    private GridPane grid;

    public Tablero(int filas, int columnas) {
        grid = new GridPane();
        grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    }

    public void limpiar() {
        grid.getChildren().clear();
    }

    public void actualizarTablero(Juego juego, Controlador controlador) {
        grid.getChildren().clear();

        for (int fila = 0; fila < grid.getRowCount(); fila++) {
            for (int columna = 0; columna < grid.getColumnCount(); columna++) {
                Casilla casilla = juego.getCasilla(fila, columna);
                CasillaUI casillaUI = new CasillaUI(casilla);

                int f = fila;
                int c = columna;

                casillaUI.setOnDescubrir(() -> {
                    juego.descubrirCasilla(f, c);
                    controlador.actualizarTablero();
                });

                grid.add(casillaUI, columna, fila);
            }
        }
    }

    public void ventanaPerder() {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("💀 Fin del juego");

        Label mensaje = new Label("Has perdido 😢");
        mensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: red;");

        Button btnCerrar = new Button("Intentar de nuevo");
        btnCerrar.setOnAction(e -> ventana.close());

        VBox layout = new VBox(15, mensaje, btnCerrar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2c2c2c; -fx-padding: 20;");

        Scene escena = new Scene(layout, 250, 150);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    public void ventanaGanar() {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Fin del juego");

        Label mensaje = new Label("Has ganado!!!!!!");
        mensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: #003cff;");

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> ventana.close());

        VBox layout = new VBox(15, mensaje, btnCerrar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2c2c2c; -fx-padding: 20;");

        Scene escena = new Scene(layout, 250, 150);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    public void agregarCasilla(CasillaUI casillaUI, int fila, int columna) {
        grid.add(casillaUI, columna, fila);
    }

    public GridPane getGrid() { return grid; }
}