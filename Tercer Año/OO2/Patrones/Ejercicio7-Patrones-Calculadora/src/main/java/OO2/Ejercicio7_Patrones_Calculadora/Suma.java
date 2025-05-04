package OO2.Ejercicio7_Patrones_Calculadora;

public class Suma implements Operador{

	@Override
	public String resultado(double num1, double num2, Calculadora calc) {
		return "El resultado es: " + String.valueOf(num1 + num2);
	}

}
