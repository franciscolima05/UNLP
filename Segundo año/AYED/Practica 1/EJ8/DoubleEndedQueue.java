/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ8;

/**
 *
 * @author franciscolima
 */
public class DoubleEndedQueue<T> extends Queue<T>{
    
    public void enqueueFirst(T elem){
        this.data.add(0, elem);
    }
}
