package OO2.ejercicio2_PiedraPapelOTijera;

public class Papel extends Opcion {

	@Override
	public String jugarPartido(Opcion op) {
		return op.jugar(this);
	}

	@Override
	public String jugar(Piedra op) {
		return "Gana Papel";
	}

	@Override
	public String jugar(Tijera op) {
		return "Gana Tijera";
	}

	@Override
	public String jugar(Papel op) {
		return "Empate";
	}

	@Override
	public String jugar(Lagarto op) {
		return "Gana Lagarto";
	}

	@Override
	public String jugar(Spock op) {
		return "Gana Papel";
	}
	
	

}
