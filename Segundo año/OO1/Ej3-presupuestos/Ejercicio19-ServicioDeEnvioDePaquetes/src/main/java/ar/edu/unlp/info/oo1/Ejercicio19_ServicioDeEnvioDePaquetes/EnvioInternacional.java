package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioInternacional extends Envio{

	public EnvioInternacional(String des, String ori, double p, LocalDate fe) {
		super(des, ori, p, fe);
	}

	public double getMonto() {
		if (this.getPeso() <= 1000) {
			return 5000 + 10 * this.getPeso();
		}
		else return 5000 + 12 * this.getPeso();
	}

}
