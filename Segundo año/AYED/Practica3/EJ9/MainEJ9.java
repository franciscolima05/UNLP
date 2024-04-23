/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ9;
import Practica3.EJ1.GeneralTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(12);
        tree.addChildren(new GeneralTree<>(12));
        tree.addChildren(new GeneralTree<>(25));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(35));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(12));
        tree.getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(35));
        tree.getChildren().get(0).getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree<>(35));
        tree.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree<>(14));
        tree.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree<>(12));
        tree.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree<>(33));
        tree.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree<>(35));
        tree.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree<>(83));
        tree.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree<>(90));
        tree.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree<>(33));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(25));
        
        tree.porNiveles();
        System.out.println(ParcialArboles.esDeSeleccion(tree));
    }
    
}
