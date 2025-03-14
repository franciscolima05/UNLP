package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Contrato {
	private Empleado emp;
	private LocalDate fechaInicio;

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public Empleado getEmpleado() {
		return this.emp;
	}
	
	public int getSize() {
		return (int) ChronoUnit.YEARS.between(fechaInicio, LocalDate.now());
	}

	public abstract boolean isActivo();
	
	public abstract double getSueldoTotal();
	
	public double calcularMonto() {
		int ant = this.getAntiguedad();
		double monto = this.getSueldoTotal();
		if((ant >= 5) && (ant<10)) {
			return monto + monto * 0.3;
		}
		if((ant>=10) && (ant<15)) {
			return monto + monto * 0.5;
		}
		if((ant>=15) && (ant<20)) {
			return monto + monto * 0.7;
		}
		return monto * 2;
	}

	public Contrato(Empleado emp, LocalDate fechaInicio) {
		this.emp = emp;
		this.fechaInicio = fechaInicio;
	}

	public int getAntiguedad() {
		return this.emp.calcularAntiguedad();
	}
}
