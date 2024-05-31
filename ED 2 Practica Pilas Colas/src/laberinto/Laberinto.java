package laberinto;

/**
 * @author  Alejandro Fernández Guerrero bu0024 IWSIM11
 * @version 1.0
 */
public class Laberinto {

    private final int TAMANIO;
    private char[][] tablero;
    private Coordenada entrada, salida;
    private Pila pilaCaminos;
    private boolean[][] visitados;


    public Laberinto(char[][] tablero, Coordenada entrada, Coordenada salida) {
        this.TAMANIO = tablero.length;
        this.tablero = tablero;
        this.entrada = entrada;
        this.salida = salida;
        this.pilaCaminos = new Pila();
        this.visitados = new boolean[TAMANIO][TAMANIO];
    }

    public void mostrar() {
        for (int i = 0; i <= 2*(TAMANIO+1); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < TAMANIO; i++) {
            if (i != entrada.getFila()) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(" "+tablero[i][j]);
            }
            if (i != salida.getFila()) {
                System.out.println(" |");
            } else {
                System.out.println("  ");
            }
        }
        for (int i = 0; i <= 2*(TAMANIO+1); i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }
    private boolean esValida (Coordenada aux) {
        return aux.getFila()>=0 && aux.getFila()< TAMANIO &&  aux.getColumna()>=0 && aux.getColumna()< TAMANIO;
    }
    private boolean visitada (Coordenada aux) {
        return visitados[aux.getFila()][aux.getColumna()];
    }
    private boolean esCamino (Coordenada aux) {
        return tablero[aux.getFila()][aux.getColumna()]==' ';
    }
    private boolean esCaminoValidoNuevo(Coordenada coordenada) {
    boolean condicion = true;
    if (!esValida(coordenada) || !esCamino(coordenada) || visitada(coordenada)){
        condicion = false;
    }
    return condicion;
    }

    public boolean existeCamino() {
        pilaCaminos.apilar(entrada);
        visitados[entrada.getFila()][entrada.getColumna()] = true;
        boolean salir = false;

        while (!salir && !pilaCaminos.vacia()) {
            Coordenada coordenada = pilaCaminos.desapilar();
            if (coordenada.iguales(salida)) {
                salir = true;
            }

            if (esCaminoValidoNuevo(coordenada.derecha())) {
                pilaCaminos.apilar(coordenada.derecha());
                visitados[coordenada.derecha().getFila()][coordenada.derecha().getColumna()] = true;
            }

            if (esCaminoValidoNuevo(coordenada.izquierda())) {
                pilaCaminos.apilar(coordenada.izquierda());
                visitados[coordenada.izquierda().getFila()][coordenada.izquierda().getColumna()] = true;
            }

            if (esCaminoValidoNuevo(coordenada.arriba())) {
                pilaCaminos.apilar(coordenada.arriba());
                visitados[coordenada.arriba().getFila()][coordenada.arriba().getColumna()] = true;
            }

            if (esCaminoValidoNuevo(coordenada.abajo())) {
                pilaCaminos.apilar(coordenada.abajo());
                visitados[coordenada.abajo().getFila()][coordenada.abajo().getColumna()] = true;
            }
        }
        return salir;
            }
        }