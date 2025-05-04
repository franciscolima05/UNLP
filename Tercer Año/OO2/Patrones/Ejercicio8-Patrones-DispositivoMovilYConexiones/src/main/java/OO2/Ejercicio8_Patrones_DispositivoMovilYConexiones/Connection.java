package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

public interface Connection {
	
	public String sendData(String data, Long crc);
	
	public String pict();

}
