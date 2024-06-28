/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parciales.GradoDeSeparacion;
import java.util.*;
import Practica1.EJ8.Queue;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class MainGradoDeSeparacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<String> g = new AdjListGraph<>();
        Vertex<String> v1 = g.createVertex("Mendoza");
        Vertex<String> v2 = g.createVertex("Tunuyán");
        Vertex<String> v3 = g.createVertex("San Martin");
        Vertex<String> v4 = g.createVertex("La Paz");
        Vertex<String> v5 = g.createVertex("Santa Rosa");
        Vertex<String> v7 = g.createVertex("Malargue");
        Vertex<String> v8 = g.createVertex("General Alvear");
        Vertex<String> v9 = g.createVertex("Trenquelauquen");
        Vertex<String> v10 = g.createVertex("General Lamiral");
        Vertex<String> v11 = g.createVertex("Fisher Alvear");
        
        
        g.connect(v1, v2);
        g.connect(v1, v3);
        g.connect(v1, v4);
        g.connect(v1, v5);
        g.connect(v2, v1);
        g.connect(v3, v1);
        g.connect(v4, v1);
        g.connect(v5, v1);
        g.connect(v2, v7);
        g.connect(v3, v7);
        g.connect(v7, v2);
        g.connect(v7, v3);
        g.connect(v3, v8);
        g.connect(v8, v3);
        g.connect(v4, v9);
        g.connect(v5, v9);
        g.connect(v9, v4);
        g.connect(v9, v5);
        g.connect(v9, v10);
        g.connect(v10, v9);
        g.connect(v10, v11);
        g.connect(v11, v10);
        
        System.out.println(GradoDeSeparacion.maximoGradoDeSeparacion(g));
        
        
        
        
    }
    
}
