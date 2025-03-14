	package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class ServicioProfesional extends ServicioGeneral {
	private Veterinario veterinario;
	
	public ServicioProfesional(Mascota mascota, Veterinario vet) {
		super(mascota);
		this.veterinario = vet;
	}


	public Veterinario getVeterinario() {
		return veterinario;
	}
	
	public abstract double calcularMateriales();
	
	public abstract double calcularExtra();
	
	public double calcularSunday() {
		if (this.getFecha().getDayOfWeek().equals(DayOfWeek.SUNDAY)){
			return 500;
		}
		return 0;
	}
	
	public double calcularCostoDeServicio() {
		return this.veterinario.getHonorario() + this.calcularMateriales() + this.calcularExtra() + this.calcularSunday();
	}
}
