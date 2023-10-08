/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;

/**
 *
 * @author Francisco
 */
public class Parcial5Teatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion f1; 
        Butaca b1;
        
        f1 = new Funcion("El Cumple De Estanislao", 17, 20, 5, 9);
        
        int i,j;
        for(i=0;i<5;i++){
            for(j=0;j<9;j++){
                f1.ocuparButaca(i, j);
            }
        }
        System.out.println(f1.toString());
    }
    
}
