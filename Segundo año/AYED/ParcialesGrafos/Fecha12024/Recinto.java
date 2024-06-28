/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialesGrafos.Fecha12024;

/**
 *
 * @author franciscolima
 */
public class Recinto {
    int tiempo;
    String nombre;

    public Recinto(String nom, int tiempo) {
        this.tiempo = tiempo;
        this.nombre = nom;
    }

    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
