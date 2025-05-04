package OO2.Ejericico2_Patrones_CalculoDeSueldos;

public class EmpleadoPasante extends Empleado{
	private int cantExamenes;
	
	public EmpleadoPasante(int cant) {
		this.cantExamenes = cant;
	}

	@Override
	public double calcularBasico() {
		return 20000;
	}

	@Override
	public double calcularAdicional() {
		return this.cantExamenes * 2000;
	}

}
