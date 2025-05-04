package OO2.Ejercicio13_SubteWay;

public class BuilderVegetariano extends Builder{

	@Override
	public Builder setPan() {
		this.sanguche.setPan(new Producto("Pan con Semillas", 120));
		return this;
	}

	@Override
	public Builder setAderezo() {
		return this;
	}

	@Override
	public Builder setPrincipal() {
		this.sanguche.setPrincipal(new Producto("Provoleta Grillada", 200));
		return this;
	}

	@Override
	public Builder setAdicional() {
		this.sanguche.setAdicional(new Producto("Berenjenas al escabeche", 100));
		return this;
	}

}
