package ar.edu.unlp.info.oo1.ejercicio10_El_Inversor;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

public class PlazoFijo extends Inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;


	public PlazoFijo() {
		this.fechaDeConstitucion = LocalDate.of(2024, 9, 17);
		this.montoDepositado = 0;
		this.porcentajeDeInteresDiario = 0;
	}
	
	public PlazoFijo(double monto, double interes) {
		this.fechaDeConstitucion = LocalDate.of(2024, 9, 17);
		this.montoDepositado = monto;
		this.porcentajeDeInteresDiario = interes;
	}
	

	
	public double valorActual() {
		long fecha = ChronoUnit.DAYS.between(this.fechaDeConstitucion, LocalDate.now());
		System.out.println("Monto: 20000 Fecha: " + fecha + "Suma: " + this.montoDepositado * this.porcentajeDeInteresDiario);
		return (this.montoDepositado + fecha * (this.montoDepositado * this.porcentajeDeInteresDiario));
	}

	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
}
