package impresoras;
/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Utilidades {
    public static String generarNombre () {
        String resultado;
        String [] nombres = {"Fichero", "Datos", "Programa", "Listado", "Generador", "Esquema", "Horario", "Tabular",
                "Recursos", "Utilidades", "ListaClase", "Calificaciones","Prueba","Ejemplo"};
        String [] extension = {"csv","txt","java","c","cpp","docx","pdf"};
        int aux = (int) (Math.random()*nombres.length);
        resultado =nombres[aux];
        aux = (int) (Math.random()*extension.length);
        return resultado+'.'+extension[aux];
    }
    public static Impresoras cargaInicial () {
        int capacidad = (int) (Math.random()*5+1);
        int ficheros = (int) (Math.random()*15+capacidad);
        Impresoras resultado = new Impresoras(capacidad);
        for (int i = 0; i < ficheros; i++) {
            int aux = (int) (Math.random()*resultado.getCapacidad());
            String fichero = Utilidades.generarNombre();
            resultado.insertar(fichero,aux);
        }
        return resultado;
    }

}
