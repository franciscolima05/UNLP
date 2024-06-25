/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ3;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class MapaCiudades {
    Graph<String> grafo;
    
    
    public MapaCiudades(Graph<String> gr){
        this.grafo = gr;
    }
    
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> lis = new LinkedList<>();
        if(!this.grafo.isEmpty()){
            Vertex<String> inicio = this.grafo.search(ciudad1);
            Vertex<String> destino = this.grafo.search(ciudad2);
            boolean[] marca = new boolean[grafo.getSize()];
            if(inicio != null && destino != null){
                devolverCaminoH(inicio, this.grafo, marca, destino, lis);
            }
        }
        return lis;
    }
    
    private boolean devolverCaminoH(Vertex<String> inicio, Graph<String> grafo, boolean[] marca, Vertex<String> destino, List<String> camino){
        boolean ok = false;
        camino.add(inicio.getData());
        marca[inicio.getPosition()] = true;
        if(inicio == destino){
            return true;
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(inicio);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !ok){
                Vertex<String> ver = it.next().getTarget();
                int j = ver.getPosition();
                if(!marca[j]){
                    ok = devolverCaminoH(ver, grafo, marca, destino, camino);
                }
            }
        }
        if(!ok){
            camino.remove(camino.size() -1);
        }
        marca[inicio.getPosition()] = false;
        return ok;
    }
    
    
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new LinkedList<>();
        if(!this.grafo.isEmpty()){
            Vertex<String> inicio = this.grafo.search(ciudad1);
            Vertex<String> destino = this.grafo.search(ciudad2);
            boolean[] marca = new boolean[this.grafo.getSize()];
            if(inicio != null && destino != null){  
                if(!ciudades.contains(inicio.getData()) && !ciudades.contains(destino.getData())){
                    devolverCaminoExceptuando(inicio, destino, this.grafo, ciudades, camino, marca);
                }
            }
        }
        return camino;
    }
    
    private boolean devolverCaminoExceptuando(Vertex<String> inicio, Vertex<String> destino, Graph<String> grafo, List<String> ciudades, List<String> camino, boolean[] marca){
        boolean ok = false;
        String ciu = inicio.getData();
        if(ciudades.contains(ciu)){
           return false;
        }
        else{
            camino.add(ciu);
            marca[inicio.getPosition()] = true;
            if(inicio == destino){
                return true;
            }
            else{
                List<Edge<String>> ady = grafo.getEdges(inicio);
                Iterator<Edge<String>> it = ady.iterator();
                while(it.hasNext() && !ok){
                    Vertex<String> v = it.next().getTarget();
                    if(!marca[v.getPosition()]){
                        ok = devolverCaminoExceptuando(v, destino, grafo, ciudades, camino, marca);
                    }
                }
            }
            if(!ok){
                camino.remove(camino.size() - 1);
            }
            marca[inicio.getPosition()] = false;
        }
        return ok;
    }
    
    
    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<>();
        if(!this.grafo.isEmpty()){
            boolean[] marcas = new boolean[grafo.getSize()];
            Vertex<String> inicio = grafo.search(ciudad1);
            Vertex<String> destino = grafo.search(ciudad2);
            caminoMasCorto(inicio, destino, camino, marcas, grafo, new LinkedList<>());
        }
        return camino;
    }
    
    private void caminoMasCorto(Vertex<String> inicio, Vertex<String> destino, List<String> camino, boolean[] marcas, Graph<String> grafo, LinkedList listAct){
        listAct.add(inicio.getData());
        marcas[inicio.getPosition()] = true;
        if(inicio == destino){
            if(listAct.size() < camino.size() | camino.isEmpty()){
                camino.clear();
                camino.addAll(listAct);
            }
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(inicio);
            for(Edge<String> e : ady){
                if(!marcas[e.getTarget().getPosition()]){
                   caminoMasCorto(e.getTarget(), destino, camino, marcas, grafo, listAct);
                }
            }
        }
        listAct.remove(listAct.size() - 1);
        marcas[inicio.getPosition()] = false;
    }
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            boolean marcas[] = new boolean[grafo.getSize()];
            Vertex<String> inicio = grafo.search(ciudad1);
            Vertex<String> destino = grafo.search(ciudad2);
            caminoSinCargarCombustible(inicio, destino, grafo, tanque, marcas, camino);
        }
        return camino;
    }
    
    private boolean caminoSinCargarCombustible(Vertex<String> inicio, Vertex<String> destino, Graph<String> grafo, int tanque, boolean[] marcas, List<String> camino){
        boolean ok = false;
        camino.add(inicio.getData());
        marcas[inicio.getPosition()] = true;
        if(inicio == destino){
            return true;
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(inicio);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !ok){
                Edge<String> dist = it.next();
                if(tanque - dist.getWeight() > 0){
                    Vertex<String> v = dist.getTarget();
                    if(!marcas[v.getPosition()]){
                        ok = caminoSinCargarCombustible(v, destino, grafo, (tanque - dist.getWeight()), marcas, camino);
                    }
                }
            }
            if(!ok){
                camino.remove(camino.size() - 1);
            }
            marcas[inicio.getPosition()] = false;
        }
        return ok;
    }
    
    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanque){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            boolean marcas[] = new boolean[grafo.getSize()];
            Vertex<String> inicio = grafo.search(ciudad1);
            Vertex<String> destino = grafo.search(ciudad2);
            caminoConMenorCargaDeCombustible(inicio, destino, grafo, tanque, marcas, camino, new LinkedList() ,  0, 999, tanque);
        }
        return camino;
    }
    
    private int caminoConMenorCargaDeCombustible(Vertex<String> inicio, Vertex<String> destino, Graph<String> grafo, int tanque, boolean[] marcas, List<String> camino, List<String> caminoAct,  int cargasAct, int cargas, int max){
        caminoAct.add(inicio.getData());
        marcas[inicio.getPosition()] = true;
        if(inicio == destino){
            if(cargasAct < cargas){
                System.out.println("ACTUALES: " +cargasAct);
                System.out.println("Minimas: " +cargas);
                cargas = cargasAct;
                camino.clear();
                camino.addAll(caminoAct);
            }
        }
        else{
            List<Edge<String>> ady = grafo.getEdges(inicio);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && cargasAct < cargas){
                Edge<String> e = it.next();
                if(!marcas[e.getTarget().getPosition()]){
                    if(tanque - e.getWeight() <= 0){
                        tanque = max;
                        cargasAct++;
                    }
                    cargas = caminoConMenorCargaDeCombustible(e.getTarget(), destino, grafo, tanque - e.getWeight(), marcas, camino, caminoAct, cargasAct, cargas, max);
                }
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        marcas[inicio.getPosition()] = false;
        return cargas;
    }
    
}

