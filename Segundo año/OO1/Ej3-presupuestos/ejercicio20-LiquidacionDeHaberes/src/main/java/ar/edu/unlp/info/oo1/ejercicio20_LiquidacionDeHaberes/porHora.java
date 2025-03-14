package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;

public class porHora extends Contrato{
	private double valorPorHora;
	private int cantHoras;
	private LocalDate fechaFin;
	
	
	public boolean isActivo() {
		return this.fechaFin.isAfter(LocalDate.now());
	}


	public porHora(Empleado emp, LocalDate fechaInicio, double valorPorHora, int cantHoras, LocalDate fechaFin) {
		super(emp, fechaInicio);
		this.valorPorHora = valorPorHora;
		this.cantHoras = cantHoras;
		this.fechaFin = fechaFin;
	}

	public double getSueldoTotal() {
		return this.valorPorHora * this.cantHoras;
	}
}
