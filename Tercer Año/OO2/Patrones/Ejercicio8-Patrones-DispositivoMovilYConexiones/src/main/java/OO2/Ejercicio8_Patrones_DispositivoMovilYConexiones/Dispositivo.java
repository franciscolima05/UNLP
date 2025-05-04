package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

public class Dispositivo {
	private TipoDeCalculadora tipo;
	private Connection connection;
	private Ringer ring;
	private Display display;
	
	
	public Dispositivo() {
		this.tipo = new CRC_16();
		this.connection = new WifiConn();
		this.display = new Display();
		this.ring = new Ringer();
	}
		
	public String send(String data) {
		return connection.sendData(data, tipo.crcFor(data));
	}
	
	public void cambiarCalculadora(TipoDeCalculadora type) {
		this.tipo = type;
	}
	
	public void cambiarConexion(Connection type) {
		this.connection = type;
		this.display.showBanner(type.pict());
		this.ring.ring();
	}
	
	public Connection getConection() {
		return this.connection;
	}
}
