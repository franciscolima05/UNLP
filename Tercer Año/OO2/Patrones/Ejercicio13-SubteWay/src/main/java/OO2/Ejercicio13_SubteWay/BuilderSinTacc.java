package OO2.Ejercicio13_SubteWay;

public class BuilderSinTacc extends Builder{
	
	@Override
	public Builder setPan() {
		this.sanguche.setPan(new Producto("Pan de Chipa", 150));
		return this;
	}

	@Override
	public Builder setAderezo() {
		this.sanguche.setAderezo(new Producto("Salsa Tartara", 18));
		return this;
	}

	@Override
	public Builder setPrincipal() {
		this.sanguche.setPrincipal(new Producto("Carne De Pollo", 250));
		return this;
	}

	@Override
	public Builder setAdicional() {
		this.sanguche.setAdicional(new Producto("Verduras Grilladas", 200));
		return this;
	}


}
