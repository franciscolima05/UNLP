package ejercicio1_RedSocial.redSocial;

import java.util.LinkedList;
import java.util.List;

public class Tweet extends Publicacion{
	private String body;
	private List<Retweet> retuits;
	
	public Tweet(Usuario own, String txt) {
		super(own);
		this.body = txt;
		this.retuits = new LinkedList<Retweet>();
	}
	
	public List<Retweet> getRetuits(){
		return this.retuits;
	}

	@Override
	public void eliminarTweet() {
		for(Retweet re : this.retuits) {
			re.getUsuario().eliminarUnRetweet(re);
		}
	}

}
