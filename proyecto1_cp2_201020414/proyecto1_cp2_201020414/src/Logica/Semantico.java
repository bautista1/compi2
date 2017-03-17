/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import arbol.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Reader;
import java.io.StringReader;
//import sun.net.www.protocol.http.AuthCacheValue;
/**
 *
 * @author Alberth
 */
public class Semantico {
    private Graphviz grafo;
     
    int retornoExistenciaVariable = 0;//comprueba que no exista la variable en la tabla
    private int validacionSuper=0;//1 si puede usarse, 0 si no se puede usar
    private int validarSobreEscritura=0;//0 si puede usarse, 1 si no se puede usar
    private int validarAtributoVariable=0;//0 o 1, 0 indica que es variable y 1 indica que es atributo
    private String nomVar="";
    private int validarClase=0;//0 o 1, 0 si no es extendida y 1 si es extendida
    private int validaInstancia=0;//0 o 1, 0 si no es instancia y 1 si es instancia
    private int salir=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    private int comprobarRetorno=0;//0=indica que no viene ningun retorno y 1=indica que viene un retorno
    private int variableEncontrada=0;//0=indica que no existe una variable con ese nombre, 1=indica que existe una variable con ese nombre
    private String tipoRetorno="";//indica de que tipo es el metodo para almacenar su retorno int,double,bool,string,char
    private int cantParametros=0;//determina cuantos parametros tiene el metodo o funcion
    private String ambExtendida="";//lleva el nombre de la clase de la cual se esta extendiendo
    private String ambitoAuxMetodo="";//lleva el nombre de la clase en la cual se encuentra el metodo en este caso ambito
    //private NodoArbol auxArbol=null;//contendra la lista de clases que se podran instanciar
    
    
     public Semantico(){
        grafo = new Graphviz();        
        
    }
     

     //no tocar de aqui para abajo ya que es de los arboles
     public void dibujarArbol(NodoArbol raiz){
        if (raiz != null){
            String texto = "digraph{\nnode [shape = box];\n";        
            texto += dibujarNodo(raiz);                
            texto += "}";          
            grafo.dibujar(texto,"grafo","pdf");
        }
    }
    private String dibujarNodo(NodoArbol raiz){
        String nodo = raiz.toGraphviz();        
        for (int i = 0; i < raiz.getCantidadHijos(); i++) {
            nodo += dibujarNodo(raiz.getHijoEn(i));
        }
        return nodo;
    }
    
}//no tocar
