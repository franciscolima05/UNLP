/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5;

/**
 *
 * @author Francisco
 */
public class Coros {
    private String nombre;
    private Director dir;
    private Corista [] serie;
    private int cantCoristas;

    
    public Coros(String nomD, int DF){
        this.nombre = nomD;
        this.serie = new Corista[DF];
    }
    
    public int getCantCoristas(){
        return this.cantCoristas;
    }
    
    public Director getDir() {
        return dir;
    }

    public void setDir(Director dir) {
        this.dir = dir;
    }
    
    public Corista[] getSerie(){
        return serie;
    }
    
}
