package ar.edu.unlp.info.oo1.ejercicio12_VolumenYsuperficieDeSolidos;

public class Esfera extends Pieza {
	
	public Esfera(int radio, String material, String color) {
		super(material, color);
		this.radio = radio;
	}

	private int radio;

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public double getVolumen() {
		double num =  1.3 * Math.PI * Math.pow(this.getRadio(), 3);
		return Math.round(num * 100) / 100;
	}
	
	public double getSuperficie() {
		double num = 4 * Math.PI * Math.pow(radio, 2);
		num = Math.round(num * 100) / 100;
		return num;
	}
}
