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
// TODO: Colocar minas aleatoriamente

        Random rand = new Random();
        while(bombas<minas) {
            int filasRND = rand.nextInt(filas);
            int columnasRND = rand.nextInt(columnas);
            if(!tablero[filasRND][columnasRND].isMina()) {
                tablero[filasRND][columnasRND].setMina(true);
                bombas++;
            }
        }

        for(int i =0; i<filas;i++) {
            for(int j=0;j<columnas;j++) {
                buscarMinas(tablero[i][j]);
                System.out.println(tablero[i][j].getMinasAdyacentes());
            }
        }

    }

    public void buscarMinas(Casilla casilla) {
        int fila = casilla.getFila();
        int columna = casilla.getColumna();

        if (casilla.isMina()) return;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int f = fila + i;
                int c = columna + j;
                if (f >= 0 && f < tablero.length && c >= 0 && c < tablero[0].length) {
                    Casilla vecina = tablero[f][c];
                    if (vecina != null && vecina.isMina()) {
                        casilla.incrementarMinasAdyacentes();
                    }
                }
            }
        }
    }

    public void descubrirAlrededor(int fila, int columna) {

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int f = fila + i;
                int c = columna + j;
                if (f >= 0 && f < tablero.length && c >= 0 && c < tablero[0].length) {
                    Casilla vecina = tablero[f][c];
                    if (vecina != null && !vecina.isMina()) {
                        if(vecina.getMinasAdyacentes()==0 && !vecina.isDescubierta()) {
                            vecina.setDescubierta(true);
                            descubrirAlrededor(vecina.getFila(), vecina.getColumna());
                        }else{
                            vecina.setDescubierta(true);
                        }
                    }
                }
            }
        }
    }

    public boolean verificarTablero(){
        int espaciosDescubiertos=0;
        for(int i =0; i<filas;i++) {
            for(int j =0; j<columnas;j++) {
                if(tablero[i][j].isDescubierta()) {
                    espaciosDescubiertos++;
                }
            }
        }

        if(espaciosDescubiertos==(this.filas*this.columnas)-this.minas){
            return true;
        }
        return false;
    }

    public void descubrirBombas(){
        for(int i =0; i<filas;i++) {
            for(int j =0; j<columnas;j++) {
                if(tablero[i][j].isMina()) {
                    tablero[i][j].setDescubierta(true);
                }
            }
        }
    }


    // TODO: Método para descubrir casilla
    public boolean descubrirCasilla(int f, int c) {
        tablero[f][c].setDescubierta(true);
        return tablero[f][c].isMina();
    }

    public Casilla getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public Casilla[][] getTablero() { return tablero; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}