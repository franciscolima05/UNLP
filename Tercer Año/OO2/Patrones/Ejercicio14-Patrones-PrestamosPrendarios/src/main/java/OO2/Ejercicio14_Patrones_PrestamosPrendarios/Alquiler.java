package OO2.Ejercicio14_Patrones_PrestamosPrendarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Garantia{
	private LocalDate comienzoContrato;
	private LocalDate finContrato;
	private double costoMensual;
	
	
	public Alquiler(LocalDate inicio, LocalDate fin, double costo) {
		this.comienzoContrato = inicio;
		this.finContrato = fin;
		this.costoMensual = costo;
	}
	
	public int calcularMesesRestantes() {
		return (int)ChronoUnit.MONTHS.between(comienzoContrato, finContrato);
	}
	
	@Override
	public double calcularValorTotal() {
		return this.calcularValorGeneral() * 0.9;
	}

	@Override
	public double calcularValorGeneral() {
		return this.calcularMesesRestantes() * this.costoMensual;
	}
	

}
