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
public class Paciente {
    private String nombre;
    private boolean tieneObra;
    private double costo;

    
    public Paciente(String nom, boolean to, double cos){
        this.nombre = nom;
        this.tieneObra = to;
        this.costo = cos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public boolean isTieneObra() {
        return tieneObra;
    }

    public double getCosto() {
        return costo;
    }
@Override
    public String toString(){
        String aux = this.nombre + "  " + this.costo + "  " + this.tieneObra;
        return aux;
    }
    
    
}
