package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public class BuilderIntermedia extends Constructor{

	@Override
	public Constructor agregarProcesador() {
		computadora.add(Catalogo.getComponente("Procesador Intermedio"));
		return this;
		
	}

	@Override
	public Constructor agregarMemoriaRAM() {
		computadora.add(Catalogo.getComponente("16 GB"));
		return this;
	}

	@Override
	public Constructor agregarDisco() {
		computadora.add(Catalogo.getComponente("SSD 500 GB"));
		return this;
		
	}

	@Override
	public Constructor agregarGrafica() {
		computadora.add(Catalogo.getComponente("GTX 1650"));
		return this;
	}

	@Override
	public Constructor agregarGabinete() {
		computadora.add(Catalogo.getComponente("Gabinete Intermedio"));
		computadora.add(Catalogo.getComponente("Fuente 800 W"));
		return this;
	}

	@Override
	protected Constructor agregarUsuario(String usuario) {
		computadora.setUsuario(usuario);
		return this;
	}

	
	

}
