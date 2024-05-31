/*
    Nombre y apellidos: Alejandro Fernández Guerrero
    Grupo: IWSIM-11
 */
package metro;

import java.util.LinkedList;

public class Metro {
    /**************
    * EJERCICIO 1 *
    * *************/
    /*TODO (1.3)
    Definir e instanciar a valor predeterminado los atributos propusestos
    - redMetro: Grafo que contiene las paradas de la red de metro seleccionadas 
    - parada: vector de vértices del grafo
    - numParadas: número de paradas/vértices en el grafo (paradas.length)
    * */
    private GrafoMA redMetro;
    private Parada[] paradas;
    private int numParadas;

    //TODO (1.3) Constructor.
    public Metro(Parada[] paradas){
        this.paradas = paradas;
        this.numParadas = paradas.length;
        this.redMetro = new GrafoMA(numParadas, false);
    }

    /*
    TODO (1.3)
    Debe devolver
     * -1 si la parada no está (Vendrá bien despues)
     * la posición en paradas[] en caso contrario.
     */
    public int indiceParada(Parada parada){
        int indice = -1;
        for (int i = 0; i < numParadas; i++) {
            if (parada.getLineas() == paradas[i].getLineas()){ // No haría falta el getLineas
                indice = i;
            }
        }
        return indice;
    }
    /*
    TODO (1.3)
    Usar:
    - GrafoMA.insertarArista
    Cuidado, las paradas podrían venir como null. En ese caso, no hacer nada con el grafo.
    Si las paradas no están en el grafo, tampoco lo modificamos.
    No imprimimos mensaje de error, símplemente lo dejamos quieto.
     */
    public void comunicarParadas(Parada origen, Parada destino) {
        if (origen!=null && destino != null) {
            int i = indiceParada(origen);
            int j = indiceParada(destino);
            if (i != -1 && j != -1) {
                redMetro.insertarArista(i, j);
            }
        }
    }

    //TODO (1.3) Modificar para que devuelva el atributo asociado
    public int getNumParadas(){return numParadas;}
    //TODO (1.3) Usar GrafoMA.mostrarAmpliado
    public void mostrarAmpliado(){
      redMetro.mostrarampliado();
    }
    /************
     * EJERCICIO 2 *
    * *************/
    //TODO (2.4)
    public LinkedList<Parada> conexiones(Parada parada){
        LinkedList<Parada> Conexiones = new LinkedList<>();
        int origen = indiceParada(parada);
        if (origen != -1) {
            for (int i = 0; i < numParadas; i++) {
                if (redMetro.existeArista(origen, i)){
                 Conexiones.add(paradas[i]);
                }
            }
        }
        return Conexiones;
    }
    //TODO (2.4)
    public LinkedList<LinkedList <Parada>> getConexiones(){
        LinkedList<LinkedList<Parada>> lista = new LinkedList<>();
        for (int i = 0; i < numParadas; i++) {
            LinkedList<Parada> conexion = conexiones(paradas[i]);
            lista.add(conexion);
        }
        return lista;
    }
    //TODO (2.5)
    public void mostrarConexiones(){
        System.out.println("--> Todas las conexiones de mi red de metro <--");
        LinkedList<LinkedList <Parada>> lista = getConexiones();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i+": "+ paradas[i].getNombre() + " conecta con: ");
            for (int j = 0; j < lista.get(i).size(); j++) {
                System.out.print(lista.get(i).get(j).getNombre()+" ");
            }
            System.out.println();
        }
    }
    //TODO(2.6)
    /*
    //Descomentar y completar si es de utilidad
    public static LinkedList<Integer> lineasComunes(int[] lineas1, int[] lineas2){return new LinkedList<>();}
     */
    //TODO(2.6)
    public LinkedList<Integer> lineasComunes(Parada parada1, Parada parada2){
        LinkedList<Integer> lineas = new LinkedList<>();
        for (int i = 0; i < parada1.getNumLineas(); i++) {
            for (int j = 0; j < parada2.getNumLineas(); j++) {
                if (parada1.getLineas()[i] == parada2.getLineas()[j]){
                    lineas.add(parada1.getLineas()[i]);
                }
            }
        }
        return lineas;
    }
    public void mostrarConexionesLineas(){
        System.out.println("--> Todas las conexiones de mi red de metro (incluye líneas) <--");
        LinkedList<LinkedList <Parada>> lista = getConexiones();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i+": "+ paradas[i].getNombre() + " conecta con: ");
            for (int j = 0; j < lista.get(i).size(); j++) {
                Parada parada = lista.get(i).get(j);
                System.out.print(parada.getNombre()+" ("+lineasComunes(paradas[i], parada)+") ");
            }
            System.out.println();
        }
    }
    //TODO(2.8)
    public int[] getGrados() {
        int[] grados = new int[numParadas];
        for (int i = 0; i < numParadas; i++) {
            int grado = 0;
            for (int j = 0; j < numParadas; j++) {
                if (redMetro.existeArista(i,j)){ // Revisar si fuese dirigido
                    grado++;
                }
            }
            grados[i] = grado;
            System.out.println("Grado "+ paradas[i].getNombre()+": "+grado);
        }
        return grados;
    }
    //TODO(3.2)
    private void hacerDirigido() {
        if (!redMetro.getDirigido()){
            int n = redMetro.getNumVertices();
            GrafoMA redDirigida = new GrafoMA(n,true);
            for (int i = 0; i < numParadas; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i!=j && (redMetro.existeArista(i,j) || redMetro.existeArista(j,i))){
                        redDirigida.insertarArista(i,j);
                        redDirigida.insertarArista(j,i);
                    }
                }
            }
            redMetro = redDirigida;
        }
    }
    //TODO(3.2)
    public void obrasEntreParadas(Parada origen, Parada destino){
        hacerDirigido();
        int i = indiceParada(origen);
        int j = indiceParada(destino);
        if (i!=-1 && j!=-1){
            redMetro.eliminarArista(i,j);
        }
    }
    //TODO(3.3)
    public boolean existeCamino(Parada p1, Parada p2){
        boolean[] visitados = new boolean[numParadas];
        boolean resultado = false;
        int i = indiceParada(p1);
        int j = indiceParada(p2);
        if (i!=-1 && j!=-2) {
            redMetro.recorridoEnProfundidad(i, visitados);
            resultado = visitados[j];
        }
        return resultado;
    }
}

