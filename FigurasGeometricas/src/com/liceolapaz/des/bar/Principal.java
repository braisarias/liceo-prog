package com.liceolapaz.des.bar;

import java.util.Scanner;

public class Principal {


	public static void main(String[] args) {
		while (true) {
			imprimirMenu();
			int opcion = recogerOpcion();
			
			FiguraGeometrica figura = null;
			switch (opcion) {
			case 0:
				System.exit(0);
			case 1:
				figura = pedirDatosTriangulo();
				break;
			case 2:
				figura = pedirDatosRectangulo();
				break;
			case 3:
				figura = pedirDatosCuadrado();
				break;
			case 4:
				figura = pedirDatosPentagono();
				break;
			default:
				System.out.println("Opción no válida.");
				continue;
			}
			System.out.println("El área es " +
					figura.calcularArea() + 
					" y el perímetro es " +
					figura.calcularPerimetro());
		}
	}

	private static Pentagono pedirDatosPentagono() {
		System.out.print("Introduce lado:");
		double lado = recogerDato();
		
		System.out.print("Introduce apotema:");
		double apotema = recogerDato();
		
		return new Pentagono(lado, apotema);
	}

	private static Cuadrado pedirDatosCuadrado() {
		System.out.print("Introduce lado:");
		double lado = recogerDato();
		
		return new Cuadrado(lado);
	}

	private static Rectangulo pedirDatosRectangulo() {
		System.out.print("Introduce base:");
		double base = recogerDato();
		
		System.out.print("Introduce altura:");
		double altura = recogerDato();
		
		return new Rectangulo(base, altura);
	}

	private static Triangulo pedirDatosTriangulo() {
		System.out.print("Introduce lado1:");
		double lado1 = recogerDato();
		
		System.out.print("Introduce lado2:");
		double lado2 = recogerDato();
		
		System.out.print("Introduce lado3:");
		double lado3 = recogerDato();
		
		System.out.print("Introduce altura:");
		double altura = recogerDato();
		
		Triangulo triangulo = new Triangulo(lado1, lado2, lado3, altura);
		return triangulo;
		
	}

	private static double recogerDato() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	
	private static int recogerOpcion() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static void imprimirMenu() {
		System.out.print("FIGURAS GEOMÉTRICAS\n"
				+ "1. Triángulo\n"
				+ "2. Rectángulo\n"
				+ "3. Cuadrado\n"
				+ "4. Pentágono\n"
				+ "0. Salir\n"
				+ "Escoja una opción: ");
	}

}
