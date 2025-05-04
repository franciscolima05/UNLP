package OO2.Ejercicio4_Patrones_ToDoItem;

public class Pending extends Estado{

	public Pending(ToDoItem toDoItem) {
		super(toDoItem);
	}

	@Override
	public void start() {
		this.context.setEstado(new InProgress(this.context));
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("La tarea esta pending");
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}
	
	

}
