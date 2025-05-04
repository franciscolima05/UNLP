package OO2.Ejercicio7_Patrones_Calculadora;

public class Calculadora {
	private double valor1;
	private double valor2;
	private Operador operacion;
	private Estado state;
	
	
	public void setValor(double num) {
		this.state.setValor(num, null);
	}
	
	public void mas() {
		this.state.mas(this);
	}
	
	public void menos() {
		this.state.menos(this);
	}
	
	public void dividido() {
		this.state.dividido(this);
	}
	
	public void por() {
		this.state.por(this);
	}
	
	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public void setState(Estado state) {
		this.state = state;
	}

	public void setOperacion(Operador op) {
		this.operacion = op;
	}
	
	public void setEstado(Estado st) {
		this.state = st;
	}
	
	public String resultado() {
		this.state.resultado(this);
	}
	
	public Operador getOperador() {
		return this.operacion;
	}
	
	public double getValor1() {
		return this.valor1;
	}
	
	public double getValor2() {
		return this.valor2;
	}
}
