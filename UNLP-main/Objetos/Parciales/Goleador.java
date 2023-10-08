/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

/**
 *
 * @author Francisco
 */
public class Goleador {
    private String nombre;
    private String nombreEquipo;
    private int cantGoles;

    public Goleador(String nom, String nombreE, int num){
        this.nombre = nom;
        this.cantGoles = num;
        this.nombreEquipo = nombreE;
    }
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getCantGoles() {
        return cantGoles;
    }
@Override
    public String toString(){
        String aux = this.nombre + " " + this.nombreEquipo + " " + this.cantGoles + " | ";
        return aux;
    }
}
