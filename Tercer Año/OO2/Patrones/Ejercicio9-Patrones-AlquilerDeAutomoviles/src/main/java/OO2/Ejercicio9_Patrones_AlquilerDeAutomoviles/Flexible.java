package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

public class Flexible implements TipoDeCancelacion{

	@Override
	public double calcularReembolso(Reserva reservaActual) {
		return reservaActual.montoAPagar();
	}

}
