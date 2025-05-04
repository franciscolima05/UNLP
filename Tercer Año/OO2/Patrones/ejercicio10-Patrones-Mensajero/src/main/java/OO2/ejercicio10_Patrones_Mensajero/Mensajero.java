package OO2.ejercicio10_Patrones_Mensajero;

public class Mensajero {
	private EstrategiaDeCifrado strategy;
	
	public Mensajero(EstrategiaDeCifrado str) {
		this.strategy = str;
	}

	public void setStrategy(EstrategiaDeCifrado strategy) {
		this.strategy = strategy;
	}
	
	public void enviar(String mensaje) {
		this.strategy.encriptar(mensaje);
	}
	
	public void recibir(String mensaje) {
		this.strategy.desencriptar(mensaje);
	}
}
