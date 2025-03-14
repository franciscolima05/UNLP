package ar.edu.unlp.info.oo1.ejercicio10_El_Inversor;

public class InversionEnAcciones extends Inversion{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nom, int cant, double val) {
		this.nombre = nom;
		this.cantidad = cant;
		this.valorUnitario = val;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double valorActual() {
		return this.cantidad * this.valorUnitario;
	}
}
