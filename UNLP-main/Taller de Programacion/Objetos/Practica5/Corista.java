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
public class Corista {
    private String nombre;
    private int dni;
    private int edad;
    private String tono;

    
    public Corista(String nom, int dni, int edad, String t){
        this.nombre = nom;
        this.dni = dni;
        this.edad = edad;
        this.tono = t;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {
        this.tono = tono;
    }
}
