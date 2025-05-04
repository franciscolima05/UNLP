package OO2.Ejercicio14_Patrones_PrestamosPrendarios;

public class Inmueble implements Garantia{
	private String direccion;
	private double superficie;
	private double costoM2;

	
	public Inmueble(String dir, double sup, double costo) {
		this.direccion = dir;
		this.superficie = sup;
		this.costoM2 = costo;
	}
	
	@Override
	public double calcularValorTotal() {
		return this.calcularValorGeneral() * 0.2;
	}

	@Override
	public double calcularValorGeneral() {
		return this.superficie * this.costoM2;
	}
	
	
}
