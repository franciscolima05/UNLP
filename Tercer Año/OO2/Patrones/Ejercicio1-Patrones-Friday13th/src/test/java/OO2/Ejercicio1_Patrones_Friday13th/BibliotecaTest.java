package OO2.Ejercicio1_Patrones_Friday13th;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

	Socio socio1;
	Biblioteca biblio;
	
	@BeforeEach
	void setUp() {
		biblio = new Biblioteca();
		biblio.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblio.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
		JsonSimple js = new JsonSimple();
		biblio.setExporter(js);
	}
	
	@Test
	void testExportar() {
		System.out.print(biblio.exportarSocios());
		assertEquals("{\n"
				+ "   	 \"nombre\": \"Arya Stark\",\n"
				+ "   	 \"email\": \"needle@stark.com\",\n"
				+ "   	 \"legajo\": \"5234-5\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "   	 \"nombre\": \"Tyron Lannister\",\n"
				+ "   	 \"email\": \"tyron@thelannisters.com\",\n"
				+ "   	 \"legajo\": \"2345-2\"\n"
				+ "    }\n"
				+ "", biblio.exportarSocios());
	}
}
