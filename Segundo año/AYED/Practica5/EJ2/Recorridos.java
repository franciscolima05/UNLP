/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ2;
import Practica5.ejercicio1.adjList.*;
import java.util.*;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class Recorridos<T> {
    public Recorridos(){
        
    }
    
    public List<T> dfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<>();
        for(int i = 0; i < grafo.getSize(); i++){
            if(!marca[i]){
                dfs(lis, i, grafo, marca);
            }
        }
        return lis;
    }
    
    private void dfs(List <T> lis, int i, Graph<T> grafo, boolean[] marca){
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lis.add(v.getData());
        System.out.println(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for(Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if(!marca[j]){
                dfs(lis, j, grafo, marca);
            }
        }
    }
    
    public List<T> bfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<>();
        for(int i = 0; i < grafo.getSize(); i++){
            if(!marca[i]){
                this.bfs(i, grafo, marca, lis);
            }
        }
        return lis;
    }
    
    private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> lis){
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while(!cola.isEmpty()){
            Vertex<T> aux = cola.dequeue();
            lis.add(aux.getData()); 
            List<Edge<T>> adyacentes = grafo.getEdges(aux);
            for(Edge<T> e : adyacentes){
                int j = e.getTarget().getPosition();
                if(!marca[j]){
                    marca[j] = true;
                    cola.enqueue(e.getTarget());
                }
            }
        }
    }
    
}
