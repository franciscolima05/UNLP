package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Veterinario {
	private String nombre;
	private LocalDate fechaIngreso;
	private double honorario;
	
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public double getHonorario() {
		return honorario;
	}
	public double getAntiguedad() {
		return ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
	}

	public double calcularBonificacionVet(){
		return this.getAntiguedad() * 100;
	}
	
}
