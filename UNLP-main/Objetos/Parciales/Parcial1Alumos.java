/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial1Alumos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoDeGrado alu1;
        AlumnoDoctorado alu2;
        Materia mat;
        
        alu1 = new AlumnoDeGrado("Diplomatura en Esports", 777,"Estanislao Andres", 37);
        alu2 = new AlumnoDoctorado("Tecnico Analista en casos de violencia Pediatricas", "Universidad del este", 657,"Matias juliana Guaymas", 20);
        
        
        int matigay = 0;
        /*while(matigay != 5){
            mat = new Materia(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            matigay = GeneradorAleatorio.generarInt(6);
            alu1.agregarMateria(mat);
        }
        
        int matigay2 = 0;
        while(matigay2 != 5){
            mat = new Materia(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            matigay2 = GeneradorAleatorio.generarInt(6);
            alu2.agregarMateria(mat);
        }*/
        
        int i;
        for(i=0;i<alu1.getCantMax();i++){
            mat = new Materia(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            if(i==5){
                mat.setNombre("Tesis");
            }
            alu1.agregarMateria(mat);
        }
        
         for(i=0;i<alu1.getCantMax();i++){
            mat = new Materia(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            if(i==5){
                mat.setNombre("Tesis");
            }
            alu2.agregarMateria(mat);
        }
        
        
        
        System.out.println(alu1.toString());
        System.out.println(alu2.toString());

    }
    
}
