/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ5;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
import Practica1.EJ8.Queue;
/**
 *
 * @author franciscolima
 */
public class EJ5 {
 
    
    private static void buscar2(Graph<Persona> grafo, int dni, Vertex<Persona> emp){
        for(Vertex<Persona> v : grafo.getVertices()){
            if(v.getData().getDni() == dni){
                emp = v;
            }
        }
    }
    
    private static Vertex<Persona> buscar(Graph<Persona> grafo, int dni){
        for(Vertex<Persona> v : grafo.getVertices()){
            if(v.getData().getDni() == dni){
                return v;
            }
        }
        return null;
    }
    
    public static List<Persona> pagarCobros(int dist, int dni, Graph<Persona> grafo){
        Vertex<Persona> emp = buscar(grafo, dni);
        System.out.println(emp);
        boolean[] marcas = new boolean[grafo.getSize()];
        List<Persona> lista = new LinkedList<>();
        int cont = 0;
        int tam;
        if(emp == null){
            return lista;
        }
        else{
            Queue<Vertex<Persona>> cola = new Queue<>();
            Vertex<Persona> aux;
            cola.enqueue(emp);
            while(!cola.isEmpty() && cont <= dist && lista.size() < 40){
                tam = cola.size();
                for(int i = 0; i < tam; i++){
                    aux = cola.dequeue();
                    System.out.println("DISTANCIA: " + cont + " PERSONA: " + aux.getData().getNombre());
                    marcas[aux.getPosition()] = true;
                    Persona p = aux.getData();
                    if(p.getClase() == "Jubilado" && !p.isCobro() && lista.size() < 40){
                        System.out.println("AGREGUE A LA LISTA A: " + p.getNombre());
                        lista.add(p);
                    }
                    List<Edge<Persona>> ady = grafo.getEdges(aux);
                    for(Edge<Persona> e : ady){
                        Vertex<Persona> v = e.getTarget();
                        System.out.println(v.getData().getNombre());
                        if(!marcas[v.getPosition()]){
                            cola.enqueue(v);
                        }
                    }
                }
                cont++;
            }
        }
        return lista;
    }
}
