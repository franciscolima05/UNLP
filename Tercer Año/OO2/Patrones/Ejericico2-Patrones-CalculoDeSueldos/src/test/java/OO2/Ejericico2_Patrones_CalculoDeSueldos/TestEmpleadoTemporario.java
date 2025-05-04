package OO2.Ejericico2_Patrones_CalculoDeSueldos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmpleadoTemporario {

	EmpleadoTemporario temp;
	
	
	@BeforeEach
	void setUp() {
		temp = new EmpleadoTemporario(10, 1, true);
	}
	
	
	@Test
	void testBasico() {
		assertEquals(23000, temp.calcularBasico());
	}
	
	@Test
	void testAdicional() {
		assertEquals(7000, temp.calcularAdicional());
	}
	
	@Test
	void testDescuento() {
		assertEquals(3340, temp.calcularDescuento());
	}
	
	@Test
	void testSueldo() {
		assertEquals(26660, temp.sueldo());
	}
}
