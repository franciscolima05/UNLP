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
public class Pareja {
    private Bailarin bailarin1;
    private Bailarin bailarin2;
    
    public Pareja(Bailarin b1, Bailarin b2){
        this.bailarin1 = b1;
        this.bailarin2 = b2;
    }
    
    public int diferenciaEdad(){
        int aux;
        if(this.bailarin1.getEdad() > this.bailarin2.getEdad()){
            aux = this.bailarin1.getEdad() - this.bailarin2.getEdad();
        }
        else{
            if(this.bailarin2.getEdad() > this.bailarin1.getEdad()){
                aux = this.bailarin2.getEdad() - this.bailarin1.getEdad();
            }
            else
                aux = 0;
        }
        return aux;
    }
    
@Override
    public String toString(){
        String aux = "Barilarin 1: " + this.bailarin1.toString() + "\n" + "Bailarin 2: "  + this.bailarin2.toString();
        return aux;
    }
}
