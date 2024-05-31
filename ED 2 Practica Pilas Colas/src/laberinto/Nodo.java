package laberinto;
/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Nodo {

    private Coordenada coordenada;
    private Nodo siguiente;

    public Nodo(Coordenada coordenada, Nodo siguiente) {
        this.coordenada = coordenada;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Coordenada getDato() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

}

