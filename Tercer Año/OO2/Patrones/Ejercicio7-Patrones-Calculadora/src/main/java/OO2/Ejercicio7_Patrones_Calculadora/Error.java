package OO2.Ejercicio7_Patrones_Calculadora;

public class Error implements Estado{

	@Override
	public void setValor(double num, Calculadora calc) {
	}

	@Override
	public void mas(Calculadora calc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menos(Calculadora calc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dividido(Calculadora calc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void por(Calculadora calc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String resultado(Calculadora calc) {
		return "ERROR";
	}

}
