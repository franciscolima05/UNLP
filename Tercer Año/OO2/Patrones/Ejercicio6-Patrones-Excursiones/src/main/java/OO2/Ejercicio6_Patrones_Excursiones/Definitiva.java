package OO2.Ejercicio6_Patrones_Excursiones;

public class Definitiva extends TipoInscripcion{

	@Override
	public void inscribirUsuario(Usuario user, Excursion exc) {
		if(exc.getInscriptos().size() == exc.getCupoMaximo()) {
			exc.setTipoDeInscripcion(new ListaDeEspera());	
			exc.getListaDeEspera().add(user);
		}
		else {
			exc.getInscriptos().add(user);
		}
	}

	@Override
	public String informacionExtra(Excursion exc) {
		String cadena = "";
		for (Usuario u: exc.getInscriptos()) {
			cadena += ' ' + u.getEmail();
		}
		return cadena + " "+ String.valueOf(exc.getCupoMaximo() - exc.getInscriptos().size());
	}

}
