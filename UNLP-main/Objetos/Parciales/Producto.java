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
public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;

    public Producto(int code, double price, String dec){
        this.codigo = code;
        this.precio = price;
        this.descripcion = dec;
    }
    
    public double getPrecio() {
        return precio;
    }
@Override
    public String toString(){
        String aux = this.codigo + "  " + this.precio + "  " + this.descripcion;
        return aux;
    }
}
