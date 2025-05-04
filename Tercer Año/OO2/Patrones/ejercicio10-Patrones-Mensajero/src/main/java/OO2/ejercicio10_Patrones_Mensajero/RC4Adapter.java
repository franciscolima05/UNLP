package OO2.ejercicio10_Patrones_Mensajero;

public class RC4Adapter implements EstrategiaDeCifrado{
	private RC4 encriptador;
	private String clave;
	
	public RC4Adapter(String key) {
		this.clave = key;
	}

	@Override
	public void encriptar(String mensaje) {
		this.encriptador = new RC4();
		this.encriptador.encriptar(mensaje, this.clave);
	}

	@Override
	public void desencriptar(String mensaje) {
		this.encriptador.desencriptar(mensaje, this.clave);
	}

}
