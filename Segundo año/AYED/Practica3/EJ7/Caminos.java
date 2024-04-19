/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica3.EJ7;
import Practica3.EJ1.GeneralTree;
import java.util.*;
/**
 *
 * @author franciscolima
 */
public class Caminos {
    GeneralTree<Integer> tree;
    
    public Caminos(GeneralTree<Integer> tree){
        this.tree = tree;
    }
    
    public List<Integer> caminoAHojaMasLejana(){
        LinkedList<Integer> listAct = new LinkedList<>();
        LinkedList<Integer> listMax = new LinkedList<>();
        if(!this.tree.isEmpty()){
            listMax = caminoAHojaMasLejanaHelper(listAct, listMax, this.tree);
            return listMax;
        }
        else
            return listMax;
    }   
    
    private LinkedList<Integer> caminoAHojaMasLejanaHelper(LinkedList<Integer> listAct, LinkedList<Integer> listMax, GeneralTree<Integer> tree){
        listAct.add(tree.getData());
        if(tree.hasChildren()){
            for(GeneralTree<Integer> child : tree.getChildren()){
                caminoAHojaMasLejanaHelper(listAct, listMax, child);
                listAct.remove(listAct.size() - 1);
            }
        }
        if(listAct.size() > listMax.size()){
            listMax.removeAll(listMax);
            System.out.println(listMax.isEmpty());
            listMax.addAll(listAct);
        }
        return listMax;
    }
}
