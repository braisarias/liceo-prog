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
		if(this.matriz.length == operando.matriz.length && this.matriz[0].length == operando.matriz[0].length){
			double[][] resultado = new double[matriz.length][matriz[0].length];
			for (int i = 0; i < matriz.length; i++){
				for (int j = 0; j < matriz[0].length;j++){
					resultado[i][j] = this.matriz[i][j] + operando.matriz[i][j];
				}
			}
			Matriz resultadoMatriz = new Matriz(resultado);
			return resultadoMatriz;
		}
		else{
			return null;
		}
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
		
		if(this.matriz[0].length == operando.matriz.length) {
			Matriz matrizResultado;
			double[][] resultado;
			int filas = this.matriz.length;
			int columnas = operando.matriz[0].length;
			resultado = new double[filas][columnas];
			
			// rellenamos array resultado
			for (int i=0; i < filas; i++) {
				for(int j=0; j < columnas; j++) {
					double elemento = 0;
					
					for(int k=0; k < columnas; k++) {
						double a = this.matriz[i][k];
						double b = operando.matriz[k][j];
						elemento += a * b;
					}
					resultado[i][j] = elemento;
				}
			}
			
			matrizResultado = new Matriz(resultado);
			return matrizResultado;
		}
		return null;
	}
	
	/**
	 * Este método implementa la operación de multiplicar una matriz por un número.
	 * @param escalar es el número por el que se multiplicará la matriz
	 * @return la matriz resultado de la multiplicación.
	 */
	public Matriz multiplicar(double escalar) {
		Matriz matrizResultado;
		
		double[][] resultado;
		
		resultado = new double[this.matriz.length][this.matriz[0].length];
		
		
		for (int i=0; i < this.matriz.length; i++) {
			for (int j=0; j < this.matriz[0].length; j++) {
				resultado[i][j] = this.matriz[i][j] * escalar;
			}
		}
		matrizResultado = new Matriz (resultado);
		return matrizResultado;
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
		
		if (this.matriz.length != this.matriz[0].length) {
			return null;
		}
		
		if (this.matriz.length == 2) {
			return this.matriz[0][0] * this.matriz[1][1] - this.matriz[0][1]*this.matriz[1][0];
		}
		if (this.matriz.length == 1){
			return this.matriz[0][0];
		}
		double resultado = 0;
		for (int i=0; i < this.matriz.length; i++) {
			double e = this.matriz[0][i];
			resultado += e * Math.pow(-1, i) * this.adjuntaXY(0,i).determinante();
		}
		
		return resultado;
	}

	private Matriz adjuntaXY(int x, int y) {
		double[][] resultado = new double[this.matriz.length -1][this.matriz[0].length -1];
		int iA = 0;
		int jA = 0;
		
		for (int i=0; i < this.matriz.length; i++) {
			for (int j=0; j < this.matriz[0].length; j++) {
				
				if (jA >= resultado.length) {
					jA = 0;
					iA++;
				}
				
				if (i != x && j != y) {
					resultado[iA][jA++] = this.matriz[i][j];
				}
				
			}
		}
		return new Matriz(resultado);
	}

	/**
	 * Este método calcula la inversa de la matriz.
	 * @return la matriz inversa en caso de poder realizarse.
	 * En caso contrario devolverá null.
	 */
	public Matriz invertir() {
		if (this.matriz.length != this.matriz[0].length) {
			return null; // matriz no cuadrada
		}
		double determinante = this.determinante();
		
		if (determinante == 0) {
			return null; // determinante distinto de cero para poder calcular
			
		}
		return this.adjunta().traspuesta().multiplicar(1/determinante);
	}
	
	private Matriz adjunta() {
		double [][] vAdj = new double[this.matriz.length][this.matriz[0].length];
		int signo = 1;
		for (int i=0; i < this.matriz.length; i++) {
			for (int j=0; j < this.matriz[0].length; j++) {
				signo = (int) Math.pow(-1, i+j);
				vAdj[i][j] = signo * this.adjuntaXY(i, j).determinante();
			}
		}
		
		return new Matriz(vAdj);
	}
	
	/**
	 * Este método calcula la matriz traspuesta.
	 * @return la matriz traspuesta.
	 */
	public Matriz traspuesta() {
		Matriz matrizResultado;
		double[][] resultado;
		
		resultado = new double[this.matriz[0].length][this.matriz.length];
		
		for (int i=0; i < this.matriz.length; i++) {
			for (int j=0; j < this.matriz[0].length; j++) {
				resultado[j][i] = this.matriz[i][j];
			}
		}
		matrizResultado = new Matriz (resultado);
		return matrizResultado;
	}
}
