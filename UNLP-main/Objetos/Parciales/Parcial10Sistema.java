/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial10Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Sistema s1;
       Paciente pc;
       
       s1 = new Sistema();
       
       int i,j;
        for(i=0;i<5;i++){
            for(j=0;j<6;j++){
                pc = new Paciente(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarBoolean(),Math.round(GeneradorAleatorio.generarDouble(1000)));
                s1.agregarPaciente(pc, i, j);
            }
        }
        
        System.out.println(s1.concatenador());
        
        for(j=0;j<6;j++){
                pc = new Paciente("Carlitos", GeneradorAleatorio.generarBoolean(),Math.round(GeneradorAleatorio.generarDouble(1000)));
                s1.agregarPaciente(pc,4, j);
            }
        
        System.out.println();
        
        System.out.println(s1.concatenador());
        
        System.out.println(s1.tieneTurno("Carlitos", 4));
        s1.eliminarPaciente("Carlitos");
        System.out.println(s1.tieneTurno("Carlitos", 4));
    }
    
}
