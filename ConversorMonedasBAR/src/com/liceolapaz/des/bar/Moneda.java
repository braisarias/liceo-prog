package com.liceolapaz.des.bar;

public abstract class Moneda {
	public Moneda(double cantidad) {
		super();
		this.cantidad = cantidad;
	}

	protected double cantidad;
	protected double tasaConversion;
	
	protected double cantidadEnEuros() {
		// tasa de conversion
		// cantidad a convertir
		return this.cantidad * tasaConversion;
}
}
