package Practica5.ejercicio1.adjMatrix;

import Practica5.ejercicio1.adjList.Edge;
import Practica5.ejercicio1.adjList.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {
	private Vertex<T> target;
	private int weight;
	
	/**
	 * Constructor de las aristas.  Solo se crean desde el grafo.
	 */
	AdjMatrixEdge(Vertex<T> target, int weight){
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public Vertex<T> getTarget() {
		return target;
	}

	@Override
	public int getWeight() {
		return weight;
	}
}
