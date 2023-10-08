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
public class CursoADistancia extends Curso{
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public CursoADistancia(String lin, int a, int cant){
        super(a, cant);
        this.link = lin;
    }
@Override
    public boolean puedeRendir(Alumno2 a){
       return ((a.getAutoEvaluaciones() >= 3)&&(a.getAsistencias() >= 1));
    }
}
