package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{

	public CajaDeAhorro() {
		super(0);
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
			if(this.getSaldo() >= monto * 1.02) {
				return true;
			}
			return false;
	}

	//ESTOY REDEFINIENDO LA PLANTILLA DEL PADRE, POR ENDE RECHAZANDO LA HERENCIA
//@Override
//	public boolean extraer(double monto) {
//		 if(this.puedeExtraer(monto + monto * 0.02)) {
//			 System.out.println("RESULTADO: " + monto + monto * 0.02);
//			 this.extraerSinControlar(monto + monto * 0.02);
//			 return true;
//		 }
//		 return false;
//	}
//@Override
//	public boolean transferirACuenta(double monto, Cuenta destino) {
//		if(this.puedeExtraer(monto + monto * 0.02)) {
//			this.extraerSinControlar(monto + monto * 0.02);
//			destino.depositar(monto);
//			return true;
//		}
//		return false;
//	}

@Override
	public void depositar(double monto) {
		super.depositar(monto - monto * 0.02);
	}

protected void extraerSinControlar(double monto) {
	super.extraerSinControlar(monto*1.02);
}

}