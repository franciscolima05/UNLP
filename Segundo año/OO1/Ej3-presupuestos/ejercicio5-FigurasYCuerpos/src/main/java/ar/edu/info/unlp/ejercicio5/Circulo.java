package ar.edu.info.unlp.ejercicio5;


public class Circulo implements Figura2D{
	private double radio;
	private double diametro;

	public Circulo() {}
	
	public Circulo(double r) {
		this.radio = r;
	}
	
	public void setRadio(double x) {
		this.radio = x;
		this.diametro = this.radio * 2;
	}
	
	public void setDiametro(double y) {
		this.diametro = y;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}

	public double getPerimetro() {
		return Math.PI * this.diametro;
	}
	
	public double getArea() {
		return Math.PI * (this.radio * this.radio);
	}
	
	public double getRadio() {
		return this.radio;
	}
}

