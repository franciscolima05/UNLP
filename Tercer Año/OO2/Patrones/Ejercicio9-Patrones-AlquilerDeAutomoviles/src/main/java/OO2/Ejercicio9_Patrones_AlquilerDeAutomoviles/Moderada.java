package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

public class Moderada implements TipoDeCancelacion{

	@Override
	public double calcularReembolso(Reserva reservaActual) {
		int dias = reservaActual.diasParaLaReserva();
		if(dias >= 7) {
			return reservaActual.montoAPagar();
		}
		else {
			if(dias >=2) {
				return reservaActual.montoAPagar() * 0.5;
			}
		}
		return 0;
	}

}
