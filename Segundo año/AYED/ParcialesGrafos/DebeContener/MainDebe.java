/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParcialesGrafos.DebeContener;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class MainDebe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();
        Vertex<String> Suipacha = grafo.createVertex("Suipacha");
        Vertex<String> CarlosKeen = grafo.createVertex("Carlos Keen");
        Vertex<String> Navarro = grafo.createVertex("Navarro");
        Vertex<String> Saladillo = grafo.createVertex("Saladillo");
        Vertex<String> Lobos = grafo.createVertex("Lobos");
        Vertex<String> Canuelas = grafo.createVertex("Cañuelas");
        Vertex<String> Abasto = grafo.createVertex("Abasto");
        Vertex<String> LaPlata = grafo.createVertex("La Plata");
        Vertex<String> Pinamar = grafo.createVertex("Pinamar");
        Vertex<String> Quilmes = grafo.createVertex("Quilmes");
        Vertex<String> Moreno = grafo.createVertex("Moreno");
        
        grafo.connect(Suipacha, CarlosKeen);
        grafo.connect(CarlosKeen, Suipacha);
        grafo.connect(CarlosKeen, Moreno);
        grafo.connect(Moreno, CarlosKeen);
        grafo.connect(Suipacha, Navarro);
        grafo.connect(Navarro, Suipacha);
        grafo.connect(Moreno, Quilmes);
        grafo.connect(Quilmes, Moreno);
        grafo.connect(Quilmes, LaPlata);
        grafo.connect(LaPlata, Quilmes);
        grafo.connect(LaPlata, Pinamar);
        grafo.connect(Pinamar, LaPlata);
        grafo.connect(LaPlata, Abasto);
        grafo.connect(Abasto, LaPlata);
        grafo.connect(Moreno, Abasto);
        grafo.connect(Abasto, Moreno);
        grafo.connect(Canuelas, Abasto);
        grafo.connect(Abasto, Canuelas);
        grafo.connect(Navarro, Canuelas);
        grafo.connect(Canuelas, Navarro);
        grafo.connect(Navarro, Saladillo);
        grafo.connect(Saladillo, Navarro);
        grafo.connect(Navarro, Lobos);
        grafo.connect(Lobos, Navarro);

        List<String> pasar = new LinkedList<>();
        pasar.add("La Plata");
        pasar.add("Navarro");
        List<String> lis = Parcial.resolver(grafo, pasar, "Saladillo", "Pinamar");
        System.out.println(lis);
    }
    
}
