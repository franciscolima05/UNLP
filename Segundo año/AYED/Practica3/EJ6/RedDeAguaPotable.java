/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ6;
import Practica3.EJ1.GeneralTree;

/**
 *
 * @author franciscolima
 */
public class RedDeAguaPotable {
    GeneralTree<Character> tree;
    
    
    public RedDeAguaPotable(GeneralTree<Character> tree){
        this.tree = tree;
    }
    
    public double minimoCaudal(double caudal){
        if(!this.tree.isEmpty()){
            return minimoCaudalHelper(caudal, this.tree, 9999, 0);
        }
        System.out.println("VACIO");
        return caudal;
    }
    
    private double minimoCaudalHelper(double caudal, GeneralTree<Character> arb, double min, double act){
        if(arb.hasChildren()){
            caudal = (caudal / arb.getChildren().size());
            act = caudal;
            for(GeneralTree<Character> child : arb.getChildren()){
               min =  minimoCaudalHelper(act, child, min, act);
            }
        }
        else{
            if(act < min){
                System.out.println("ACTUAL: " + act);
                min = act;
                System.out.println("MINIMO: " + min);
            }
        }
        return min;
    }
    
}
