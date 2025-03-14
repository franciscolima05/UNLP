package ejercicio1_RedSocial.redSocial;

public class Tweet extends Publicacion{
	private String body;
	
	public Tweet(Usuario own, String txt) {
		super(own);
		this.body = txt;
	}

}
