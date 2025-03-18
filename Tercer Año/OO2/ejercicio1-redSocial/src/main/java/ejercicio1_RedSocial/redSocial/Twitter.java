package ejercicio1_RedSocial.redSocial;

import java.util.LinkedList;
import java.util.List;

public class Twitter {

	private List<Usuario> usuarios;
	
	public Twitter() {
		usuarios = new LinkedList<Usuario>();
	}
	
	public Usuario crearUsuario(String sn) {
		Usuario usu = null;
		if(!this.usuarios.stream().anyMatch(Usuario -> Usuario.getScreenName().equals(sn))) {
			usu = new Usuario(sn);
			this.usuarios.add(usu);
			return usu;
		}
		return usu;
	}
	
	public void eliminarUsuario(String str) {
		Usuario urs = this.usuarios.stream()
				.filter(alu -> alu.getScreenName().equals(str))
				.findAny().orElse(null);
		if(urs != null) {
			urs.eliminarTweets();
			this.usuarios.remove(urs);
		}
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
}
