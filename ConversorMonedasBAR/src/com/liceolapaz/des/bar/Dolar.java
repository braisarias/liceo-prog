package com.liceolapaz.des.bar;

public class Dolar extends Moneda {
	private final double TASA_CONVERSION = 0.883509299;
	
	public Dolar(double cantidad) {
		super(cantidad);
		this.tasaConversion = TASA_CONVERSION;
	}

	

}
