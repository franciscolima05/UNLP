/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ10;
import Practica3.EJ1.GeneralTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class MainEJ10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(1);
        tree.addChildren(new GeneralTree<>(0));
        tree.addChildren(new GeneralTree<>(1));
        tree.addChildren(new GeneralTree<>(1));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(0));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(0));
        tree.getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(1).getChildren().get(1).addChildren(new GeneralTree<>(0));
        tree.getChildren().get(1).getChildren().get(1).getChildren().get(0).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(2).getChildren().get(0).addChildren(new GeneralTree<>(0));
        tree.getChildren().get(2).getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(0));
        tree.getChildren().get(2).getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(0));
        
        List<Integer> lista = ParcialArboles10.resolver(tree);
        
        tree.porNiveles();
        
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
    
}
