package OO2.Ejercicio11_Patrones_Topografias;

public class Agua implements Topografia{

	@Override
	public double calcularProporcion() {
		return 1;
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
