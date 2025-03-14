package ar.edu.unlp.info.oo1.ejercicio12_VolumenYsuperficieDeSolidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PiezaTest {
	Clinidro cilindro1 = new Clinidro(5, 10, "Hierro", "Rojo");
	Esfera esfera1 = new Esfera(5, "Madera", "Azul");
	PrismaRectangular pr1 = new PrismaRectangular(10, 5, 5, "Hierro", "Azul");
	ReporteDeConstruccion reporte = new ReporteDeConstruccion();
@BeforeEach

@Test
	void testVolumen() {
	assertEquals(785.0, cilindro1.getVolumen());
	assertEquals(510.0, esfera1.getVolumen());
	assertEquals(250.0, pr1.getVolumen());
}

@Test
	void testSuperficie() {
	assertEquals(471.24, cilindro1.getSuperficie());
	assertEquals(314, esfera1.getSuperficie());
	assertEquals(125, pr1.getSuperficie());
}

@Test
	void testVolumenMaterial() {
		reporte.add(pr1);
		reporte.add(cilindro1);
		reporte.add(esfera1);
		assertEquals(1035, reporte.getVolumenDeMaterial("Hierro"));
		assertEquals(439, reporte.getSuperficieDeColor("Azul"));
	}
}
