/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ8;
import java.util.*;


public class Queue <T>{
    protected List<T> data;
    
    public Queue(){
       this.data = new ArrayList<>();
    }
    
    public void enqueue(T dato){
        data.addLast(dato);
    }
    
    public T dequeue(){
        return data.remove(0);
    }
    
    public T head(){
        return data.get(0);
    }
    
    public boolean isEmpty(){
        return data.size() == 0;
    }
    
    public int size(){
        return data.size();
    }
    @Override
   public String toString() {
      String str = "[";
      for(T d: data)
           str = str + d +", ";
      str = str.substring(0, str.length()-2)+"]";
      return str;
    } 
}
    
    
    
    

