/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica3.EJ4;
import Practica3.EJ1.GeneralTree;
/**
 *
 * @author franciscolima
 */
public class MainEJ4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralTree<AreaEmpresa> tree = new GeneralTree<>(new AreaEmpresa(14, "M"));
        tree.addChildren(new GeneralTree<>(new AreaEmpresa(13, "J")));
        tree.addChildren(new GeneralTree<>(new AreaEmpresa(25, "K")));
        tree.addChildren(new GeneralTree<>(new AreaEmpresa(10, "L")));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(new AreaEmpresa(4, "A")));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(new AreaEmpresa(7, "B")));
        tree.getChildren().get(0).addChildren(new GeneralTree<>(new AreaEmpresa(5, "C")));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(new AreaEmpresa(6, "C")));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(new AreaEmpresa(10, "E")));
        tree.getChildren().get(1).addChildren(new GeneralTree<>(new AreaEmpresa(18, "F")));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(new AreaEmpresa(9, "G")));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(new AreaEmpresa(12, "H")));
        tree.getChildren().get(2).addChildren(new GeneralTree<>(new AreaEmpresa(19, "I")));
        
        
        System.out.println(AnalizadorArbol.devolverMaximoPromedio(tree));
    
    }
    
}