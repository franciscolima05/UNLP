/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;
import PaqueteLectura.*;
public class Paracial3Goleadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Torneo t1;
        Goleador g1;
        GeneradorAleatorio.iniciar();
        t1 = new Torneo("TORNEO GORDO", 10, 11);
        
        int aux = 0;
        while(aux != 5){
            aux = GeneradorAleatorio.generarInt(10) + 1;
            g1 = new Goleador(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(6), GeneradorAleatorio.generarInt(20));
            t1.agregarGoleador(g1, aux);
        }
     
        
        System.out.println(t1.toString());
    }
    
}
