package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	private int cantidadDeDias;
	private LocalDate fecha;
	private AutoEnAlquiler auto;
	private Usuario conductor;
	private TipoDeCancelacion politica;
	
	public Reserva(int cantDias, LocalDate fecha, AutoEnAlquiler auto, Usuario cond, TipoDeCancelacion pol) {
		this.cantidadDeDias = cantDias;
		this.fecha = fecha;
		this.auto = auto;
		this.conductor = cond;
		this.politica = pol;
	}
	
	public int diasParaLaReserva() {
		return (int) ChronoUnit.DAYS.between(this.fecha, LocalDate.now());
	}
	
	public double montoAPagar() {
		return this.auto.getPrecioPorDia() * this.cantidadDeDias;
	}
	
	public double montoAReembolzar() {
		return this.politica.calcularReembolso(this);
	}
	
	public void cambiarPoliticaDeCancelacion(TipoDeCancelacion nuevaPolitica) {
		this.politica = nuevaPolitica;
	}
}
