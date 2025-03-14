package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio{
	private int km;

	public EnvioInterurbano(String des, String ori, double p, LocalDate fe, int kms) {
		super(des, ori, p, fe);
		this.km = kms;
	}
	
	public double getMonto() {
		double peso = this.getPeso();
		if (this.km <= 100) {
			return 20 * peso;
		}
		else {
			if (this.km <= 500) {
				return 25 * peso;
			}
		}
		return 30 * peso;
	}

}
