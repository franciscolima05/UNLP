package ejercicio24_PoolCar.ejercicio24_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUsuario {

	
	Pasajero pas1;
	Conductor cond1;
	Vehiculo v8;
	
	
	@BeforeEach
	void setUp() {
		pas1 = new Pasajero("Jonas", 200);
		cond1 = new Conductor("Matias", 5000);
		v8 = new Vehiculo("Renault 12", 4, Year.of(2002), 2000, cond1);
		cond1.setAuto(v8);
	}
	
	@Test
	public void testAgregarViaje() {
		assertTrue(pas1.getViajesRealizados().isEmpty());
		pas1.agregarViajrAnterior(new Viaje("La matanza", "La plata", 200, LocalDate.now(), v8));
		assertFalse(pas1.getViajesRealizados().isEmpty());
	}
	
	@Test 
	public void testBonificacion() {
		assertEquals(0, pas1.bonificacion());
		pas1.agregarViajrAnterior(new Viaje("La matanza", "La plata", 200, LocalDate.now(), v8));
		assertEquals(500, pas1.bonificacion());
		assertEquals(20, cond1.bonificacion());
	}
	
	@Test
	public void testRecargo() {
		pas1.cargarSaldo(1000);
		assertEquals(900, pas1.getSaldo());
		pas1.agregarViajrAnterior(new Viaje("La matanza", "La plata", 200, LocalDate.now(), v8));
		pas1.cargarSaldo(100);
		assertEquals(1000, pas1.getSaldo());
	}
	
	
	
}
