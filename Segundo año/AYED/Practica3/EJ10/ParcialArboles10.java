/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ10;
import Practica3.EJ1.GeneralTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class ParcialArboles10 {
    
     public static List<Integer> resolver(GeneralTree<Integer> tree){
         List<Integer> listaMax = new LinkedList<>();
         if(!tree.isEmpty()){
             List<Integer> listaAct = new LinkedList<>();
             Max max1 = new Max(0);
             resolverHelper(tree, listaAct, listaMax, max1, 0);
             return listaMax;
         }
         else
             return listaMax;
     }


     private static List<Integer> resolverHelper(GeneralTree<Integer> tree, List<Integer> act, List<Integer> listMax, Max maximo, int cont){
         if(tree.getData() == 1){
             act.add(tree.getData());
             cont++;
         }
         if(!tree.isLeaf()){
             for(GeneralTree<Integer> child : tree.getChildren()){
                 resolverHelper(child, act, listMax, maximo, cont);
             }
         }
         else{
            if(cont > maximo.getNumMax()){
                maximo.setNumMax(cont);
                listMax.removeAll(listMax);
                listMax.addAll(act);
            }
        }
        return listMax;
     }
}
