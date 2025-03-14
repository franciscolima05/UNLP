package ejercicio24_PoolCar.ejercicio24_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Year;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestViaje {

	Pasajero pas1;
	Pasajero pas2;
	Pasajero pas3;
	Conductor cond1;
	Vehiculo v1;
	Viaje viajeTest;
	Viaje viajeTest2;
	
	@BeforeEach
	void setUp() {
		pas1 = new Pasajero("Jonas", 100);
		pas2 = new Pasajero("Matias", -1000);
		pas3 = new Pasajero("Fran", 10000);
		cond1 = new Conductor("Matheo", 500);
		v1 = new Vehiculo("Auto 1", 2, Year.of(2020), 5000, cond1);
		cond1.setAuto(v1);
		viajeTest = new Viaje("La Plata", "La Matanza", 900, LocalDate.of(2024, 12, 12), v1);
		viajeTest2 = new Viaje("La Plata", "La Matanza", 900, LocalDate.of(2005, 4, 5), v1);
	}
	
	@Test
	void testConstructor() {
		assertEquals(1, viajeTest.getPasajeros().size());
		assertEquals(cond1, viajeTest.getPasajeros().get(0));
	}
	
	@Test
	void testAgregarPasajero() {
		viajeTest.registrarPasajero(pas1);
		assertEquals(2, viajeTest.getPasajeros().size());
		viajeTest.registrarPasajero(pas2);
		assertEquals(2, viajeTest.getPasajeros().size());
		viajeTest.registrarPasajero(pas3);
		assertEquals(2, viajeTest.getPasajeros().size());
		
		viajeTest2.registrarPasajero(pas3);
		assertEquals(1, viajeTest2.getPasajeros().size());
	}
	
	@Test
	void testDebitarCostoViaje() {
		viajeTest.registrarPasajero(pas1);
		viajeTest.procesarViaje();
		assertEquals(-800, pas1.getSaldo());
		assertEquals(-350, cond1.getSaldo());
	}
}
