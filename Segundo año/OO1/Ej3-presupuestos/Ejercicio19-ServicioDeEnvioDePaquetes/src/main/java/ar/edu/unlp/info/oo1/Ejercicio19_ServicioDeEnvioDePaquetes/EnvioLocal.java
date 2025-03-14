package ar.edu.unlp.info.oo1.Ejercicio19_ServicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioLocal extends Envio {
	private boolean entregaRapida;

	public EnvioLocal(String des, String ori, double p, LocalDate fe, boolean er) {
		super(des, ori, p, fe);
		this.entregaRapida = er;
	}
	public double getMonto() {
		if (this.entregaRapida) {
			return 1500;
		}
		return 1000;
	}

}
