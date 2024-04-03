/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ1;

/**
 *
 * @author franciscolima
 */
public class MainEJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree(10);
        
        tree.addLeftChild(new BinaryTree<Integer>(2));
        tree.addRightChild(new BinaryTree<Integer>(4));
        tree.getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
        tree.getRightChild().addRightChild(new BinaryTree<Integer>(42));
        tree.getLeftChild().addRightChild(new BinaryTree<Integer>(20));
        
        System.out.println(tree.contarHojas());
        tree.entreNiveles(0, 3);
    }
}
