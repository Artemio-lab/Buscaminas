package juego;

public class Controlador {
    private Juego juego;
    private Tablero tablero;
    private int filas;
    private int columnas;

    public Controlador(int filas, int columnas, int minas) {
        tablero = new Tablero(filas, columnas);
        juego = new Juego(filas, columnas, minas);
        this.filas = filas;
        this.columnas = columnas;
        llenarTablero();
    }

    public void llenarTablero() {
        for(int i =0; i<columnas; i++){
            for(int j =0; j<filas; j++){
                tablero.llenarGridPanel(juego.getCasilla(j,i));
            }
        }
    }

    public Tablero  getTablero() {
        return tablero;
    }
}
