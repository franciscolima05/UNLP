/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ11;
import Practica3.EJ1.GeneralTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<Integer> arb = new GeneralTree<>(2);
        arb.addChildren(new GeneralTree(1));
        arb.addChildren(new GeneralTree(25));
        arb.getChildren().get(0).addChildren(new GeneralTree(5));
        arb.getChildren().get(0).addChildren(new GeneralTree(4));
        arb.getChildren().get(1).addChildren(new GeneralTree(13));
        arb.getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree(16));
        arb.getChildren().get(0).getChildren().get(0).getChildren().get(0).addChildren(new GeneralTree(83));
        arb.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree(7));
        arb.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree(11));
        arb.getChildren().get(0).getChildren().get(1).addChildren(new GeneralTree(3));
        arb.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree(33));
        arb.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree(12));
        arb.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree(17));
        arb.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChildren(new GeneralTree(9));
        
        System.out.println(ParcialArboles11.resolver(arb));
    }
    
}
