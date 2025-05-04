package OO2.Ejercicio8_Patrones_DispositivoMovilYConexiones;
import java.util.zip.CRC32;

public class CRC_32 implements TipoDeCalculadora{

	@Override
	public Long crcFor(String data) {
		CRC32 crc = new CRC32();
		crc.update(data.getBytes());
		return crc.getValue();
	}

}
