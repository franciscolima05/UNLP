package ejercicio1_RedSocial.redSocial;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUsuario {

	private Usuario usr;
	private Tweet tuit;
	
	
	@BeforeEach
	void setUp() {
		usr = new Usuario("Carlitos123");
		tuit = new Tweet(usr, "Aguante estudiantes 7 a 0");
	}
	
	@Test
	void testCrearTweet() {
		assertEquals(0, usr.getTweets().size());
		usr.crearTweet("Como me gusta la noche");
		assertEquals(1, usr.getTweets().size());
		assertEquals(null, usr.crearTweet(""));
		assertEquals(null, usr.crearTweet("La vida es un viaje lleno de sorpresas, donde cada paso nos enseña algo nuevo; a veces tropezamos, pero siempre hay una mano amiga o un rayo de sol que nos levanta, nos inspira y nos guía hacia adelante, recordándonos que el amor y la esperanza son el motor de todo lo que somossssss"));
	}
	
	@Test
	void testCrearReTweet() {
		usr.crearReTweet(tuit);
		assertEquals(1, usr.getTweets().size());
	}
	
	@Test
	void testEliminarTweets() {
		usr.crearTweet("hola");
		usr.crearTweet("manola");
		usr.eliminarTweets();
		assertEquals(0, usr.getTweets().size());
	}
}
