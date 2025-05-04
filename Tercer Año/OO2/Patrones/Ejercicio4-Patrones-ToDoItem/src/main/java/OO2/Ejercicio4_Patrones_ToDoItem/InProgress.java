package OO2.Ejercicio4_Patrones_ToDoItem;

public class InProgress extends Estado{

	
	public InProgress(ToDoItem context) {
		super(context);
	}

	@Override
	public void start() {
	}

	@Override
	public void togglePause() {
		this.context.setEstado(new Paused(this.context));
	}

	@Override
	public void finish() {
		this.context.setEstado(new Finished(this.context));
		
	}
	

}
