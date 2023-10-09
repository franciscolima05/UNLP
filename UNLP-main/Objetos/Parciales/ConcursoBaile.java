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
public class ConcursoBaile {
    private Pareja[] concursantes;
    private int cantConcursantes;
    
    public ConcursoBaile(int n){
        this.concursantes = new Pareja[n];
        this.cantConcursantes = 0;
    }
    
    public void agregarPareja(Pareja p){
        this.concursantes[this.cantConcursantes++] = p;
    }
    
    public Pareja masDiferencia(){
        int i;
        int min = -999; 
        int minPareja = 0;
        for(i=0;i<this.cantConcursantes;i++){
            if(this.concursantes[i].diferenciaEdad() > min){
                min = this.concursantes[i].diferenciaEdad();
                minPareja = i;
            }
        }
        return this.concursantes[minPareja];
    }
    
@Override    
    public String toString(){
        String aux ="";
        int i;
        for(i=0;i<this.cantConcursantes;i++){
            aux = aux + "  " + this.concursantes[i].toString() + "\n";
        }
        return aux;
    }
    
}
