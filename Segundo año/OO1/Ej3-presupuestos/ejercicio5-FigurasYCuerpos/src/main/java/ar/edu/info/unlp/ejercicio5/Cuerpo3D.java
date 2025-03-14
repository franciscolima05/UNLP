package ar.edu.info.unlp.ejercicio5;

public class Cuerpo3D {
	private double altura;
	private Figura2D caraBasal;
	
	public void setAltura(double x) {
		this.altura = x;
	}
	
	public void setCaraBasal(Figura2D figura) {
		this.caraBasal = figura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea() * this.altura;
	}
}
