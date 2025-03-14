package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

import java.time.LocalDate;
import java.util.LinkedList;

public class Propiedad {
	@SuppressWarnings("unused")
	private String direccion;
	@SuppressWarnings("unused")
	private String nombre;
	private double precio;
	private LinkedList<Reserva> reservas;
	private PoliticaDeCancelacion politica;
	
	public Propiedad(String direccion, String nombre, double precio, PoliticaDeCancelacion pol) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precio = precio;
		this.reservas = new LinkedList<Reserva>();
		this.politica = pol;
	}

	public double getPrecio() {
		return this.precio;
	}
	
	public double montoTotal() {
		return this.reservas.stream()
		.mapToDouble(precio -> precio.montoTotal())
		.sum();
	}
	
	public LinkedList<Reserva> getReservas() {
		return this.reservas;
	}
	
	public Reserva crearReserva(Usuario inquilino, DateLapse periodo) {
		if(this.isDisponible(periodo)) {
			Reserva res = new Reserva(periodo, this, inquilino);
			this.reservas.add(res);
			return res;
		}
		return null;
	}
	
	public boolean isDisponible(DateLapse periodo){
		return this.reservas.stream()
				.noneMatch( r -> r.estaDisponible(periodo));
	}
	
	public double cancelarReserva(Reserva r) {
		if(r.puedeCancelar()) {
			this.reservas.remove(r);
			return this.politica.reembolzar(r);
		}
	}
}
