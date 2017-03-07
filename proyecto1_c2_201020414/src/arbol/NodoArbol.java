/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package arbol;

import java.util.ArrayList;

/**
*
* @author Alberth Bautista
*/
public class NodoArbol {
   private String etiqueta;
   private ArrayList<NodoArbol> lista_Hijos;
private int codigo;
private String nodo_Graphviz;
private int linea;
private int columna;
   private static int contador = 0;


    public NodoArbol(String etiqueta) {
        this.etiqueta = etiqueta;
        this.lista_Hijos = new ArrayList();
        contador++;
        codigo = contador;
        
        nodo_Graphviz = String.format("n%d [label = \"%s\"];\n",codigo,etiqueta);
       
    }
    public NodoArbol() {
        
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
    
    public static void setContador(int cont){
        contador = cont;
      //  System.out.println("inicializando contador "+contador);
    }
    
    public String getEtiqueta(){
        return this.etiqueta;
    }

    
    public NodoArbol getHijoEn(int indice){            
        return this.lista_Hijos.get(indice);
    }
    
    public void addHijo(NodoArbol hijo){

        this.lista_Hijos.add(hijo);
        nodo_Graphviz+= String.format("n%d -> n%d;\n",codigo,hijo.getCodigo());
        //System.err.println(nodo_Graphviz);
    }         
    
    public void addHijo(String etiqueta){
        
        NodoArbol nuevo = new NodoArbol(etiqueta);
        this.lista_Hijos.add(nuevo);
        nodo_Graphviz+= String.format("n%d -> n%d;\n",codigo,nuevo.getCodigo());
       // System.err.println(codigo+","+nuevo.getCodigo());
        //System.err.println(nodo_Graphviz);
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String toGraphviz(){        
        //System.out.println("Todo el graphviz -> \n" +nodo_Graphviz);
        return nodo_Graphviz;
        
    }
    
    public int getCantidadHijos(){
        return this.lista_Hijos.size();
    }
    
         public String obtenerGrafoArbol(){
        String texto = "";
        texto += "digraph G{\n";
 
        texto += "node[shape=box, style=filled, color=Gray95];\n";
        if (nodo_Graphviz.equalsIgnoreCase("")){
            texto += "n[label = \"Arbol B Vacio\"];\n";
        }else{
            texto += toGraphviz();
        }
        texto += "}";
        return texto;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
         
}// no tocar
