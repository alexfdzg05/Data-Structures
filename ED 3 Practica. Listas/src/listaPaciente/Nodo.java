/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package listaPaciente;


import general.Paciente;

class Nodo {

    private Paciente paciente;
    private Nodo siguiente;

    public Nodo(int dato, Paciente paciente, Nodo siguiente) {
        this.siguiente = siguiente;
        this.paciente = paciente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
