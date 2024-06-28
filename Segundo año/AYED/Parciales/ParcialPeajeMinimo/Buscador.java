/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.ParcialPeajeMinimo;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class Buscador {
    Vertex<String> origen;
    Vertex<String> destino;
    
    public Buscador(Vertex<String> o, Vertex<String> d){
        this.origen = o;
        this.destino = d;
    }
    
    public Buscador(){
        this.origen = null;
        this.destino = null;
    }
    
    public Vertex<String> getOrigen(){
        return this.origen;
    }
    
    public Vertex<String> getDestino(){
        return this.destino;
    }
    
    public void setDestino(Vertex<String> i){
        this.destino = i;
    }
    
    public void setOrigen(Vertex<String> o){
        this.origen = o;
    }
}
