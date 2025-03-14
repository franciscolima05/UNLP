package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

import java.util.List;

public class Persona {
	private String nombre;
	private String direccion;
	private List<Pedido> pedidos;
	private List<Producto> productos;
	
	public Pedido crearPedido(Producto prod, TipoDeEnvio tipoEnvio, TipoDePago tipoPago, int cant) {
		if(cant <= prod.getStock()) {
			Pedido p = new Pedido(prod, this, tipoEnvio, tipoPago, cant);
			prod.decrementarCantidad(cant);
			this.pedidos.add(p);
			return p;
		}
		return null;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public Producto publicarProducto(String nombre, int stock, double precio, String categoria) {
		Producto prod = new Producto(nombre, precio, stock, categoria);
		this.productos.add(prod);
		return prod;
	}
	
	public BagImpl<String> conocerCantidad(){
		BagImpl<String> bolsa = new BagImpl<String>();
		this.pedidos.stream().forEach(p -> bolsa.add(p.getProd().getCategoria()));
		return bolsa;
	}
}
