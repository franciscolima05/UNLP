package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;
import java.time.LocalDate;
import java.util.*;
public class Usuario {
	private Integer dni;
	private String nombre;
	private String direccion;
	private LinkedList<Propiedad> propiedades;
	
	
	public Usuario(Integer dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.propiedades = new LinkedList<Propiedad>();
	}
	
	public void agregarPropiedad(Propiedad prop) {
		this.propiedades.add(prop);
	}
	
	public double calcularRetribucion() {
		return this.propiedades.stream()
		.mapToDouble(precio -> precio.montoTotal())
		.sum();
	}
	
	public Integer cantidadPropiedades() {
		return this.propiedades.size();
	}
}
