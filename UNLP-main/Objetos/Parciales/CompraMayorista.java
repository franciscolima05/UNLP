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
public class CompraMayorista extends Compra {
    private int cuit;
    
    public CompraMayorista(int nro, int max, int cuit){
        super(nro, max);
        this.cuit = cuit;
    }
    
@Override
    public String toString(){
        String aux = super.toString()+ "\n" + " CUIT: " +this.cuit;
        return aux;
    }
}
