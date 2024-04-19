/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ4;
import Practica3.EJ1.GeneralTree;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class AnalizadorArbol {
    
    
    public static double devolverMaximoPromedio(GeneralTree<AreaEmpresa> a){
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        int act;
        double promAct;
        double promMax = -1.0;
        int sum = 0;
        GeneralTree<AreaEmpresa> aux;
        cola.enqueue(a);
        while(!cola.isEmpty()){
            sum = 0;
            act = cola.size();
            System.out.println("TAMAÑO COLA: " + act);
            for(int i = 0; i< act; ++i){
                aux = cola.dequeue();
                System.out.println("ELEMENTO: " + aux.getData().getTime());
                sum += aux.getData().getTime();
                for(GeneralTree<AreaEmpresa> child : aux.getChildren()){
                    cola.enqueue(child);
                }
            }
            promAct = sum / act;
            System.out.println("PROMEDIO ACTUAL: " + promAct);
            if(promAct > promMax)
                promMax = promAct;
        }
        return promMax;
    }
    
}
