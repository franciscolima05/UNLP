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
public class CompraMinorista extends Compra{
    private boolean esJubilado;
    
    public CompraMinorista(int nro, int max, boolean ok){
        super(nro, max);
        this.esJubilado = ok;
    }
@Override
    public String toString(){
        String aux = super.toString()+ "\n" + " Es jubilado: " + this.esJubilado;
        return aux;
    }
}
