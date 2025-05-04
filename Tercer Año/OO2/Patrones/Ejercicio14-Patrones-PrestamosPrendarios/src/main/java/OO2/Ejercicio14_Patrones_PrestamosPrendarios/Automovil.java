package OO2.Ejercicio14_Patrones_PrestamosPrendarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil implements Garantia{
	private LocalDate modelo;
	private int kilometraje;
	private double costo;
	
	
	public Automovil(LocalDate modelo, int km, double costo) {
		this.modelo = modelo;
		this.costo = costo;
		this.kilometraje = km;
	}
	
	public int calcularAntiguedad() {
		return (int) ChronoUnit.YEARS.between(modelo, LocalDate.now());
	}
	
	@Override
	public double calcularValorTotal() {
		return this.calcularValorGeneral() * 0.7;
	}

	@Override
	public double calcularValorGeneral() {
		return this.costo * (this.calcularAntiguedad() * 0.1);
	}

}
