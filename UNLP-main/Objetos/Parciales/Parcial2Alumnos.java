/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial2Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso con;
        Concursante alu;
        GeneradorAleatorio.iniciar();
        
        con = new Concurso(20);
        
        int i = 0;
        for(i=0; i<19; i++){
            alu = new Concursante(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(20), GeneradorAleatorio.generarString(10));
            con.agregarConcursante(alu, GeneradorAleatorio.generarInt(5));
        }
        System.out.println(con.toString());
    }
}
