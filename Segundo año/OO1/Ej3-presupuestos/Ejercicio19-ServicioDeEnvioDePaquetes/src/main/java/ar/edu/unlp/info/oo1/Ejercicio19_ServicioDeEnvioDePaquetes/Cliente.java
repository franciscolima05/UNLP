package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;
import java.util.*;
public abstract class Cliente {
	private String nombre;
	private String direccion;
	private List<Envio> envios;
	
	public Cliente(String nom, String dir) {
		this.nombre = nom;
		this.direccion = dir;
		this.envios = new LinkedList<Envio>();
	}
	
	public  void agregarEnvio(Envio e) {
		this.envios.add(e);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public double montoAPagar(DateLapse periodo) {
		return this.envios.stream()
		.filter(fecha -> periodo.includesDate(fecha.getFecha()))
		.mapToDouble(monto -> this.montoAPagarConDescuento(monto.getMonto()))
		.sum();
	}
	
	public abstract double montoAPagarConDescuento(double precio);
}
