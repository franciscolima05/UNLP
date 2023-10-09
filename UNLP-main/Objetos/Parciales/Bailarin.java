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
public class Bailarin {
    private int dni;
    private String nombre;
    private int edad;

    public Bailarin(int dni, String nom, int edad){
        this.dni = dni;
        this.edad = edad;
        this.nombre = nom;
    }
    
    
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
@Override
    public String toString(){
        String aux = this.nombre + "  " + this.dni + "  " + this.edad;
        return aux;
    }
    
}
