/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

import PaqueteLectura.*;
public class Parcial4Cursos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CursoADistancia c1;
       CursoPresencial c2;
       Alumno2 a, a2;
       
       c1 = new CursoADistancia("399084", 2023, 25);
       c2 = new CursoPresencial(5, 2023, 20);
       
       int aux = 0;
       
       while(aux != 10){
           a = new Alumno2(aux, GeneradorAleatorio.generarString(6));
           a2 = new Alumno2(aux, GeneradorAleatorio.generarString(6));
           aux++;
           c1.agregarAlumno(a);
           c2.agregarAlumno(a2);
       }
       
       int i,j;
       for(i=0;i<10;i++){
           for(j=0;j<3;j++){
               if(i!=3){
                c1.aproboPrueba(i);
                c2.aproboPrueba(i);
                c1.incAsistenciaDni(i);
                c2.incAsistenciaDni(i);
                }
       }
    }
       System.out.println(c1.cantAlumnosRendir());
       System.out.println(c2.cantAlumnosRendir());
}
}
