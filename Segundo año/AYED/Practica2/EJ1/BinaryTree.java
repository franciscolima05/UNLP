/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ1;

import java.util.*;
import Practica1.EJ8.Queue;
public class BinaryTree <T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    
    public BinaryTree(){
        super();
    }
    
    public BinaryTree(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public BinaryTree<T> getLeftChild(){
        return leftChild;
    }
    
    public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}
        
	public boolean hasLeftChild() {
		return this.leftChild!=null;
        }
        
        public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

        
        public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
        
        public int contarHojas(){
            int i = 0;
            int j = 0;
            if(this.isEmpty()) return 0;
            else{
                if(this.isLeaf()) return 1;
                else{
                    if(this.hasLeftChild())
                        i = this.getLeftChild().contarHojas();
                    if(this.hasRightChild())
                        j = this.getRightChild().contarHojas();
                    return i + j;
                }   
            }                    
        }
        
        public BinaryTree<T> espejo(){
            BinaryTree<T> arbEsp = new BinaryTree<>();
            
            if(this.hasLeftChild())
                arbEsp.addRightChild(this.getLeftChild().espejo());
            if(this.hasRightChild())
                arbEsp.addLeftChild(this.getLeftChild().espejo());
            return arbEsp;
        }
        
        public void entreNiveles(int n, int m){
           Queue<BinaryTree> cola = new Queue<>();
           int i = 0;
           BinaryTree aux;
           cola.enqueue(this);
           while(!cola.isEmpty() && (i < m)){
               aux = cola.dequeue();
               System.out.println(aux);
               if(this.hasLeftChild())
                   cola.enqueue(this.getLeftChild());
               if(this.hasRightChild())
                   cola.enqueue(this.getRightChild());
               i++;
           }
        }
    }
