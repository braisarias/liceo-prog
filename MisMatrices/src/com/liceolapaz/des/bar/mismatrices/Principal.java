package com.liceolapaz.des.bar.mismatrices;

import java.util.Scanner;

public final class Principal {
	public static void main(String[] args) {
		do {
			imprimirMenu();
			int opcion = recogerEntero("Introducir opcion: ");
			switch (opcion) {
				case 0:
					System.exit(0);
				case 1: // suma
					do_suma();
					break;
				case 2: // multiplicar
					do_multiplicar();
					break;
				case 3: // determinante
					do_determinante();
					break;
				case 4: // inversa
					do_inversa();
					break;
				case 5: // traspuesta
					do_traspuesta();
					break;
				default:
					break;
			}
		} while (true); 
	}

	private static void do_suma() {
		Matriz matrizA = recogerMatriz();
		System.out.println("matrizA:");
		System.out.println(matrizA);
		Matriz matrizB = recogerMatriz();
		System.out.println("matrizB:");
		System.out.println(matrizB);
		Matriz suma = matrizA.sumar(matrizB);
		
		if (suma == null) {
			System.out.println("Matrices de distinta dimensión. No se pueden sumar");
			return;
		}
		System.out.println("Suma:");
		System.out.println(suma);
	}

	private static void do_multiplicar() {
		int opcion =0;
		while (opcion > 2 || opcion < 1) {
			imprimirMenuMultiplicar();
			opcion = recogerEntero("Introduce opcion:");
		}
		
		Matriz matrizA = recogerMatriz();
		System.out.println("matrizA:");
		System.out.println(matrizA);
		Matriz resultado;
		if (opcion == 1) {
			Matriz matrizB = recogerMatriz();
			System.out.println("matrizB:");
			System.out.println(matrizB);
			resultado = matrizA.multiplicar(matrizB);
			if(resultado == null) {
				System.out.println("Estas matrices no se pueden multiplicar");
				return;
			}
		} else {
			double escalar = recogerDouble("Introduce el escalar: ");
			resultado = matrizA.multiplicar(escalar);
		}
		
		System.out.println("Multiplicación:");
		System.out.println(resultado);
		
	}

	private static void imprimirMenuMultiplicar() {
		System.out.println("1. Multiplicar 2 matrices"
				+ "\n2. Multiplicar matriz x escalar");
	}

	private static void do_determinante() {
		Matriz matrizA = recogerMatriz();
		System.out.println("matrizA:");
		System.out.println(matrizA);
		
		Double determinante = matrizA.determinante();
		
		if (determinante == null) {
			System.out.println("Matriz no cuadrada. No se puede calcular el determinante");
			return;
		}
		
		System.out.println("Determinante: " + determinante);
	}

	private static void do_inversa() {
		Matriz matrizA = recogerMatriz();
		System.out.println("matrizA:");
		System.out.println(matrizA);
		
		Matriz inversa = matrizA.invertir();
		
		if (inversa == null) {
			System.out.println("Matriz no invertible.");
			return;
		}
		
		System.out.println("Inversa:");
		System.out.println(inversa);
		
	}

	private static void do_traspuesta() {
		Matriz matrizA = recogerMatriz();
		System.out.println("matrizA:");
		System.out.println(matrizA);
			
		System.out.println("Traspuesta:");
		System.out.println(matrizA.traspuesta());
	}

	private static void imprimirMenu() {
		System.out.println("MIS MATRICES\n"
				+ "1. Sumar\n"
				+ "2. Multiplicar\n"
				+ "3. Determinante\n"
				+ "4. Invertir\n"
				+ "5. Traspuesta\n"
				+ "0. Salir");
	}

	/**
	 * Función que recoge la matriz del usuario fila a fila
	 * tal y como se especifica en el enunciado del ejercicio.
	 * @return un objeto de tipo Matriz construido tal como el usuario introduce.
	 */
	private static Matriz recogerMatriz() {
		int nFilas=0, nColumnas=0;
		
		while (nFilas <= 0 || nColumnas <= 0) {
			nFilas = recogerEntero("Introduce el número de filas:");
			nColumnas = recogerEntero("Introduce el número de columnas:");
		}
		// al salir de este while nos aseguramos de que el número de filas
		// y el número de columnas es mayor que cero
		
		double[][] arrayMatriz = new double[nFilas][nColumnas];
		// inicializamos un array de 2 dimensiones auxiliar
		// en el vamos almacenando los valores de los números de la matriz
		// que vamos a construir, para después constrirla con el
		
		for (int i=0; i<nFilas; i++) {
			String filaStr = recogeString("Introduce fila " + i + ": ");
			
			//TODO: deberiamos controlar si el string recogido es de la forma
			//		que tiene que ser. De momento nos fiamos del usuario :)
			
			String [] filaSplited = filaStr.split(" ");
			// con la función split (que tienen todos los Strings) podemos dividir
			// el string que ha introducido el usuario, en este caso nos interesa
			// separarlo cuando tenemos un espacio.
			// esta función nos devuelve un array de Strings
			// con todas las separaciones que ha hecho
			
			for(int j=0; j < filaSplited.length; j++) {
				arrayMatriz[i][j] = Double.parseDouble(filaSplited[j]);
				// Convertimos cada uno de los strings a double
				// para introducirlo en el array auxiliar
			}
			// Si recorremos el array de strings es como si recorrieramos
			// las columnas de nuestra matriz, por lo que podemos usar ese indice j
			// como indice de nuestra columna.
		}
		
		return new Matriz(arrayMatriz);
	}

	/**
	 * Esta función enseña un mesaje y recoge una línea por teclado.
	 * @param msg el mensje que enseña por pantalla.
	 * @return el String qu ese ha recogido del usuario.
	 */
	private static String recogeString(String msg) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(msg);
		
		return sc.nextLine();
		// en este caso lo que queremos leer
		// del teclado es la siguiente línea que introduce el usuario.
	}

	/**
	 * Esta función enseña un mensaje y recoge un número entero por teclado.
	 * @param msg el mensaje que enseña por pantalla
	 * @return devuelve el valor de entero introducido por pantalla
	 */
	private static int recogerEntero(String msg) {
		Integer numero = null;
		Scanner sc = new Scanner(System.in);
		
		while (numero == null) {
			System.out.print(msg);
			numero = sc.nextInt();
		}
		return numero.intValue();
	}
	
	/**
	 * Esta función enseña un mensaje y recoge un número double por teclado.
	 * @param msg el mensaje que enseña por pantalla
	 * @return devuelve el valor del double introducido por pantalla
	 */
	private static double recogerDouble(String msg) {
		Double numero = null;
		Scanner sc = new Scanner(System.in);
		
		while (numero == null) {
			System.out.print(msg);
			numero = sc.nextDouble();
		}
		return numero.doubleValue();
	}

}
