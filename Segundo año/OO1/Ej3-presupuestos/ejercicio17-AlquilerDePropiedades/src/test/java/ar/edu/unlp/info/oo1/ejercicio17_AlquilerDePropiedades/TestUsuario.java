package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUsuario {
	public Usuario user;
	public Usuario userCliente;
	public Propiedad prop1;
	public Propiedad prop2;
	public Propiedad prop3;
	
	@BeforeEach
	public void setUp() {
		user = new Usuario(46628567, "Francisco", "116, 175");
		userCliente = new Usuario(4859288, "Tobias", "117, 331");
		prop1 = new Propiedad("115, 2212", "Alto Rancho", 2000);
		prop2 = new Propiedad("60, 2212", "Casa Leo", 5000);
		prop3 = new Propiedad("Caballito, 232", "La Mansion", 12000);
	}
	
	@Test
	public void testAgregarPropiedades() {
		user.agregarPropiedad(prop1);
		user.agregarPropiedad(prop2);
		user.agregarPropiedad(prop3);
		assertEquals(3, user.cantidadPropiedades());
	}
	
	@Test
	public void testCrearReservas() {
		assertTrue(userCliente.realizarReserva(prop1,LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15)));
		assertFalse(userCliente.realizarReserva(prop1,LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15)));
		assertTrue(userCliente.realizarReserva(prop1,LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 15)));
		assertFalse(userCliente.realizarReserva(prop1,LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 15)));
		assertFalse(prop1.isDisponible(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15)));
	}
	
	@Test
	public void testCancelarReserva() {
		prop1.crearReserva(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15));
		assertEquals(1, prop1.getReservas().size());
		assertFalse(prop1.isDisponible(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15)));
		assertTrue(prop1.cancelarReserva(prop1.getReservas().get(0)));
		assertEquals(0, prop1.getReservas().size());
		assertTrue(prop1.isDisponible(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15)));
	}
	
	@Test
	public void testMontos() {
		user.agregarPropiedad(prop1);
		user.agregarPropiedad(prop2);
		prop1.crearReserva(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 15));
		prop2.crearReserva(LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 12));
		assertEquals(20000, user.calcularRetribucion());
	}
}


