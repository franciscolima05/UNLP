package OO2.Ejercicio4_Patrones_ToDoItem;

public class Paused extends Estado {
	
	
	public Paused(ToDoItem cx) {
		super(cx);
	}

	@Override
	public void start() {
	}

	@Override
	public void togglePause() {
		this.context.setEstado(new InProgress(this.context));
	}

	@Override
	public void finish() {
		this.context.setEstado(new Finished(this.context));
		
	}
	
	

}
