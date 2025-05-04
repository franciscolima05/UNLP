package OO2.Ejercicio7_Patrones_Calculadora;

public class Division implements Operador{

	@Override
	public String resultado(double num1, double num2, Calculadora calc) {
		if(num2 == 0) {
			calc.setEstado(new Error());
			return 	"ERROR";
		}
		else {
			return "El resultado es: " + String.valueOf( num1 / num2);
		}
	}

}
