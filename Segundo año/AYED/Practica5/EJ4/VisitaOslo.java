/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ4;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class VisitaOslo {
    
    
    public static List<String> paseoEnBici(Graph<String> grafo, String destino, int maxTiempo, List<String> lugaresRestringidos, String inicio){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<String> ini = grafo.search(inicio);
            Vertex<String> des = grafo.search(destino);
            boolean[] marcas = new boolean [grafo.getSize()];
            if(ini != null && des != null && (!lugaresRestringidos.contains(ini.getData()) && !lugaresRestringidos.contains(des.getData()))){
                paseoEnBici(grafo, ini, des, lugaresRestringidos, maxTiempo, camino, marcas);
            }
        }
        return camino;
    }
    
    private static boolean paseoEnBici(Graph<String> grafo, Vertex<String> inicio, Vertex<String> des, List<String> lugaresRes, int maxT, List<String> camino, boolean[] marcas){
        boolean ok = false;
        if(lugaresRes.contains(inicio.getData())){
            return false;
        }
        else{
            marcas[inicio.getPosition()] = true;
            camino.add(inicio.getData());
            if(inicio == des){
                return true;
            }
            else{
                List<Edge<String>> ady = grafo.getEdges(inicio);
                Iterator<Edge<String>> it = ady.iterator();
                while(it.hasNext() && !ok){
                    Edge<String> e = it.next();
                    System.out.println("ACTUAL: " + e.getTarget().getData());
                    if(!marcas[e.getTarget().getPosition()]){
                        if(maxT - e.getWeight() >= 0){
                            System.out.println();
                            System.out.println("ME QUEDE CON: " +  e.getTarget().getData());
                            System.out.println();
                            ok = paseoEnBici(grafo, e.getTarget(), des, lugaresRes, maxT - e.getWeight(), camino, marcas);
                        }
                    }
                }
            }
        }
        if(!ok){
            camino.remove(camino.size() -1);
        }
        marcas[inicio.getPosition()] = false;
        return ok;
    }
}
