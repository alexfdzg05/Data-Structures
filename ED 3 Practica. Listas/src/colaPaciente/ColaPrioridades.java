/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package colaPaciente;

import general.Paciente;

public class ColaPrioridades {
    private NodoPrioridad inicio;

    public ColaPrioridades() {
        inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    /** Inserta el paciente en la cola que le corresponde según su prioridad.
     * Si no hay ningún paciente con la misma prioridad, crea una cola nueva en la que mete al paciente.
     */
    public void encolar(int prioridad, Paciente paciente) {
        NodoPrioridad anterior, actual = inicio;
        anterior = null;
        while (actual!=null && actual.getClave() < prioridad){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        NodoPrioridad nuevo = new NodoPrioridad(prioridad,new Cola(),null);
        nuevo.getDato().encolar(paciente);
        if (inicio!=null) {
            if (actual == null) {
                anterior.setSiguiente(nuevo);
            } else if (actual.getClave() > prioridad && anterior != null) {
                nuevo.setSiguiente(actual);
                anterior.setSiguiente(nuevo);
            } else if (actual.getClave() > prioridad && anterior == null) {
                nuevo.setSiguiente(actual);
                inicio = nuevo;
            } else {
                actual.getDato().encolar(paciente);
            }
        }else{
            inicio = nuevo;
        }
    }

    /** Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
     * y si no la encuentra devuelve NULL.
     */
    public Paciente desencolar(){
        Paciente paciente = null;
        while (inicio != null && inicio.getDato().vacia()){
            inicio = inicio.getSiguiente();
        }
        if (inicio!=null){
            paciente = inicio.getDato().desencolar();
        }
        return paciente;
    }

    /** Visualizar todos los pacientes del hospital, ordenados por prioridad
     */
    public void mostrar() {
        NodoPrioridad actual = inicio;
        while (actual !=null){
            if (!actual.getDato().vacia()) {
                System.out.println("Prioridad " + actual.getClave() + ": ");
                actual.getDato().mostrar();
            }
                actual = actual.getSiguiente();
        }
    }
}


