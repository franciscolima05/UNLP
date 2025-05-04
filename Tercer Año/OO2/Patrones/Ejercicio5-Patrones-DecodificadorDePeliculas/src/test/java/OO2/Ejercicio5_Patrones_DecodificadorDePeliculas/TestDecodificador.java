package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDecodificador {
	
	private DecodificadorDePeliculas deco;
	private List<Pelicula> pelis;
	private List<Pelicula> reproducidas;
	Pelicula pelicula1;
	Pelicula pelicula2;
	Pelicula pelicula3;
	Pelicula pelicula4;
	Pelicula pelicula5;
	Pelicula pelicula6;
	Pelicula pelicula7;
	Pelicula pelicula8;
	Pelicula pelicula9;
	Pelicula pelicula10;

	@BeforeEach
	void setUp() throws Exception {
		deco = new DecodificadorDePeliculas(null);
		pelicula1 = new Pelicula("El Padrino", 1972, 9.2);
        pelicula2 = new Pelicula("Titanic", 1997, 7.8);
        pelicula3 = new Pelicula("Avatar", 2009, 7.8);
        pelicula4 = new Pelicula("Pulp Fiction", 1994, 8.9);
        pelicula5 = new Pelicula("Forrest Gump", 1994, 8.8);
        pelicula6 = new Pelicula("El Senior de los Anillos: El Retorno del Rey", 2003, 8.9);
        pelicula7 = new Pelicula("La lista de Schindler", 1993, 8.9);
        pelicula8 = new Pelicula("Matrix", 1999, 8.7);
        pelicula9 = new Pelicula("Interestelar", 2014, 8.6);
        pelicula10 = new Pelicula("Gladiador", 2000, 8.5);
        
        pelicula3.addSimilares(pelicula6);
        pelicula3.addSimilares(pelicula9);
        pelicula1.addSimilares(pelicula4);
        pelicula1.addSimilares(pelicula10);
        pelicula7.addSimilares(pelicula5);
        
        pelis = new ArrayList<Pelicula>();
        reproducidas = new ArrayList<Pelicula>();
        
        pelis.add(pelicula1);
        pelis.add(pelicula2);
        pelis.add(pelicula3);
        pelis.add(pelicula4);
        pelis.add(pelicula5);
        pelis.add(pelicula6);
        pelis.add(pelicula7);
        pelis.add(pelicula8);
        pelis.add(pelicula9);
        pelis.add(pelicula10);
        
        reproducidas.add(pelicula1);
        reproducidas.add(pelicula3);
        reproducidas.add(pelicula5);
        reproducidas.add(pelicula7);
        
        deco.agregarPelicula(pelis);
        deco.agregarVistas(reproducidas);
	}

	@Test
	void testObtenerSugerenciasPorSimilitud() {
		deco.setCriterio(new Similaridad());
		List<Pelicula> similares = deco.recomendar();
		
		assertTrue(similares.contains(pelicula6));
		assertTrue(similares.contains(pelicula10));
		assertTrue(similares.contains(pelicula9));
	}
	
	@Test
	void testObtenerSugerenciasPorPuntaje() {
		deco.setCriterio(new Puntaje());
		List<Pelicula> similares = deco.recomendar();
		
		assertTrue(similares.contains(pelicula6));
		assertTrue(similares.contains(pelicula4));
		assertTrue(similares.contains(pelicula8));
	}

}