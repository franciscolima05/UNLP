/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial9Bailarines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConcursoBaile cb;
        Bailarin bb, bb2, bb3, bb4;
        Pareja p, p2;
        GeneradorAleatorio.iniciar();
        
        
        bb = new Bailarin(GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50));
        bb2 = new Bailarin(GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50));
        
        p = new Pareja(bb, bb2);
        
        bb3 = new Bailarin(GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50));
        bb4 = new Bailarin(GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50));
        
        p2 = new Pareja(bb3, bb4);
        
        cb = new ConcursoBaile(5);
        cb.agregarPareja(p);
        cb.agregarPareja(p2);
        System.out.println(cb.toString());
        System.out.println(cb.masDiferencia().toString());
    }
}
