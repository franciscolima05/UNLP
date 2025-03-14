package ar.edu.unlp.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.*;
public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> listaItem;
	
	
	public Presupuesto(String s){
		this.cliente = s;
		this.listaItem = new LinkedList<Item>();
		this.fecha = LocalDate.now();
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public void agregarItem(Item i) {
		this.listaItem.add(i);
	}
	
	public double calcularTotal() {
		int aux = 0;
		for(Item i : this.listaItem) {
			aux += i.costo();
		}
		return aux;
	}
}
