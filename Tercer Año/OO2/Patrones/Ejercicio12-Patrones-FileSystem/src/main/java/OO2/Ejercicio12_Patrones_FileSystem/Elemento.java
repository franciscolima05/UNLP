package OO2.Ejercicio12_Patrones_FileSystem;

import java.time.LocalDate;
import java.util.List;

public abstract class Elemento {
	private String nombre;
	private LocalDate fecha;
	
	public Elemento(String nombre, LocalDate fecha) {
		this.fecha = fecha;
		this.nombre = nombre;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract int calcularSize();
	
	public abstract Archivo masGrande();
	
	public abstract Archivo masNuevo();
	
	public abstract Elemento encontrar(String nom);

	public abstract void coincide(List<Elemento> lista, String nom);
}
