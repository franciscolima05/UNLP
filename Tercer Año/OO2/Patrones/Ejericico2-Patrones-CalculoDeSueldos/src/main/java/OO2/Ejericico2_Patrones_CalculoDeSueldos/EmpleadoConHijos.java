package OO2.Ejericico2_Patrones_CalculoDeSueldos;

public abstract class EmpleadoConHijos extends Empleado {
	private int cantHijos;
	private boolean esCasado;
	
	public EmpleadoConHijos(int ch, boolean es) {
		this.cantHijos = ch;
		this.esCasado = es;
	}
	
	@Override
	public double calcularAdicional() {
		int total = 0;
		if(this.esCasado) {
			total += 5000;
		}
		total += 2000 * this.cantHijos;
		return total + this.calcularExtras();
	}


	protected abstract int calcularExtras();

	
}
