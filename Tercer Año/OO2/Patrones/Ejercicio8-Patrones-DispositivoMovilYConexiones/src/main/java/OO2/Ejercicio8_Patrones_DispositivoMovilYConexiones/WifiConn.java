package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

public class WifiConn implements Connection{
	private String pict;
	
	
	
	public WifiConn() {
		this.pict = "WIFI";
	}

	@Override
	public String sendData(String data, Long crc) {
		return "El Mensaje es: " + data+ " "+ crc;
	}

	@Override
	public String pict() {
		return this.pict;
	}
	
	

}
