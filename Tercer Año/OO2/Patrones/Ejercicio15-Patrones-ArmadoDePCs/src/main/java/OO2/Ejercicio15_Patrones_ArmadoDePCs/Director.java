package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public class Director {

	public Presupuesto armarComputadora(Constructor builder, String usuario) {
		return builder.agregarProcesador()
		.agregarMemoriaRAM()
		.agregarDisco()
		.agregarGrafica()
		.agregarGabinete()
		.agregarUsuario(usuario)
		.getProducto();
	}	
}
