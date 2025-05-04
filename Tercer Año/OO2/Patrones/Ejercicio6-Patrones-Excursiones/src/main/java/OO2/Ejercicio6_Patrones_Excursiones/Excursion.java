package OO2.Ejercicio6_Patrones_Excursiones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoDeEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private TipoInscripcion tipoDeInscripcion;
	private List<Usuario> listaDeEspera;
	private List<Usuario> inscriptos;
	private List<Usuario> inscriptosProvisionales;
	
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoDeEncuentro, double costo,
			int cupoMinimo, int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoDeEncuentro = puntoDeEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
		this.tipoDeInscripcion = new Provisoria();
		this.listaDeEspera = new ArrayList<>();
		this.inscriptos = new ArrayList<>();
		this.inscriptosProvisionales = new ArrayList<>();
	}
	
	
	public void setTipoDeInscripcion(TipoInscripcion tipo) {
		this.tipoDeInscripcion = tipo;
	}
	
	public void inscribir(Usuario user) {
		this.tipoDeInscripcion.inscribirUsuario(user, this);
	}
	
	public String obtenerInformacion() {
		return this.tipoDeInscripcion.darInformacion(this);
	}


	public String getNombre() {
		return nombre;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public String getPuntoDeEncuentro() {
		return puntoDeEncuentro;
	}


	public double getCosto() {
		return costo;
	}


	public int getCupoMinimo() {
		return cupoMinimo;
	}


	public int getCupoMaximo() {
		return cupoMaximo;
	}


	public TipoInscripcion getTipoDeInscripcion() {
		return tipoDeInscripcion;
	}


	public List<Usuario> getListaDeEspera() {
		return listaDeEspera;
	}


	public List<Usuario> getInscriptos() {
		return inscriptos;
	}


	public List<Usuario> getInscriptosProvisionales() {
		return inscriptosProvisionales;
	}
	
	
}
