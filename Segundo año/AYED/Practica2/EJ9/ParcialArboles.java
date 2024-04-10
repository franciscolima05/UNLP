/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.EJ9;
import Practica2.EJ1.BinaryTree;
/**
 *
 * @author franciscolima
 */
public class ParcialArboles {
    
    
    private BinaryTree<ArbolSAD> sumAndDifHelper(BinaryTree<Integer> arb, int padre, int suma, BinaryTree<ArbolSAD> arbSAD){
        int aux = arb.getData();
        ArbolSAD triste = new ArbolSAD(suma + aux, aux - padre);
        arbSAD.setData(triste);
        if(arb.hasLeftChild()){
            arbSAD.addLeftChild(new BinaryTree<ArbolSAD>());
            sumAndDifHelper(arb.getLeftChild(), aux, aux + suma, arbSAD.getLeftChild());
        }
        if(arb.hasRightChild()){
            arbSAD.addRightChild(new BinaryTree<ArbolSAD>());
            sumAndDifHelper(arb.getRightChild(), aux, aux + suma, arbSAD.getRightChild());
        }
        return arbSAD;
    }
    
    
    public BinaryTree<ArbolSAD> sumAndDif(BinaryTree<Integer> arb){
        BinaryTree<ArbolSAD> arbSAD = new BinaryTree<ArbolSAD>(); 
        if(arb.isEmpty())
            return arbSAD;
        else{
            this.sumAndDifHelper(arb, 0, 0, arbSAD);
        }
        return arbSAD;
    }
    
    public static void preOrdenSAD(BinaryTree<ArbolSAD> arbsad){
        System.out.println(arbsad.getData().getDif());
        System.out.println(arbsad.getData().getSuma());
        if(arbsad.hasLeftChild()){
            preOrdenSAD(arbsad.getLeftChild());
        }
        if(arbsad.hasRightChild()){
            preOrdenSAD(arbsad.getRightChild());
        }
    }
}
