package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
	private String nombre;
	private LocalDate fechaDeNacimiento;
	private String especie;
	private List<ServicioGeneral> serviciosAnteriores;	
	
	public Mascota(String nombre, LocalDate fechaDeNacimiento, String especie,
		List<ServicioGeneral> serviciosAnteriores) {
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.especie = especie;
		this.serviciosAnteriores = new ArrayList<>();
	}

	public void agregarALaLista(ServicioGeneral sg) {
		this.serviciosAnteriores.add(sg);
	}
	
	public boolean utilizoServicios(int cant) {
		return this.serviciosAnteriores.size() > cant;
	}
	
	public double recaudacion(LocalDate fecha) {
		return this.serviciosAnteriores.stream().filter(atencion -> atencion.getFecha().equals(fecha))
		.mapToDouble(at -> at.calcularCostoDeServicio())
		.sum();
	}
}
