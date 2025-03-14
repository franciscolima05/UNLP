package ejercicio24_PoolCar.ejercicio24_PoolCar;

import java.time.Year;

public class Vehiculo {
	private String descripcion;
	private int cantPasajeros;
	private Year anio;
	private double valor;
	private Conductor propietario;
	
	
	public Vehiculo(String descripcion, int cantPasajeros, Year anio, double valor, Conductor propietario) {
		this.descripcion = descripcion;
		this.cantPasajeros = cantPasajeros;
		this.anio = anio;
		this.valor = valor;
		this.propietario = propietario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public Year getAnio() {
		return anio;
	}
	public double getValor() {
		return valor;
	}
	public Conductor getPropietario() {
		return this.propietario;
	}
	
	public int getAntiguedad() {
		return Year.now().minusYears(this.anio.getValue()).getValue();
	}

	public double calcularBonificacion() {
		return this.getValor() * 0.01;
	}
}
