package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;

public class DePlanta extends Contrato{
	private double sueldoMensual;
	private double montoPorConyugue;
	private double montoPorHijo;

	public boolean isActivo() {
		return true;
	}

	public DePlanta(Empleado emp, LocalDate fechaInicio, double sueldoMensual, double montoPorConyugue,
			double montoPorHijo) {
		super(emp, fechaInicio);
		this.sueldoMensual = sueldoMensual;
		this.montoPorConyugue = montoPorConyugue;
		this.montoPorHijo = montoPorHijo;
	}

	public double getSueldoTotal() {
		double monto = this.sueldoMensual;
		if (this.getEmpleado().hasConyugue()) {
			monto =+ this.montoPorConyugue;
		}
		if(this.getEmpleado().getCantHijos() > 0) {
			monto =+ this.montoPorHijo * this.getEmpleado().getCantHijos();
		}
		return monto;
	}
}
