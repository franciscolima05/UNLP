package Practica3.EJ2;
import Practica3.EJ1.GeneralTree;
import java.util.*;

public class MainEJ1 {

    public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(7);
        tree.addChildren(new GeneralTree<>(13));
        tree.addChildren(new GeneralTree<>(15));
        tree.addChildren(new GeneralTree<>(17));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(20));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(21));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(24));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(25));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(27));
        
        LinkedList<Integer> list;
        
        list = RecorridosAG.numerosImparesMayoresQuePostOrden(tree, 5);
        
        System.out.println("LISTA");
        
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
