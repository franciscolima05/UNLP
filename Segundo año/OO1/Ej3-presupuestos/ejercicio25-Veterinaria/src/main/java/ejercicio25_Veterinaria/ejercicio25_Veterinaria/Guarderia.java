package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

public class Guarderia extends ServicioGeneral{
	private int cantDias;	
	
	public Guarderia(Mascota mascota, int cant) {
		super(mascota);
		this.cantDias = cant;
		
	}

	@Override
	public double calcularCostoDeServicio() {
		double monto = this.cantDias * 500;
		if(this.getMascota().utilizoServicios(5)) {
			return monto - monto * 0.1;
		}
		return monto;
	}

}
