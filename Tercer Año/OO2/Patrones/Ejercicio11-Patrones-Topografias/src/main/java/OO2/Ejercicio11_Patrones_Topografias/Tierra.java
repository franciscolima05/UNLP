package OO2.Ejercicio11_Patrones_Topografias;

public class Tierra implements Topografia{

	@Override
	public double calcularProporcion() {
		return 0;
	}

	@Override
	public boolean esIgual(Topografia topo) {
		return this.calcularProporcion() == topo.calcularProporcion();
	}

	@Override
	public boolean equals(Topografia topo) {
		return this.esIgual(topo);
	}
	
}
