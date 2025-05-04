package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.ArrayList;
import java.util.List;

public class DecodificadorDePeliculas {
	private List<Pelicula> grilla;
	private CriterioDeRecomendacion criterio;
	private List<Pelicula> reproducidas;
	
	
	public DecodificadorDePeliculas(CriterioDeRecomendacion criterio) {
		this.grilla = new ArrayList<>();
		this.reproducidas = new ArrayList<>();
		this.criterio = criterio;
		
	}
	
	public List<Pelicula> recomendar() {
		return this.criterio.recomendarPelicula(this.grilla, this.reproducidas);
	}
	
	public void setCriterio(CriterioDeRecomendacion criterio) {
		this.criterio = criterio;
	}
	
	
	public void agregarVistas(List<Pelicula> peli) {
		this.reproducidas.addAll(peli);
	}
	
	public void agregarPelicula(List<Pelicula> peli) {
		this.grilla.addAll(peli);
	}
	//UTILIZO EL PATRON STRATEGY

}
