package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

public class AutoEnAlquiler {
	private String marca;
	private double precioPorDia;
	private int cantidadDePiezas;
	
	public double getPrecioPorDia() {
		return this.precioPorDia;
	}

	public AutoEnAlquiler(String marca, double precioPorDia, int cantidadDePiezas) {
		super();
		this.marca = marca;
		this.precioPorDia = precioPorDia;
		this.cantidadDePiezas = cantidadDePiezas;
	}
}
