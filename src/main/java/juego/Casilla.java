package juego;

public class Casilla {
    private final int fila;
    private final int columna;
    private boolean mina;
    private boolean descubierta;
    private int minasAdyacentes;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        minasAdyacentes = 0;
        descubierta = false;
        mina=false;
    }

    // Getters y setters
    public boolean isMina() { return mina; }
    public void setMina(boolean mina) { this.mina = mina; }
    public boolean isDescubierta() { return descubierta; }
    public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }
    public int getMinasAdyacentes() { return minasAdyacentes; }
    public void setMinasAdyacentes(int minasAdyacentes) { this.minasAdyacentes = minasAdyacentes; }
    public void incrementarMinasAdyacentes() {minasAdyacentes++;}
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
}