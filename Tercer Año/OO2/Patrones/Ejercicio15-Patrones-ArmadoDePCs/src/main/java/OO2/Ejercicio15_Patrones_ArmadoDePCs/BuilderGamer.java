package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public class BuilderGamer extends Constructor {


	@Override
	public Constructor agregarProcesador() {
		computadora.add(Catalogo.getComponente("Procesador Gamer"));
		computadora.add(Catalogo.getComponente("Pad Termico"));
		computadora.add(Catalogo.getComponente("Cooler"));
		return this;
		
	}

	@Override
	public Constructor agregarMemoriaRAM() {
		computadora.add(Catalogo.getComponente("32 GB"));
		computadora.add(Catalogo.getComponente("32 GB"));
		return this;
	}

	@Override
	public Constructor agregarDisco() {
		computadora.add(Catalogo.getComponente("SSD 500 GB"));
		computadora.add(Catalogo.getComponente("SSD 1 TB"));
		return this;
		
	}

	@Override
	public Constructor agregarGrafica() {
		computadora.add(Catalogo.getComponente("RTX 4090"));
		return this;
	}

	@Override
	public Constructor agregarGabinete() {
		computadora.add(Catalogo.getComponente("Gabinete Gamer"));
		double consumo = computadora.calcularConsumo();
		computadora.add(Catalogo.getComponente("Fuente" + consumo + "W"));
		return this;
	}

	@Override
	protected Constructor agregarUsuario(String usuario) {
		computadora.setUsuario(usuario);
		return this;
	}

	
	
}
