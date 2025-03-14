package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;
import java.util.*;


public class ClienteDeCorreo {
	private List<Carpeta> carpetas;
	private Carpeta inbox;
	
	public ClienteDeCorreo() {
		this.carpetas = new LinkedList<Carpeta>();
		inbox = new Carpeta("inbox");
	}
	
	public List<Carpeta> getCarpetas() {
		List<Carpeta> copia=carpetas;
		copia.add(inbox);
		return copia;
	}
	
	public void agregarCarpeta(Carpeta car) {
		this.carpetas.add(car);
	}
	
	public void recibir(Email msg) {
		inbox.boxear(msg);
	}
	
	public Email buscar(String texto) {
		return this.getCarpetas().stream()
		.map(carpeta-> carpeta.buscarEmail(texto))
		.filter(carpeta-> carpeta != null)
		.findFirst().orElse(null);
	}
	
	public Integer espacioOcupado() {
		return this.getCarpetas().stream()
		.mapToInt(carpeta-> carpeta.tamaño())
		.sum();
	}
	
	public int totalMails() {
		return this.getCarpetas().stream()
				.mapToInt(carp -> carp.getCantMails())
				.sum();
	}
	
	public BagImpl<String> cantCategorias(){
		BagImpl<String> bolsa = new BagImpl();
		bolsa.add("chico");
		bolsa.add("mediano");
		bolsa.add("grande");
		for (Carpeta car : this.getCarpetas()) {
			car.getCategorias(bolsa);
		}
		return bolsa;
	}
}