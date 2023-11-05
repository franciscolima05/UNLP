
package Practica5;

public class CoroSemiCircular extends Coros{
    private  Corista [] colocacion;
    
    public CoroSemiCircular(){
        this.colocacion = new Corista[this.getCantCoristas()];
        int i;
        for(i=0;i<this.getCantCoristas();i++){
            colocacion[i] = this.getSerie()[i];
        }
        
    }
}
