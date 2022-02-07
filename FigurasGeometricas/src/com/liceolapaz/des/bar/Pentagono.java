package com.liceolapaz.des.bar;

class Pentagono implements FiguraGeometrica {

	private double lado;
	private double apotema;
	
	
	
	public Pentagono(double lado, double apotema) {
		super();
		this.lado = lado;
		this.apotema = apotema;
	}

	@Override
	public double calcularArea() {
		return this.calcularPerimetro() * this.apotema/2;
	}

	@Override
	public double calcularPerimetro() {
		return this.lado*5;
	}

}
