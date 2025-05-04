package OO2.Ejercicio13_SubteWay;

public class Sanguche {
	private Producto pan;
	private Producto principal;
	private Producto adicional;
	private Producto aderezo;
	
	public Producto getPan() {
		return pan;
	}
	
	public Producto getPrincipal() {
		return principal;
	}
	
	public Producto getAdicional() {
		return adicional;
	}
	
	public Producto getAderezo() {
		return aderezo;
	}
	
	public void setPan(Producto pan) {
		this.pan = pan;
	}
	
	public void setPrincipal(Producto principal) {
		this.principal = principal;
	}
	
	public void setAdicional(Producto adicional) {
		this.adicional = adicional;
	}
	
	public void setAderezo(Producto aderezo) {
		this.aderezo = aderezo;
	}
	
	public double getPrecio() {
		return this.pan.getPrecio() + this.principal.getPrecio() + this.adicional.getPrecio() + this.aderezo.getPrecio();
	}

}
