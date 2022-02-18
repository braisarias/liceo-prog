package com.liceolapaz.des.bar.mismatrices;

import java.util.Arrays;

class Matriz {
	private double [][] matriz;

	/**
	 * Este constructor inicializa una matriz de filas x columnas
	 * y pone todos sus elementos a cero.
	 * Es un constructor no estrictamente necesario para la práctica.
	 * 
	 * @param filas el número de filas de la matriz
	 * @param columnas el número de columnas de la matriz
	 */
	public Matriz(int filas, int columnas) {
		this.matriz = new double[filas][columnas];
		
		for (int i=0; i < this.matriz.length; i++) {
			for(int j=0; j < this.matriz[i].length ;j++) {
				this.matriz[i][j] = 0;
			}
		}
	}

	/**
	 * Este constructor crea un objeto matriz a partir de un array bidimensional de doubles
	 * que sería la matriz en si.
	 * 
	 * @param matriz un array de doubles de 2 dimensiones, que serán los elementos de la propia matriz 
	 */
	public Matriz(double[][] matriz) {
		super();
		this.matriz = matriz;
	}
	
	/**
	 * Método que convierte un objeto de nuestra matriz en un string
	 * de la forma en la que se especifica en el enunciado del ejercicio.
	 */
	@Override
	public String toString() {
		String matrizStr = "";
		for (int i=0; i < this.matriz.length; i++) {
			matrizStr += "( ";
			for(int j=0; j < this.matriz[i].length ;j++) {
				
				matrizStr += this.matriz[i][j] + " ";
				//TODO: Aquí en lugar de escribir el número así tal cual, 
				//		podríamos escribirlo especificando un tamaño fijo de caracteres
				//		ara así poder ver la matriz mejor en caso de tener muchos decimales
				//		en algunos números y pocos en otros.
			}
			matrizStr += ")\n";
		}
		
		return matrizStr;
	}

	/**
	 * Este método implementa la operación de suma de matrices
	 * entre el propio objeto que llama a la matriz y el que se le pasa por parámetro
	 * 
	 * @param operando es la matriz con la que queremos sumar la matriz desde donde se llama el método
	 * @return la matriz resultado de la suma si la suma se ha podido realizar.
	 * En caso de que no se puedan sumar se devolverá null.
	 */
	public Matriz sumar(Matriz operando) {
		//TODO: implementarla operación de suma
		return this;
	}
	
	/**
	 * Este método implementa la operación de multiplicación de matrices
	 * entre el propio objeto que llama a la matriz y el que se le pasa por parámetro
	 * 
	 * @param operando es la matriz con la que queremos multiplicar la matriz desde donde se llama el método
	 * @return la matriz resultado de la multiplicación si se ha podido realizar.
	 * En caso de que no se puedan multiplicar se devolverá null.
	 */
	public Matriz multiplicar(Matriz operando) {
		//TODO: implementarla operación de multiplicar con un operando Matriz
		return this;
	}
	
	/**
	 * Este método implementa la operación de multiplicar una matriz por un número.
	 * @param escalar es el número por el que se multiplicará la matriz
	 * @return la matriz resultado de la multiplicación.
	 */
	public Matriz multiplicar(double escalar) {
		//TODO: implementarla operación de multiplicar con un operando escalar
		return this;
	}
	
	/**
	 * Este método calcula el determinante de la matriz.
	 * @return el resultado del determinante de la matriz en caso de poder realizarse.
	 * En caso contrario devolverá null.
	 */
	public Double determinante() {
		// he decidido cambiar el tipo a devolver en esta función
		// debido a que hay que controlar las situaciones en las que no se puede
		// calcular el determinante, por lo tanto si usamos la clase Double
		// en lugar del primitivo podemos devolver null cuando no se pueda calcular
		
		//TODO: implementarla operación determinante
		return null;
	}

	/**
	 * Este método calcula la inversa de la matriz.
	 * @return la matriz inversa en caso de poder realizarse.
	 * En caso contrario devolverá null.
	 */
	public Matriz invertir() {
		//TODO: implementarla operación invertir
		return this;
	}
	
	/**
	 * Este método calcula la matriz traspuesta.
	 * @return la matriz traspuesta.
	 */
	public Matriz traspuesta() {
		//TODO: implementarla operación traspuesta
		return this;
	}
}
