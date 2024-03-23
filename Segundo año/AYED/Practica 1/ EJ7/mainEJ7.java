/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica1.EJ7;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
public class mainEJ7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vec = new int[5];
        int i;
        for(i=0; i< 5; i++){
            vec[i] = i;
        }
        TestArrayList.main(vec);
        
        ArrayList<Estudiante> list1 = new ArrayList<>();
        
        TestArrayList.listaEstudiante(list1);
        
        for(Estudiante num : list1){
           num.toString();
        }
        
        String cadena = "123321";
        System.out.println(TestArrayList.esCapicua(cadena));
    }
}
