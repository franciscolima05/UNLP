package OO2.Ejercicio7_Patrones_Calculadora;

public class EsperandoOperador implements Estado {

	@Override
	public void setValor(double num, Calculadora calc) {
		
	}

	@Override
	public void mas(Calculadora calc) {
		calc.setOperacion(new Suma());
	}

	@Override
	public void menos(Calculadora calc) {
		calc.setOperacion(new Resta());
		
	}

	@Override
	public void dividido(Calculadora calc) {
		calc.setOperacion(new Division());
		
	}

	@Override
	public void por(Calculadora calc) {
		calc.setOperacion(new Multiplicacion());
		
	}

	@Override
	public double resultado(Calculadora calc) {
		return calc.getOperador().resultado(calc.getValor1(), calc.getValor2(), calc);
	}

}
