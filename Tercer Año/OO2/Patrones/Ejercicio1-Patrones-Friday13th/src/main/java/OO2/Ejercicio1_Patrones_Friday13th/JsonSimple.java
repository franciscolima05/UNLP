package OO2.Ejercicio1_Patrones_Friday13th;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimple extends VoorheesExporter {
	
	@SuppressWarnings({ "unchecked", "unused" })
	private String exportar(Socio s) {
		JSONObject obj = new JSONObject();
		obj.put("Nombre", s.getNombre());
		obj.put("Email", s.getEmail());
		obj.put("Legajo", s.getLegajo());
		
		try {

			FileWriter file = new FileWriter("data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj.toJSONString();
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private String exportarSocios(List<Socio> socios) {
		JSONArray obj = new JSONArray();
		socios.forEach(socio -> {
			obj.add(socio.getNombre());
			obj.add(socio.getEmail());
			obj.add(socio.getLegajo());
		});
		
		
		try {

			FileWriter file = new FileWriter("data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj.toJSONString();
	}

}
