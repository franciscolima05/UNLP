package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

public class SeisCuotas extends TipoDePago{
	protected double recargo(Producto prod) {
		return prod.getPrecio()*0.20;
	}

}
