/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ7;
import Practica3.EJ1.GeneralTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class MainEJ7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(12);
        
        tree.addChildren(new GeneralTree<>(17));
        tree.addChildren(new GeneralTree<>(9));
        tree.addChildren(new GeneralTree<>(15));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(10));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(6));
        tree.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree<>(1));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(8));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(14));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(18));
        tree.getChildren().get(2).getChildren().get(0).addChildren(new GeneralTree<>(16));
        tree.getChildren().get(2).getChildren().get(0).addChildren(new GeneralTree<>(7));
        
        List<Integer> list;
        Caminos cam = new Caminos(tree);
        list = cam.caminoAHojaMasLejana();
        int i = 0;
        for(Integer elem : list){
            System.out.println("ELEMENTO NRO: " + i++ + " - " + elem);
        }
    }
    
}
