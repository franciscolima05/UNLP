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
public class Sistema {
    private Paciente [][] matriz;
    
    
    public Sistema(){
        int i,j;
        this.matriz = new Paciente[5][6];
        for(i=0;i<5;i++){
            for(j=0;j<6;j++){
                this.matriz[i][j] = null;
            }
        }
    }
    
     public void agregarPaciente(Paciente p, int d, int t){
        this.matriz[d][t] = p;
    }
     
     public void eliminarPaciente(String nom){
         int i,j;
        for(i=0;i<5;i++){
            for(j=0;j<6;j++){
                if(this.matriz[i][j].getNombre().equals(nom)){
                    this.matriz[i][j] = null;
                }    
            }
        }
     }
     
     public boolean tieneTurno(String nombre, int dia){
         int i;
         boolean tiene = false;
         for(i=0;i<6;i++){
             if(this.matriz[dia][i] != null){
                 tiene = this.matriz[dia][i].getNombre().equals(nombre);
             }
         }
         return tiene;
     }
     
     public String concatenador(){
         String aux = "";
         int i, j;
         for(i=0;i<5;i++){
            for(j=0;j<6;j++){
                aux = aux + this.matriz[i][j].toString() + "\n";
                System.out.println(i);
                System.out.println(j);
                }    
            }
         return aux;
        }
     }

