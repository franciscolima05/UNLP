package ar.edu.info.unlp.ejercicio5;

public class Cuadrado implements Figura2D{

	public double lado;
	
	public Cuadrado() {} 
	
	public Cuadrado(double x) {
		this.lado = x;
	}
	
	public void setLado(double x) {
		this.lado = x;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro() {
		return this.lado * 4;
	}
	
	public double getArea() {
		return this.lado * this.lado;
	}
}
