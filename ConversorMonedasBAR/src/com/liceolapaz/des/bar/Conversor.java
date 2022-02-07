package com.liceolapaz.des.bar;

import java.util.Scanner;

public class Conversor {

	public static void main(String[] args) {
		do {
			//  imprimir menu
			imprimirMenu();
			// pedir opcion
			pedirOpcion();
			//  recoller opcion
			int opcion = recogerOpcion();
			//comprobar opcion
			switch (opcion) {
			case 1:
				// Escriba la cantidad
				pedirCantidad();
				double cantidad = recogerCantidad();
				Dolar dolar = new Dolar(cantidad);
				double cantidadEnEuros = dolar.cantidadEnEuros();
				
				ensenharCantidadEuros(cantidadEnEuros);
				// instanciar un dollar
							// convertir
							// enseñar cantidad convertida 
				break;
			case 2: // libras
				pedirCantidad();
				cantidad = recogerCantidad();
				Libras libras = new Libras(cantidad);
				cantidadEnEuros = libras.cantidadEnEuros();
				
				ensenharCantidadEuros(cantidadEnEuros);
				break;
			case 3: // Yener
				pedirCantidad();
				cantidad = recogerCantidad();
				Yenes yenes = new Yenes(cantidad);
				cantidadEnEuros = yenes.cantidadEnEuros();
				
				ensenharCantidadEuros(cantidadEnEuros);
				break;
			case 0:
				//salir
				System.exit(0);
			default:
				System.out.println("Opción incorrecta");
				//opcion incorrecta
				
			// 1. Dollar
				// Escriba la cantidad
				// instanciar un dollar
				// convertir
				// enseñar cantidad convertida 
			// 2. Libras
			// 3, Yenes
			// 0 salir
			}
		} while (true);
	}

	private static void ensenharCantidadEuros(double cantidad) {
		System.out.println("La cantidad en euros es " + cantidad);
		
	}

	private static double recogerCantidad() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}

	private static void pedirCantidad() {
		System.out.print("Teclea cantidad a convertir: ");
		
	}

	private static int recogerOpcion() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Introduce opción: ");
		
	}

	private static void imprimirMenu() {
		System.out.println("CONVERSOR DE MONEDAS\n"
				+ "1. Dólares\n"
				+ "2. Libras\n"
				+ "3. Yens\n"
				+ "0. Salir");
	}

}
