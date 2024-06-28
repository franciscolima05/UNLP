/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialesGrafos.MundialSub20;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class EJ {
    
    public static List<Recorrido> recorrerCiudad(Graph<String> ciudad, List<String> restringidos, String inicio, String destino){
        List<Recorrido> caminos = new LinkedList<>();
        if(!ciudad.isEmpty()){
            Vertex<String> ini = ciudad.search(inicio);
            Vertex<String> des = ciudad.search(destino);
            boolean[] marcas = new boolean[ciudad.getSize()];
            recorrerCiudad(ciudad, restringidos, ini, des, caminos, new Recorrido(), 0, marcas);
        }
        return caminos;
    }
    
    private static void recorrerCiudad(Graph<String> ciudad, List<String> restringidos, Vertex<String> ini, Vertex<String> des, List<Recorrido> caminos, Recorrido recAct, int tiempo, boolean[] marcas){
        if(!restringidos.contains(ini.getData())){
            recAct.setTotal(recAct.getTotal() + tiempo);
            recAct.getCamino().add(ini.getData());
            marcas[ini.getPosition()] = true;
            if(ini == des){
                caminos.add(new Recorrido(recAct));
                recAct.setTotal(0);
            }
            else{
                List<Edge<String>> ady = ciudad.getEdges(ini);
                for(Edge<String> e : ady){
                    Vertex<String> v = e.getTarget();
                    if(!marcas[v.getPosition()]){
                        recorrerCiudad(ciudad, restringidos, v, des, caminos, recAct, e.getWeight(), marcas);
                    }
                }
            }
            recAct.getCamino().remove(recAct.getCamino().size() - 1);
            marcas[ini.getPosition()] = false;
        }
    }
}
