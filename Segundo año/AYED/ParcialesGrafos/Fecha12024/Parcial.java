/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialesGrafos.Fecha12024;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class Parcial {
    
    private static Vertex<Recinto> buscar(Graph<Recinto> grafo, String n){
        for(Vertex<Recinto> v : grafo.getVertices()){
            if(n.equals(v.getData().getNombre())){
                return v;
            }
        }
        return null;
    }
    
    public static int resolver(Graph<Recinto> sitios, int tiempo){
        List<String> max = new LinkedList<>();
        if(!sitios.isEmpty()){
            Vertex<Recinto> v = buscar(sitios, "Entrada");
            boolean[] marcas = new boolean[sitios.getSize()];
            resolver(sitios, marcas, max, new LinkedList<>(), v, tiempo);
        }
        System.out.println(max);
        return max.size();
    }
    
    private static void resolver(Graph<Recinto> grafo, boolean[] marcas, List<String> max, List<String> caminoAct, Vertex<Recinto> ini, int tiempo){
        caminoAct.add(ini.getData().getNombre());
        tiempo -= ini.getData().getTiempo();
        marcas[ini.getPosition()] = true;
        for(Edge<Recinto> e : grafo.getEdges(ini)){
            if(!marcas[e.getTarget().getPosition()] && (tiempo - e.getWeight() - e.getTarget().getData().getTiempo()) >= 0){
                resolver(grafo, marcas, max, caminoAct, e.getTarget(), tiempo - e.getWeight());
            }
        }
        if(caminoAct.size() > max.size()){
            max.clear();
            max.addAll(caminoAct);
        }
        caminoAct.remove(caminoAct.size() - 1);
        marcas[ini.getPosition()] = false;
    }
    
}
