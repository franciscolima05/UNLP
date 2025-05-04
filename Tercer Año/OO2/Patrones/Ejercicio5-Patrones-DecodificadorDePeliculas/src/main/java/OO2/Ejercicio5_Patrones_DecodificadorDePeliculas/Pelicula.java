package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int estreno;
	private List<Pelicula> peliculasSimilares;
	private double puntaje;
	
	
	public int getEstreno() {
		return this.estreno;
	}
	
	public double getPuntaje() {
		return this.puntaje;
	}

	public List<Pelicula> getSimilares(){
		return this.peliculasSimilares;
	}
	
	public void addSimilares(Pelicula peli) {
		this.peliculasSimilares.add(peli);
		peli.getSimilares().add(this);
	}

	public Pelicula(String titulo, int estreno, double puntaje) {
		super();
		this.titulo = titulo;
		this.estreno = estreno;
		this.peliculasSimilares = new ArrayList<>();
		this.puntaje = puntaje;
	}

	public String getTitulo() {
		return titulo;
	}
}
