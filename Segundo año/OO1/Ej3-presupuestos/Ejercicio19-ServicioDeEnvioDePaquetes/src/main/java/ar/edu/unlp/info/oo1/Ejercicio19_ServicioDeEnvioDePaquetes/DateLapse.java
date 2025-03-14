package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate to;
	private LocalDate from;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.to = to;
		this.from = from;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(this.from, this.to);
	}
	
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.from) && other.isBefore(this.to);
	}
	public boolean overlapse(DateLapse periodo) {
		return !((this.from.isAfter(periodo.to)) || (this.to.isBefore(periodo.from)));
	}
}
	