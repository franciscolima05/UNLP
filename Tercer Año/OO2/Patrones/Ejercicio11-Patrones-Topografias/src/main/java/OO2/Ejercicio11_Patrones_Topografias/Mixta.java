package OO2.Ejercicio11_Patrones_Topografias;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Topografia{
	private List<Topografia> topografias;
	
	public Mixta() {
		this.topografias = new ArrayList<>();
	}

	@Override
	public double calcularProporcion() {
		return (this.topografias.stream().mapToDouble(topo -> topo.calcularProporcion()).sum()) / 4;
	}

	@Override
	public boolean esIgual(Topografia topo) {
		if(this.calcularProporcion() != topo.calcularProporcion()) {
			return false;
		}
		return this.topografias.equals(topo);
	}
	
	public void add(Topografia topo) {
		if(this.topografias.size() < 4) {
			this.topografias.add(topo);
		}
	}

	@Override
	public boolean equals(Topografia topo) {
		return this.esIgual(topo);
	}
}
