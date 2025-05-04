package OO2.Ejercicio6_Patrones_Excursiones;

public class ListaDeEspera extends TipoInscripcion{

	@Override
	public void inscribirUsuario(Usuario user, Excursion exc) {
		exc.getListaDeEspera().add(user);
	}

	@Override
	public String informacionExtra(Excursion exc) {
		return "";
	}

}
