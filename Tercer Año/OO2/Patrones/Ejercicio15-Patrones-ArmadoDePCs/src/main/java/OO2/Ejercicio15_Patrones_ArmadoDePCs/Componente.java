package OO2.Ejercicio15_Patrones_ArmadoDePCs;

public class Componente {
	private String nombre;
	private double precio;
	private double consumo;
	public Componente(String nombre, double precio, double consumo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.consumo = consumo;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

}
