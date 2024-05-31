/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package colaPaciente;

import general.Paciente;

public class AplicacionCola {

    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Alberto","Frecuentes mareos");
        Paciente paciente2 = new Paciente("Ana", "Infección resistente");
        Paciente paciente3 = new Paciente("Eva", "Problemas digestivos");
        Cola colaPacientes = new Cola();
        colaPacientes.encolar(paciente1);
        colaPacientes.encolar(paciente2);
        colaPacientes.encolar(paciente3);
        System.out.println("CONTENIDO DE LA COLA: ");
        colaPacientes.mostrar();
        while (!colaPacientes.vacia()){
            colaPacientes.desencolar();
        }
        System.out.println("CONTENIDO DE LA COLA: ");
        colaPacientes.mostrar();
        System.out.println();
        ColaPrioridades colaPacientesPrioridad = new ColaPrioridades();
        colaPacientesPrioridad.encolar(4,paciente1);
        colaPacientesPrioridad.encolar(2,paciente2);
        colaPacientesPrioridad.encolar(4, paciente3);
        colaPacientesPrioridad.mostrar();
        Paciente paciente = colaPacientesPrioridad.desencolar();
        System.out.println("PACIENTE ATENDIDO: ");
        paciente.mostrar();
        System.out.println("-------------------------");
        colaPacientesPrioridad.mostrar();
        Paciente paciente4 = new Paciente("Ernesto", "Problemas cardiovasculares");
        System.out.println("LLEGA ERNESTO CON PRIORIDAD 1");
        colaPacientesPrioridad.encolar(1,paciente4);
        colaPacientesPrioridad.mostrar();
    }

}

