package OO2.Ejercicio17_Patrones_AccesoALaBaseDeDatos;

import java.util.Arrays;
import java.util.Collection;

public class Usuario {
	private Proxy conexionALaBD;
	private int key;

	public Usuario(){
	}
	
	public void conectarse(Proxy bd) {
		this.conexionALaBD = bd;
	}
	
	public void identificarse() {
		this.conexionALaBD.identificarUsuario();
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public Collection<String> request() {
		return this.conexionALaBD.getSearchResults("select * from comics where id=1");
	}
	
	public int post() {
		return this.conexionALaBD.insertNewRow(Arrays.asList("Patoruzú", "La flor"));
	}
}
