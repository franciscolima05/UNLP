package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class Puntaje implements CriterioDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPelicula(List<Pelicula> lista, List<Pelicula> vista) {
		List<Pelicula> listaOrdenada = lista.stream()
				.sorted((peli1, peli2) -> Double.compare(peli1.getPuntaje(), peli2.getPuntaje()))
				.collect(Collectors.toList());
		List<Pelicula> recomendaciones = listaOrdenada.subList(0, 2);
		return recomendaciones;
	}

}
