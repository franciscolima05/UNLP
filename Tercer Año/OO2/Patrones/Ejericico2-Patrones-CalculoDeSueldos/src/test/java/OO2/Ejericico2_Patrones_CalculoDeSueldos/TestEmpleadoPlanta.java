package OO2.Ejericico2_Patrones_CalculoDeSueldos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmpleadoPlanta {

	EmpleadoPlanta ep;
	
	
	@BeforeEach
	void setUp() {
		ep = new EmpleadoPlanta(10, 2, true);
	}
	
	@Test
	void testSueldo() {
		assertEquals(71050, ep.sueldo());
	}
	
	@Test
	void testDescuento() {
		assertEquals(7950, ep.calcularDescuento());
	}
	
	@Test
	void testAdicional() {
		assertEquals(29000, ep.calcularAdicional());
	}
	
	@Test
	void testBasico() {
		assertEquals(50000, ep.calcularBasico());
	}
	
}
