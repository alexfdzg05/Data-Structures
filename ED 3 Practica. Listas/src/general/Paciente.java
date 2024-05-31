/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package general;

public class Paciente {
    private String nombre;
    private EstadoPaciente estado;
    private String sintomas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.estado = EstadoPaciente.hospitalizado;
    }

    public Paciente(String nombre, String sintomas) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.estado = EstadoPaciente.hospitalizado;
    }

    public String getNombre() {
        return nombre;
    }


    public String getSintomas() {
        return sintomas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void darAlta() {
        estado = EstadoPaciente.alta;
    }

    public boolean estaAlta() {
        return estado == EstadoPaciente.alta;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ".  Síntomas: " + sintomas + ".  Estado: " + estado.name());
    }
}
