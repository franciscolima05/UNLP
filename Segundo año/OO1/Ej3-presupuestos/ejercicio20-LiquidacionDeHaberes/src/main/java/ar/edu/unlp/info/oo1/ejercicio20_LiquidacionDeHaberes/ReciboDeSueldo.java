package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ReciboDeSueldo {
	private String nombre;
	private String apellido;
	private int CUIT;
	private int antiguedad;
	private LocalDate fechaCreacion;
	private double montoTotal;
	
	public ReciboDeSueldo(Empleado emp, Contrato cont) {
		this.nombre = emp.getNombre();
		this.apellido = emp.getApellido();
		this.CUIT = emp.getCUIL();
		this.antiguedad = emp.calcularAntiguedad();
		this.fechaCreacion = LocalDate.now();
		this.montoTotal = cont.calcularMonto();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCUIT() {
		return CUIT;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

}
