package OO2.Ejercicio4_Patrones_ToDoItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestToDoItem {

	
	ToDoItem tdInProgress;
	ToDoItem tdPaused;
	ToDoItem tdFinished;
	ToDoItem tdPending;
	ToDoItem tdi;
	
	
	@BeforeEach
	void setUp() {
		tdi = new ToDoItem("Prueba1");
		tdInProgress = new ToDoItem("Progress");
		tdPaused = new ToDoItem("Pausado");
		tdFinished = new ToDoItem("Terminado");
		tdPending = new ToDoItem("Pending");
		
		tdInProgress.start();
		tdPaused.start();
		tdPaused.togglePause();
		tdFinished.start();
		tdFinished.finish();
		
	}
	
	@Test
	void testStart() {
        assertTrue(tdInProgress.getState() instanceof InProgress);
	}
	
	@Test
	void testFinished() {
		assertTrue(tdFinished.getState() instanceof Finished);
	}
	
	@Test
	void testPending() {
		assertTrue(tdPending.getState() instanceof Pending);
	}
	
	@Test
	void testPaused() {
		assertTrue(tdPaused.getState() instanceof Paused);
	}
	
	@Test
	void testWorkedTime() {
		System.out.print(tdFinished.workedTime());
        assertThrows(IllegalStateException.class, () -> tdPending.workedTime());
	}
}
