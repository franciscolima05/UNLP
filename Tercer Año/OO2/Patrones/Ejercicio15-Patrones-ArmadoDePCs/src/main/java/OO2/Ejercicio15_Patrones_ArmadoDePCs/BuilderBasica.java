package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public class BuilderBasica extends Constructor {


	@Override
	public Constructor agregarProcesador() {
		computadora.add(Catalogo.getComponente("Procesador Basico"));
		return this;
		
	}

	@Override
	public Constructor agregarMemoriaRAM() {
		computadora.add(Catalogo.getComponente("8 GB"));
		return this;
	}

	@Override
	public Constructor agregarDisco() {
		computadora.add(Catalogo.getComponente("HDD 500 GB"));
		return this;
		
	}

	@Override
	public Constructor agregarGrafica() {
		return this;
	}

	@Override
	public Constructor agregarGabinete() {
		computadora.add(Catalogo.getComponente("Gabinete Estandar"));
		return this;
		
	}

	@Override
	protected Constructor agregarUsuario(String usuario) {
		computadora.setUsuario(usuario);
		return this;
	}

	
}
