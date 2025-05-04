package OO2.Ejercicio12_Patrones_FileSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {
	private List<Elemento> elementos;
	
	public FileSystem() {
		this.elementos = new ArrayList<>();
	}
	
	public int tamanoTotalOcupado() {
		return this.elementos.stream()
				.mapToInt(elemento -> elemento.calcularSize())
				.sum();
	}
	
	public Archivo archivoMasGrande() {
		return (Archivo) this.elementos.stream()
				.max((e1, e2) -> Integer.compare(e1.calcularSize(), e2.calcularSize()))
				.orElse(null);
	}
	
	public Archivo archivoMasNuevo() {
		return (Archivo) this.elementos.stream()
				.max((e1, e2) -> e1.masNuevo().getFecha().compareTo(e2.masNuevo().getFecha()))
				.orElse(null);
	}
	
	public Elemento Buscar(String nom) {
		return this.elementos.stream()
		.filter(elem -> elem.encontrar(nom) != null)
		.findFirst()
		.orElse(null);
		
	}
	
	public List<Elemento> BuscarTodos(String nom) {
		ArrayList<Elemento> lista = new ArrayList<>();
		this.elementos.stream().forEach(el -> el.coincide(lista, nom));
		return lista;
	}
	
}
