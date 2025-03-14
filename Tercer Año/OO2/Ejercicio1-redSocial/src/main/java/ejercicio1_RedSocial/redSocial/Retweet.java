package ejercicio1_RedSocial.redSocial;

public class Retweet extends Publicacion {
	private Tweet from;
	
	public Retweet(Usuario own, Tweet tuit) {
		super(own);
		this.from = tuit;
	}

}
