package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

public class PoliticaDeCancelacionModerada implements PoliticaDeCancelacion{

	@Override
	public double reembolsar(Reserva r) {
		if(r.getDuracion() >= 7) {
			return r.montoTotal();
		}
		if(r.getDuracion() > 2) {
			return r.montoTotal() * 0.5;
		}
		return 0;
	}
	
}
