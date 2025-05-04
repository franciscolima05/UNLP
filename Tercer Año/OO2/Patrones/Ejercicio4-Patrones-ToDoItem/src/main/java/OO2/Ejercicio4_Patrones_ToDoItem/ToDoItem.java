package OO2.Ejercicio4_Patrones_ToDoItem;

import java.time.Duration;
import java.time.Instant;

public class ToDoItem {
	private Instant start;
	private Instant end;
	private String name;
	private Estado state;
	private String comment;
	
	public ToDoItem(String name) {
		this.start = null;
		this.end = null;
		this.name = name;
		this.state = new Pending(this);
		this.comment = null;
	}
	
	public void setEstado(Estado es) {
		this.state = es;
	}
	
	public Estado getState() {
		return this.state;
	}
	
	public void start() {
		state.start();
		this.start = Instant.now();
	}
	
	public void finish() {
		state.finish();
		this.end = Instant.now();
	}
	
	public void togglePause() {
		state.togglePause();
	}
	
	
	public Duration workedTime() {
		if(this.start == null) {
			throw new IllegalStateException("El ToDoItem no se ha iniciado aún.");
		}
		
		if (end == null) {
            return Duration.between(start, Instant.now());
        }
		
		return Duration.between(start, end);
	}
	
	public void addComment(String comm) {
		if(!this.state.equals(new Finished(this))) {
			this.comment = comm;
		}
	}
}
