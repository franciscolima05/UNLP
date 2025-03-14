package ejercicio24_PoolCar.ejercicio24_PoolCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{
		
	private List<Viaje> viajesRealizados;
	
	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
		this.viajesRealizados = new ArrayList<Viaje>();
	}
	
	
	public List<Viaje> getViajesRealizados(){
		return this.viajesRealizados;
	}

	@Override
	public double recargo() {
		boolean ok2 = this.viajesRealizados.stream().anyMatch(v -> v.getFecha().isAfter(LocalDate.now().minusDays(30)));
		if(!ok2) {
			return this.getSaldo() * 0.1;
		}
		return 0;
	}
	
	public Viaje agregarViajrAnterior(Viaje v) {
		this.viajesRealizados.add(v);
		return v;
	}


	@Override
	public double bonificacion() {
		if(this.viajesRealizados.size() >= 2) {
			return 500;
		}
		return 0;
	}

}
