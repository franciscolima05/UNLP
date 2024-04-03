/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ3;

import java.util.*;
import Practica2.EJ1.BinaryTree;
public class ContadorArbol {
    private BinaryTree<Integer> tree = new BinaryTree<>(0);

    public ContadorArbol(int i){
        this.tree.setData(i);
    }
    
    
    public BinaryTree<Integer> getTree() {
        return tree;
    }
    
    private void listaPares(BinaryTree<Integer> tree, LinkedList<Integer> list){
        if(tree.getData() % 2 == 0){
            list.add(tree.getData());
        }
        if(tree.hasLeftChild()){
            listaPares(tree.getLeftChild(), list);
        }
        if(tree.hasRightChild()){
            listaPares(tree.getRightChild(), list);
        }
    }
    
    private void listaParesInOrder(BinaryTree<Integer> tree, LinkedList<Integer> list){
        if(tree.hasLeftChild()){
            listaParesInOrder(tree.getLeftChild(), list);
        }
        if(tree.getData() % 2 == 0)
            list.add(tree.getData());
        if(tree.hasRightChild()){
            listaParesInOrder(tree.getRightChild(), list);
        }
    }
    
    public LinkedList<Integer> numerosParesInOrder(){
        LinkedList<Integer> list = new LinkedList<>();
        listaParesInOrder(this.getTree(), list);
        return list;
        }
    
    public LinkedList<Integer> numerosPares(){
        LinkedList<Integer> list = new LinkedList<>();
        listaPares(this.getTree(), list);
        return list;
        }
    

    private void listaParesPostOrden(BinaryTree<Integer> tree, LinkedList<Integer> list){
        if(tree.hasLeftChild()){
            listaParesPostOrden(tree.getLeftChild(), list);
        }
        if(tree.hasRightChild()){
            listaParesPostOrden(tree.getRightChild(), list);
        }
        if(tree.getData() % 2 == 0){
            list.add(tree.getData());
        }
    }
    
    public LinkedList<Integer> numeroParesPostOrder(){
        LinkedList<Integer> list = new LinkedList<>();
        listaParesPostOrden(this.tree, list);
        return list;
    }
}