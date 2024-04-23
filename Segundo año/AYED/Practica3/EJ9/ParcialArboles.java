/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ9;
import Practica3.EJ1.GeneralTree;
/**
 *
 * @author franciscolima
 */
public class ParcialArboles {
    
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(!arbol.isEmpty()){
            return esDeSeleccionHelper(arbol, arbol.getData());
        }
        else
            return false;
    }
    
    private static boolean esDeSeleccionHelper(GeneralTree<Integer> tree, int act){
        if(act > tree.getData())
            return false;
        else{
            if(!tree.isLeaf()){
                for(GeneralTree<Integer> child : tree.getChildren()){
                    if(!esDeSeleccionHelper(child, tree.getData())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
