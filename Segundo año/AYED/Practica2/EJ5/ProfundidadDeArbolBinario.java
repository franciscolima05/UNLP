/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ5;

import Practica1.EJ8.Queue;
import Practica2.EJ1.BinaryTree;
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> tree;

    public ProfundidadDeArbolBinario(int i) {
        this.tree = new BinaryTree(i);
    }
    
    
    
    public  BinaryTree<Integer> getTree(){
        return this.tree;
    }
    
    
    private int sumaElementosHelper(BinaryTree<Integer> arb, int i, int p){
        if(i == p)
           return arb.getData();
        else{
            int total = 0;
            if(arb.hasLeftChild())
                total += sumaElementosHelper(arb.getLeftChild(), i+1, p);
            if(arb.hasRightChild())
                total += sumaElementosHelper(arb.getRightChild(), i+1, p);
            return total;
        }
    }
    
    public int sumaElementosProfundidad(int p){
        if(!this.tree.isEmpty())
            return this.sumaElementosHelper(this.tree, 0, p);
        else
            return -1;
    }
}
