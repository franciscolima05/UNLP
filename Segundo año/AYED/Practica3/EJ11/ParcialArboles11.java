/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ11;
import Practica3.EJ1.GeneralTree;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class ParcialArboles11 {
    
    public static boolean resolver(GeneralTree<Integer> tree){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        int act = 1;
        int ant = 0;
        cola.enqueue(tree);
        while(!cola.isEmpty()){
            if(act != ant + 1){
                return false;
            }
            else{
                for(int i = 0;i< act ; i++){
                    aux = cola.dequeue();
                    for(GeneralTree<Integer> child : aux.getChildren()){
                        cola.enqueue(child);
                    }
                }
            }
            ant = act;
            act = cola.size();
        }
        return true;
    }
}