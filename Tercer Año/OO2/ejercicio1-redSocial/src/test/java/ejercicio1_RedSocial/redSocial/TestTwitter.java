package ejercicio1_RedSocial.redSocial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTwitter {

	private Twitter system;
	private Usuario usr;
	
	@BeforeEach
	void setUp() {
		system = new Twitter();
		usr = new Usuario("carlitos123");
	}
	
	@Test
	void agregarUsuarioTest() {
		assertEquals(0, system.getUsuarios().size());
		system.crearUsuario("carlitos123");
		assertEquals(1, system.getUsuarios().size());
		assertEquals(null,system.crearUsuario("carlitos123"));
		assertEquals(1, system.getUsuarios().size());
	}
	
	@Test 
	void eliminarUsuarioTest() {
		system.crearUsuario("carlitos123");
		assertEquals(1, system.getUsuarios().size());
		system.eliminarUsuario("carlitos124");
		assertEquals(1, system.getUsuarios().size());
		system.eliminarUsuario("carlitos123");
		assertEquals(0, system.getUsuarios().size());	
	}
	
}
