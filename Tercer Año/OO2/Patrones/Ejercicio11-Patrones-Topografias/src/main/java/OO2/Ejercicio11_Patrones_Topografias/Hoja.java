package OO2.Ejercicio11_Patrones_Topografias;

public class Hoja implements Topografia {
	private double proporcionAgua;

	
	public Hoja(double proporcion) {
		this.proporcionAgua = proporcion;
	}
	
	@Override
	public double calcularProporcionAgua() {
		return this.proporcionAgua;
	}

	@Override
	public boolean esIgualaMixta(Mixta mixta) {
		return false;
	}

	@Override
	public boolean equals(Object topo) {
		return ((Topografia)topo).calcularProporcionAgua() == this.calcularProporcionAgua();
	}
}
