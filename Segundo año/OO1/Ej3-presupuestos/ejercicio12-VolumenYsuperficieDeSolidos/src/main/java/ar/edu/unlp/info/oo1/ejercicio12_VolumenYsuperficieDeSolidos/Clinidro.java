package ar.edu.unlp.info.oo1.ejercicio12_VolumenYsuperficieDeSolidos;

public class Clinidro extends Pieza {
	private int radio;
	private int altura;
	
	public Clinidro(int radio, int altura, String material, String color) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	public int getRadio() {
		return radio;
	}
	public int getAltura() {
		return altura;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public double getVolumen() {
		double num = Math.PI * this.getRadio() * this.getRadio() * this.getAltura();
		return Math.round(num * 100) / 100;
		
	}
	
	public double getSuperficie() {
		double num = (2 * Math.PI * this.getRadio() * this.getAltura() + 2 * Math.PI * this.getRadio() * this.getRadio());
		num = Math.round(num * 100) / 100.0;
		return num;
	}
}
