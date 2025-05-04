package OO2.Ejercicio4_Patrones_ToDoItem;

public abstract class Estado {
	protected ToDoItem context;
	
	public Estado(ToDoItem cx) {
		this.context = cx;
	}

	public abstract void start();
	
	public abstract void togglePause();
	
	public abstract void finish();

}
