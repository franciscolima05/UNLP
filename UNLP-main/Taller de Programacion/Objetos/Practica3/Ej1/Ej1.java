/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;

import PaqueteLectura.*;
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo triangulo1 = new Triangulo();
        String color;
        GeneradorAleatorio.iniciar();
        
        //triangulo1.setLado1(10.0);
        //triangulo1.setLado2(10.0);
        //triangulo1.setLado3(10.0);
        triangulo1.setLado1(GeneradorAleatorio.generarDouble(50));
        triangulo1.setLado2(GeneradorAleatorio.generarDouble(50));
        triangulo1.setLado3(GeneradorAleatorio.generarDouble(50));
        System.out.println("Ingrese color de relleno");
        color = Lector.leerString();
        triangulo1.setColorRelleno(color);
        System.out.println("Ingrese color de borde");
        color = Lector.leerString();
        triangulo1.setColorLinea(color);
        
        System.out.println(triangulo1.CalcularPerimetro());
        
        System.out.println(triangulo1.CalcularArea());

        
        
    }
    
}
