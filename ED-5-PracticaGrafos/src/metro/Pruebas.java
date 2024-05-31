package metro;

import java.util.Arrays;
import java.util.LinkedList;

public class Pruebas {
    public static void main(String[] args) {
        /*
        Descomentar el ejercicio que se está realizando.
        Al entregar, dejar los tres descomentados.
        * */
        ejercicio_1();
        ejercicio_2();
        ejercicio_3();
    }

    public static void ejercicio_1() {
        System.out.println("--------- Ejercicio 1 ---------");
        System.out.println("-- Crear Paradas --");
        Parada Planetario = new Parada("Planetario", new int[]{6});
        Parada Plaza = new Parada("Plaza Elíptica", new int[]{6});
        System.out.println(Planetario.toString());
        System.out.println(Plaza.toString());
        System.out.println("-- Crear red --");
        Metro redMetro = new Metro(new Parada[]{Planetario, Plaza});
        System.out.println("-- Comunicar Paradas --");
        redMetro.comunicarParadas(Planetario, Plaza);
        System.out.println("-- Información de la red de metro --");
        redMetro.mostrarAmpliado();
    }

    public static void ejercicio_2() {
        System.out.println("--------- Ejercicio 2 ---------");
        System.out.println("-- Crear Paradas -- ");
        Parada Planetario = new Parada("Planetario", new int[]{6});
        Parada Plaza = new Parada("Plaza Elíptica", new int[]{6});
        Parada Moncloa = new Parada("Moncloa", new int[]{6});
        Parada ManuelBecerra = new Parada("Manuel Becerra", new int[]{6, 2});
        Parada Sol = new Parada("Sol", new int[]{1, 2});
        Parada Alcala = new Parada("Alcala", new int[]{2});
        Parada Ventas = new Parada("Ventas", new int[]{2});
        Parada CuatroCaminos = new Parada("Cuatro Caminos", new int[]{1, 2, 6});
        Parada Chamartin = new Parada("Chamartin", new int[]{1});
        Parada[] paradas = new Parada[]{Planetario, Plaza, Moncloa, ManuelBecerra, Sol,
                Alcala, Ventas, CuatroCaminos, Chamartin};
        System.out.println("-- Listar Paradas -- ");
        System.out.println(" Paradas (Usando Arrays.toString): ");
        System.out.println(Arrays.toString(paradas));
        System.out.println("-- Crear redMetro -- ");
        Metro redMetro = new Metro(paradas);
        System.out.println("-- Comunicar Paradas -- ");
        redMetro.comunicarParadas(Planetario, Plaza);
        redMetro.comunicarParadas(Plaza, Moncloa);
        redMetro.comunicarParadas(Moncloa, CuatroCaminos);
        redMetro.comunicarParadas(CuatroCaminos, Sol);
        redMetro.comunicarParadas(CuatroCaminos, ManuelBecerra);
        redMetro.comunicarParadas(CuatroCaminos, Chamartin);
        redMetro.comunicarParadas(Sol, Alcala);
        redMetro.comunicarParadas(Alcala, ManuelBecerra);
        redMetro.comunicarParadas(ManuelBecerra, Ventas);
        redMetro.comunicarParadas(ManuelBecerra, Planetario);
        System.out.println("Numero de paradas: "+redMetro.getNumParadas());
        redMetro.mostrarAmpliado();
        System.out.println("Conexiones con Planetario");
        LinkedList<Parada> paradasLinkedList = redMetro.conexiones(Planetario);
        System.out.println(paradasLinkedList.toString());
        redMetro.mostrarConexiones();
        redMetro.mostrarConexionesLineas();
        System.out.println("--> Grados de los vértices <--");
        redMetro.getGrados();
    }

    public static void ejercicio_3() {
        System.out.println("--------- Ejercicio 3 ---------");
        System.out.println("-- Crear Paradas -- ");
        Parada Planetario = new Parada("Planetario", new int[]{6});
        Parada Plaza = new Parada("Plaza Eliptica", new int[]{6});
        Parada Moncloa = new Parada("Moncloa", new int[]{6});
        Parada ManuelBecerra = new Parada("Manuel Becerra", new int[]{6, 2});
        Parada Sol = new Parada("Sol", new int[]{1, 2});
        Parada Alcala = new Parada("Alcala", new int[]{2});
        Parada Ventas = new Parada("Ventas", new int[]{2});
        Parada CuatroCaminos = new Parada("Cuatro Caminos", new int[]{1, 2, 6});
        Parada Chamartin = new Parada("Chamartin", new int[]{1});
        Parada[] paradas = new Parada[]{Planetario, Plaza, Moncloa, ManuelBecerra, Sol,
                Alcala, Ventas, CuatroCaminos, Chamartin};
        System.out.println("-- Listar Paradas -- ");
        System.out.println(" Paradas (Usando Arrays.toString): ");
        System.out.println(Arrays.toString(paradas));
        System.out.println("-- Crear redMetro -- ");
        Metro redMetro = new Metro(paradas);
        System.out.println("-- Comunicar Paradas -- ");
        redMetro.comunicarParadas(Planetario, Plaza);
        redMetro.comunicarParadas(Plaza, Moncloa);
        redMetro.comunicarParadas(Moncloa, CuatroCaminos);
        redMetro.comunicarParadas(CuatroCaminos, Sol);
        redMetro.comunicarParadas(CuatroCaminos, ManuelBecerra);
        redMetro.comunicarParadas(CuatroCaminos, Chamartin);
        redMetro.comunicarParadas(Sol, Alcala);
        redMetro.comunicarParadas(Alcala, ManuelBecerra);
        redMetro.comunicarParadas(ManuelBecerra, Ventas);
        redMetro.comunicarParadas(ManuelBecerra, Planetario);
        System.out.println("Numero de paradas: "+redMetro.getNumParadas());
        redMetro.mostrarAmpliado();
        System.out.println("--> Obras desde Manuel Becerra hacia Cuatro Caminos <--");
        redMetro.obrasEntreParadas(ManuelBecerra, CuatroCaminos);
        redMetro.mostrarAmpliado();

        Parada origen = Chamartin;
        Parada destino = Moncloa;
        System.out.println("¿Se puede ir de "+origen.getNombre()+" a "+destino.getNombre()+"? "+
                redMetro.existeCamino(origen,destino));
        origen = Plaza;
        System.out.println("¿Se puede ir de "+origen.getNombre()+" a "+destino.getNombre()+"? "+
                redMetro.existeCamino(origen,destino));


        System.out.println("--> Nuevas obras");
        redMetro.obrasEntreParadas(Plaza, Moncloa);
        redMetro.obrasEntreParadas(ManuelBecerra, Alcala);
        redMetro.mostrarAmpliado();
        origen = Chamartin;
        boolean primerGrupo = redMetro.existeCamino(origen,destino);
        System.out.println("¿Se puede ir de "+origen.getNombre()+" a "+destino.getNombre()+"? "+
                            primerGrupo);
        origen = Plaza;
        boolean segundoGrupo = redMetro.existeCamino(origen,destino);
        System.out.println("¿Se puede ir de "+origen.getNombre()+" a "+destino.getNombre()+"? "+
                segundoGrupo);
        System.out.println("¿Se pueden ver en Moncloa? "+(primerGrupo && segundoGrupo));
    }
}
