/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */
package listaPaciente;

import general.Paciente;

public class AplicacionLista {

    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Alberto", "Frecuentes mareos");
        Paciente paciente2 = new Paciente("Ana", "Infección resistente");
        Paciente paciente3 = new Paciente("Eva", "Problemas digestivos");
        Paciente paciente4 = new Paciente("Ernesto", "Problemas cardiovasculares");
        ListaOrdinal pacientes = new ListaOrdinal();
        pacientes.insertar(1, paciente1);
        pacientes.insertar(2, paciente2);
        pacientes.insertar(3, paciente3);
        pacientes.insertar(4, paciente4);
        paciente2.darAlta();
        paciente3.darAlta();
        System.out.println("PACIENTES DEL HOSPITAL: ");
        ver(pacientes);
        System.out.println("-------------------------");
        pacientes.borrarAltas();
        ver(pacientes);
        System.out.println("-------------------------");
        pacientes.insertar(2,paciente2);
        pacientes.insertar(3,paciente3);
        verAltas(pacientes);
        ListaOrdinal pacientesMareados = pacientesSintoma(pacientes, "mareo");
        System.out.println("PACIENTES CON MAREO: ");
        ver(pacientesMareados);
        System.out.println("-------------------------");
    }
    private static void verAltas(ListaOrdinal lista){
        Iterador it = lista.getIterador();
        System.out.println("PACIENTES EN ALTA: ");
        while (it.hasNext()){
            Paciente paciente = it.next();
            if (paciente.estaAlta()){
                paciente.mostrar();
            }
        }
        System.out.println("-------------------------");
    }
    private static ListaOrdinal pacientesSintoma(ListaOrdinal lista, String sintoma){
        Iterador it = lista.getIterador();
        ListaOrdinal resultado = new ListaOrdinal();
        int orden = 0;
        while (it.hasNext()){
            Paciente paciente = it.next();
            if (paciente.getSintomas().contains(sintoma)){
                resultado.insertar(orden, paciente);
                orden++;
            }
        }
        return resultado;
    }
    private static void ver(ListaOrdinal lista){
        Iterador it = lista.getIterador();
        while (it.hasNext()){
            Paciente paciente = it.next();
            paciente.mostrar();
        }
    }
}