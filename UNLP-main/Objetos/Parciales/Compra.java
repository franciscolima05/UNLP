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
public abstract class Compra {
    private int nro;
    private Producto[] vector;
    private int cantProductos;
    private int maxProductos;
    
    public Compra(int nro, int max){
        this.nro = nro;
        this.maxProductos = max;
        this.cantProductos = 0;
        this.vector = new Producto[this.maxProductos];
    }
    
    public int getNro() {
        return nro;
    }

    public int getCantProductos() {
        return cantProductos;
    }
    
    public void agregarProducto(Producto p){
        this.vector[this.cantProductos++] = p;
    }
    
    public double precioConIva(){
        double aux = 0;
        int i;
        for(i=0;i<this.cantProductos;i++){
            aux = aux + this.vector[i].getPrecio();
        }
        aux = aux + (aux * 21) / 100;
        return aux;
    }
    
    public double precioSinIva(){
        double aux = 0;
        int i;
        for(i=0;i<this.cantProductos;i++){
            aux = aux + this.vector[i].getPrecio();
        }
        return aux;
    }

    public String concatenador(){
        String aux ="";
        int i;
        for(i=0;i<this.cantProductos;i++){
            aux = aux + this.vector[i].toString() + "\n";
        }
        return aux;
    }
    
    
   public String toString(){
       String aux = "Nro: "+this.nro + "  " + this.concatenador() +"\n" +" Precio a pagar: " + this.precioConIva() + "\n" + "Precio Sin iva: " +this.precioSinIva();
       return aux;
   }
    
    
}
