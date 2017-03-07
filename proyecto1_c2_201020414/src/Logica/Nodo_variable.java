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
public class Nodo_variable {
    public String nombre;//nombre variable
    public Object valor;//el valor que contendra
    public String ambito;//a donde pertenece
    public String acceso;//privado, protegido, publico
    public int posicion;//que posicion tiene
    public String tipo;//variable o atributo o arreglo o funcion o metodo
    public String tDato;//string, int,char,bool,double,void
    public String parametros;//la lista de tipo de datos que va a contener la funcion o metodo
    public int tamanho;//la cantidad de parametros de una funcion o metodo
    public int heredado;//0 si no es heredado, 1 si es heredado
    public int prioridad;//1 si tiene mas peso que el resto, 0 si no tiene peso
    public NodoArbol nodoParametro;//va a contener todos los parametros
    public String ubicacion;//local o global
    public Nodo_variable(String name,Object val,String ambit,String acceso,int pos,String tipo,String tDato,int heredado,int prioridad,String ubicacion){//variables
        this.nombre=name;
        this.valor=val;
        this.ambito=ambit;
        this.acceso=acceso;
        this.posicion=pos;
        this.tipo=tipo;
        this.tDato=tDato;
        this.heredado=heredado;
        this.prioridad=prioridad;
        this.ubicacion=ubicacion;
    }   

    public Nodo_variable(String name,Object val,String ambit,String acceso,int pos,String tipo,String tDato,String parametro,int tamanho,int heredado,int prioridad,NodoArbol nodoParametros){//funciones o metodos
        this.nombre=name;
        this.valor=val;
        this.ambito=ambit;
        this.acceso=acceso;
        this.posicion=pos;
        this.tipo=tipo;
        this.tDato=tDato;
        this.parametros=parametro;
        this.tamanho=tamanho;
        this.heredado=heredado;
        this.prioridad=prioridad;
        this.nodoParametro=nodoParametros;
    } 
    
    public Nodo_variable(String name,Object val,String ambit,String acceso,int pos,String tipo,String tDato,String parametro,int tamanho,int heredado,int prioridad,NodoArbol nodoParametros,String ubicacion){//funciones o metodos
        this.nombre=name;
        this.valor=val;
        this.ambito=ambit;
        this.acceso=acceso;
        this.posicion=pos;
        this.tipo=tipo;
        this.tDato=tDato;
        this.parametros=parametro;
        this.tamanho=tamanho;
        this.heredado=heredado;
        this.prioridad=prioridad;
        this.nodoParametro=nodoParametros;
        this.ubicacion=ubicacion;
    } 

}//no tocar
