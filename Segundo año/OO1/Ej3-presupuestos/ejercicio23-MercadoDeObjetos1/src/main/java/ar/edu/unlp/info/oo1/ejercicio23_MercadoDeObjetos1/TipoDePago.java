package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

public abstract class TipoDePago {
	

	public double montoTotal(Producto prod){
		return this.precioProducto(prod) + this.recargo(prod);
	}
	
	private double precioProducto(Producto prod) {
		return prod.getPrecio();
	}
	
	protected abstract double recargo(Producto prod);

}
