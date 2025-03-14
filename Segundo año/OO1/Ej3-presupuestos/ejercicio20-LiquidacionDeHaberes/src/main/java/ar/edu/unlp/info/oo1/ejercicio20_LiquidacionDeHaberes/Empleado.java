package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.*;

public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate fechaNacimiento;
	private int cantHijos;
	private List<Contrato> contratos;
	private boolean conyugue;
	
	
	public Empleado(String nombre, String apellido, int cUIL, LocalDate fechaNacimiento, int cantHijos, boolean conyugue) {
		this.nombre = nombre;
		this.apellido = apellido;
		CUIL = cUIL;
		this.fechaNacimiento = fechaNacimiento;
		this.cantHijos = cantHijos;
		this.contratos = new ArrayList<Contrato>();
		this.conyugue = conyugue;
	}
	
	public void agregarContrato(Contrato e) {
		this.contratos.add(e);
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean hasConyugue() {
		return conyugue;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCUIL() {
		return CUIL;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}


	public int calcularAntiguedad() {
		return this.contratos.stream()
		.mapToInt(fecha -> fecha.getSize())
		.sum();
	}
	
	public ReciboDeSueldo crearRecibo() {
		Contrato contrato =  this.contratos.stream().filter(cont -> cont.isActivo()).findFirst().orElseThrow();
		ReciboDeSueldo rds = new ReciboDeSueldo(this, contrato);
		return rds;
	}
}
