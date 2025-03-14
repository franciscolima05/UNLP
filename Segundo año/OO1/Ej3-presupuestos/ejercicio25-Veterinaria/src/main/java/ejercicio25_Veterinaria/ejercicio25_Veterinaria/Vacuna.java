package ejercicio25_Veterinaria.ejercicio25_Veterinaria;

public class Vacuna extends ServicioProfesional{
	private String nombre;
	private double costo;
	
	public Vacuna(Mascota mascota, Veterinario vet, String nombre, double costo) {
		super(mascota, vet);
		this.nombre = nombre;
		this.costo = costo;
	}

	@Override
	public double calcularMateriales() {
		return 500;
	}

	@Override
	public double calcularExtra() {
		return this.costo;
	}
	
	
}
