package ar.edu.unlp.info.oo1.ejercicio12_VolumenYsuperficieDeSolidos;

import java.util.*;

public class ReporteDeConstruccion {
	private List<Pieza> listaPiezas;


	public ReporteDeConstruccion() {
		this.listaPiezas = new LinkedList<Pieza>();
	}
	
	public List<Pieza> getListaPiezas() {
		System.out.println("CANTIDAD DE ELEMENTOS: " + this.listaPiezas.size());
		return this.listaPiezas;
	}
	
	public void add(Pieza p) {
		this.listaPiezas.add(p);
	}
	
	public double getVolumenDeMaterial(String material) {
		return this.getListaPiezas().stream()
		.filter(pieza-> pieza.getMaterial() == material)
		.mapToDouble(pieza-> pieza.getVolumen())
		.sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.getListaPiezas().stream()
		.filter(pieza-> pieza.getColor() == color)
		.mapToDouble(pieza-> pieza.getSuperficie())
		.sum();
	}
}
