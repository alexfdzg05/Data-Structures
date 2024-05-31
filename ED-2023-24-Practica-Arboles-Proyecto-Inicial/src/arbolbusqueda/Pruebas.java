package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println("-------------- Arbol binario de busqueda ------------");
		Alumno alumno = new Alumno("Felipe Garcia", 1253, 5.3);
		Alumno alumno1 = new Alumno("Adriana Torres", 2345, 7.0);
		Alumno alumno2 = new Alumno("Alicia Blazquez Martín", 5622, 10.0);
		Alumno alumno3 = new Alumno("Diego Perez Gonzalez", 8135, 8.0);
		Alumno alumno4 = new Alumno("Mar Hernando Lopez", 8217, 6.3);
		Alumno alumno5 = new Alumno("Pedro Jimenez del Pozo", 8510, 3.0);
		Alumno alumno6 = new Alumno("Eduardo Parra Martín", 8765, 6.7);
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.insertar(alumno2);
		arbol.insertar(alumno5);
		arbol.insertar(alumno1);
		arbol.insertar(alumno);
		arbol.insertar(alumno6);
		arbol.insertar(alumno3);
		arbol.insertar(alumno4);
		System.out.println("\nABB alumnos (inicial). Preorden con niveles: ");
		arbol.preOrdenNivel();
		System.out.println("\nABB alumnos tras agregar el rango de matrículas [1300-1310].");
		arbol.agregarRangoDeMatriculas(1300,1310,new Alumno("Temporal",0,0.0));//Tengo que inicializar a 0 la matrícula en el propio método se corregirá
		arbol.preOrdenNivel();
		System.out.println("\nABB alumnos tras eliminar el rango de matrículas [1300-6000].");
		arbol.eliminarRangoMatriculas(1300,6000);
		arbol.preOrdenNivel();
		System.out.println("\nABB alumnos tras eliminar el rango de matrículas [500-600].");
		arbol.eliminarRangoMatriculas(500,600);
		arbol.preOrdenNivel();
		System.out.println();
		System.out.print("\nEl sucesor inmediato de "+alumno5+" es: ");
		Alumno alumno7 = arbol.encontrarSucesorInmediato(alumno5);
		if (alumno7 !=null) {
			System.out.println(alumno7);
		}else{
			System.out.println("null");
		}
		System.out.print("El sucesor inmediato de "+alumno4+" es: ");
		alumno7 = arbol.encontrarSucesorInmediato(alumno4);
		if (alumno7!=null) {
			System.out.println(alumno7);
		}else{
			System.out.println("null");
		}
		System.out.print("El sucesor inmediato de "+alumno2+" es: ");
		alumno7 = arbol.encontrarSucesorInmediato(alumno2);
		if (alumno7!=null) {
			System.out.println(alumno7);
		}else{
			System.out.println("null");
		}
		System.out.print("El sucesor inmediato de "+alumno6+" es: ");
		alumno7 = arbol.encontrarSucesorInmediato(alumno6);
		if (alumno7!=null) {
			System.out.println(alumno7);
		}else{
			System.out.println("null");
		}
		System.out.println("\nABB alumnos tras pivotar a "+alumno3+" a la raiz.");
		arbol.pivotarSobre(alumno3);
		arbol.preOrdenNivel();
		System.out.println("\nABB alumnos tras pivotar a "+alumno3+" a la\n" +
				"raiz (prueba idempotencia).");
		arbol.pivotarSobre(alumno3);
		arbol.preOrdenNivel();//
		System.out.println("----------------------------------------------------");
	}
}
