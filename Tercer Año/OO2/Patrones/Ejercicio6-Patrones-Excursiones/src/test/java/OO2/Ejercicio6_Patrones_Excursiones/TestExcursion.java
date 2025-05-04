package OO2.Ejercicio6_Patrones_Excursiones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExcursion {

	
	Excursion excursionKayak;
	Usuario persona1;
	Usuario persona2;
	Usuario persona3;
	
	
	@BeforeEach
	void setUp() {
		excursionKayak = new Excursion("Excursion en kayak", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1,3), "Plaza Moreno", 5000, 1, 2);
		persona1 = new Usuario("Francisco", "Lima", "Francisco@mail.com");
		persona2 = new Usuario("Matias", "Guaymas", "Matias@mail.com");
		persona3 = new Usuario("Juan Francisco", "Acosta Alfano", "FranEdelp123@gmail.com");
		
	}
	
	
	@Test
	void testAgregarInscripto() {
		excursionKayak.inscribir(persona1);
		assertEquals(1, excursionKayak.getInscriptosProvisionales().size());
		assertEquals("Excursion en kayak 5000.0 2025-01-03 2025-01-01 Plaza Moreno 1", excursionKayak.obtenerInformacion());
	}
	
	@Test
	void testAgregarDefinitiva() {
		excursionKayak.inscribir(persona1);
		excursionKayak.inscribir(persona2);
		assertEquals(2, excursionKayak.getInscriptos().size());
		assertEquals(0, excursionKayak.getInscriptosProvisionales().size());
		assertEquals("Excursion en kayak 5000.0 2025-01-03 2025-01-01 Plaza Moreno Francisco@mail.com Matias@mail.com 0", excursionKayak.obtenerInformacion());
	}
	
	@Test
	void testAgregarListaDeEspera() {
		excursionKayak.inscribir(persona1);
		excursionKayak.inscribir(persona2);
		excursionKayak.inscribir(persona3);
		assertEquals(1, excursionKayak.getListaDeEspera().size());
		assertEquals("Excursion en kayak 5000.0 2025-01-03 2025-01-01 Plaza Moreno", excursionKayak.obtenerInformacion());
	}
}
