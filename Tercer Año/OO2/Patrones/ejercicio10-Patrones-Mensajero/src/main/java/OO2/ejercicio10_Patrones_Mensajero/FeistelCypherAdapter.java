package OO2.ejercicio10_Patrones_Mensajero;

public class FeistelCypherAdapter implements EstrategiaDeCifrado{
	private FeistelCypher encriptador;

	@Override
	public void encriptar(String mensaje) {
		this.encriptador = new FeistelCypher(mensaje);
		this.encriptador.encode(mensaje);		
	}

	@Override
	public void desencriptar(String mensaje) {
		this.encriptador.encode(mensaje);
	}

}
