/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.CiudadFasesCovid;

/**
 *
 * @author franciscolima
 */
public class Ciudad {
    int fase;
    String nombre;
    
    public Ciudad(){
        this.fase = 0;
        this.nombre = "";
    }

    public Ciudad(int fase, String nombre) {
        this.fase = fase;
        this.nombre = nombre;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
