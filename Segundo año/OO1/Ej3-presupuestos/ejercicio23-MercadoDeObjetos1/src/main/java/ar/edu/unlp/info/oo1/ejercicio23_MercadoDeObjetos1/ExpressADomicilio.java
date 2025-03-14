package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos1;

public class ExpressADomicilio implements TipoDeEnvio{

	@Override
	public double calcularPrecio(String dir1, String dir2) {
		return CalculadoraDeDistancia.distanciaEntre(dir1, dir2) / 2;
	}

}
