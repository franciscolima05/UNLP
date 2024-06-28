/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialesGrafos.DebeContener;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class Parcial {
    
    public static List<String> resolver(Graph<String> grafo, List<String> pasando, String destino, String origen){
        List<String> res = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<String> ini = grafo.search(origen);
            Vertex<String> des = grafo.search(destino);
            boolean[] marcas = new boolean[grafo.getSize()];
            if(ini != null && des != null){
                resolver(grafo, ini, des, pasando, marcas, res);
            }
        }
        return res;
    }
    
    private static boolean resolver(Graph<String> grafo, Vertex<String> ini, Vertex<String> des, List<String> pasando, boolean[] marcas, List<String> res){
        boolean ok = false;
        res.add(ini.getData());
        System.out.println(res);
        marcas[ini.getPosition()] = true;
        if(ini == des){
            return true;
        }
        else{
            boolean estaba = false;
            List<Edge<String>> ady = grafo.getEdges(ini);
            for(Edge<String> e : ady){
                if(pasando.contains(e.getTarget().getData())){
                    estaba = true;
                    if(!marcas[e.getTarget().getPosition()]){
                        ok = resolver(grafo, e.getTarget(), des, pasando, marcas, res);
                    }
                }
            }
            if(!estaba){
                Iterator<Edge<String>> it = ady.iterator();
                while(it.hasNext() && !ok){
                    Vertex<String> v = it.next().getTarget();
                    if(!marcas[v.getPosition()]){
                        ok = resolver(grafo, v, des, pasando, marcas, res);
                    }
                }
            }
        }
        if(!ok){
            res.remove(res.size() -1);
            marcas[ini.getPosition()] = false;
        }
        return ok;
    }
}
