package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private List<AutoEnAlquiler> autosAlquilados;
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.autosAlquilados = new ArrayList<>();
	}
}
