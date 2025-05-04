package OO2.Ejercicio11_Patrones_Topografias;

import java.util.ArrayList;
import java.util.List;

public class Pantano implements Topografia {
	private List<Topografia> topografias;
	
	public Pantano() {
		this.topografias = new ArrayList<>();
	}

	@Override
	public double calcularProporcion() {
		return this.topografias.stream()
		.mapToDouble(tp -> tp.calcularProporcion())
		.sum() / 4; 
		
	}

	public List<Topografia> getTopografias(){
		return this.topografias;
	}
	
	@Override
	public boolean esIgual(Topografia topo) {
		return topo.esIgualPantano(this);
	}

	
	public void add(Topografia topo) {
		if(topo.esIgualAgua()) {
			this.addAgua(topo);
		}
		if(topo.esIgualTierra()){
			this.addTierra(topo);
		}
	}
	
	public void addAgua(Topografia topo) {
		int num = (int) this.topografias.stream()
				.filter(elemento -> elemento.esIgualAgua())
				.count();
		if(num < 3) {
			this.topografias.add(topo);
		}
	}
	
	public void addTierra(Topografia topo) {
		int num = (int) this.topografias.stream()
				.filter(elemento -> elemento.esIgualTierra())
				.count();
		if(num < 1) {
			this.topografias.add(topo);
		}
	}

	@Override
	public boolean esIgualPantano(Pantano pantano) {
	    List<Topografia> otrasTopos = pantano.getTopografias();
		for (int i = 0; i < this.topografias.size(); i++) {
	        if (!this.topografias.get(i).esIgual(otrasTopos.get(i))) {
	            return false;
	        }
	    }
	    return true;
	}

}
