/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ1;

/**
 *
 * @author franciscolima
 */
public class MainEJ3 {

    /**
     * @param args the command line arguments
     */
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
        tree.getChildren().get(1).getChildren().get(0).addChildren(new GeneralTree<>(30));
        
        
        System.out.println(tree.nivel(15));
    }
    
}
