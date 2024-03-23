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
      /** 
        
        TestArrayList.main(vec);
        
        ArrayList<Estudiante> list1 = new ArrayList<>();
        
        TestArrayList.listaEstudiante(list1);
        
        for(Estudiante num : list1){
           num.toString();
        }
        
        String cadena = "123321";
        System.out.println(TestArrayList.esCapicua(cadena));
        **/
        ArrayList <Integer> list = TestArrayList.calcularSucesion(6);
      /**  
        int tamaño = list.size();
        
        System.out.println("Tamaño de la lista: "+ tamaño);
        
        for(i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
        
        LinkedList<Integer> listaLink = new LinkedList<>();
        for(i = 0; i < 5; i++){
            listaLink.add(i);
        }
        System.out.println(TestArrayList.sumarLinkedList(listaLink));
        
        TestArrayList.invertirLista(list);
        for(i = 0; i< list.size(); i++){
            System.out.print(list.get(i));
        }
        
        **/
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        ArrayList<Integer> lista3;
        
        for(i = 0; i < 5; i++){
            lista1.add(i);
        }
        for(i = 6; i < 10; i++){
            lista2.add(i);
        }
        
        lista3 = TestArrayList.combinarOrdenado(lista1, lista2);
        
         for(i = 0; i< lista3.size(); i++){
            System.out.println(lista3.get(i));
        }
    }
}
