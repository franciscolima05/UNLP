/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ1;
import java.util.*;
import java.math.*;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class GeneralTree <T> {
    T data;
    LinkedList<GeneralTree<T>> children;
    
    public GeneralTree(T data){
        this.data = data;
        this.children = new LinkedList<>();
    }
    
    public GeneralTree(T data, LinkedList<GeneralTree<T>> children){
        this.data = data;
        this.children = children;
    }
    
    public T getData(){
        return this.data;
    }
    
    public List<GeneralTree<T>> getChildren(){
        return this.children;
    }
    
    public boolean isLeaf(){
        return !this.hasChildren();
    }
    
    public void addChildren(GeneralTree<T> child){
        this.children.add(child);
    }
    
    public void removeChild(GeneralTree<T> child){
        this.children.remove(child);
    }
    
    public boolean hasChildren(){
        return !(this.children.isEmpty() || this.children == null);
    }
    
    public boolean isEmpty(){
        return this.data == null && !this.hasChildren();
    }
    
    public int altura(){
        if(this.isEmpty()){
            return 0;
        }
        else{
            return alturaHelper(this);
        }
    }
    
    private int alturaHelper(GeneralTree <T> a){
        if(a.isLeaf()){
            return 0;
        }
        
        int max = 0;
        for(GeneralTree<T> child : a.getChildren()){
            max = Math.max(max, alturaHelper(child));
        }
        
        return max + 1;
    }
    
    public int nivel(T dato){
        int cont = 0;
        int act;
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        while(!cola.isEmpty()){
            act = cola.size();
            for(int i = 0; i < act; ++i){
                aux = cola.dequeue();
                System.out.println("ELEMENTO: "+ aux.getData());
                if(aux.getData() == dato){
                    return cont;
                }
                else{
                    for(GeneralTree<T> child : aux.getChildren()){
                        cola.enqueue(child);
                    }
                }
            }
            System.out.println("NIVEL: " + cont);
            cont++;
        }
        return -1;
    }
    
    public int ancho(){
        int act;
        int i;
        int max = -1;
        int cont = 0;
        Queue<GeneralTree<T>> cola = new Queue<>();
        GeneralTree<T> aux;
        cola.enqueue(this);
        while(!cola.isEmpty()){
           act = cola.size();
           if(act > max){
               max = cont;
           }
           for(i = 0; i < act; ++i){
                aux = cola.dequeue();
                System.out.println("ELEMENTO: " + aux.getData());
                for(GeneralTree<T> child : aux.getChildren()){
                    cola.enqueue(child);
                }
           }
           System.out.println("NIVEL: "+ cont);
           cont++;//Cuenta una vez mas de lo necesario
        }
        return max;
    }
}