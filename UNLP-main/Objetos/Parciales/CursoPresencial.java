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
public class CursoPresencial extends Curso {
    private int aula;

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }
    
    public CursoPresencial(int lin, int a, int cant){
        super(a, cant);
        this.aula = lin;
    }
@Override
    public boolean puedeRendir(Alumno2 a){
        return (a.getAsistencias() >= 3);
    }
}
