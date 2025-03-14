package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Reserva{
	private DateLapse periodo;
	private Propiedad propiedad;
	private Usuario inquilino;
	
	public Reserva(DateLapse p, Propiedad prop, Usuario inquilino) {
		super();
		this.periodo = p;
		this.propiedad = prop;
	}
	
	public int getDuracion() {
		return this.periodo.sizeInDays();
	}
	
	public double montoTotal() {
		return periodo.sizeInDays() * this.propiedad.getPrecio();
	}
	
	public boolean estaDisponible(DateLapse periodo){
		return this.periodo.overlapse(periodo);
	}
	
	
	
}
