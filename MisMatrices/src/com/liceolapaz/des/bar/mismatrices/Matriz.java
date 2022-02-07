package com.liceolapaz.des.bar.mismatrices;

import java.util.Arrays;

class Matriz {
	private double [][] matriz;

	public Matriz(int filas, int columnas) {
		this.matriz = new double[filas][columnas];
		
		for (int i=0; i < this.matriz.length; i++) {
			for(int j=0; j < this.matriz[i].length ;j++) {
				this.matriz[i][j] = 0;
			}
		}
	}

	@Override
	public String toString() {
		String matrizStr = "";
		for (int i=0; i < this.matriz.length; i++) {
			matrizStr += "( ";
			for(int j=0; j < this.matriz[i].length ;j++) {
				
				matrizStr += this.matriz[i][j] + " ";
				
			}
			matrizStr += ")\n";
		}
		
		return matrizStr;
	}

	public Matriz(double[][] matriz) {
		super();
		this.matriz = matriz;
	}

	public Matriz sumar(Matriz operando) {
		return null;
	}
	
}
