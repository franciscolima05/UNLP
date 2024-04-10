/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ6;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class Transformacion {
    private BinaryTree<Integer> tree;
    
    public Transformacion(int i){
        tree = new BinaryTree(i);
    }
    
    private int sumaHelper(BinaryTree<Integer> arb){
        int suma = 0;
        if(arb.isLeaf()){
            suma = arb.getData();
            arb.setData(0);
            return suma;
        }
        if(arb.hasLeftChild()){
            suma += sumaHelper(arb.getLeftChild());
        }
        if(arb.hasRightChild()){
            suma += sumaHelper(arb.getRightChild());
        }
        int act = arb.getData();
        arb.setData(suma);
        return suma + act;
    }
    
    public BinaryTree<Integer> suma(){
        sumaHelper(this.tree);
        return this.tree;
    }

    public BinaryTree<Integer> getTree() {
        return tree;
    }
}
