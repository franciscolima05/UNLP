package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;
import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private Usuario usuario;
	private double bonificacion;
	private double montoTotal;
	
	public Factura(Usuario user, double bonif, double monto) {
		this.fecha=LocalDate.now();
		this.usuario = user;
		this.bonificacion = bonif;
		this.montoTotal = monto;
	}
}
	
