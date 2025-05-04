package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.List;

public interface CriterioDeRecomendacion {
	
	public List<Pelicula> recomendarPelicula(List<Pelicula> lista, List<Pelicula> reproducidas);
}
