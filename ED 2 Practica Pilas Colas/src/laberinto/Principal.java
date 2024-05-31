package laberinto;

/**
 * @author Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Principal {
    public char[][] laberinto1() {
        final int TAMANIO = 6;
        char[][] tabla = new char[TAMANIO][TAMANIO];
        String fila0 = "X     ";
        String fila1 = "  X X ";
        String fila2 = "X X XX";
        String fila3 = "   XX ";
        String fila4 = " X XX ";
        String fila5 = " X    ";
        tabla[0] = fila0.toCharArray();
        tabla[1] = fila1.toCharArray();
        tabla[2] = fila2.toCharArray();
        tabla[3] = fila3.toCharArray();
        tabla[4] = fila4.toCharArray();
        tabla[5] = fila5.toCharArray();
        return tabla;
    }

    public void pruebaPila () {
        char[][] tabla = laberinto1();
        Coordenada entrada, salida;
        entrada = new Coordenada(1, 0);
        salida = new Coordenada(3, 5);
        System.out.println();
        System.out.println("USANDO LA CLASE Pila:");
        Laberinto laberinto = new Laberinto(tabla, entrada, salida);
        System.out.println();
        laberinto.mostrar();
        System.out.println();
        if (laberinto.existeCamino()) {
            System.out.println("Existe camino desde la entrada " + entrada + " a la salida " + salida);
        } else {
            System.out.println("No existe camino desde la entrada " + entrada + " a la salida " + salida);
        }
    }
    // TODO Completar ls prueba usando LaberintoStack
    public void pruebaStack () {
        char[][] tabla = laberinto1();
        Coordenada entrada, salida;
        entrada = new Coordenada(1, 0);
        salida = new Coordenada(3, 5);
        System.out.println();
        System.out.println("USANDO LA CLASE Pila:");
        Laberinto laberinto = new Laberinto(tabla, entrada, salida);
        System.out.println();
        laberinto.mostrar();
        System.out.println();
        if (laberinto.existeCamino()) {
            System.out.println("Existe camino desde la entrada " + entrada + " a la salida " + salida);
        } else {
            System.out.println("No existe camino desde la entrada " + entrada + " a la salida " + salida);
        }
    }

    public static void main(String[] args) {
        Principal prueba = new Principal();
        prueba.pruebaPila();
        prueba.pruebaStack();
    }
}
