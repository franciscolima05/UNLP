package ejercicio24_PoolCar.ejercicio24_PoolCar;

public class Conductor extends Usuario	{
	private Vehiculo auto;

	public Conductor(String nombre, double saldo) {
		super(nombre, saldo);
	}

	public void setAuto(Vehiculo auto) {
		this.auto = auto;
	}
	
	@Override
	public double recargo() {
		if(this.obtenerAntiguedad() < 5) {
			return this.getSaldo() * 0.01;
		}
		return this.getSaldo() * 0.1;
	}

	@Override
	public double bonificacion() {
		return this.auto.calcularBonificacion();
	}

	public int obtenerAntiguedad() {
		return this.auto.getAntiguedad();
	}
	
}
