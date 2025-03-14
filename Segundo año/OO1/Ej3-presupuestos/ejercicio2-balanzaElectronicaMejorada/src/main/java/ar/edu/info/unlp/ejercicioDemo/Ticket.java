package ar.edu.info.unlp.ejercicioDemo;

import java.time.LocalDate;

public class Ticket {
	private LocalDate fecha;
	private Integer cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Ticket(int cant, double prec, double peso) {
		this.cantidadDeProductos = cant;
		this.precioTotal = prec;
		this.pesoTotal = peso;
		this.fecha = LocalDate.now();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public double impuesto() {
		return precioTotal * 0.21;
	}
	
}
