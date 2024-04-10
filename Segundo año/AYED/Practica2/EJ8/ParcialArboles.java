/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ8;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class ParcialArboles {
    
    private static boolean prefijoHelper(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        int aux, aux2;
        aux = arbol1.getData();
        aux2 = arbol2.getData();
        if(aux != aux2){
            return false;
        }
        boolean res = true;
        if(arbol1.hasLeftChild()){
            if(arbol2.hasLeftChild()){
                res = res && prefijoHelper(arbol1.getLeftChild(), arbol2.getLeftChild());
            } else return false;
        }
        if(arbol1.hasRightChild()){
            if(arbol2.hasRightChild()){
                res = res && prefijoHelper(arbol1.getRightChild(), arbol2.getRightChild());
            }else return false;
        }
        return res;
    }
    
    
    public static boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if((arbol1.isEmpty()) || (arbol2.isEmpty()))
            return arbol1.isEmpty() && arbol2.isEmpty();
        return prefijoHelper(arbol1, arbol2);
    }
}
