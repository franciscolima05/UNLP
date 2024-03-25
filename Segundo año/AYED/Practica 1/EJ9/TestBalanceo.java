/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.EJ9;

import java.util.*;
public class TestBalanceo {
    //String apertura = "([{";
    //String cierre = "}])";
    
    public static boolean estaBalanceado(String cadena){
        ArrayList<Character> apertura = new ArrayList<>();
        ArrayList<Character> cierre = new ArrayList<>();
        apertura.add('(');
        apertura.add('{');
        apertura.add('[');
        cierre.add(')');
        cierre.add('}');
        cierre.add(']');
        int i = 0;
        Stack<Character> pila = new Stack();
        boolean ok = true;
        char aux;
        if(cadena.isEmpty() || cadena.length() % 2 != 0){
            return false;
        }
        else{
            while(i < cadena.length() && ok){
                char elem = cadena.charAt(i);
                if(apertura.contains(elem)){
                    pila.push(elem);
                }
                else{
                    if(!pila.isEmpty()){
                        aux = pila.pop();
                        if(apertura.indexOf(aux) != cierre.indexOf(elem)){
                            ok = false;
                        }
                    }
                }
                i++;
            }
            return ok;
        }
    }  
}
