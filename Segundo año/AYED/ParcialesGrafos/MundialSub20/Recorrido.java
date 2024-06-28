/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialesGrafos.MundialSub20;
import java.util.*;
import Practica5.ejercicio1.adjList.*;
/**
 *
 * @author franciscolima
 */
public class Recorrido {
    int total;
    LinkedList<String> camino;

    
    public Recorrido(Recorrido R){
        this.camino = new LinkedList(R.getCamino());
        this.total = R.getTotal();
    }
    
    public Recorrido(){
        this.total = 0;
        this.camino = new LinkedList<>();
    }
    
    public Recorrido(int total, LinkedList<String> camino) {
        this.total = total;
        this.camino = camino;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LinkedList<String> getCamino() {
        return camino;
    }

    public void setCamino(LinkedList<String> camino) {
        this.camino = camino;
    }
    
    
    
}
