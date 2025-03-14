package ar.edu.unlp.info.oo1.ejercicio16_FilteredSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EvenNumberSetTest {
	private EvenNumberSet<Integer> setNum;
	
	@BeforeEach
	public void setUp() {
		setNum = new EvenNumberSet<Integer>();
	}
	
	@Test
	public void testAdd() {
		setNum.add(1);
		assertEquals(0, setNum.size());
		setNum.add(2);
		assertEquals(1, setNum.size());
		assertTrue(setNum.contains(2));
		setNum.add(2);
		assertEquals(1, setNum.size());
		assertTrue(setNum.contains(2));
	}
}