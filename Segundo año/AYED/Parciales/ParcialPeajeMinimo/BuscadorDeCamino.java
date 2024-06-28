/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.ParcialPeajeMinimo;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class BuscadorDeCamino {
    private static Buscador buscar(Graph<String> grafo, String o, String d){
        Buscador b = new Buscador();
        List<Vertex<String>> vert = grafo.getVertices();
        Iterator<Vertex<String>> it = vert.iterator();
        boolean ok1 = false;
        boolean ok2 = false;
        while(it.hasNext() && !(ok1 && ok2)){
            Vertex<String> v = it.next();
            if(v.getData().equals(o)){
                ok1 = true;
                b.setOrigen(v);
            }
            if(v.getData().equals(d)){
                ok2 = true;
                b.setDestino(v);
            }
        }
        return b;
    }
    
    public static List<String> resolver(Graph<String> grafo, String o, String d, int monto){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            Buscador b = buscar(grafo, o, d);
            if(b.getDestino() != null && b.getOrigen() != null){
                boolean[] marcas = new boolean[grafo.getSize()];
                resolver(grafo, b.getDestino(), b.getOrigen(), monto, camino, marcas, 0);
            }
        }
        return camino;
    }
    
    private static boolean resolver(Graph<String> grafo, Vertex<String> des, Vertex<String> ini, int monto, List<String> camino, boolean[] marcas, int actual){
        camino.add(ini.getData());
        boolean ok = false;
        marcas[ini.getPosition()] = true;
        if(ini == des && monto < actual){
            return true;
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(ini);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !ok){
                Edge<String> e = it.next();
                if(!marcas[e.getTarget().getPosition()]){
                    ok = resolver(grafo, des, e.getTarget(), monto, camino, marcas, actual + e.getWeight());
                }
            }
        }
        if(!ok) camino.remove(camino.size() -1);
        marcas[ini.getPosition()] = false;
        return ok;
    }
}
