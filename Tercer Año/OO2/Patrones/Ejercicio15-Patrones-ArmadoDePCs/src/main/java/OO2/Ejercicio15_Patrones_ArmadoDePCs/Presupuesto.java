package OO2.Ejercicio15_Patrones_ArmadoDePCs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private List<Componente> componentes;
	private String usuario;
	private LocalDate fecha;
	
	
	public Presupuesto() {
		this.componentes = new ArrayList<>();
	}
	
	public void add(Componente com) {
		this.componentes.add(com);
	}
	
	public double calcularConsumo() {
		return this.componentes.stream()
				.mapToDouble(comp -> comp.getConsumo())
				.sum();
	}
	
	public double calcularPrecio() {
		return this.componentes.stream()
				.mapToDouble(comp -> comp.getPrecio())
				.sum();	
	}
	
	public void setUsuario(String usu) {
		this.usuario = usu;
	}
}
