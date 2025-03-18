package OO2.ejercicio2_PiedraPapelOTijera;

public class JugarMano {
	
	private Opcion op1;
	private Opcion op2;
	
	public JugarMano(Opcion op1, Opcion op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	public String jugar() {
		return this.op1.jugarPartido(this.op2);
	}
}
