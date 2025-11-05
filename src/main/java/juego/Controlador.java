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
        actualizarTablero();
    }


    public void actualizarTablero() {
        tablero.actualizarTablero(juego,this);

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Casilla casilla = juego.getCasilla(fila, columna);
                CasillaUI casillaUI = new CasillaUI(casilla);

                int f = fila;
                int c = columna;

                casillaUI.setOnDescubrir(() -> {
                    boolean perdio = juego.descubrirCasilla(f, c);
                    if (perdio) {
                        juego.descubrirBombas();
                        tablero.ventanaPerder();
                    }
                    if(juego.getCasilla(f,c).getMinasAdyacentes()==0) {
                        juego.descubrirAlrededor(f, c);
                    }
                    actualizarTablero();

                    buscarVictoria();
                });

                tablero.agregarCasilla(casillaUI, fila, columna);
            }
        }
    }

    public void buscarVictoria() {
        if(juego.verificarTablero()){
            tablero.ventanaGanar();
        }
    }

    public Tablero  getTablero() {
        return tablero;
    }
}
