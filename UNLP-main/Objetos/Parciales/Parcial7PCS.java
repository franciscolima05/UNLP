/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial7PCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Sala s1;
       PC pc1;
       GeneradorAleatorio.iniciar();
       s1 = new Sala(5);
       int i, j;
       for(i=1;i<6;i++){
           for(j=1;j<4;j++){
               pc1 = new PC(GeneradorAleatorio.generarDouble(30));
               s1.agregarPC(i, j, pc1);
           }
       }
       
       System.out.println(s1.concatenador());
       s1.encenderPc();
      
       
       System.out.println();
       System.out.println(s1.concatenador());
    }
    
}
