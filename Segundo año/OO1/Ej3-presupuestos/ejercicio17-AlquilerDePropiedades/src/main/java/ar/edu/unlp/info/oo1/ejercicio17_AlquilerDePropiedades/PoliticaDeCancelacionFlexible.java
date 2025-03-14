package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

import java.time.LocalDate;

public class PoliticaDeCancelacionFlexible implements PoliticaDeCancelacion{

	@Override
	public double reembolsar(Reserva r) {
			return r.montoTotal();
	}
}
