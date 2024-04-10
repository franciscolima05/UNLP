/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ8;

import Practica2.EJ1.BinaryTree;

/**
 *
 * @author franciscolima
 */
public class MainEJ8 {

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
        
        BinaryTree<Integer> tree2 = new BinaryTree(10);
        
        tree2.addLeftChild(new BinaryTree<Integer>(2));
        tree2.addRightChild(new BinaryTree<Integer>(4));
        tree2.getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
        tree2.getRightChild().addRightChild(new BinaryTree<Integer>(42));
        tree2.getLeftChild().addRightChild(new BinaryTree<Integer>(20));
        tree2.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        tree2.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(60));
        tree2.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(70));
    
        tree.preOrden();
        System.out.println("-------------");
        tree2.preOrden();
        System.out.println(ParcialArboles.esPrefijo(tree, tree2));
    
    }
    
    
}
