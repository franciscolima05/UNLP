package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public class CuentaCorriente extends Cuenta{
	private double limite;
	
	
	@Override
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo() - monto >= this.limite) {
			return true;
		}
		return false;
		
	}
	 
	public CuentaCorriente() {
		this.limite = 0;
	}
	
	public CuentaCorriente(double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}
	
	public double getLimite() {
		return this.limite;
	}
}
