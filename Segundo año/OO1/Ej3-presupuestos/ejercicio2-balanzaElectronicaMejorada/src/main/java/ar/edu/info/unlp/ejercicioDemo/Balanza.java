package ar.edu.info.unlp.ejercicioDemo;

public class Balanza {
	private Integer cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza(){
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto  produ) {
		this.cantidadDeProductos++;
		this.pesoTotal += produ.getPeso();
		this.precioTotal += produ.getPrecioPorKilo() * produ.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket t1 = new Ticket(this.cantidadDeProductos, this.precioTotal, this.pesoTotal);
		return t1;
	}
	
}
