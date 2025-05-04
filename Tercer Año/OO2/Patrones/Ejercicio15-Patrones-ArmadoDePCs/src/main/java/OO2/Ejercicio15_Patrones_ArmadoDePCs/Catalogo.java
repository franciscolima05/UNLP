package OO2.Ejercicio15_Patrones_ArmadoDePCs;

import java.util.List;

public class Catalogo {
	private static List<Componente> componentes;
	
	public static void setComponentes(List<Componente> componentes) {
		Catalogo.componentes= componentes;
	}
	
	public static Componente getComponente(String prompt) {
		return componentes.stream()
		.filter(elem -> elem.getNombre().equals(prompt))
		.findFirst()
		.orElse(null);
	}

}
