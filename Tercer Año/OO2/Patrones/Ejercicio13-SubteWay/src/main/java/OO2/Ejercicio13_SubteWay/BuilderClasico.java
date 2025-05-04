package OO2.Ejercicio13_SubteWay;

public class BuilderClasico extends Builder{

	@Override
	public Builder setPan() {
		this.sanguche.setPan(new Producto("Pan Brioche", 100));
		return this;
	}

	@Override
	public Builder setAderezo() {
		this.sanguche.setAderezo(new Producto("Mayonesa", 20));
		return this;
	}

	@Override
	public Builder setPrincipal() {
		this.sanguche.setPrincipal(new Producto("Carnde de Ternera", 300));
		return this;
	}

	@Override
	public Builder setAdicional() {
		this.sanguche.setAdicional(new Producto("Tomate", 80));
		return this;
	}


}
