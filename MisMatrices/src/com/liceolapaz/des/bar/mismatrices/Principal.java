package com.liceolapaz.des.bar.mismatrices;

import java.util.Scanner;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		int [] a;
//		a = new int[10];
//		
//		for (int i=0; i<a.length; i++) {
//			a[i] = 0;
//		}
		
		
		
		
		System.out.println("MIS MATRICES");
		Matriz matrizA;
		
		System.out.print("Introduce número de filas:");
		int filas = recogerEntero();
		System.out.print("Introduce número de columnas:");
		int columnas = recogerEntero();
		//matrizA = new Matriz(filas, columnas);
		
		double[][] arrayMatriz = new double[filas][columnas];
		
		for (int i=0; i < arrayMatriz.length; i++) {
			for(int j=0; j < arrayMatriz[i].length ;j++) {
				arrayMatriz[i][j] = 0;
			}
		}
		matrizA = new Matriz(arrayMatriz);
		
		System.out.println(matrizA);
			
	}

	private static int recogerEntero() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
