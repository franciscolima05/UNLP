/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ4;

import Practica2.EJ1.BinaryTree;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class RedBinariaLlena {
    private BinaryTree<Integer> tree = new BinaryTree<>(0);

    public BinaryTree<Integer> getTree() {
        return tree;
    }


    public RedBinariaLlena(int i){
        this.tree.setData(i);
    }
    
    private int maximo(BinaryTree <Integer> tree, int i, int j){
        if(i> j)
            return i + tree.getData();
        else
            return j + tree.getData();
    }
    
    private int retardoMax(BinaryTree<Integer> tree){
        if(tree.isEmpty())
            return 0;
        int hi = 0, hd = 0;
        if(tree.hasLeftChild()){
            hi = retardoMax(tree.getLeftChild());
        }
        if(tree.hasRightChild()){
            hd = retardoMax(tree.getRightChild());
        }
        return maximo(tree, hi, hd);
    }
    
    public int retardoReenvio(){
        return retardoMax(this.tree);
    }
    
}
