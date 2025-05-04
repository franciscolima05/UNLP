package OO2.Ejercicio14_Patrones_PrestamosPrendarios;

import java.util.ArrayList;
import java.util.List;

public class GarantiaMixta implements Garantia{
	private List<Garantia> Elementos;
	
	public GarantiaMixta() {
		this.Elementos = new ArrayList<>();
	}

	@Override
	public double calcularValorTotal() {
		return this.calcularValorGeneral() * 0.5;
	}
	
	public double calcularValorGeneral() {
		return this.Elementos.stream()
				.mapToDouble(elem -> elem.calcularValorGeneral())
				.sum();
	}
	
	public void add(Garantia gar) {
		this.Elementos.add(gar);
	}
	
}
