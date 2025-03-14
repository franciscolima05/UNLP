package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {}
	
	public Cuenta(double s) {
		this.saldo = s;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double m) {
		this.saldo += m;
	}
	
	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	
	//ESTO ES UNA PLANTILLA
	public boolean extraer(double monto) {
		if(this.puedeExtraer(monto)) { //ESTO ES UN GANCHO QUE PERMITE REIMPLEMENTAR EN LAS SUBCLASES ESTA PARTE DE LA PLANTILLA
			System.out.println("Pude");
			this.extraerSinControlar(monto); //ESTO ES UN GANCHO QUE PERMITE REIMPLEMENTAR EN LAS SUBCLASES ESTA PARTE DE LA PLANTILLA
			return true;
		}
		System.out.println("No Pude");
		return false;
	}
	
	public boolean transferirACuenta(double monto, Cuenta des) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			des.depositar(monto);
			return true;
		}
		return false;
	}
	
	public abstract boolean puedeExtraer(double monto);
}
