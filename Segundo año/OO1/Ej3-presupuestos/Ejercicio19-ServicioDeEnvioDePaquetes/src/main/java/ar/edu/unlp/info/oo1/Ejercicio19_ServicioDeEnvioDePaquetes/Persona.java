package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

public class Persona extends Cliente{
	private int DNI;
	
	
	public Persona(String nom, String dir, int D) {
		super(nom, dir);
		this.DNI = D;
	}

	public double montoAPagarConDescuento(double precio) {
		return precio - precio * 0.1;
	}

}
