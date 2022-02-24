package com.liceolapaz.des.bar.mismatrices;

import java.util.Scanner;

public final class Principal {
	public static void main(String[] args) {
		System.out.println("MIS MATRICES");
		Matriz matrizA;
		matrizA = recogerMatriz();
		System.out.println(matrizA);
		Matriz matrizB;
		matrizB = recogerMatriz();
		System.out.println(matrizB);

		Matriz resultadoSuma = matrizA.sumar(matrizB);
		if(resultadoSuma == null){
			System.out.println("Las matrices deben tener el mismo tamaño");
		}else{
			System.out.println(resultadoSuma);
		}
		//TODO: Por ahora nuestro programa solo recoge una matriz y la enseña
		//		por pantalla. Pero debemos implementar el resto del programa.
		
//		System.out.println(matrizA);
		// como tenemos implementada la función toString podemos poner
		// directamente el nombre de nuestro objeto y Java ya llama a la función toString 
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

}
