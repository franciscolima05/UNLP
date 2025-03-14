package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;
import java.util.*;


public class Carpeta {
	private LinkedList<Email> inbox;
	@SuppressWarnings("unused")
	private String nombre;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.inbox = new LinkedList<Email>();
	}
	
	public LinkedList<Email> getInbox() {
		return this.inbox;
	}
	
	public int getCantMails() {
		return this.inbox.size();
	}
	
	public void boxear(Email msg) {
		this.getInbox().add(msg);
	}
	
	public void mover(Email msg, Carpeta destino) {
		this.getInbox().remove(msg);
		destino.boxear(msg);
	}
	
	public Email buscarEmail(String texto) {
		return this.getInbox().stream()
		.filter(email-> email.contengo(texto))
		.findFirst().orElse(null);
	}
	
	public Integer tamaño() {
		return this.inbox.stream()
		.mapToInt(email-> email.tamaño())
		.sum();
	}
	
	public void getCategorias(BagImpl<String> bolsa){
		for (Email e : this.inbox) {
			if(e.tamaño() < 300) {
				bolsa.add("chico");
			}
			else {
				if(e.tamaño() < 500) {
					bolsa.add("mediano");
				}
					else
						bolsa.add("grande");
			}
		}
	}
}
