package OO2.Ejericico2_Patrones_CalculoDeSueldos;

public abstract class Empleado {

	public double calcularDescuento() {
		return this.calcularBasico() * 0.13 + this.calcularAdicional() * 0.05;
	}
	
	public abstract double calcularBasico();
	
	public abstract double calcularAdicional();
	
	public double sueldo() {
		return this.calcularAdicional() + this.calcularBasico() - this.calcularDescuento();
	}
}
