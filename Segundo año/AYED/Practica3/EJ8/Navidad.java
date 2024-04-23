/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ8;
import Practica3.EJ1.GeneralTree;
/**
 *
 * @author franciscolima
 */
public class Navidad {
    GeneralTree<Integer> tree;
    
    public Navidad(GeneralTree<Integer> tree){
        this.tree = tree;
    }
    
    public  String esAbetoNavidenio(){
        if(!this.tree.isEmpty()){
            boolean ok = esAbetoNavidenioHelper(this.tree);
            if(ok){
                return "El Arbol es Abeto Navideño";
            }
            else
                return "No lo es";
        }
        return "El arbol es vacio";
    }

    
    private boolean esAbetoNavidenioHelper(GeneralTree<Integer> tree){
        int j = 0;
        for(GeneralTree<Integer> child : tree.getChildren()){
            if(child.isLeaf()){
                j++;
            }
            else
                 esAbetoNavidenioHelper(child);
        }
        return j >= 3;
    }
}
