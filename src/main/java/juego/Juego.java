package juego;

import java.util.Random;

public class Juego {
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] tablero; // matriz que representa el tablero
    public Juego(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        tablero = new Casilla[filas][columnas];
// TODO: Inicializar la matriz con objetos Casilla
        int bombas=0;
        for(int i =0; i<filas;i++) {
            for(int j=0;j<columnas;j++) {
                tablero[i][j] = new Casilla(i,j);
            }
        }
        Random rand = new Random();
        while(bombas<minas) {
            int filasRND = rand.nextInt(filas);
            int columnasRND = rand.nextInt(columnas);
            if(!tablero[filasRND][columnasRND].isMina()) {
                tablero[filasRND][columnasRND].setMina(true);
            }
        }
// TODO: Colocar minas aleatoriamente

// TODO: Calcular minas adyacentes para cada casilla
    }
    // TODO: Método para descubrir casilla
    public boolean descubrirCasilla(int f, int c) {
        return true; // placeholder
    }
    public Casilla[][] getTablero() { return tablero; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}