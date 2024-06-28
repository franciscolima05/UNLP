/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parciales.CiudadFasesCovid;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class CiudadFasesCovid {

   private static Buscador buscar(Graph<Ciudad> grafo, String o, String d){
       Buscador b = new Buscador();
       boolean ok1 = false;
       boolean ok2 = false;
       Iterator<Vertex<Ciudad>> it = grafo.getVertices().iterator();
       while(it.hasNext() && !(ok1 && ok2)){
           Vertex<Ciudad> v = it.next();
           if(v.getData().getNombre().equals(o)){
               ok1 = true;
               b.setOrigen(v);
           }
           if(v.getData().getNombre().equals(d)){
               ok2 = true;
               b.setDestino(v);
           }
       }
       return b;
   }
   
   public static List<String> resolver(Graph<Ciudad> grafo, String origen, String destino){
       List<String> camino = new LinkedList();
       if(!grafo.isEmpty()){
           Buscador b = buscar(grafo, origen, destino);
           boolean[] marcas = new boolean[grafo.getSize()];
           if(b.getDestino() != null && b.getOrigen() != null){
               if(b.getDestino().getData().getFase() != 1 && b.getOrigen().getData().getFase() != 1){
                   resolver(grafo, b.getOrigen(), b.getDestino(), camino, marcas);
               }
           }
       }
       return camino;
   }
   
   private static boolean resolver(Graph<Ciudad> grafo, Vertex<Ciudad> ini, Vertex<Ciudad> des, List<String> camino, boolean[] marcas){
       camino.add(ini.getData().getNombre());
       boolean ok = false;
       marcas[ini.getPosition()] = true;
       if(ini == des){
           return true;
       }
       else{
           List<Edge<Ciudad>> ady = grafo.getEdges(ini);
           Iterator<Edge<Ciudad>> it = ady.iterator();
           while(it.hasNext() && !ok){
               Vertex<Ciudad> v = it.next().getTarget();
               if(v.getData().getFase() > 1 && !marcas[v.getPosition()]){
                   ok = resolver(grafo, v, des, camino, marcas);
               }
           }
       }
       if(!ok){
           camino.remove(camino.size() -1);
           marcas[ini.getPosition()] = false;
       }
       return ok;
   }
    
}
