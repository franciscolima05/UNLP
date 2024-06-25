/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5.EJ5;
import Practica5.ejercicio1.adjList.*;
import java.util.List;
/**
 *
 * @author franciscolima
 */
public class MainEJ5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona("Empleado", "Matias", 111, true));
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", 222, false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", 333, false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin", 444, true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar", 555, true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", 666, true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", 777, false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", 888, true));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", 999, false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        List<Persona> lista = EJ5.pagarCobros(3, 111, grafo);
        for(Persona p : lista){
            System.out.println("DNI: " + p.getDni() + " NOMBRE: " + p.getNombre());
        }
    }
    
}
