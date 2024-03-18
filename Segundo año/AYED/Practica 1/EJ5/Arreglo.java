/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ5;

/**
 *
 * @author franciscolima
 */
public class Arreglo {
    private static int min = 9999;
    private static int max = -1;
    private static double prom = 0.0;
    
    
    public static int[] Arreglorom(int[] vec){
        int cont = 0;
        int minimo = 9999;
        int maximo = -1;
        int i;
        int sum = 0;
        
            
        for(i=0; i < vec.length; i++){
            cont++;
            sum =sum + vec[i];
            if(vec[i] < minimo){
                minimo = vec[i];
            }    
            if(vec[i] > maximo){
                maximo = vec[i];
            }
        }
        
        int[]resp = new int[3];
        resp[0] = minimo;
        resp[1] = maximo;
        resp[2] = sum / cont;
        return resp;
    }

    public static int getMin() {
        return min;
    }

    public static int getMax() {
        return max;
    }

    public static double getProm() {
        return prom;
    }


public static void arregloSinNada(int[]vec){
    int cont=0;
    int suma = 0;
    int i;
    for(i=0; i< vec.length;i++){
        cont++;
        suma = suma + vec[i];
        if(vec[i]< min){
            min = vec[i];
        }
        if(vec[i] > max){
            max = vec[i];
        }
        prom = suma / cont;
    }
}

public static void arregloConParametros(int[]vec1, int[]resp){
    int i;
    int suma = 0;
    int cont = 0;
    int minimo = 999;
    int maximo = -1;
    
    for(i=0; i < vec1.length;i++){
        cont++;
        suma = suma + vec1[i];
        if(vec1[i]< minimo){
            minimo = vec1[i];
        }
        if(vec1[i]  > maximo){
            maximo = vec1[i];
        }
        
        resp[0] = minimo;
        resp[1] = maximo;
        resp[2] = suma / cont;
    }
}

}

