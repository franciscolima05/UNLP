package OO2.Ejercicio4_Patrones_ToDoItem;

public class Finished extends Estado {

	public Finished(ToDoItem cx) {
		super(cx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("La tarea ha terminado");
	}

	@Override
	public void finish() {
	}

}
