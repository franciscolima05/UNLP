/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ4;

/**
 *
 * @author franciscolima
 */
public class AreaEmpresa {
    String id;
    int time;

    public AreaEmpresa(int i, String id){
        this.setId(id);
        this.setTime(i);
    }
    
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    private void setTime(int time) {
        this.time = time;
    }
    
}
