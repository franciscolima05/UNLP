/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5.EJ3;
import Practica5.ejercicio1.adjList.*;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class MainEJ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        MapaCiudades mapa = new MapaCiudades(mapaCiudades);
        
        List<String> lista = mapa.devolverCamino("La Plata", "San Vicente");
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(lista);
        System.out.println("");
        //LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:[La Plata, Ensenada, Florencio Varela, Berazategui, Presidente Peron, San Vicente]
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        List<String> lista2 = mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos);
        System.out.println("Camino exceptuando lugares: " + lista2);
        
        
        List<String> listaCaminoCorto = mapa.caminoMasCorto("La Plata", "San Vicente");
        System.out.println("Camino Corto: " + listaCaminoCorto);
        //LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): [La Plata, Berisso, Florencio Varela, San Vicente]
    
    
        List<String> listaSinCargar = mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 30);
        System.out.println("Camino sin cargar combustible: " + listaSinCargar);
        //LISTA CAMINO SIN CARGAR COMBUSTIBLE: [La Plata, Ensenada, Florencio Varela, San Vicente]
    
    
        List<String> listaMenosCargas = mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 10);
        System.out.println("Camino Cargando La menor cantidad de veces: " + listaMenosCargas);
        //LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: [La Plata, Berisso, Florencio Varela, San Vicente]
        
    }
    
}
