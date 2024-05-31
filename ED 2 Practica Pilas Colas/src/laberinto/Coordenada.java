package laberinto;

/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada() {
        this.fila = 0;
        this.columna = 0;
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean iguales(Coordenada coordenada) {
        return this.fila == coordenada.fila && this.columna == coordenada.columna;
    }

    public Coordenada derecha() {
        return new Coordenada(fila, columna + 1);
    }

    public Coordenada izquierda() {
        return new Coordenada(fila, columna - 1);
    }

    public Coordenada arriba() {
        return new Coordenada(fila - 1, columna);
    }

    public Coordenada abajo() {
        return new Coordenada(fila + 1, columna);
    }

    public String toString() {
        return"[" + fila + " , " + columna + "]";
    }

}
