/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import arbol.*;
/**
 *
 * @author Alberth
 */
public class Nodo_Metodo_Funcion {
    public String nombre;//nombre metodo/funcion
    public String tDato;//string, int,char,bool,double,void a retornar si void no retorna 
    public String tipo;//metodo o funcion
    public NodoArbol valor;//valor de la variable
    public int cantHijos;//la cantidad de parametros si fuese el caso
    public Nodo_Metodo_Funcion(String name,String tDato,String tipo,NodoArbol valor,int cantHijos){
        this.nombre=name;
        this.tDato=tDato;
       this.tipo=tipo;
       this.valor=valor;
       this.cantHijos=cantHijos;
    }   
}
