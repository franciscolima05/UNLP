package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

public class Pedido {
	private Producto prod;
	private Persona persona;
	private TipoDeEnvio tipoEnvio;
	private TipoDePago tipoPago;
	private int cantidad;

	

	public Producto getProd() {
		return prod;
	}



	public Persona getPersona() {
		return persona;
	}



	public TipoDeEnvio getTipoEnvio() {
		return tipoEnvio;
	}



	public TipoDePago getTipoPago() {
		return tipoPago;
	}


	public int getCantidad() {
		return cantidad;
	}
	
	public double calcularPrecio(String dirVendedor) {
		return this.tipoEnvio.calcularPrecio(dirVendedor, this.persona.getDireccion()) + this.tipoPago.montoTotal(prod);
	}


	public Pedido(Producto prod, Persona per, TipoDeEnvio tipoEnvio, TipoDePago tipoPago, int cantUnidades) {
			this.prod = prod;
			this.prod.decrementarCantidad(cantUnidades);
			this.cantidad = cantUnidades;
			this.persona = per;
			this.tipoEnvio = tipoEnvio;
			this.tipoPago = tipoPago;
	}
}