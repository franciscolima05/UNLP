/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ6;
import Practica3.EJ1.GeneralTree;
public class MainEJ6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<Character> tree;
        tree = new GeneralTree<>('A');
        tree.addChildren(new GeneralTree<>('B'));
        tree.addChildren(new GeneralTree<>('C'));
        tree.addChildren(new GeneralTree<>('D'));
        tree.addChildren(new GeneralTree<>('E'));
        tree.getChildren().get(1).addChildren(new GeneralTree<>('F'));
        tree.getChildren().get(1).addChildren(new GeneralTree<>('G'));
        tree.getChildren().get(2).addChildren(new GeneralTree<>('H'));
        tree.getChildren().get(2).addChildren(new GeneralTree<>('I'));
        tree.getChildren().get(2).addChildren(new GeneralTree<>('J'));
        tree.getChildren().get(2).addChildren(new GeneralTree<>('K'));
        tree.getChildren().get(2).addChildren(new GeneralTree<>('P'));
        tree.getChildren().get(1).getChildren().get(1).addChildren(new GeneralTree<>('L'));
        tree.getChildren().get(2).getChildren().get(2).addChildren(new GeneralTree<>('M'));
        tree.getChildren().get(2).getChildren().get(2).addChildren(new GeneralTree<>('N'));
        
        RedDeAguaPotable red = new RedDeAguaPotable(tree);
        
        System.out.println(red.minimoCaudal(1000));
    }
    
}
