package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class Similaridad implements CriterioDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPelicula(List<Pelicula> lista, List<Pelicula> vista) {
		List<Pelicula> similares = vista.stream()
				.flatMap(pelicula -> pelicula.getSimilares().stream().distinct())
				.collect(Collectors.toList());
		similares = similares.stream()
				.sorted((pelicula1, pelicula2) -> Integer.compare(pelicula1.getEstreno(), pelicula2.getEstreno()))
				.collect(Collectors.toList());
		return similares.subList(0, 2);
		
	}
}
