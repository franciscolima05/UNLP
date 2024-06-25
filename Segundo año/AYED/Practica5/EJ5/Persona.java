/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5.EJ5;

/**
 *
 * @author franciscolima
 */
public class Persona {
    String clase;
    String nombre;
    boolean cobro;
    int dni;
    
    public Persona(String C, String nom, int i,  boolean ok){
        this.clase = C;
        this.nombre = nom;
        this.cobro = ok;
        this.dni = i;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public boolean isCobro() {
        return cobro;
    }

    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    
}
