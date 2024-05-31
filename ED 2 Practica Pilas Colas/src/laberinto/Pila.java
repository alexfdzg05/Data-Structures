package laberinto;
/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Pila {
    private Nodo cima;
    private int numElementos;

    public Pila() {
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    /**
     * Apila el dato en la cima de la pila
     */
    public void apilar(Coordenada coordenada) {
        Nodo nuevo = new Nodo(coordenada, cima);
        cima = nuevo;
        numElementos++;
    }

    /**
     * Elimina la cima de la pila si existe, y devuelve como
     * resultado dicho dato.
     */
    public Coordenada desapilar() {
        Coordenada valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    /**
     * Devuelve el número de elementos que contiene la pila
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Visualiza el contenido de la pila
     */
    public void mostrar() {
        Nodo aux = cima;
        System.out.println("Contenido de la pila:");
        while (aux != null) {
            System.out.println("["+aux.getDato().getFila()+","+aux.getDato().getColumna()+"]");
            aux = aux.getSiguiente();
        }
        System.out.println("FIN");
    }


}
	
