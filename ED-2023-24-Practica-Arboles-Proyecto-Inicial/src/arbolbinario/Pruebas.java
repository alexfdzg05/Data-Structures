package arbolbinario;

import java.util.Arrays;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL SINTACTICO **********");
        System.out.println("Gramática:\n" +
                "S→SN PV\n" +
                "SN→DET N\n" +
                "PV→V SN\n" +
                "DET→el|la\n" +
                "N→gato|perro|película\n" +
                "V →ve|come");
        String[] prueba1 =
                {"S->SN PV",
                "SN->DET N",
                "PV->V SN",
                "DET->el",
                "N->gato",
                "V->ve",
                "SN->DET N",
                "DET->la",
                "N->pelicula"};
        System.out.print("\nÁrbol sintáctico para la siguiente secuencia de reglas: ");
        System.out.println(Arrays.toString(prueba1));
        Arbol arbol = new Arbol(prueba1);
        System.out.println("Derivaciones en preOrden: ");
        String[] derivaciones = arbol.generarDerivaciones(); //Dentro del método no sé que capacidad ponerle si no hay una variable numElementos;
        System.out.println(Arrays.toString(derivaciones));
        System.out.print("La frase reconstruida del árbol es: ");
        System.out.println(arbol.generarFrase());
        System.out.println("\n********** 2º PRUEBA ARBOL SINTACTICO **********");
        System.out.println("Gramática:\n" +
                "S→SN PV\n" +
                "PV→V SN\n" +
                "V→come\n" +
                "SN→DET N\n" +
                "DET→el\n" +
                "N→perro");
        String[] prueba2 =
                {"S->SN PV",
                "PV->V SN",
                "V->come",
                "SN->DET N",
                "DET->el",
                "N->perro"};
        System.out.print("\nÁrbol sintáctico para la siguiente secuencia de reglas: ");
        System.out.println(Arrays.toString(prueba2));
        Arbol arbol2 = new Arbol(prueba2);
        System.out.println("Derivaciones en preOrden: ");
        String[] derivaciones2 = arbol2.generarDerivaciones(); //Dentro del método no sé que capacidad ponerle si no hay una variable numElementos;
        System.out.println(Arrays.toString(derivaciones2));
        System.out.print("La frase reconstruida del árbol es: ");
        System.out.println(arbol2.generarFrase());

    }
}

