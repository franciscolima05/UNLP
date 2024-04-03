/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica2.EJ3;

import Practica2.EJ1.BinaryTree;
import java.util.*;
public class MainEJ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContadorArbol arb = new ContadorArbol(10);
        
        arb.getTree().addLeftChild(new BinaryTree<Integer>(8));
        arb.getTree().addRightChild(new BinaryTree<Integer>(12));
        arb.getTree().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        arb.getTree().getLeftChild().addRightChild(new BinaryTree<Integer>(9));
        arb.getTree().getRightChild().addLeftChild(new BinaryTree<Integer>(14));
        arb.getTree().getRightChild().addRightChild(new BinaryTree<Integer>(16));
        
        LinkedList<Integer> list = new LinkedList<>();
        list = arb.numerosPares();
        for(int i=0; i < list.size(); i++){
            System.out.println(i + ": " + list.get(i));
        }
        
        System.out.println("-------------------------------");
        
        LinkedList<Integer> list2 = new LinkedList<>();
        list2 = arb.numerosParesInOrder();
        for(int i=0; i < list2.size(); i++){
            System.out.println(i + ": " + list2.get(i));
        }
        
        System.out.println("-------------------------------");
        
        LinkedList<Integer> list3 = new LinkedList<>();
        list3 = arb.numeroParesPostOrder();
        for(int i=0; i < list3.size(); i++){
            System.out.println(i + ": " + list3.get(i));
        }
    }
    
}
