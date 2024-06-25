/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ6;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class CaperusitaRoja {
    Graph<String> bosque;
    
    public CaperusitaRoja(Graph<String> a){
        this.bosque = a;
    }
    
    
    public List<List<String>> recorridosMasSeguros(){
        List<List<String>> caminos = new LinkedList<>();
        if(!this.bosque.isEmpty()){
            Vertex<String> casaC = bosque.search("Casa Caperucita");
            Vertex<String> casaA = bosque.search("Casa Abuelita");
            boolean[] marcas = new boolean[bosque.getSize()];
            recorridosMasSeguros(this.bosque, marcas, caminos, new LinkedList<>(), casaA, casaC);
        }
        return caminos;
    }
    
    private void recorridosMasSeguros(Graph<String> bosque, boolean[] marcas, List<List<String>> caminosSeguros, List<String>caminoAct, Vertex<String> abuela, Vertex<String> cap){
        caminoAct.add(cap.getData());
         marcas[cap.getPosition()] = true;
        if(cap == abuela){
            caminosSeguros.add(new LinkedList<>(caminoAct));
        }
        else{
            List<Edge<String>> ady = bosque.getEdges(cap);
            for(Edge<String> e : ady){
                if(e.getWeight() < 5 && !marcas[e.getTarget().getPosition()]){
                    recorridosMasSeguros(bosque, marcas, caminosSeguros, caminoAct, abuela, e.getTarget());
                }
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        marcas[cap.getPosition()] = false;
    }
}
