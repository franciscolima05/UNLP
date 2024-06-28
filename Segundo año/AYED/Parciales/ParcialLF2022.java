/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales;
import java.util.*;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class ParcialLF2022 {
    
    public static LinkedList<Integer> resolver(BinaryTree<Integer> tree, int min){
         LinkedList<Integer> list = new LinkedList();
         if(!tree.isEmpty()){
             resolverHelper(tree, min, list, new LinkedList<>());
         }
         return list;
    }
    
    
    private static void resolverHelper(BinaryTree<Integer>tree, int min, LinkedList<Integer> listMin, LinkedList<Integer> listAct){
        listAct.add(tree.getData());
        if(listMin.isEmpty()){
            if(tree.hasLeftChild()){
                resolverHelper(tree.getLeftChild(), min, listMin, listAct);
            }
            if(tree.hasRightChild()){
                resolverHelper(tree.getRightChild(), min, listMin, listAct);
            }
            if(tree.isLeaf()){
                int cont = 0;
                for(Integer elem : listAct){
                    if(elem % 2 == 0){
                        cont++;
                    }
                }
                if(cont >= min){
                    listMin.addAll(listAct);
                }
            }
            listAct.remove(listAct.size() - 1);
        }
    }
}
