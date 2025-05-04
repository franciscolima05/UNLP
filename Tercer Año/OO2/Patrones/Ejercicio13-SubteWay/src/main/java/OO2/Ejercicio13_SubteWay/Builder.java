package OO2.Ejercicio13_SubteWay;

public abstract class Builder {
	protected Sanguche sanguche;
	
	public void reset() {
		this.sanguche = new Sanguche();
	}
	
	
	public abstract Builder setPan();
	public abstract Builder setAderezo();
	public abstract Builder setPrincipal();
	public abstract Builder setAdicional();
	
	public Sanguche entregar() {
		Sanguche s = this.sanguche;
		this.reset();
		return s;
	}
}