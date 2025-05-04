package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;

public class Conn4G implements Connection{
	private Connection4G conexion4G;
	
	public Conn4G() {
	}

	@Override
	public String sendData(String data, Long crc) {
		conexion4G = new Connection4G();
		return this.conexion4G.transmit(data, crc);
		
	}

	@Override
	public String pict() {
		conexion4G = new Connection4G();
		return this.conexion4G.symb();
	}

}
