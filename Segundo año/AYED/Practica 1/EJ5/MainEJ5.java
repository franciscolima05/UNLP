/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica1.EJ5;

public class MainEJ5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vec1 = new int[11];
        int i;
        for(i=0;i<=10;i++){
            vec1[i] = i;
        }
        int[] vec2 = Arreglo.Arreglorom(vec1);
        for(i=0;i<3;i++){
            System.out.println(vec2[i]);
        }
        
        Arreglo.arregloSinNada(vec1);
        System.out.println(Arreglo.getMax());
        System.out.println(Arreglo.getMin());
        System.out.println(Arreglo.getProm());
    
        int[] vec3 = new int[3];
        
        Arreglo.arregloConParametros(vec1, vec3);
        for(i=0;i<3;i++){
            System.out.println(vec3[i]);
        }
    }
}
