package ejercicio24_PoolCar.ejercicio24_PoolCar;

public abstract class Usuario {
	private String nombre;
	private double saldo;
	
	public Usuario(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void cargarSaldo(double monto) {
		this.saldo += monto - this.recargo();
	}
	public abstract double recargo();
	
	public void pagarViaje(double monto) {
		this.saldo -= monto - this.bonificacion();
	}
	
	public abstract double bonificacion();
	
	public boolean isNegativo() {
		return !(this.getSaldo() > 0);
	}
}
