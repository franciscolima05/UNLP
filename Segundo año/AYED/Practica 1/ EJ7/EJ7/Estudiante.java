/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ7;

/**
 *
 * @author franciscolima
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private String comision;
    //private String email;
    //private String direccion;

    public Estudiante(){
    this.nombre = "nada";
    this.apellido = "nada";
    this.comision =  "nada";
    //this.email = "nada";
    //this.direccion = "nada";
}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }


    
    
    
    public Estudiante(String nombre, String apellido, String comision) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
   
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getComision() {
        return comision;
    }

   @Override
   
   public String toString(){
       String cad = " | " + this.getNombre() + " | " + this.getApellido() + " | " + this.getComision() + " | ";
       return cad;
   }
}
