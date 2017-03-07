/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Alberth
 */
public class Nodo_variables {
    public String nombre;//nombre variable
    public String tDato;//string, int,char,bool,double,void
    public String tipo;//global
    public Object valor;//valor de la variable
    public Nodo_variables(String name,String tDato,String tipo,Object valor){
        this.nombre=name;
        this.tDato=tDato;
       this.tipo=tipo;
       this.valor=valor;
    }   


   
}//no tocar
