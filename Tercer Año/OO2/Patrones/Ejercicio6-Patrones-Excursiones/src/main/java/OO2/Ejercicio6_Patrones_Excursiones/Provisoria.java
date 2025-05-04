package OO2.Ejercicio6_Patrones_Excursiones;

public class Provisoria extends TipoInscripcion{

	@Override
	public void inscribirUsuario(Usuario user, Excursion exc) {
		exc.getInscriptosProvisionales().add(user);
		if(exc.getInscriptosProvisionales().size() > exc.getCupoMinimo()) {
			exc.setTipoDeInscripcion(new Definitiva());
			exc.getInscriptos().addAll(exc.getInscriptosProvisionales());
			exc.getInscriptosProvisionales().clear();
		}
		
	}

	@Override
	public String informacionExtra(Excursion exc) {
		return " " + String.valueOf(exc.getCupoMaximo() - exc.getCupoMinimo());
	}

}
