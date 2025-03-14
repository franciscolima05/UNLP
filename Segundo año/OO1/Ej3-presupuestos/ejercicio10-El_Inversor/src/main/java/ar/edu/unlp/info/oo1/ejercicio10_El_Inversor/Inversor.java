package ar.edu.unlp.info.oo1.ejercicio10_El_Inversor;

import java.util.*;

public class Inversor {

	private String nombre;
	private List<Inversion> inversiones;

	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Inversion> getInversiones() {
		return inversiones;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setInversiones(List<Inversion> inversiones) {
		this.inversiones = inversiones;
	}
}

