/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parciales;
import Practica2.EJ1.BinaryTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class MainParcialLF2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(7);
        tree1.addLeftChild(new BinaryTree<>(56));
        tree1.addRightChild(new BinaryTree<>(25));
        tree1.getLeftChild().addLeftChild(new BinaryTree<>(38));
        tree1.getLeftChild().addRightChild(new BinaryTree<>(31));
        tree1.getRightChild().addLeftChild(new BinaryTree<>(5));
        tree1.getRightChild().addRightChild(new BinaryTree<>(6));
        tree1.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(87));
        tree1.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(77));
        tree1.getLeftChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(16));
        tree1.getLeftChild().getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<>(43));
        tree1.getLeftChild().getLeftChild().getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(9));
        tree1.getLeftChild().getLeftChild().getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<>(10));
        tree1.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(94));
        tree1.getLeftChild().getRightChild().getRightChild().addRightChild(new BinaryTree<>(2));
        tree1.getLeftChild().getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<>(1));
        LinkedList<Integer> lista1 = ParcialLF2022.resolver(tree1, 3);
        for(Integer elem : lista1){
            System.out.println(elem);
        }
    }
    
}
