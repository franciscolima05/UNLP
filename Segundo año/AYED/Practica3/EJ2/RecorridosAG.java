package Practica3.EJ2;
import java.util.*;
import Practica3.EJ1.GeneralTree;
import Practica1.EJ8.Queue;
public class RecorridosAG {
    

    private static void numerosImparesHelperPreOrden(GeneralTree<Integer> a, Integer n, LinkedList<Integer> list){
        int i = 0;
        if(!(a.getData() % 2 == 0) && a.getData() > n){
            list.add(a.getData());
        }
        if(a.hasChildren()){
            while(a.getChildren().size() > i){
                numerosImparesHelperPreOrden(a.getChildren().get(i), n, list);
                i++;
            }
        }
    }
    
    
    public static LinkedList<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
        LinkedList<Integer> list = new LinkedList<>();
        numerosImparesHelperPreOrden(a, n, list);
        return list;
    }
    
    private static void numerosImparesHelperPostOrden(GeneralTree<Integer> a, Integer n, LinkedList<Integer> list){
        int i = 0;
        if(a.hasChildren()){
            while(a.getChildren().size() > i){
                numerosImparesHelperPostOrden(a.getChildren().get(i), n, list);
                i++;
            }
        }
        if(!(a.getData() % 2 == 0) && a.getData() > n){
            list.add(a.getData());
        }
    }
    
    
    public static LinkedList<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
        LinkedList<Integer> list = new LinkedList<>();
        if(a.isEmpty()){
            return list;
        }
        numerosImparesHelperPostOrden(a, n, list);
        return list;
    }
 
    public static LinkedList<Integer>  numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        LinkedList<Integer> list = new LinkedList<>();
       GeneralTree<Integer> aux = new GeneralTree<>(0);
        cola.enqueue(a);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(!(aux.getData() % 2 == 0) && aux.getData() > n){
                list.add(aux.getData());
            }
            for(int i = 0; i< aux.getChildren().size(); i++){
                cola.enqueue(aux.getChildren().get(i));
            }
        }
        return list;
    }
    
    private static void numerosImparesMayoresQueInOrdenHelper(GeneralTree<Integer> a, Integer n, LinkedList<Integer> list){
        if(a.hasChildren()){
            numerosImparesMayoresQueInOrdenHelper(a.getChildren().get(0), n, list);
        }
        Integer aux = a.getData();
        if(!(aux % 2 == 0) && aux > n){
            list.add(aux);
        }
        for(int i = 1; i < a.getChildren().size(); i++){
            numerosImparesMayoresQueInOrdenHelper(a.getChildren().get(i), n, list);
        }
    }
    
    public static LinkedList<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
        LinkedList<Integer> list = new LinkedList<>();
        numerosImparesMayoresQueInOrdenHelper(a, n, list);
        return list;
    }
     
    
}
