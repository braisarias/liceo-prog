package com.liceolapaz.des.bar;

public class Libras extends Moneda {
	protected final double TASA_CONVERSION = 1.20;
	
	public Libras(double cantidad) {
		super(cantidad);
		this.tasaConversion = TASA_CONVERSION;
	}

	

}
