package OO2.ejercicio2_PiedraPapelOTijera;

public class Spock extends Opcion {
	
	@Override
	public String jugarPartido(Opcion op) {
		return op.jugar(this);
	}

	@Override
	public String jugar(Piedra op) {
		return "Gana Spock";
	}

	@Override
	public String jugar(Tijera op) {
		return "Gana Spock";
	}

	@Override
	public String jugar(Papel op) {
		return "Gana Papel";
	}

	@Override
	public String jugar(Lagarto op) {
		return "Gana Lagarto";
	}

	@Override
	public String jugar(Spock op) {
		return "Empate";
	}
	
	

}


}
