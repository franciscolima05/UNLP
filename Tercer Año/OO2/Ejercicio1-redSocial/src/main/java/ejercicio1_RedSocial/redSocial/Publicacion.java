package ejercicio1_RedSocial.redSocial;

public abstract class Publicacion {
	private Usuario owner;
	
	public Publicacion(Usuario own) {
		this.owner = own;
	}
}
