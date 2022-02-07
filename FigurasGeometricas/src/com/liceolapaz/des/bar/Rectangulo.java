package com.liceolapaz.des.bar;

class Rectangulo implements FiguraGeometrica {

	private double base;
	private double altura;
	
	
	public Rectangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return this.altura * this.base;
	}

	@Override
	public double calcularPerimetro() {
		return (this.altura + this.base)*2;
	}

}
