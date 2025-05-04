package OO2.Ejericico2_Patrones_CalculoDeSueldos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmpleadoPasante {

	
	EmpleadoPasante ep;
	
	@BeforeEach
	void setUp() {
		ep = new EmpleadoPasante(5);	
	}
	
	
	@Test
	void testBasico() {
		assertEquals(20000, ep.calcularBasico());
	}
	
	@Test
	void testAdicional() {
		assertEquals(10000, ep.calcularAdicional());
	}
	
	@Test
	void testDescuento() {
		assertEquals(3100, ep.calcularDescuento());
	}
	
	@Test
	void testSueldo() {
		assertEquals(26900, ep.sueldo());
	}
}
