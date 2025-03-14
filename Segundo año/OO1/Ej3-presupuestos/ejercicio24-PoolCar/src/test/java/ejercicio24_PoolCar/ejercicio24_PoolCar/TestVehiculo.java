package ejercicio24_PoolCar.ejercicio24_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVehiculo {
	
	Vehiculo v;
	Conductor c;

	
	@BeforeEach
	void setUp() {
		c = new Conductor("Matias", 5000);
		v = new Vehiculo("Auto 1", 4, Year.of(2020), 5000, c);
		c.setAuto(v);
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(4, v.getAntiguedad());
	}
}
