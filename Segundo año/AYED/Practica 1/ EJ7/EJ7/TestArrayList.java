package Practica1.EJ7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

    public class TestArrayList {
    
    public static void main(int[]vec){
        ArrayList<Integer> nums = new ArrayList<> ();
        int i;
        for(i=0; i< vec.length; i++){
            nums.add(vec[i]);
        }
        
        for(Integer num : nums){
            System.out.println(num);
        }
        LinkedList<Integer> numL = new LinkedList<>();
        
        for(i=0; i< vec.length; i++){
            numL.add(vec[i]);
        }
        
        for(Integer num : numL){
            System.out.println(num);
        }
        
        Iterator<Integer> iterador = nums.iterator(); 
        
        while(iterador.hasNext()){
            Integer num = iterador.next();
            System.out.println(num);
        }
    }
    
    private static void cambiarLista(ArrayList<Estudiante> list){
        Scanner sca = new Scanner(System.in);
        System.out.println("Que dato desea modificar?");
        System.out.println("1 = nombre|2 = apellido|3 = comision");
        Integer op = sca.nextInt();
        if(op == 1){
            System.out.println("ingrese nuevo nombre");
            String nom = sca.nextLine();
            nom = sca.nextLine();
            System.out.println("a que estudiante desea cambiarle el nombre al 1, 2, 3?");
            Integer op2 = sca.nextInt();
            if(op2 == 1){
                Estudiante est1 = list.get(0);
                est1.setNombre(nom);
            }
            if(op2 == 2){
                Estudiante est1 = list.get(1);
                est1.setNombre(nom);
            }
            if(op2 == 3){
                Estudiante est1 = list.get(2);
                est1.setNombre(nom);
            }
        }
        else{
            if(op == 2){
                System.out.println("ingrese nuevo Apellido");
                String nom = sca.nextLine();
                nom = sca.nextLine();
                System.out.println("a que estudiante desea cambiarle el nombre al 1, 2, 3?");
                Integer op2 = sca.nextInt();
                if(op2 == 1){
                    Estudiante est1 = list.get(0);
                    est1.setApellido(nom);
                }
                if(op2 == 2){
                    Estudiante est1 = list.get(1);
                    est1.setApellido(nom);
                }
                if(op2 == 3){
                    Estudiante est1 = list.get(2);
                    est1.setApellido(nom);
                }
            }
            else{
                System.out.println("ingrese nueva Comision");
                String nom = sca.nextLine();
                nom = sca.nextLine();
                System.out.println("a que estudiante desea cambiarle la comision al 1, 2, 3?");
                Integer op2 = sca.nextInt();
                if(op2 == 1){
                    Estudiante est1 = list.get(0);
                    est1.setComision(nom);
                }
                if(op2 == 2){
                    Estudiante est1 = list.get(1);
                    est1.setComision(nom);
                }
                if(op2 == 3){
                    Estudiante est1 = list.get(2);
                    est1.setComision(nom);
                  
                }
            }  
        }
    }
    
    private static void imprimirLista(ArrayList<Estudiante> list){
        Iterator<Estudiante> iterador = list.iterator();
        
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }
    }
    
    private static void agregarEstudiante(ArrayList<Estudiante> list){
        String nom, ap, com;
        Scanner sca = new Scanner(System.in);
        System.out.println("ingrese nombre del nuevo estudiante");
        nom = sca.nextLine();
        System.out.println("ingrese apellido del nuevo estudiante");
        ap = sca.nextLine();
        System.out.println("ingrese comision del nuevo estudiante");
        com = sca.nextLine();
        
        Estudiante e = new Estudiante(nom, ap, com);
        
        int i;
        boolean ok = true;
        for(i=0; i< list.size(); i++){
           if(e.getApellido().equals(list.get(i).getApellido()) && e.getNombre().equals(list.get(i).getNombre()) && e.getComision().equals(list.get(i).getComision())){
               ok = false;
           }
        }
        if(ok){
            list.add(e);
        }
    }
    
    public static boolean esCapicua(String cadena){
        int head = cadena.length() - 1;
        int tail = 0;
        boolean ok = true;
        if(cadena.isEmpty() | cadena.length() == 1){
            return ok = false;
        }
        else{
            while(ok && head > tail){
                if(cadena.charAt(tail) == cadena.charAt(head)){
                    ok = true;
                }
                else{
                    ok = false;
                }
                head--;
                tail++;
            }
            return ok;
        }
    }
    
    public static ArrayList <Integer> calcularSucesion(int n){
        ArrayList <Integer> list = new ArrayList<>();
        list.add(n);
        if(n != 1){
            if(n % 2 == 0){
                list.addAll(calcularSucesion(n/2));
            }
            else{
                list.addAll(calcularSucesion(n * 3 + 1));
            }
        }   
        return list;   
    }
    
    private static void invertir(ArrayList<Integer> list, int ini, int fin){
        int aux;
        if(fin > ini){
            aux = list.get(ini);
            list.set(ini,list.get(fin));
            list.set(fin, aux);

            TestArrayList.invertir(list, ini + 1, fin - 1);
        }
    }
    
    public static void invertirLista(ArrayList<Integer> list){
        int ini = 0;
        int fin = list.size() - 1;
        TestArrayList.invertir(list, ini, fin);
    }
    
   
    
    public static int sumarLinkedList(LinkedList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        else{
            int elemento = list.removeFirst();
            
            return elemento + sumarLinkedList(list);
        }
    }
    
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int i, j;
        Integer aux1 = 0, aux2 = 0;
        ArrayList<Integer> list3 = new ArrayList<>();
      
        i = 0; j= 0;
        while (i < list1.size() && j < list2.size()){
            aux1 = list1.get(i);
            aux2 = list2.get(j);
            if(aux1 < aux2){
                list3.add(aux1);
                i++;
            }
            else{
                list3.add(aux2);
                j++;
            }
        }
        
        while(i < list1.size()){
            list3.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            list3.add(list2.get(j));
            j++;
        }
      
        return list3;
    }
    
    public static void listaEstudiante(ArrayList list){
        int i;
        Estudiante e1 = new Estudiante("carlitos", "Elbala", "3A");
        Estudiante e2 = new Estudiante("Miriam", "Vergman", "13B");
        Estudiante e3 = new Estudiante("Adolfito", "Zucullini", "7Z");
        
        ArrayList<Estudiante> list2 = new ArrayList<>();
        
        list2.add(e1);
        list2.add(e2);
        list2.add(e3);
        
        ArrayList<Estudiante> list3 = new ArrayList<>();
        list3.addAll(list2);
        
        TestArrayList.imprimirLista(list2);
        System.out.print(" ");
        TestArrayList.imprimirLista(list3);
        TestArrayList.cambiarLista(list2);
        TestArrayList.imprimirLista(list2);
        TestArrayList.imprimirLista(list3);
        TestArrayList.agregarEstudiante(list2);
        TestArrayList.imprimirLista(list2);
    }
}
