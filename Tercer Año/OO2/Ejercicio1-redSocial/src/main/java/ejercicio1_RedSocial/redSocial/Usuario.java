package ejercicio1_RedSocial.redSocial;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String screenName;
	private List<Publicacion> tweets;
	
	public Usuario(String screenN) {
		this.screenName = screenN;
		this.tweets = new LinkedList<Publicacion>();
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	public Tweet crearTweet(String cuerpo) {
		Tweet twt = null;
		if (cuerpo.length() > 1 && cuerpo.length() < 280) {
			this.tweets.add(twt = new Tweet(this, cuerpo));
			return twt;
		}
		return twt;
	}
	
	public Retweet crearReTweet(Tweet twt) {
		Retweet rt = new Retweet(this, twt);
		this.tweets.add(rt);
		return rt;
	}
	
	public List<Publicacion> getTweets(){
		return this.tweets;
	}
	
	public void eliminarTweets() {
		this.tweets.clear();
	}
	
}
