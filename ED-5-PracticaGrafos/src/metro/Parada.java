package metro;

import java.util.Arrays;

public class Parada {
    /***************
     * EJERCICIO 1 *
     * *************/

    //TODO (1.3) : Añadir atributos
    private String nombre;
    private int[] lineas;
    private int numLineas;

    /*
    TODO (1.3)
     Creará una líne con nombre y líneas los pasados por parámetro.
     numLineas será lineas.length)
     */
    public Parada(String nombre, int[] lineas){
        this.nombre = nombre;
        this.lineas = lineas;
        numLineas = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i]!=0){
                numLineas++;
            }
        }
    }
    //TODO (1.3) Debe asignar un nombre a la parada
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //TODO (1.3) El return debe ser el array de líneas que pasan por la parad
    public void setLineas (int[] lineas){
        numLineas = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i]!=0){
                numLineas++;
            }
        }
        this.lineas = lineas;
    }
    //TODO (1.3) El return debe ser el nombre de la parada
    public String getNombre(){return nombre;}
    //TODO (1.3) Devolverá el array de líneas que pasan por la parada
    public int[] getLineas(){return lineas;}
    //TOOD (1.3) Devolverá el número de líneas (sin .length)
    public int getNumLineas(){return numLineas;}
    /*
    TODO (1.3)
     Devolverá un String con información de la parada.
     Observar los ejemplos de ejecución para ver la estructura del print.
     */
    @Override
    public String toString(){return "Parada{"+nombre+" Líneas: "+ Arrays.toString(lineas)+ ", "+numLineas+"}";}
}
