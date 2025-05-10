package OO2.Ejercicio11_Patrones_Topografias;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTopografias {
	
	Mixta topoMixta;
	Mixta topoMixta2;
	Mixta topoMixta3;
	Mixta topoMixta4;
	Mixta topoMixta5;
	Mixta topoMixta6;
	Mixta topoMixta7;
	
	Pantano pantano1;
	Pantano pantano2;
	Pantano pantano3;
	
	
	@BeforeEach
	void setUp() {
		topoMixta = new Mixta();
		topoMixta.add(new Hoja(0));
		topoMixta.add(new Hoja(0));
		topoMixta.add(new Hoja(1));
		topoMixta.add(new Hoja(1));
		topoMixta2 = new Mixta();
		topoMixta2.add(new Hoja(0));
		topoMixta2.add(new Hoja(0));
		topoMixta2.add(new Hoja(1));
		topoMixta2.add(new Hoja(1));
		topoMixta3 = new Mixta();
		topoMixta3.add(new Hoja(1));
		topoMixta3.add(new Hoja(1));
		topoMixta3.add(new Hoja(0));
		topoMixta3.add(new Hoja(0));
		
		topoMixta6 = new Mixta();
		topoMixta6.add(new Hoja(0));
		topoMixta6.add(new Hoja(0));
		topoMixta6.add(new Hoja(1));
		topoMixta6.add(new Hoja(1));
		topoMixta7 = new Mixta();
		topoMixta7.add(new Hoja(1));
		topoMixta7.add(new Hoja(1));
		topoMixta7.add(new Hoja(0));
		topoMixta7.add(new Hoja(0));
		
		topoMixta4 = new Mixta();
		topoMixta4.add(new Hoja(0));
		topoMixta4.add(new Hoja(0));
		topoMixta4.add(topoMixta6);
		topoMixta4.add(new Hoja(1));
		topoMixta5 = new Mixta();
		topoMixta5.add(new Hoja(0));
		topoMixta5.add(new Hoja(0));
		topoMixta5.add(topoMixta6);
		topoMixta5.add(new Hoja(1));
//		
//		pantano1 = new Pantano();
//		pantano2 = new Pantano();
//		pantano3 = new Pantano();
//		
//		pantano1.add(new Hoja(1));
//		pantano1.add(new Hoja(1));
//		pantano1.add(new Hoja(1));
//		pantano1.add(new Hoja(0));
//
//		pantano2.add(new Hoja(1));
//		pantano2.add(new Hoja(1));
//		pantano2.add(new Hoja(1));
//		pantano2.add(new Hoja(0));
//		
//		pantano3.add(new Hoja(0));
//		pantano3.add(new Hoja(1));
//		pantano3.add(new Hoja(1));
//		pantano3.add(new Hoja(1));
		
		
	}
	
	@Test
	void testIgualdad() {
		assertTrue(topoMixta.equals(topoMixta2));
		assertTrue(topoMixta2.equals(topoMixta));
		assertFalse(topoMixta.equals(topoMixta3));
		assertTrue(topoMixta4.equals(topoMixta5));
		assertFalse(topoMixta.equals(new Hoja(1)));
		assertFalse(new Hoja(1).equals(topoMixta));
		assertTrue(new Hoja(1).equals(new Hoja(1)));
		assertFalse(new Hoja(1).equals(new Hoja(0)));
		//assertTrue(pantano1.esIgual(pantano2));
		//assertFalse(pantano1.esIgual(pantano3));
	}
}
