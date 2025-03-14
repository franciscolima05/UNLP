package clases;

import java.time.*;

public class Mamifero {

	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero madre;
	private Mamifero padre;
	
	public Mamifero(String id) {
		this.identificador = id;
		this.especie = "";
		this.fechaNacimiento = LocalDate.now();
		this.madre = null;
		this.padre = null;
	}
	
	public Mamifero() {}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getAbueloPaterno() {
		if(this.padre != null) {
			return this.padre.getPadre();
		}
		else return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if(this.madre != null) {
			return this.madre.getPadre();
		}
		else return null;
	}

	public Mamifero getAbuelaPaterna() {
		if(this.padre != null) {
			return this.padre.getMadre();
		}
		else return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if(this.madre != null) {
			return this.madre.getMadre();
		}
		else return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero anc) {
		if(this == anc | (this.getMadre() == null && this.getPadre() == null)) {
			return false;
		}
		else {
			return tieneComoAncestroAHelper(this, anc);
		}
	}

	public boolean tieneComoAncestroAHelper(Mamifero aux, Mamifero anc){
		boolean ok = false;
		if(aux == anc){
			return true;
		}
		else {
			if(aux.getMadre() != null) {
				ok = ok | tieneComoAncestroAHelper(aux.getMadre(), anc);
			}
			if(aux.getPadre() != null) {
				ok = ok | tieneComoAncestroAHelper(aux.getPadre(), anc);
			}
		}
		return ok;
	}
	
}
