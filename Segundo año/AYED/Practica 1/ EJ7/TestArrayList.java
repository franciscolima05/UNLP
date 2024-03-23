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
