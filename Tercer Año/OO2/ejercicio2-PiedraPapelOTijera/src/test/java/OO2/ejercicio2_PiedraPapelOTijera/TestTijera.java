package OO2.ejercicio2_PiedraPapelOTijera;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTijera {

	private JugarMano jugarManoPapel;
	private JugarMano jugarManoTijera;
	private JugarMano jugarManoLagarto;
	private JugarMano jugarManoSpock;
	private JugarMano jugarManoPiedra;
	
	@BeforeEach
	void setUp() {
		jugarManoPapel = new JugarMano(new Piedra(), new Papel());
		jugarManoTijera= new JugarMano(new Piedra(), new Tijera());
		jugarManoLagarto = new JugarMano(new Piedra(), new Lagarto());
		jugarManoSpock= new JugarMano(new Piedra(), new Spock());
		jugarManoPiedra = new JugarMano(new Piedra(), new Piedra());
	}
	
	@Test 
	void testPartidos() {
		assertEquals("Gana Papel", jugarManoPapel.jugar());
		assertEquals("Gana Piedra", jugarManoTijera.jugar());
		assertEquals("Gana Piedra", jugarManoLagarto.jugar());
		assertEquals("Gana Spock", jugarManoSpock.jugar());
		assertEquals("Empate", jugarManoPiedra.jugar());
	}
}
