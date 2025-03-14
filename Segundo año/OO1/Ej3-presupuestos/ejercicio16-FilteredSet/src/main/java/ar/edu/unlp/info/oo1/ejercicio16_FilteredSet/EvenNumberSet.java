package ar.edu.unlp.info.oo1.ejercicio16_FilteredSet;
import java.util.HashSet;
import java.util.Iterator;
public class EvenNumberSet<Integer> extends HashSet<Integer>{

@Override
	public boolean add(Integer num) {
		if ((int)num%2==0){
			return super.add(num);
		}
		else return false;
	}	
	//La otra solucion posible seria en vez de aplicar el abstractset de java y redefinir el metodo add,
	//Usar la interfaz de Set y escibir todos los metodos de esta incluido el Add para que cumpla la funcionalidad esperada	
}


