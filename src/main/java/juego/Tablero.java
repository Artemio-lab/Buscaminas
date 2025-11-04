package juego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class Tablero {
    private GridPane grid;

    public Tablero(int filas, int columnas) {
        grid = new GridPane();
        grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
// TODO: Inicializar botones en el GridPane
// TODO: Asignar eventos a cada botón
// TODO: Mostrar minas y número de minas adyacentes al hacer clic
    }

    public void llenarGridPanel(Casilla casilla) {
        CasillaUI casillaUI = new CasillaUI(casilla);
        grid.add(casillaUI, casilla.getColumna(), casilla.getFila());
    }
    public GridPane getGrid() { return grid; }
}