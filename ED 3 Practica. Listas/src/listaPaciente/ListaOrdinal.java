/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package listaPaciente;

import general.Paciente;

class ListaOrdinal {

    private Nodo inicio, fin;
    private int numElementos;

    public ListaOrdinal() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    /** Inserta el dato en la última posición de la lista
     */
    public void insertar(int dato, Paciente paciente) {
        Nodo nuevo = new Nodo(dato, paciente, null);
        if (this.estaVacia()){
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }

    /** Inserta el dato en la posición indicada de la lista,
     *  si es posible.
     */
    public void insertar(int dato, Paciente paciente, int posicion) {
        Nodo nuevo, anterior;
        if ((posicion > numElementos) || (posicion < 0)) {
            System.out.println("No es posible la inserción del " + dato);
        } else {
            if (posicion == numElementos) {
                this.insertar(dato,paciente);
            } else {
                if (posicion == 0) {   // Insertar al principio
                    nuevo = new Nodo(dato, paciente, inicio);
                    inicio = nuevo;
                } else {  // Buscar posición de inserción.
                    anterior = inicio;
                    for (int i = 0; i < posicion - 1; i++) {
                        anterior = anterior.getSiguiente();
                    }
                    nuevo = new Nodo(dato, paciente, anterior.getSiguiente());
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
            }
        }
    }

    /** Busca el dato que ocupa la posición recibida como parámetro,
     * en caso de existir.
     */
    public Paciente get(int posicion) {
        Nodo aux = inicio;
        if ((posicion > numElementos - 1) || (posicion < 0)) {
            System.out.println("No existe la posición " + posicion);
            return null;
        } else {
            for (int i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }
        }
        return aux.getPaciente();
    }

    /** Borra el primer elemento de la lista cuyo dato coincide con el
     * parámetro recibido.
     */
    public void borrar(Paciente paciente) {
        Nodo actual = inicio;
        Nodo anterior = null;
        boolean borrado = false;
        while (actual != null && !borrado){
            if (actual.getPaciente() ==  paciente) {  // Borrar actual
                if (actual != inicio) {
                    anterior.setSiguiente(actual.getSiguiente());
                } else {
                    inicio = actual.getSiguiente();
                }
                if (actual == fin) {  // se borra el último
                    fin = anterior;
                }
                numElementos--;
                borrado = true;
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
    }

    /** Devuelve la primera posición en la que se encuentra el dato,
     * en caso de existir. En caso contrario, devuelve -1
     */

    public int posicion(Paciente paciente) {
        Nodo actual = inicio;
        int pos = 0;
        while (actual != null && actual.getPaciente() != paciente) {
            actual = actual.getSiguiente();
            pos++;
        }
        if (actual != null){
            return pos;
        } else {
            return -1;
        }
    }

    /** Determina si el dato recibido como parámetro existe en la lista.
     */
    public boolean contiene(Paciente paciente) {
        Iterador it = getIterador();
        boolean condicion = false;
        while (it.hasNext() && !condicion){
            Paciente paciente1 = it.next();
            if (paciente1.equals(paciente)){
                condicion = true;
            }
        }
        return condicion;
    }

    public int getNumElementos() {
         return numElementos;
    }

    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    public void borrarAltas(){
        System.out.println("DESPUÉS DE BORRAR LAS ALTAS: ");
        Nodo actual, anterior;
        actual = inicio;
        anterior = null;
        int contador = 0;
        while (actual!=null){
            if (actual.getPaciente().estaAlta() && contador == 0){
                while (actual!=null && actual.getPaciente().estaAlta()){
                    actual = actual.getSiguiente();
                }
                if (actual==null){
                    inicio = fin = null;
                }else{
                    inicio = actual;
                }
            }else if (actual.getPaciente().estaAlta()){
                while (actual!=null && actual.getPaciente().estaAlta()){
                    actual = actual.getSiguiente();
                }
                if (actual==null){
                    fin = anterior;
                }else{
                    anterior.setSiguiente(actual);
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
            contador++;
        }
    }

}
