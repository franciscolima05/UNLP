package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

public class Empresa extends Cliente{
	private int CUIT;

	public Empresa(String nom, String dir, int c) {
		super(nom, dir);
		this.CUIT = c;
	}

	@Override
	public double montoAPagarConDescuento(double precio) {
		return precio;
	}
}
