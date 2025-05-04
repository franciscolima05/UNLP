package OO2.Ejercicio13_SubteWay;

public class Director {
	
	public Sanguche armarSanguche(Builder constructor) {
		return constructor.setPan()
		.setAderezo()
		.setPrincipal()
		.setAdicional()
		.entregar();
		
	}
	
//	public void construirSangucheVegano() {
//		this.constructor.reset();
//		this.constructor.setPan(new Producto("Pan Integral", 100));
//		this.constructor.setAderezo(new Producto("Salsa Criolla", 20));
//		this.constructor.setPrincipal(new Producto("Milanesa de Girgolas", 500));
//	}
//	
//	public void construirSangucheClasico() {
//		this.constructor.reset();
//		this.constructor.setPan(new Producto("Brioche", 100));
//		this.constructor.setPrincipal(new Producto("Carne De Ternera", 300));
//		this.constructor.setAderezo(new Producto("Mayonesa", 20));
//		this.constructor.setAdicional(new Producto("Tomate", 80));
//	}
//	
//	public void construirSangucheVegetariano() {
//		this.constructor.reset();
//		this.constructor.setPan(new Producto("Con Semillas", 120));
//		this.constructor.setPrincipal(new Producto("Provoleta Grillada", 200));
//		this.constructor.setAdicional(new Producto("Berenjenas al escabeche", 100));
//	}
//	
//	 public void construirSangucheSinTACC() {
//		 this.constructor.reset();
//		 this.constructor.setPan(new Producto("Chipa", 150));
//		 this.constructor.setAderezo(new Producto("Salsa Tartara", 18));
//		 this.constructor.setPrincipal(new Producto("Pollo", 250));
//		 this.constructor.setAdicional(new Producto("Verduras Grilladas", 200));
//	 }
}
