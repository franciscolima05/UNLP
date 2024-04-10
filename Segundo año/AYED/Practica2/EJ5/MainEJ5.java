/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ5;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProfundidadDeArbolBinario arb = new ProfundidadDeArbolBinario(20);
        
        arb.getTree().addLeftChild(new BinaryTree<Integer>(10));
        arb.getTree().addRightChild(new BinaryTree<Integer>(15));
        arb.getTree().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        arb.getTree().getLeftChild().addRightChild(new BinaryTree<Integer>(9));
        arb.getTree().getRightChild().addLeftChild(new BinaryTree<Integer>(16));
        arb.getTree().getRightChild().addRightChild(new BinaryTree<Integer>(25));
        
        System.out.println(arb.sumaElementosProfundidad(2));

        
    }
    
}
