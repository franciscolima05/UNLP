/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.CiudadFasesCovid;

import Practica5.ejercicio1.adjList.Vertex;

/**
 *
 * @author franciscolima
 */
public class Buscador {
    Vertex<Ciudad> origen;
    Vertex<Ciudad> destino;
    
    public Buscador(Vertex<Ciudad> o, Vertex<Ciudad> d){
        this.origen = o;
        this.destino = d;
    }
    
    public Buscador(){
        this.origen = null;
        this.destino = null;
    }
    
    public Vertex<Ciudad> getOrigen(){
        return this.origen;
    }
    
    public Vertex<Ciudad> getDestino(){
        return this.destino;
    }
    
    public void setDestino(Vertex<Ciudad> i){
        this.destino = i;
    }
    
    public void setOrigen(Vertex<Ciudad> o){
        this.origen = o;
    }
}
