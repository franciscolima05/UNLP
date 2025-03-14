package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

public class Archivo {
	private String nombre;

	
	public Archivo(String nom) {
		this.nombre = nom;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Integer tamaño() {
		return this.getNombre().length();
	}
}
