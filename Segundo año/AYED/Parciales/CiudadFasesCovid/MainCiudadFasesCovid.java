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
public class MainCiudadFasesCovid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad(5, "Suipacha"));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad(3, "Carlos Keen"));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad(1, "Moreno"));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad(1, "Quilmes"));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad(4, "Navarro"));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad(3, "Cañuelas"));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad(2, "Abasto"));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad(2, "La Plata"));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        
        List<String> lista = CiudadFasesCovid.resolver(grafo, "Carlos Keen", "La Plata");
        System.out.println(lista);
    }
    
}
