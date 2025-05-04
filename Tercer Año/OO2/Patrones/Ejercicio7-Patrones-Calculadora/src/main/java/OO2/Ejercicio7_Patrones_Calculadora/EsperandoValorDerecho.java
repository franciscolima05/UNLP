package OO2.Ejercicio7_Patrones_Calculadora;

public class EsperandoValorDerecho implements Estado {

	@Override
	public void setValor(double num, Calculadora calc) {	
		calc.setValor2(num);
	}

	@Override
	public void mas(Calculadora calc) {
		calc.setEstado(new Error());
		
	}

	@Override
	public void menos(Calculadora calc) {
		calc.setEstado(new Error());
		
	}

	@Override
	public void dividido(Calculadora calc) {
		calc.setEstado(new Error());
		
	}

	@Override
	public void por(Calculadora calc) {
		calc.setEstado(new Error());
		
	}

	@Override
	public double resultado(Calculadora calc) {
		
	}
}
