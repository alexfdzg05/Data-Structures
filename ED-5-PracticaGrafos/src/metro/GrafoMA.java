package metro;

public class GrafoMA {
    private int numVertices;          // Número de vértices.
    private boolean dirigido;         // indica si el grafo es dirigido o no dirigido
    private boolean[][] matrizAdy;    // Matriz de adyacencias del grafo.


    public GrafoMA(int numVertices, boolean dirigido) { // crea la matriz de adyacencia vacia
        this.numVertices = numVertices;
        this.dirigido = dirigido;
        this.matrizAdy = new boolean[numVertices][numVertices];
        this.inicializaMA();// Inicialiaza la Matriz de adyacencia a False.
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public boolean getDirigido() {
        return this.dirigido;
    }

    // Inicialiaza la Matriz de adyacencia a False.
    public void inicializaMA()
    { for (int i = 0; i < this.numVertices; i++)
        for (int j = 0; j < this.numVertices; j++)
            this.matrizAdy[i][j]=false;
    }

    //comprueba que un vertice este dentro del rango de vertices del grafo
    public boolean verticeEnRango(int v){
        return  ((v < this.numVertices) && (v >= 0) );
    }

    //inserta una arista en el grafo con origen en o y destino en d
    public void insertarArista(int o, int d) {
        if (this.verticeEnRango(o) && this.verticeEnRango(d))
            if (!existeArista(o,d))
            {   this.matrizAdy[o][d] = true;
                if (!this.getDirigido()) this.matrizAdy[d][o] = true;
            } else System.out.println("la arista con origen en " + o + " y destino en " + d + " ya existe");
        else System.out.println("Error, los vertices " + o + ", " + d + " Están fuera de rango");

    }
    //elimina si existe una arista en el grafo con origen en o y destino en d
    public void eliminarArista(int o, int d) {
        if (this.verticeEnRango(o) && this.verticeEnRango(d))
            if (this.existeArista(o,d))
            { this.matrizAdy[o][d] = false;
                if (!this.getDirigido()) this.matrizAdy[d][o] = false;
            } else System.out.println("la arista con origen en " + o + " y destino en " + d + " no existe");
        else System.out.println("Error, los vertices " + o + ", " + d + " Estan fuera de rango");
    }


    public boolean existeArista(int u, int v) {
        boolean resul=false;
        if (this.verticeEnRango(u) && this.verticeEnRango(v))
            resul= this.matrizAdy[u][v];
        else
            System.out.println("Error, los vertices " + u + ", " + v + " Estan fuera de rango");
        return  resul;
    }

    public int gradoEntrada(int v) {
        int resul = 0;
        if (this.verticeEnRango(v)){
            for (int i = 0; i < this.numVertices; i++)      //Recorrer la columna del vertice v
                if (this.matrizAdy[i][v]) resul++;

        }
        return resul;
    }

    public int gradoSalida(int v) {
        int resul = 0;
        if (this.verticeEnRango(v)) {
            for (int j = 0; j < this.numVertices; j++)      //Recorrer fila del vertice v
                if (this.matrizAdy[v][j]) resul++;
        }
        return resul;
    }

    public int incidencia(int v) {
        int resul = 0;
        if (this.verticeEnRango(v)) {
            if (!this.getDirigido())
                resul = this.gradoEntrada(v);
            else resul = this.gradoEntrada(v) + this.gradoSalida(v);
        }
        return resul;
    }
    public int numAristas() {   // Número total de aristas del grafo
        int resul = 0;
        if (this.getDirigido())
        { for (int i = 0; i < this.numVertices; i++)
            for (int j = 0; j < this.numVertices; j++)
                if (this.matrizAdy[i][j]) resul++;
        }
        else { for (int i = 0; i < this.numVertices; i++)
            for (int j = i; j < this.numVertices; j++)
                if (this.matrizAdy[i][j]) {
                    resul++;
                    if (i!=j) resul++;
                }
        }
        return resul;
    }


    public void mostrarampliado() {
        //imprime la matriz por consola con numeros en las filas y columnas
        System.out.println("El grafo tiene una Matriz de " + this.numVertices + " x " + this.numVertices);
        if (this.getDirigido()) {
            System.out.println("De un grafo dirigido");
        } else {
            System.out.println("De un grafo No dirigido");
        }
        if (this.getNumVertices()<10)
            System.out.print("   ");
        if (this.getNumVertices()<10)
            for (int i = 0; i < this.numVertices; i++)
                System.out.print(" "+i+" ");
        if (this.getNumVertices()<10) System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            if (this.getNumVertices()<10) System.out.print(" "+i+" ");
            for (int j = 0; j < this.numVertices; j++) {
                if (this.matrizAdy[i][j]) {
                    System.out.print(" T ");
                } else {
                    System.out.print(" F ");
                }
            }
            System.out.println();
        }
    }


