package OO2.Ejercicio12_Patrones_FileSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archivo extends Elemento{
	private int size;
	
	public Archivo(String nombre, LocalDate fecha, int size) {
		super(nombre, fecha);
		this.size = size;
	}
	
	public int calcularSize() {
		return this.size + 32;
	}

	@Override
	public Archivo masGrande() {
		return this;
	}

	@Override
	public Archivo masNuevo() {
		return this;
	}

	@Override
	public void coincide(List<Elemento> lista, String nom) {
		if(this.getNombre().equals(nom)) {
			lista.add(this);
		}
	}

	@Override
	public Elemento encontrar(String nom) {
		if(this.getNombre().equals(nom))
			return this;
		else
			return null;
	}}
