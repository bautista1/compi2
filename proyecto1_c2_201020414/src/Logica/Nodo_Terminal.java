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
public class Nodo_Terminal {
    public String nombre;//nombre variable
   
    public String tDato;//string, int,char,bool,double,void
   
    public Nodo_Terminal(String name,String tDato){
        this.nombre=name;       
        this.tDato=tDato;
    }   
}
