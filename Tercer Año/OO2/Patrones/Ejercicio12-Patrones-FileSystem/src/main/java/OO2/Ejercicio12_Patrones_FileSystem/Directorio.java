package OO2.Ejercicio12_Patrones_FileSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Directorio extends Elemento{
	private List<Elemento> elementos;
	
	
	public Directorio(String nombre, LocalDate fecha) {
		super(nombre, fecha);
		this.elementos = new ArrayList<>();
	}


	@Override
	public int calcularSize() {
		return this.elementos.stream()
				.mapToInt(elemento -> elemento.calcularSize())
				.sum();
	}

	@Override
	public Archivo masGrande() {
		return (Archivo) this.elementos.stream()
		.max((e1, e2) -> Integer.compare(e1.calcularSize(), e2.calcularSize()))
		.orElse(null);
	}


	@Override
	public Archivo masNuevo() {
		return (Archivo) this.elementos.stream()
				.max((e1, e2) -> e1.getFecha().compareTo(e2.getFecha()))
				.orElse(null);
	}

	
	

	@Override
	public void coincide(List<Elemento> lista, String nom) {
		if(this.getNombre().endsWith(nom)) {
			lista.add(this);
		}
		this.elementos.stream()
			.forEach(el -> el.coincide(lista, nom));
	}


	@Override
	public Elemento encontrar(String nom) {
		if(this.getNombre().equals(nom)) {
			return this;
		}
		return this.elementos.stream()
				.filter(elemento -> elemento.encontrar(nom) != null)
				.findFirst()
				.orElse(null);
	}
	
}
