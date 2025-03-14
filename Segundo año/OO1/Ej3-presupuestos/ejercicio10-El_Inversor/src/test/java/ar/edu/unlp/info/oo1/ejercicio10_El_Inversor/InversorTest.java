package ar.edu.unlp.info.oo1.ejercicio10_El_Inversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	Inversor inv = new Inversor();
	PlazoFijo pj = new PlazoFijo(20000, 0.05);
	InversionEnAcciones ac = new InversionEnAcciones("TSLA", 20, 25000);	

@BeforeEach


@Test
	void testConstructor() {
	assertEquals(20000, pj.getMontoDepositado());
	assertEquals(0.05, pj.getPorcentajeDeInteresDiario());
	assertEquals("TSLA", ac.getNombre());
	assertEquals(20, ac.getCantidad());
	assertEquals(25000, ac.getValorUnitario());
}

@Test
	void testValor() {
	assertEquals(500000, ac.valorActual());
	assertEquals(30000, pj.valorActual());
}
	
}
