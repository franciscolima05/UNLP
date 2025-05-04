package OO2.Ejercicio13_SubteWay;

public class BuilderVegano extends Builder{

	@Override
	public Builder setPan() {
		this.sanguche.setPan(new Producto("Pan Integral", 100));
		return this;
	}

	@Override
	public Builder setAderezo() {
		this.sanguche.setAderezo(new Producto("Salsa Criolla", 20));
		return this;
	}

	@Override
	public Builder setPrincipal() {
		this.sanguche.setPrincipal(new Producto("Milanesa de Girgolas", 500));
		return this;
	}

	@Override
	public Builder setAdicional() {
		return this;
	}

}
