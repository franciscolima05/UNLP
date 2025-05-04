package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

public class Connection4G extends Conn4G {
	private String symb;
	
	public Connection4G() {
		this.symb = "4G";
	}
	
	public String transmit(String data, Long crc) {
		return "El Mensaje es: " + data + " "+ crc;
	}
	
	public String symb() {
		return this.symb;
	}

	
}
