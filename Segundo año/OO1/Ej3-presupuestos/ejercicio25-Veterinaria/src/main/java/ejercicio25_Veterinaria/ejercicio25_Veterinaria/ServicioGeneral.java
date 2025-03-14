package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

import java.time.LocalDate;

public abstract class ServicioGeneral{
	private Mascota mascota;
	private LocalDate fecha;

	public Mascota getMascota() {
		return mascota;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

	public ServicioGeneral(Mascota mascota) {
		this.mascota = mascota;
		this.fecha = LocalDate.now();
		this.mascota.agregarALaLista(this);
	}
	
	public abstract double calcularCostoDeServicio();
}
