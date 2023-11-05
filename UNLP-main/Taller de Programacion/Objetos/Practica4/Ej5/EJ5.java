/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica4;

/**
 *
 * @author alumnos
 */
public class EJ5 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		VisorFiguras vs;
		Rectangulo rec;
		Cuadrado cua1, cua2;
		
		
		vs = new VisorFiguras();
		rec = new Rectangulo(2.0,1.5,"verde", "rojo");
		cua1 = new Cuadrado(5, "azul", "mama de mati");
		cua2 = new Cuadrado(8, "que linda que esta la mama de mati", "la hermanita de mati fis bella");
		
		vs.guardar(rec);
		vs.guardar(cua1);
		vs.guardar(cua2);
		
		vs.mostrar();
	}
	
}
