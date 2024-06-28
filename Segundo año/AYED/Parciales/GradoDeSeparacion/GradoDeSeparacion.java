/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.GradoDeSeparacion;
import java.util.*;
import Practica1.EJ8.Queue;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class GradoDeSeparacion {
    
    public static int maximoGradoDeSeparacion(Graph<String> grafo){
        int grado = -1;
        if(!grafo.isEmpty()){
            List<String> grados = new LinkedList<>();
            Queue<Vertex<String>> cola = new Queue<>();
            Vertex<String> aux;
            boolean[] marcas = new boolean[grafo.getSize()];
            int tam;
            cola.enqueue(grafo.getVertex(0));
            while(!cola.isEmpty()){
               tam = cola.size();
               System.out.println("NIVEL: " + grado);
               for(int i = 0; i< tam; i++){
                   aux = cola.dequeue();
                   System.out.println(aux.getData());
                   grados.add(aux.getData());
                   marcas[aux.getPosition()] = true;
                   for(Edge<String> e : grafo.getEdges(aux)){
                        if(!marcas[e.getTarget().getPosition()]){
                            cola.enqueue(e.getTarget());
                            marcas[e.getTarget().getPosition()] = true;
                        }
                   }
               }
               grado++;
            }
            System.out.println(grados);
            System.out.println("Size Grafo: " + grafo.getSize());
            System.out.println("Size Lista: " + grados.size());
            if(grados.size() == grafo.getSize() && grado <= 6){
                return grado;
            }
        }
        return -1;
    }
}
