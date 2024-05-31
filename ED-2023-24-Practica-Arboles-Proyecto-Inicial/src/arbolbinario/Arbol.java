package arbolbinario;

import java.util.Stack;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(String dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(String dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------
    // TODO 2.3
    public Arbol(String[] reglas) {
        raiz = new NodoArbol("S");
        NodoArbol nodo = raiz;
        int numNoTerminales = 0;
        Cola colaNoTerminales = new Cola();
        colaNoTerminales.encolar(nodo);
        for (int i = 0; i < reglas.length; i++) {
            if (numNoTerminales!=-1) {
                if (!colaNoTerminales.vacia()) {
                    nodo = colaNoTerminales.desencolar();
                }
                numNoTerminales = aplicarRegla(nodo, reglas[i], colaNoTerminales, numNoTerminales);
            }
        }
        //Errores de ejecución:
        if (numNoTerminales == -1){
            raiz = null;
        }else {
            if (!colaNoTerminales.vacia()) {
                System.out.println("Error al construir el árbol: quedan símbolos no terminales sin expandir");
            }
        }
    }
    //Por lo que más o menos pillo dle constructor es que debería de crearme una cola de NoTerminales por aquí
    //después sería recorrer lo que es el arrayde reglas e ir construyendo el árbol.
    public boolean esParteIzquierdaDe(NodoArbol nodo, String regla){
        return Utilidades.getParteIzquierda(regla).equals(nodo.getDato());
    }
    public int aplicarReglaIntermedia(NodoArbol nodo, String regla, Cola colaNoTerminales, int numNoTerminales){
        String cadena = Utilidades.getParteDerecha(regla);
        String izq = cadena.split(" ")[0];
        String der = cadena.split(" ")[1];
        NodoArbol izquierdo = new NodoArbol(izq, null, null);
        NodoArbol derecho = new NodoArbol(der, null, null);
        nodo.setDerecho(derecho);
        nodo.setIzquierdo(izquierdo);
        colaNoTerminales.encolar(izquierdo);
        colaNoTerminales.encolar(derecho);
        numNoTerminales += 2;
        return numNoTerminales;
    }
    public int aplicarReglaFinal(NodoArbol nodo, String regla, int numNoTerminales){
        String terminal= Utilidades.getParteDerecha(regla);
        nodo.setIzquierdo(new NodoArbol(terminal));
        numNoTerminales -= 1;
        return numNoTerminales;
    }
    public int aplicarRegla(NodoArbol nodo, String regla, Cola colaNoTerminales, int numNoTerminales){
        if (esParteIzquierdaDe(nodo, regla)) {
            if (Utilidades.esReglaIntermedia(regla)) {
                numNoTerminales = aplicarReglaIntermedia(nodo, regla, colaNoTerminales, numNoTerminales);
            } else if (Utilidades.esReglaFinal(regla)) {
                numNoTerminales = aplicarReglaFinal(nodo, regla, numNoTerminales);
            } else {
                System.out.println("La regla " + regla + " no es parseable");
                return -1;
            }
        }else{
            System.out.println("Error al construir el árbol: La regla "+regla+" no se ha podido aplicar");
            numNoTerminales =-1;
        }
        return numNoTerminales;
    }

    // ------------------------------------------------------------------------
    // TODO 2.4
    public String[] generarDerivaciones() {
    return generarDerivaciones(raiz);
    }
    private String[] generarDerivaciones(NodoArbol nodo){
        String[] res;
        if (nodo==null){
            res = new String[]{};
        } else if (nodo.getDerecho() == null) {
            res = new String[]{String.format("%s->%s",nodo.getDato(),nodo.getIzquierdo().getDato())};
        }else {
            String[] resI = generarDerivaciones(nodo.getIzquierdo());
            String[] resD = generarDerivaciones(nodo.getDerecho());
            res = new String[resI.length + resD.length + 1];
            res[0] = String.format("%s->%s %s",nodo.getDato(), nodo.getIzquierdo().getDato(), nodo.getDerecho().getDato());
            for (int i = 0; i < resI.length; i++) {
                res[i+1] = resI[i];
            }
            for (int i = resI.length; i < resI.length + resD.length; i++) {
                res[i+1] = resD[i - resI.length];
            }
        }
        return res;
    }

    // ------------------------------------------------------------------------
    // TODO 2.5
    public String generarFrase() { //Es recorrerlo en preOrden y comprobar si un nodo no tiene hijos --> Entonces habrá que mostrarlo
        String frase = "";
        if (raiz!=null) {
            frase = generarFrase(raiz, "");
            String[] palabras = frase.split(" ");
            boolean esFrase = true;
            for (int i = 0; i < palabras.length; i++) {
                if (esFrase) {
                    esFrase = Utilidades.esSimboloTerminal(palabras[i]);
                }
            }
            if (!esFrase) {
                frase = "Frase mal construida, quedan símbolos No Terminales";
            }
        }
        return frase;
    }
    private String generarFrase(NodoArbol nodo, String resultado){
        if (nodo!=null){
            if (nodo.getDerecho() == null && nodo.getIzquierdo()==null){
                resultado = nodo.getDato()+" ";
            }
            resultado += generarFrase(nodo.getIzquierdo(),"") + generarFrase(nodo.getDerecho(),"");
        }
        return resultado;
    }


}
