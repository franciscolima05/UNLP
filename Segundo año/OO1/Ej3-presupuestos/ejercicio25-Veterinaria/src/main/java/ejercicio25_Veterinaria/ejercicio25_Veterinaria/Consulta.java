package ejercicio25_Veterinaria.ejercicio25_Veterinaria;


public class Consulta extends ServicioProfesional{


	public Consulta(Mascota mascota, Veterinario vet) {
		super(mascota, vet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularMateriales() {
		return 300;
	}

	@Override
	public double calcularExtra() {
		return this.getVeterinario().calcularBonificacionVet();
	}
}
