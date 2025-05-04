package OO2.Ejericico2_Patrones_CalculoDeSueldos;

public class EmpleadoTemporario extends EmpleadoConHijos{
	private int cantHoras;
	public EmpleadoTemporario(int horas, int ch, boolean es) {
		super(ch, es);
		this.cantHoras = horas;
	}

	@Override
	protected int calcularExtras() {
		return 0;
	}

	@Override
	public double calcularBasico() {
		return 20000 + this.cantHoras * 300;
	}

}
