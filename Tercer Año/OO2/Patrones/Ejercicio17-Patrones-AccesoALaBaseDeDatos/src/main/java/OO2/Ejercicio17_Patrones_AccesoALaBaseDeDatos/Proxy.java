package OO2.Ejercicio17_Patrones_AccesoALaBaseDeDatos;

import java.util.Collection;
import java.util.List;

public class Proxy implements DatabaseAccess{
	private DatabaseAccess bd;
	private int accessKey;
	private Usuario user;
	
	
	public Proxy(DatabaseAccess database, int ak, Usuario user) {
		this.bd = database;
		this.accessKey = ak;
		this.user = user;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if(this.accessKey == user.getKey()){
			return this.bd.getSearchResults(queryString);
		}
		throw new IllegalArgumentException("El usuario no esta registrado");
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if(this.accessKey == user.getKey()) {
			return this.bd.insertNewRow(rowData);
		}
		throw new IllegalArgumentException("El usuario no esta registrado");
	}
	
	public void identificarUsuario() {
		user.setKey(this.accessKey);
	}
	
}
