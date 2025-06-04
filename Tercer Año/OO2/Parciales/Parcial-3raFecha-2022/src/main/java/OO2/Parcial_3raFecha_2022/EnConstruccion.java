package OO2.Parcial_3raFecha_2022;

public class EnConstruccion extends Estado{
	
	@Override
	public void aprobarEtapa(Proyecto proy) throws Exception {
		if(proy.precioDelProyecto() > 0) {
			proy.setEstado(new EnEvaluacion());
		}
		throw new RuntimeException("Este es mi mensaje de error");
	}
	
	
	@Override
	public void modificarMargenDeGanancia(Proyecto proy, double nuevoMargen) {
		if(proy.getMargen() > 0.08 && proy.getMargen() < 0.10) {
			proy.setMargen(nuevoMargen);
		}
	}
	
	
}
