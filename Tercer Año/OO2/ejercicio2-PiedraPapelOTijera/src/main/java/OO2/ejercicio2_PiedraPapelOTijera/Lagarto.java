package OO2.ejercicio2_PiedraPapelOTijera;

public class Lagarto extends Opcion {

	@Override
	public String jugarPartido(Opcion op) {
		return op.jugar(this);
	}

	@Override
	public String jugar(Piedra op) {
		return "Gana Piedra";
	}

	@Override
	public String jugar(Tijera op) {
		return "Gana Tijera";
	}

	@Override
	public String jugar(Papel op) {
		return "Gana Lagarto";
	}

	@Override
	public String jugar(Lagarto op) {
		return "Empate";
	}

	@Override
	public String jugar(Spock op) {
		return "Gana Lagarto";
	}
	
	

}

