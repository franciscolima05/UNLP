package OO2.Ejercicio5_Patrones_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class Novedad implements CriterioDeRecomendacion{
	

	@Override
	public List<Pelicula> recomendarPelicula(List<Pelicula> lista, List<Pelicula> vistas) {
		List<Pelicula> listaOrdenada = lista.stream()
				.sorted((peli1, peli2) -> Integer.compare(peli2.getEstreno(), peli1.getEstreno()))
				.collect(Collectors.toList()); 
		List<Pelicula> recomendaciones = listaOrdenada.subList(0, 2);
		return recomendaciones;
	}
}
