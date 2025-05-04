package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public abstract class Constructor {
	
	protected Presupuesto computadora;

	public  void reset() {
		computadora = new Presupuesto();
	}
	
	public  abstract Constructor agregarProcesador();
	public  abstract Constructor agregarMemoriaRAM();
	public  abstract Constructor agregarDisco();
	public  abstract Constructor agregarGrafica();
	public  abstract Constructor agregarGabinete();
	
	public Presupuesto getProducto() {
		Presupuesto c = computadora;
		this.reset();
		return c;
	}

	protected abstract Constructor agregarUsuario(String usuario);
}
