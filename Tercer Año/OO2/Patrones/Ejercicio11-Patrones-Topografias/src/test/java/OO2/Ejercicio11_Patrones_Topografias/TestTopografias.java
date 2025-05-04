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
		topoMixta.add(new Tierra());
		topoMixta.add(new Tierra());
		topoMixta.add(new Agua());
		topoMixta.add(new Agua());
		topoMixta2 = new Mixta();
		topoMixta2.add(new Tierra());
		topoMixta2.add(new Tierra());
		topoMixta2.add(new Agua());
		topoMixta2.add(new Agua());
		topoMixta3 = new Mixta();
		topoMixta3.add(new Agua());
		topoMixta3.add(new Agua());
		topoMixta3.add(new Tierra());
		topoMixta3.add(new Tierra());
		
		topoMixta6 = new Mixta();
		topoMixta6.add(new Tierra());
		topoMixta6.add(new Tierra());
		topoMixta6.add(new Agua());
		topoMixta6.add(new Agua());
		topoMixta7 = new Mixta();
		topoMixta7.add(new Agua());
		topoMixta7.add(new Agua());
		topoMixta7.add(new Tierra());
		topoMixta7.add(new Tierra());
		
		topoMixta4 = new Mixta();
		topoMixta4.add(new Tierra());
		topoMixta4.add(new Tierra());
		topoMixta4.add(topoMixta6);
		topoMixta4.add(new Agua());
		topoMixta5 = new Mixta();
		topoMixta5.add(new Tierra());
		topoMixta5.add(new Tierra());
		topoMixta5.add(topoMixta6);
		topoMixta5.add(new Agua());
//		
//		pantano1 = new Pantano();
//		pantano2 = new Pantano();
//		pantano3 = new Pantano();
//		
//		pantano1.add(new Agua());
//		pantano1.add(new Agua());
//		pantano1.add(new Agua());
//		pantano1.add(new Tierra());
//
//		pantano2.add(new Agua());
//		pantano2.add(new Agua());
//		pantano2.add(new Agua());
//		pantano2.add(new Tierra());
//		
//		pantano3.add(new Tierra());
//		pantano3.add(new Agua());
//		pantano3.add(new Agua());
//		pantano3.add(new Agua());
		
		
	}
	
	@Test
	void testIgualdad() {
		assertTrue(topoMixta.esIgual(topoMixta2));
		assertTrue(topoMixta2.esIgual(topoMixta));
		assertFalse(topoMixta.esIgual(topoMixta3));
		assertTrue(topoMixta4.esIgual(topoMixta5));
		//assertTrue(pantano1.esIgual(pantano2));
		//assertFalse(pantano1.esIgual(pantano3));
	}
}
