package OO2.Ejercicio7_Patrones_Calculadora;

public interface Estado {

	public void setValor(double num, Calculadora calc);
	
	public void mas(Calculadora calc);
	public void menos(Calculadora calc);
	public void dividido(Calculadora calc);
	public void por(Calculadora calc);
	public String resultado(Calculadora calc);
}
