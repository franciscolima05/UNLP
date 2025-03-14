package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	private CuentaCorriente cuenta;
	private CajaDeAhorro caja;
	private CuentaCorriente cuenta2;

@BeforeEach
	void setUp() throws Exception {
		this.cuenta = new CuentaCorriente();
		this.cuenta2 = new CuentaCorriente(100, -200);
		this.caja = new CajaDeAhorro();
	}

@Test
	void testConstructor() {
		assertEquals(-200, cuenta2.getLimite());
		assertEquals(100, cuenta2.getSaldo());
	}
	
@Test
	void testDeposito() {
		cuenta.depositar(100);
		caja.depositar(100);
		System.out.println("SALDO CAJA: " + caja.getSaldo());
		assertEquals(100, cuenta.getSaldo());
		assertEquals(98, caja.getSaldo());
	}
@Test
	void testExtraer() {
		cuenta2.extraer(100);
		assertEquals(0, cuenta2.getSaldo());
		caja.depositar(100);
		caja.extraer(50);
		assertFalse(cuenta.extraer(200));
		assertEquals(47, caja.getSaldo());
		cuenta.depositar(100);
	}
@Test
	void  testTransferir() {
		cuenta.transferirACuenta(100, cuenta2);
		assertEquals(100, cuenta2.getSaldo());
}
}
