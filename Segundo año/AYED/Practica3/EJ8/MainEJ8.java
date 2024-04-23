/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ8;
import Practica3.EJ1.GeneralTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class MainEJ8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<GeneralTree<Integer>> subArb1 = new LinkedList<GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(2));
        subArb1.add(new GeneralTree<Integer>(3));
        subArb1.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1, subArb1);
        
        LinkedList<GeneralTree<Integer>> subArb2A = new LinkedList<GeneralTree<Integer>>();
        subArb2A.add(new GeneralTree<Integer>(5));
        subArb2A.add(new GeneralTree<Integer>(6));
        subArb2A.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<Integer>(2, subArb2A);
        LinkedList<GeneralTree<Integer>> subArb2B = new LinkedList<GeneralTree<Integer>>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<Integer>(3));
        subArb2B.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subArb2B);
        
        LinkedList<GeneralTree<Integer>> subArb3A = new LinkedList<GeneralTree<Integer>>();
        subArb3A.add(new GeneralTree<Integer>(6));
        subArb3A.add(new GeneralTree<Integer>(7));
        subArb3A.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(3, subArb3A);
        LinkedList<GeneralTree<Integer>> subArb3B = new LinkedList<GeneralTree<Integer>>();
        subArb3B.add(new GeneralTree<Integer>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<Integer>(4));
        subArb3B.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subArb3B);
        
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(null);
        
        Navidad pruebaVacio = new Navidad(a4);
        
        Navidad prueba = new Navidad(a1);
        Navidad prueba2 = new Navidad(a2);
        Navidad prueba3 = new Navidad(a3);
        
        System.out.println(prueba.esAbetoNavidenio());
        System.out.println();
        System.out.println(prueba2.esAbetoNavidenio());
        System.out.println();
        System.out.println(prueba3.esAbetoNavidenio());
        System.out.println();
        System.out.println(pruebaVacio.esAbetoNavidenio());
    }
    
    
}
