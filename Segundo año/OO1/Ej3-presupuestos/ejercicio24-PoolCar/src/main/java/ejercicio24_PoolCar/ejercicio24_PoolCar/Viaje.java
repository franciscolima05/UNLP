package ejercicio24_PoolCar.ejercicio24_PoolCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
	private String origen;
	private String destino;
	private double costo;
	private LocalDate fecha;
	private List<Usuario> pasajeros;
	private Vehiculo auto;
	
	public Viaje(String origen, String destino, double costo, LocalDate fecha, Vehiculo au) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.fecha = fecha;
		this.auto = au;
		this.pasajeros = new ArrayList<Usuario>();
		this.pasajeros.add(this.auto.getPropietario())
;	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public double getCosto() {
		return costo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Usuario> getPasajeros(){
		return this.pasajeros;
	}
	
	public void registrarPasajero(Pasajero pasajero){
		if((this.pasajeros.size() < this.auto.getCantPasajeros())&&(!(pasajero.isNegativo())) && (LocalDate.now().isBefore(this.fecha.minusDays(2)))) {
			this.pasajeros.add(pasajero);
			pasajero.agregarViajrAnterior(this);
		}
	}
	
	public void procesarViaje() {
		this.pasajeros.stream().forEach(pasaj -> pasaj.pagarViaje(costo));
	}
}
