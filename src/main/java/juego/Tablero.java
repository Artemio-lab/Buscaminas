package juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Tablero {
    private GridPane grid;
    private Juego juego;
    public Tablero(int filas, int columnas, int minas) {
        grid = new GridPane();
        juego = new Juego(filas, columnas, minas);
// TODO: Inicializar botones en el GridPane
        Button button = new Button();
        button.setPrefSize(50, 50);
        GridPane.setRowIndex(button, filas);
        GridPane.setColumnIndex(button, columnas);

        button.setGraphic("BombaConFondo.png");
        GridPane.setConstraints(label, 2, 0); // column=2 row=0

        grid.getChildren().addAll(button, label);


// TODO: Asignar eventos a cada botón
// TODO: Mostrar minas y número de minas adyacentes al hacer clic
    }
    public GridPane getGrid() { return grid; }
}