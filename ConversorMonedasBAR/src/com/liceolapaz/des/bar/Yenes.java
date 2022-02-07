package com.liceolapaz.des.bar;

public class Yenes extends Moneda {
protected final double TASA_CONVERSION = 0.067;
	
	public Yenes(double cantidad) {
		super(cantidad);
		this.tasaConversion = TASA_CONVERSION;
	}

}
