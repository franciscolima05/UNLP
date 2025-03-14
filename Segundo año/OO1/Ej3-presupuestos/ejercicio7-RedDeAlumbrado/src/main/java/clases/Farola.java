package clases;

import java.util.*;

public class Farola {

	private List<Farola> vecinos;
	private boolean prendida;
	
	
	public Farola() {
		this.vecinos = new LinkedList<Farola>();
		this.prendida = false;
	}
	
	public List<Farola> getNeighbors(){
		return this.vecinos;
	}
	
	
	public void pairWithNeighbor(Farola f1) {
		if(!this.vecinos.contains(f1)) {
			this.vecinos.add(f1);
			f1.getNeighbors().add(this);
		}
	}
	
	public boolean isOn() {
		return this.prendida;
	}
	
	public boolean isOff() {
		return !this.prendida;
	}
	
	public void setPrendida(boolean ok) {
		this.prendida = ok;
	}
	
	public void turnOn() {
		if(this.isOff()) {
			turnOnHelper(this);
		}
	}
	
	private void turnOnHelper(Farola f) {
		f.setPrendida(true);
		for (Farola fa : f.getNeighbors()) {
			if(fa.isOff()) {
				turnOnHelper(fa);
			}
		}
	}
	
	public void turnOff() {
		if(this.isOn()) {
			turnOffHelper(this);
		}
	}
	
	private void turnOffHelper(Farola f) {
		f.setPrendida(false);
		for (Farola fa : f.getNeighbors()) {
			if(fa.isOn()) {
				turnOffHelper(fa);
			}
		}
	}
}