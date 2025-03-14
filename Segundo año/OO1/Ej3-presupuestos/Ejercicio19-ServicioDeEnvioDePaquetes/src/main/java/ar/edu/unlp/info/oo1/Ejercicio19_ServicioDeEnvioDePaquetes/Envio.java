package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

import java.time.LocalDate;

public abstract class Envio {
	private String destino;
	private String origen;
	private double peso;
	private LocalDate fecha;
	
	public Envio(String des, String ori, double p, LocalDate fe) {
		this.destino = des;
		this.origen = ori;
		this.peso = p;
		this.fecha = fe;
	}
	
	public String getDestino() {
		return destino;
	}


	public String getOrigen() {
		return origen;
	}


	public double getPeso() {
		return peso;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public abstract double getMonto();
}
