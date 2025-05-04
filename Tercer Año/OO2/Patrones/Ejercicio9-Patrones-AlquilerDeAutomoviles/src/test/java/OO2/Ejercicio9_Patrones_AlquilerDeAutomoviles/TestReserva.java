package OO2.Ejercicio9_Patrones_AlquilerDeAutomoviles;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReserva {

	AutoEnAlquiler auto;
	Reserva reservaPrueba;
	Usuario conductor;
	
	@BeforeEach
	void setUp() {
		auto = new AutoEnAlquiler("Fiat", 1000, 4);
		conductor = new Usuario("Francisco");
		reservaPrueba = new Reserva(10, LocalDate.of(2025, 4, 14), auto, conductor, new Flexible());
	}
	
	
	@Test
	void testCancelacion() {
		System.out.println(reservaPrueba.montoAReembolzar());
		reservaPrueba.cambiarPoliticaDeCancelacion(new Moderada());
		System.out.println(reservaPrueba.montoAReembolzar());
	}
}
