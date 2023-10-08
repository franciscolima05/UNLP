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
public class PC {
    private boolean estado;
    private double consumo;
    
    public boolean isEstado() {
        return estado;
    }
    
    public void encender(){
        this.estado = true;
    }

    public double getConsumo() {
        return consumo;
    }
    
    public PC(double cons){
        this.estado = false;
        this.consumo = cons;
    }
}
