package OO2.Ejercicio6_Patrones_Excursiones;

public abstract class TipoInscripcion {

	public abstract void inscribirUsuario(Usuario user, Excursion exc);
	
	public String darInformacion(Excursion exc) {
		String cadena = exc.getNombre()+" "+ exc.getCosto() +" "+ exc.getFechaFin() +" "+ exc.getFechaInicio() +" "+ exc.getPuntoDeEncuentro();
		return cadena + this.informacionExtra(exc);
	}
	
	public abstract String informacionExtra(Excursion exc);
}
