/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.Parcial3Condicion;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class ParcialTripleCondicion {
    
    public static List<String> recorrido(Graph<String> grafo, int cantLocal, int cantNafta, List<String> restringidos){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<String> ini = grafo.search("Mendoza");
            boolean[] marcas = new boolean[grafo.getSize()];
            if(ini != null && cantLocal > 0){
                recorrido(grafo, ini, cantLocal, cantNafta, restringidos, camino, marcas);
            }
        }
        return camino;
    }
    
    private static  boolean recorrido(Graph<String> grafo, Vertex<String> ini, int localidades, int nafta, List<String> rest, List<String> camino, boolean[] marcas){
        boolean ok = false;
        camino.add(ini.getData());
        marcas[ini.getPosition()] = true;
        if(camino.size() == localidades){
            return true;
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(ini);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !ok){
                Edge<String> e = it.next();
                Vertex<String> v = e.getTarget();
                if(!rest.contains(v.getData()) && !marcas[v.getPosition()] && nafta >= e.getWeight()){
                    ok = recorrido(grafo, v, localidades, nafta - e.getWeight(), rest, camino, marcas);
                }
            }
        }
        if(!ok){
            camino.remove(camino.size() - 1);
            marcas[ini.getPosition()] = false;
        }
        return ok;
    }
}
