package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;
import java.util.*;

public class Email {
	private String titulo;
	private String cuerpo;
	private LinkedList<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.cuerpo = cuerpo;
		this.titulo = titulo;
		this.adjuntos = new LinkedList<Archivo>();
	}
	
	
	public void adjuntar(Archivo arch) {
		this.getAdjuntos().add(arch);
	}


	public String getTitulo() {
		return titulo;
	}


	public String getCuerpo() {
		return cuerpo;
	}

		
	public LinkedList<Archivo> getAdjuntos() {
		return adjuntos;
	}
	

	public Integer tamaño() {
		return this.titulo.length() + this.cuerpo.length() + getAdjuntos().stream()
		.mapToInt(archivo-> archivo.tamaño())
		.sum();
	}
	
	public boolean contengo(String text) {
		return this.cuerpo.contains(text) || this.titulo.contains(text);
	}
}

