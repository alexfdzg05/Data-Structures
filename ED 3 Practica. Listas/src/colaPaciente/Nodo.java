/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package colaPaciente;

import general.Paciente;

public class Nodo {

    private Paciente dato;
    private Nodo siguiente;

    public Nodo(Paciente dato, Nodo sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente getPaciente() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }
}
