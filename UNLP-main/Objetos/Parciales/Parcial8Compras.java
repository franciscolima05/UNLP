/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial8Compras {

    public static void main(String[] args) {
        CompraMinorista cMin;
        CompraMayorista cMay;
        Producto p, p2;
        
        
        
        cMin = new CompraMinorista(245, 10, false);
        cMay = new CompraMayorista(777, 10, 459872);
        
        int i;
        for(i=0;i<10;i++){
            p = new Producto(GeneradorAleatorio.generarInt(10), Math.round(GeneradorAleatorio.generarDouble(1000)), GeneradorAleatorio.generarString(6));
            cMin.agregarProducto(p);
            p2 = new Producto(GeneradorAleatorio.generarInt(10), Math.round(GeneradorAleatorio.generarDouble(1000)), GeneradorAleatorio.generarString(6));
            cMay.agregarProducto(p2);
        }
        
        System.out.println(cMin.toString());
        System.out.println(cMay.toString());
    }
    
}
