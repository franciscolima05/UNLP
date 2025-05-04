package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDispositivo {

	
	Dispositivo disp;
	
	
	@BeforeEach
	void setUp() {
		disp = new Dispositivo();
	}
	
	@Test
	void testSendYConfigurar() {
		assertEquals("El Mensaje es: Hola 59909",disp.send("Hola"));
		disp.cambiarCalculadora(new CRC_32());
		assertEquals("El Mensaje es: Hola 3482474166",disp.send("Hola"));
	}
	
	@Test
	void testConectarCon() {
		disp.cambiarConexion(new Conn4G());
		assertTrue(disp.getConection() instanceof Conn4G);
	}
	
	
}
