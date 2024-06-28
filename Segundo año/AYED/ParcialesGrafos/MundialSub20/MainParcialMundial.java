/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParcialesGrafos.MundialSub20;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class MainParcialMundial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph();
        Vertex v1 = grafo.createVertex("Estadio Diego Armando Maradona");
        Vertex v2 = grafo.createVertex("Legislatura");
        Vertex v3 = grafo.createVertex("Coliseo Podestá");
        Vertex v4 = grafo.createVertex("MACLA");
        Vertex v5 = grafo.createVertex("Catedral La Plata");
        Vertex v6 = grafo.createVertex("Palacio Campodónico");
        Vertex v7 = grafo.createVertex("Rectorado UNLP");
        Vertex v8 = grafo.createVertex("Museo UNLP");
        
        grafo.connect(v1, v2, 25);
        grafo.connect(v2, v1, 25);
        grafo.connect(v1, v3, 20);
        grafo.connect(v3, v1, 20);
        grafo.connect(v1, v4, 35);
        grafo.connect(v4, v1, 35);
        grafo.connect(v1, v5, 40);
        grafo.connect(v5, v1, 40);
        grafo.connect(v2, v3, 25);
        grafo.connect(v3, v2, 25);
        grafo.connect(v4, v5, 8);
        grafo.connect(v5, v4, 8);
        grafo.connect(v5, v7, 5);
        grafo.connect(v7, v5, 5);
        grafo.connect(v3, v6, 10);
        grafo.connect(v6, v3, 10);
        grafo.connect(v6, v7, 30);
        grafo.connect(v7, v6, 30);
        grafo.connect(v7, v8, 15);
        grafo.connect(v8, v7, 15);
        
        List<String> evitarPasarPor = new LinkedList<>();
        evitarPasarPor.add("Legislatura");
        evitarPasarPor.add("MACLA");
        
        
        List<Recorrido> lis = EJ.recorrerCiudad(grafo, evitarPasarPor, "Estadio Diego Armando Maradona", "Palacio Campodónico");
        
        for(Recorrido aux: lis) {
            System.out.println(aux.getCamino());
            System.out.println(aux.getTotal());
        }
    }
    }
