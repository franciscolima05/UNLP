/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ4;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RedBinariaLlena arb = new RedBinariaLlena(10);
        
        arb.getTree().addLeftChild(new BinaryTree<Integer>(2));
        arb.getTree().addRightChild(new BinaryTree<Integer>(3));
        arb.getTree().getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
        arb.getTree().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        arb.getTree().getRightChild().addLeftChild(new BinaryTree<Integer>(9));
        arb.getTree().getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println(arb.retardoReenvio());
    }
    
}
