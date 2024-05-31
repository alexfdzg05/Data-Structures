package impresoras;

/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Impresoras {
    private int capacidad;
    private Cola [] vector;

    public Impresoras(int capacidad) {
        this.capacidad = capacidad;
        vector = new Cola [capacidad];
        for (int i = 0; i < capacidad; i++)
            vector[i] = new Cola();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTrabajos (int i) {
        Cola cola = vector[i];
        return cola.getNumElementos();
    }
    public void mostrar () {
        System.out.println("Estado de las colas: ");
        for (int i = 0; i < vector.length;i++){
            if (vector[i]!=null){
                System.out.println("Impresora "+i+". Trabajos: "+vector[i].getNumElementos());
            }
        }
    }
    public int insertar (String fichero) {
        int posicion = 0;
        int menor = vector[0].getNumElementos();
        for (int i = 0; i < vector.length; i++){
            if (vector[i]!=null) {
                if (menor > vector[i].getNumElementos()) {
                    menor = vector[i].getNumElementos();
                    posicion = i;
                }
            }
        }
        vector[posicion].encolar(fichero);
        return posicion;
    }
    public void insertar (String fichero, int posicion) {
        if (posicion >= 0 && posicion < vector.length){
            vector[posicion].encolar(fichero);
        }
    }
    public void imprimir () {
        for (int i = 0; i < vector.length; i++){
            String valor = vector[i].desencolar();
            if (!valor.equalsIgnoreCase("-9999")) {
                System.out.println("Se imprime el fichero " + valor + " en la cola " + i);
            }
        }
    }
    public boolean imprimir (int i) {
        boolean impreso;
        String valor = vector[i].desencolar();
        if (valor.equalsIgnoreCase("-9999")){
            impreso = false;
        }else{
            System.out.println("Se imprime el fichero "+valor+" en la cola "+ i);
            impreso = true;
        }
        return impreso;
    }
    /*/ Sin poder alterar la estructura del método mostrar en la clase Cola no se me ocurre una manera de darle el formato del
       ejemplo de ejecución. Pudiendo alterarla, borraría el "sout" del método y lo pondría antes de la ejecución del
       método mostrar (dentro de la condición if, en el método mostrarCola).
    */
    public void mostrarCola (int posicion) {
        if (posicion >= 0 && posicion < vector.length){
            vector[posicion].mostrar();
        }else{
            System.out.println("Error: Impresora fuera de rango ("+0+" - "+vector.length+")");
        }
    }
}
