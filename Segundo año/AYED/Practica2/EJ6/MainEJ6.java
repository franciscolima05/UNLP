/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ6;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transformacion arb = new Transformacion(1);
        
        arb.getTree().addLeftChild(new BinaryTree<Integer>(2));
        arb.getTree().addRightChild(new BinaryTree<Integer>(3));
        arb.getTree().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        arb.getTree().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        arb.getTree().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        arb.getTree().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        arb.getTree().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
        
        BinaryTree<Integer> arb2 = arb.suma();
        
        arb2.preOrden();
    }
    
}
