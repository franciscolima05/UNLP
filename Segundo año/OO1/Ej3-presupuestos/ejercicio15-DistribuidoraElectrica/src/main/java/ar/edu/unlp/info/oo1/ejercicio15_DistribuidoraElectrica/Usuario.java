package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;
import java.util.*;

import ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes.CuadroTarifario;
public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<Consumo>();
	}
	
	public void agregarConsumo(Consumo con) {
		this.consumos.add(con);
	}
	
	public Factura crearFactura(CuadroTarifario cuadro) {
		Consumo ult = this.consumos.get(this.consumos.size()-1);
		double monto= ult.precio(cuadro.getPrecio());
		double bonificacion=0;
		if (ult.hayBonificacion()) {
			bonificacion=monto * 0.10;
		}
		return new Factura(this, bonificacion, monto-bonificacion);
	}

}
