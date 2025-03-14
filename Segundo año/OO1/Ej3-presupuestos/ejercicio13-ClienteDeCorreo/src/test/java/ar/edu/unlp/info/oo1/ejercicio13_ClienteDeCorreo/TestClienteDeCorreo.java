package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClienteDeCorreo {

	Archivo arc1 = new Archivo("ddddd");
	Archivo arc2 = new Archivo("eeeee");
	Archivo arc3 = new Archivo("ccccc");
	Archivo arc4 = new Archivo("bbbbb");
	Archivo arc5 = new Archivo("aaaaa");
	
	Email msg1 = new Email("Matia", "oooooooooo");
	Email msg2 = new Email("Matia", "iiiiiiiiii");
	Email msg3 = new Email("Acost", "uuuuuuuuuu");
	 
	Carpeta car1 = new Carpeta("carp1");
	Carpeta car2 = new Carpeta("carp2");
	
	ClienteDeCorreo cliente = new ClienteDeCorreo();
	
@BeforeEach

@Test
	void testConstructor() {
	msg1.adjuntar(arc1);
	msg1.adjuntar(arc2);
	msg3.adjuntar(arc3);
	msg3.adjuntar(arc4);
	msg2.adjuntar(arc2);
	cliente.agregarCarpeta(car1);
	cliente.agregarCarpeta(car2);
	cliente.recibir(msg1);
	cliente.recibir(msg2);
	cliente.recibir(msg3);
}

@Test
	void testEspacioOcupado() {
	assertEquals(70,cliente.espacioOcupado());
}

@Test
	void testBuscar() {
	assertEquals(null, cliente.buscar("SIJFLSKJXFLSKJFLKJ"));
	assertEquals(msg1, cliente.buscar("oooooooooo"));
}


}
