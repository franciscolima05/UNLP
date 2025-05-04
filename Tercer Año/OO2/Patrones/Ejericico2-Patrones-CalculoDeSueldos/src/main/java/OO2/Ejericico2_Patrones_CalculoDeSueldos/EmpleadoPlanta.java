package OO2.Ejericico2_Patrones_CalculoDeSueldos;

public class EmpleadoPlanta extends EmpleadoConHijos{
	private int antiguedad;
	
	public EmpleadoPlanta(int a, int ch, boolean es) {
		super(ch, es);
		this.antiguedad = a;
	}
	
	@Override
	protected int calcularExtras() {
		return this.antiguedad * 2000;
	}

	@Override
	public double calcularBasico() {
		return 50000;
	}

}