    public void mostrar() {
        //imprime la matriz por consola sin numeros en las filas y columnas
        System.out.println("El grafo tiene una Matriz de " + this.numVertices + " x " + this.numVertices);
        if (this.getDirigido()) {
            System.out.println("De un grafo dirigido");
        } else { System.out.println("De un grafo No dirigido"); }
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (this.matrizAdy[i][j]) { System.out.print(" T "); }
                else { System.out.print(" F "); }
            }
            System.out.println();
        }
    }
    // se hace un recorrido en profundidad del grafo a partir del vertice v que pasan como origen.
    public void profundidadDesdeVertice(int v) {
        if (this.verticeEnRango(v)) {
            // se inicializa el vector de visitados que se utiliza para saber que vertice
            // he visitado ya y no volver a pasar por el(evitando bucles infinitos)
            boolean[] visitados = new boolean[this.numVertices];
            for (int i = 0; i < this.numVertices; i++) {
                visitados[i] = false;
            }// Se empieza a recorrer desde el vértice v llamando a recorridoEnProfundidad.
            this.recorridoEnProfundidad(v, visitados);
            System.out.println();
        }
    }

    // recorrido en profundidad de una componente  Conexa GN del grafo
    public void recorridoEnProfundidad(int v, boolean[] visitados) {
        visitados[v] = true;
        //System.out.print(v + " ");
        // Para cada Vértice adyacentes desde v
        for (int i = 0; i < this.numVertices; i++) {
            if (this.existeArista(v, i) && !visitados[i])
                this.recorridoEnProfundidad(i, visitados);
        }
    }
    // recorrido en profundidad de una componente  Conexa   del grafo GD
    public void recorridoEnProfundidadGD(int v, boolean[] visitados) {
        visitados[v] = true;
        //System.out.print(v + " ");
        // Para cada Vértice adyacentes desde v
        for (int i = 0; i < this.numVertices; i++) {
            if ((this.existeArista(v, i) || this.existeArista(i, v)) && !visitados[i])
                this.recorridoEnProfundidadGD(i, visitados);
        }
    }

    // Para  recorrer todos los vertices del grafo, recorriendo cada componente conexa(GN)
//  en profundidad a partir de un vertice de la misma.
    public void profundidad() {
        boolean[] visitados = new boolean[this.numVertices];
        // se inicializa el vector de visitados que se utiliza para saber que vertice
        // he visitado ya y no volver a pasar por el(evitando bucles infinitos)
        for (int i = 0; i < this.numVertices; i++) {
            visitados[i] = false;
        }
        // Para cada Vertice para visitar todas las componentes conexas(GN)
        for (int i = 0; i < this.numVertices; i++) {
            if (!visitados[i]) //llama al método que recorre el grafo en profundidad
                recorridoEnProfundidad(i, visitados);// a partir de un vertice
        }
    }


    //interfaz para recorrer la componente conexa(GN) de un grafo
    // en amplitud a partir de un vertice
    public void amplitudDesdeVertice(int v)
    {boolean[] visitados = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            visitados[i] = false;
        }
        this.recorrerAmplitudVertice(v,visitados,false);
    }

    // se hace un recorrido en amplitud del grafo a partir del vertice v que pasan como origen.
    public void recorrerAmplitudVertice(int v,boolean[] visitados,boolean completo) {
        Cola cola = new Cola();
        // Recorrer en amplitud desde vértice v
        cola.encolar(v);  	//Encolar y marcar como visitado
        visitados[v] = true;
        while (!cola.vacia()) {
            int vertice = cola.desencolar();  // Desencolar
            System.out.print(vertice + " ");  // Visualizar
            // Encolar vértices adyacentes desde v
            for (int j = 0; j < this.numVertices; j++) {
                if (this.existeArista(vertice, j) && !visitados[j]) {
                    cola.encolar(j);
                    visitados[j] = true;
                }
            }
        }
        if (!completo)System.out.println();
    }

    // Para  recorrer todos los vertices del grafo, recorriendo cada componente conexa(GN)
    //  en amplitud a partir de un vertice de la misma.
    public void amplitud() {
        boolean[] visitados = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            visitados[i] = false;
        }
        // Para cada Vertice para visitar todas las componentes conexas(GN)
        for (int i = 0; i < this.numVertices; i++) {
            if (!visitados[i]) //llama al método que recorre el grafo en amplitud
                this.recorrerAmplitudVertice(i,visitados,true);// a partir de un vertice
        }

        System.out.println();
    }

    public boolean esGrafoConexo(){
        boolean[] visitados = new boolean[numVertices];
        for (int i=0; i<numVertices; i++) visitados[i]=false;
        if (getDirigido()) recorridoEnProfundidadGD(0,visitados);
        else recorridoEnProfundidad(0,visitados);
        return todosVisitados(visitados);
    }
    private boolean todosVisitados(boolean[] visitados){
        boolean ok=true;       int i=0;
        while ((i<visitados.length) && ok){
            ok = visitados[i];
            i++;
        } return ok;
    }



    public boolean esArbol(){
        Boolean resul=false;
        if (getDirigido()) resul= (esGrafoConexo() && (this.numAristas() == numVertices-1));
        else resul= esArbolGD();
        return resul;
    }
    public boolean esArbolGN(){
        return (esGrafoConexo() && (this.numAristas() == numVertices-1));
    }

    public boolean esArbolGD(){
        int gradoEnt0 = 0 ,   gradoEnt,    v = 0;
        boolean ok = esGrafoConexo();
        while ((v<numVertices) && ok){
            gradoEnt = gradoEntrada(v);
            ok = gradoEnt <= 1;
            if (gradoEnt==0) gradoEnt0++;
            v++;
        }
        return ((gradoEnt0 == 1) && ok);
    }







}
