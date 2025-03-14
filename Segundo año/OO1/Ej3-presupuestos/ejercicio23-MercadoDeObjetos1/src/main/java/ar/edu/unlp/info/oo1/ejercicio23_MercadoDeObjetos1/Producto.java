package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

public class Producto {
	private String nombre;
	private double precio;
	private int stock;
	private String categoria;
	
	
	public Producto(String nombre, double precio, int stock, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void decrementarCantidad(int cantidad) {
		this.stock -= cantidad;
	}
}
