/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ8;

/**
 *
 * @author franciscolima
 */
public class CircularQueue<T> extends Queue<T> {
    public T shift(){
        if(data.isEmpty()){
            return null;
        }
        else{
            T elem = dequeue();
            enqueue(elem);
            return elem;
        }
    }
}
