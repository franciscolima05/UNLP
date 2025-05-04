package OO2.Ejercicio14_Patrones_PrestamosPrendarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGarantia {

	
	GarantiaMixta mixta;
	Automovil auto;
	Inmueble inmueble;
	Alquiler alquiler;
	
	
	@BeforeEach
	void setUp() {
		auto = new Automovil(LocalDate.of(2020, 4, 30), 1000, 10000);
		inmueble = new Inmueble("116 175", 100, 10);
		alquiler = new Alquiler(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 5, 1), 100);
		mixta = new GarantiaMixta();
		
		mixta.add(alquiler);
		mixta.add(auto);
		mixta.add(inmueble);
	}
	
	@Test
	void testValor() {
		assertEquals(5000, auto.calcularValorGeneral());
		assertEquals(1000, inmueble.calcularValorGeneral());
		assertEquals(400, alquiler.calcularValorGeneral());
		assertEquals(6400, mixta.calcularValorGeneral());
	}
	
	@Test
	void testValorReal() {
		assertEquals(3500, auto.calcularValorTotal());
		assertEquals(200, inmueble.calcularValorTotal());
		assertEquals(360, alquiler.calcularValorTotal());
		assertEquals(3200, mixta.calcularValorTotal());
	}
}
