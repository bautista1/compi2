/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import arbol.*;
import java.io.*;
import javax.swing.*;
import DibujarFigura.*;
import java.util.ArrayList;


/**
 *
 * @author Alberth
 */
public class Acciones_Semanticas {
    //INICIA TABLA DE SIMBOLOS
    ArrayList<Nodo_variable> tablaSimbolos;
    int retornoExistenciaVariable=0;
    //FINALIZA TABLA DE SIMBOLOS
    private int salir=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    private int continuar=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    private int heredado=0;//0= indica que puede almacenar el main, 1 indica que es extendida y no almacena el main
    private String tipoAcceso="";//publico,protegido, privado no existe ya que no pueden acceder a ese lienzo
    private int prioridad=0;//0 indica que no tiene prioridad,1 indica que tiene prioridad sobre metodo,funcion,variable,arreglo

    private int getPrioridad() {
        return prioridad;
    }

    private void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    private String getTipoAcceso() {
        return tipoAcceso;
    }

    private void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }
    private int getHeredado() {
        return heredado;
    }

    private void setHeredado(int heredado) {
        this.heredado = heredado;
    }
    private String ambito="";
    private String ambitoTemporal="";

    private String getAmbito() {
        return ambito;
    }

    private void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    private String getAmbitoTemporal() {
        return ambitoTemporal;
    }

    private void setAmbitoTemporal(String ambitoTemporal) {
        this.ambitoTemporal = ambitoTemporal;
    }
    
    
    private int getContinuar() {
        return continuar;
    }

    private void setContinuar(int continuar) {
        this.continuar = continuar;
    }
    
    public ArrayList<Nodo_variable> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(ArrayList<Nodo_variable> tablaSimbolo) {
        int exisN=-1;
        int prioridad=-1;
        for(int cont=0;cont<tablaSimbolo.size();cont++){
           // System.out.println("cont --> "+cont);
            if(tablaSimbolos.isEmpty()){
              
                        tablaSimbolos.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
            }
            else{
                for(int contFor=0;contFor<tablaSimbolos.size();contFor++){
                    if(tablaSimbolo.get(cont).tipo.equalsIgnoreCase("metodo")||tablaSimbolo.get(cont).tipo.equalsIgnoreCase("funcion")){
                            if (tablaSimbolo.get(cont).nombre.equalsIgnoreCase(tablaSimbolos.get(contFor).nombre) && (tablaSimbolo.get(cont).tamanho==tablaSimbolos.get(contFor).tamanho) && (tablaSimbolo.get(cont).parametros.equalsIgnoreCase(tablaSimbolos.get(contFor).parametros)))
                            {
                                retornoExistenciaVariable = 1;// existe la variable
                                exisN=contFor;
                                prioridad=tablaSimbolo.get(cont).prioridad;
                            }
                    }else if(tablaSimbolo.get(cont).tipo.equalsIgnoreCase("variable")){
                            if (tablaSimbolo.get(cont).nombre.equalsIgnoreCase(tablaSimbolos.get(contFor).nombre) && tablaSimbolo.get(cont).ubicacion.equalsIgnoreCase(tablaSimbolos.get(contFor).ubicacion) )
                            {
                                retornoExistenciaVariable = 1;// existe la variable
                                exisN=contFor;
                                prioridad=tablaSimbolo.get(cont).prioridad;
                            }
                    }else if(tablaSimbolo.get(cont).tipo.equalsIgnoreCase("principal")){
                            if (tablaSimbolo.get(cont).nombre.equalsIgnoreCase(tablaSimbolos.get(contFor).nombre))
                            {
                                retornoExistenciaVariable = 1;// existe la variable
                                exisN=contFor;
                                prioridad=tablaSimbolo.get(cont).prioridad;
                            }
                    }
                   // System.out.println("contFor --> "+contFor);
                }
                
                  
                if(retornoExistenciaVariable==1){
                    if(prioridad==1){
                        tablaSimbolos.remove(exisN);
                        tablaSimbolos.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
                        exisN=-1;
                        retornoExistenciaVariable=-1;
                        prioridad=-1;
                    }
                }else{
                        tablaSimbolos.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
                }    
        
        }                
        }//termina for
       
    }

    private int getSalir() {
        return salir;
    }

    private void setSalir(int salir) {
        this.salir = salir;
    }
    
    
     //para compilar
            static Analizador1.proyecto  calc=null;
        //termina compilar
    private int tLienzo=0;//0 para el lienzo original que se compila, 1 si es un lienzo extendido

    private int gettLienzo() {
        return tLienzo;
    }

    private void settLienzo(int tLienzo) {
        this.tLienzo = tLienzo;
    }
    
    public Acciones_Semanticas(){
        tablaSimbolos=new ArrayList<>();
    }
    public void evaluar_arbol(NodoArbol raizDeclaracion,int evaluador)throws Exception{
         NodoArbol aux;
         aux=raizDeclaracion.getHijoEn(0);
            setHeredado(evaluador);
           evaluar_lienzo(aux,evaluador);
           
           
    }
       
       private void evaluar_lienzo(NodoArbol raiz,int evaluardor)throws Exception{
           NodoArbol aux;
           aux=raiz.getHijoEn(0);
           String acceso=acceso(aux);
           acceso=acceso.toLowerCase();
           String ambito=raiz.getHijoEn(1).getEtiqueta();
           String tipoLienzo=raiz.getHijoEn(2).getEtiqueta();
           tipoLienzo=tipoLienzo.toLowerCase();
           aux=raiz.getHijoEn(2);
           setAmbito(ambito);
           setAmbitoTemporal(ambito);
           settLienzo(evaluardor);
           setTipoAcceso(acceso);
           if(acceso.equalsIgnoreCase("publico") || acceso.equalsIgnoreCase("protegido") ){
               if(tipoLienzo.equalsIgnoreCase("simple")){
                    evaluar_lienzo_simple(aux);
                } else {
                    evaluar_lienzo_extendido(aux);
                }
           }else if(acceso.equalsIgnoreCase("privado")){
               
           }
                
          
           
           //evaluar_llenadoTablaSimbolos();
       //    System.out.println("etiqueta --> "+acceso+","+ambito+","+tipoLienzo+","+raiz.getEtiqueta());
       }
   
       private void evaluar_lienzo_simple(NodoArbol raiz)throws Exception{
           NodoArbol aux=raiz.getHijoEn(0); 
          evaluar_llenadoTablaSimbolos(getAmbito(),aux);
       }
        private void evaluar_lienzo_extendido(NodoArbol raiz)throws Exception{
          // System.out.println("lienzo extendido");
           NodoArbol aux;
            int c=0;
           String path="C:\\EntradasCompi2\\";
         for(c=0;c<raiz.getHijoEn(0).getCantidadHijos();c++){
             aux=raiz.getHijoEn(0).getHijoEn(c);
             path+=aux.getEtiqueta()+".lz";
             compilar(path);
            // System.out.println("lienzo --> "+path);
             path="C:\\EntradasCompi2\\";
         }
                aux=raiz.getHijoEn(1);
                setAmbito(getAmbitoTemporal());
               // System.out.println("aux --> "+aux.getEtiqueta());
               // setHeredado(0);
                evaluar_llenadoTablaSimbolos(getAmbito(),aux);
                settLienzo(0);
       }
        
        private void evaluar_llenadoTablaSimbolos(String ambito,NodoArbol raiz) throws Exception{
            NodoArbol aux;
            int c=0;
            String accion="";
           // System.out.println("lienzo --> "+ambito);
            while(c<raiz.getCantidadHijos()){
                aux=raiz.getHijoEn(c);
               // System.out.println("tabla --> "+aux.getEtiqueta());
                accion=aux.getEtiqueta();
                accion=accion.toLowerCase();
                switch(accion){
                    case "conserva":
                            setPrioridad(1);
                            evaluar_conserva(ambito,aux,1);
                        break;
                    case "declaracion":
                        setPrioridad(0);
                        evaluar_declaracion(ambito,aux,"GLOBAL",0);
                        break;
                    case "funcion":
                            setPrioridad(0);
                           // System.out.println("funcion tabla simbolos --> "+aux.getEtiqueta());
                            evaluar_funcion(ambito,aux,0);
                        break;
                    case "metodo":
                            setPrioridad(0);
                            evaluar_metodo(ambito,aux,0);
                        break;
                    case "main":
                            setPrioridad(0);
                        if(getHeredado()==0){//va a almacenar el main
                          //  System.out.println("main --> "+aux.getEtiqueta()+" ambito --> "+getAmbito());
                            //almacenar_metodo_funcion(String nombreVar,Object val,String ambit,String acceso,int pos,String tipo,String tDato,String parametro,int tamanho,NodoArbol parametros,int eliminar)//
                            almacenar_metodo_funcion("main", null, getAmbito(), "publico", -1, "principal", "", "", 0, null, 0);
                            //evaluar_rellenoFuncion(getAmbito(), aux.getHijoEn(0));
                        }else{//no va almacenar el main
                            
                        }
                        break;
                    
                }
                c++;
            }
        }
        
        private void evaluar_conserva(String ambito,NodoArbol raiz,int eliminar)throws Exception{
            NodoArbol aux=raiz.getHijoEn(0); 
            int c=0;
           // System.out.println("relleno --> "+aux.getEtiqueta());
            if(aux.getEtiqueta().equalsIgnoreCase("funcion")){
               // System.out.println("funcion conserva --> "+aux.getEtiqueta());
                evaluar_funcion(ambito,aux,eliminar);
            }else if(aux.getEtiqueta().equalsIgnoreCase("metodo")){
                //System.out.println("metodo "+ambito);
                evaluar_metodo(ambito,aux,eliminar);
            }else if(aux.getEtiqueta().equalsIgnoreCase("declaracion")){
                //System.out.println("declaracion "+ambito);
                evaluar_declaracion(ambito,aux,"GLOBAL",eliminar);
            }
        }
        
         private void evaluar_declaracion(String ambito,NodoArbol raiz,String ubicacion,int eliminar) throws Exception{
             
             evaluar_variables(ambito,raiz.getHijoEn(0),ubicacion,eliminar);
         }
        private void evaluar_variables(String ambito,NodoArbol raiz,String ubicacion,int eliminar) throws Exception{
            String op=raiz.getHijoEn(1).getEtiqueta();
            NodoArbol aux=raiz.getHijoEn(1);//variables o arreglos
            String tipo=raiz.getHijoEn(0).getEtiqueta();
            
            if(op.equalsIgnoreCase("lista_variables")){//lista de variables
                evaluar_variable(ambito,tipo,aux,ubicacion,eliminar);
            }else{//lista de arreglos
                
            }
        }
        
        private void evaluar_variable(String ambito,String tipo,NodoArbol raiz,String ubicacion,int eliminar) throws Exception{
            //System.out.println("Cantidad variables --> "+raiz.getCantidadHijos()+" de tipo "+tipo);
            String nombreVar="";
            NodoArbol aux=null;
            int cantH=0;
            for(int c=0;c<raiz.getCantidadHijos();c++){
                aux=raiz.getHijoEn(c);
                cantH=aux.getCantidadHijos();
                if(cantH==1){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                   almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                }else if(cantH==2){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                    almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                }
            }
                
        }
        
        
        private void evaluar_metodo(String ambito,NodoArbol raiz,int eliminar) throws Exception{
           // String retorno=raiz.getHijoEn(0).getEtiqueta();
            String nombre=raiz.getHijoEn(0).getEtiqueta();
            NodoArbol parametros=raiz.getHijoEn(1);
            NodoArbol relleno=raiz.getHijoEn(2);
            String parametrosCad=evaluar_parametros_cadena(parametros);
           // System.out.println("parametros cadena --> "+parametrosCad+" ambito: "+nombre);
            int cantParametros=evaluar_parametros_tamanho(parametros);
            //System.out.println("cantidad parametros --> "+cantParametros);
            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), -1, "metodo", "" , parametrosCad, cantParametros,parametros,eliminar);
//            evaluar_parametros_almacenar(nombre,parametros);
//            evaluar_rellenoFuncion(nombre,relleno);
            //System.out.println("funcion --> acceso: "+raiz.getHijoEn(0).getEtiqueta()+" nombre: "+raiz.getHijoEn(1).getEtiqueta()+" paraetros: "+raiz.getHijoEn(2).getEtiqueta()+" relleno: "+raiz.getHijoEn(3).getEtiqueta());
        }
        
        
        
        private void evaluar_funcion(String ambito,NodoArbol raiz,int eliminar) throws Exception{
            String retorno=raiz.getHijoEn(0).getEtiqueta();
            String nombre=raiz.getHijoEn(1).getEtiqueta();
            NodoArbol parametros=raiz.getHijoEn(2);
            NodoArbol relleno=raiz.getHijoEn(3);
            String parametrosCad=evaluar_parametros_cadena(parametros);
           // System.out.println("parametros cadena --> "+parametrosCad+" ambito: "+nombre);
            int cantParametros=evaluar_parametros_tamanho(parametros);
            
           // System.out.println("cantidad parametros --> "+cantParametros);
            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), -1, "funcion", retorno, parametrosCad, cantParametros,parametros,eliminar);
           // evaluar_parametros_almacenar(nombre,parametros);
           // evaluar_rellenoFuncion(nombre,relleno);
            //System.out.println("funcion --> acceso: "+raiz.getHijoEn(0).getEtiqueta()+" nombre: "+raiz.getHijoEn(1).getEtiqueta()+" paraetros: "+raiz.getHijoEn(2).getEtiqueta()+" relleno: "+raiz.getHijoEn(3).getEtiqueta());
        }
        
        private void evaluar_parametros_almacenar(String nombreFM,NodoArbol parametros)throws Exception{
           // System.out.println("funcion parametro -> "+parametros.getEtiqueta());
            if(parametros.getEtiqueta().equalsIgnoreCase("PARAMETROS")){
                parametros_almacen(nombreFM,parametros);
            } 
        }
        
        private void parametros_almacen(String ambito,NodoArbol raiz)throws Exception{
           // System.out.println("cantidad parametros --> "+raiz.getCantidadHijos());
            NodoArbol aux=null;
            String tDato="";
            String nombreVar="";
            for(int c=0;c<raiz.getCantidadHijos();c++){
                aux=raiz.getHijoEn(c);
                tDato=aux.getHijoEn(0).getEtiqueta();
                nombreVar=aux.getHijoEn(1).getEtiqueta();
                almacenar_parametros(nombreVar,null, ambito,"privado",c,"variable",tDato);
            }
        }
        
        private String evaluar_parametros_cadena(NodoArbol parametros){
            String parametro="";
            NodoArbol parametroE;
            int c=0;
            if(parametros.getEtiqueta().equalsIgnoreCase("vacio")){//no hago nada
            }else{
                
                while(c<parametros.getCantidadHijos()){
                    parametroE=parametros.getHijoEn(c);
                 //   System.out.println("parametrosE --> "+parametroE.getHijoEn(0).getEtiqueta());
                    parametro+=parametroE.getHijoEn(0).getEtiqueta()+"_";
                            c++;
                }
            }
            
            return parametro;
        }
        
        private int evaluar_parametros_tamanho(NodoArbol parametros){
            int tamanho=0;
            NodoArbol parametroE;
            int c=0;
            if(parametros.getEtiqueta().equalsIgnoreCase("vacio")){//no hago nada
            }else{
                
                while(c<parametros.getCantidadHijos()){
                    parametroE=parametros.getHijoEn(c);
                    tamanho+=1;
                            c++;
                }
            }
            
            return tamanho;
        }
        
           private void evaluar_rellenoFuncion(String ambito,NodoArbol relleno)throws Exception{
        int c=0;
        NodoArbol aux;
        NodoArbol aux1=null;
        String tipoDato="";
           //System.out.println("evaluar_relleno --> "+relleno.getEtiqueta());
        while(c<relleno.getCantidadHijos()){
            aux=relleno.getHijoEn(c);
            //System.out.println("EVALUAR RELLENO DE LA FUNCION --> "+ambito+","+aux.getEtiqueta());
            if(aux.getEtiqueta().equalsIgnoreCase("VARIABLE_SIMPLE")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                            tipoDato=aux.getHijoEn(0).getEtiqueta().toString();
//                           evaluar_variables_crear(ambito,"PRIVADO",tipoDato , aux.getHijoEn(1),"variable");
                    }
                }
               
            }else if(aux.getEtiqueta().equalsIgnoreCase("VARIABLE_COMPUESTA")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                      //  imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
                    }
                }
                
                        
            }
            
            
            else if(aux.getEtiqueta().equalsIgnoreCase("DECLARACION_VARIABLES")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                  //  evaluar_Variables_valor(aux, ambito);
                   int d=0;
                 String cadena;
                 NodoArbol temp=null;
                 String tDato="";
                 NodoArbol raizDeclaracion=aux;
                 String nombreVar="";
                 temp=raizDeclaracion.getHijoEn(0);
                 tDato=raizDeclaracion.getHijoEn(1).getHijoEn(0).getEtiqueta().toString();
                 tDato=tDato.toLowerCase();
                        
                 for(d=0;d<temp.getCantidadHijos();d++){
                     
                     nombreVar=temp.getHijoEn(d).getEtiqueta().toString();
                     nombreVar=nombreVar.toLowerCase();
                     //System.out.println(nombreVar+" "+ambito);
                     almacenar_parametros(nombreVar,null,ambito,"privado",0,"variable",tDato);
                 }
                    }
                }
                   
            }
            //REPEAT_UNTIL 
            else if(aux.getEtiqueta().equalsIgnoreCase("REPEAT_UNTIL")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    //evaluar_repeat_until(aux, ambito);
                  
                    }
                }
               
            }
            //FOR
            else if(aux.getEtiqueta().equalsIgnoreCase("FOR")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                   // evaluar_paraNormal(aux, ambito);
                    }
                }
               
            }
            //LOOP
            else if(aux.getEtiqueta().equalsIgnoreCase("LOOP")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    //evaluar_loop(aux, ambito);
                 
                    }
                }
                
            }
            //DO WHILE
            else if(aux.getEtiqueta().equalsIgnoreCase("DO_WHILE")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                   // evaluar_doWhileNormal(aux,ambito);   
                    }
                }
               
            }
            //INTERRUPTOR
            else if(aux.getEtiqueta().equalsIgnoreCase("SWITCH")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                    Object valorComparar=evaluar_op(aux.getHijoEn(0), ambito);
//                    evaluar_interruptorNormal(aux.getHijoEn(1), ambito,valorComparar);
                    }
                }
               
            }
            //MIENTRAS
            else if(aux.getEtiqueta().equalsIgnoreCase("WHILE")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                    evaluar_MientrasNormal(aux,ambito);
                    }
                }
                
            }
            //SI
            else if(aux.getEtiqueta().equalsIgnoreCase("IF")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                    evaluar_siNormal(aux,ambito);
                    }
                }
              
            }
            //disp
            else if(aux.getEtiqueta().equalsIgnoreCase("IMPRIMIR")){
              
                if(0==getSalir()){
                    if(0==getContinuar()){
//                          Object hola=evaluar_op(aux.getHijoEn(0), ambito);
//                           String ho=(String)hola.toString();
//                         imprimirConsola(ho);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("ASIGNACION_VARIABLE")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                        evaluar_asignacion(aux, ambito);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("BREAK")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                        setSalir(1);
                    }
                    
                }
                
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("CONTINUAR")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                        //setContinuar(1);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("RETORNO")){
                  if(0==getSalir()){
                    
                      if(0==getContinuar()){
//                 
//                 Object valo=null;//evaluar_op(aux.getHijoEn(0), ambito);
//                 String tipo=getTipoRetorno();
//                 tipo=tipo.toLowerCase();
//                 Object existe=buscarVariable("retorno", ambito);
//                        if(existe!=null){
//                            valo=evaluar_op(aux.getHijoEn(0), ambito);
//                        }else{
//                            almacenar_parametros("retorno",aux.getHijoEn(0),ambito,"privado",0,"variable",gettDatoF());         
//                           setComprobarRetorno(1);
//                            setSalir(1);
//                            }
//                          
//                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
//                        if(existe!=null){
//                            modificarAsignacion("retorno", valo, ambito);
//                        }else{
//                                                      
//                            }
//                        
//                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
//                          if(existe!=null){
//                            modificarAsignacion("retorno", valo, ambito);
//                        }else{
//                           
//                            
//                            }
//                    }else if((tipo.equalsIgnoreCase("string") && (valo instanceof String))){
//                         if(existe!=null){
//                            modificarAsignacion("retorno", valo, ambito);
//                        }else{
//                           
//                            
//                            }
//                    }else if((tipo.equalsIgnoreCase("char")&& (valo instanceof Character))){
//                          if(existe!=null){
//                            modificarAsignacion("retorno", valo, ambito);
//                        }else{
//                            
//                            
//                            }
//                    }else if((tipo.equalsIgnoreCase("bool")&& (valo instanceof Boolean))){
//                         if(existe!=null){
//                            modificarAsignacion("retorno", valo, ambito);
//                        }else{
//                           
//                            
//                            
//                            }
//                    }else{
//                       // imprimirConsola("EL TIPO DE DATO EN EL RETORNO NO ES VALIDO EN LA FUNCION "+ambito);
//                    }
                  }
                  }
            }
             else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_CONSTRUCTOR_CON_PARAMETROS")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                        if(1==getValidacionSuper()){
//                            JOptionPane.showConfirmDialog(null, "me falta terminarlo", "super", JOptionPane.INFORMATION_MESSAGE);
//                        }else{
//                            imprimirConsola("NO PUEDE EXISTIR LA PALABRA SUPER YA QUE NO ES UNA CLASE EXTENDIDA");
//                        }
                    }
                }
            }else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_CONSTRUCTOR_SIN_PARAMETROS")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                        if(1==getValidacionSuper()){
//                            JOptionPane.showConfirmDialog(null, "me falta terminarlo", "super", JOptionPane.INFORMATION_MESSAGE);
//                        }else{
//                            imprimirConsola("NO PUEDE EXISTIR LA PALABRA SUPER YA QUE NO ES UNA CLASE EXTENDIDA");
//                        }
                    }
                }
            }
            
           
            c++;
        }
        
        
    }
    
        private void compilar(String path){                 
        String sentence = getTexto(path);//txtEntrada.getText();
        NodoArbol arbol;
        InputStream is = new ByteArrayInputStream(sentence.getBytes());
        if(calc == null) calc = new Analizador1.proyecto(is);
        else calc.ReInit(is);
        try
        {
            Graphviz di=new Graphviz();
            arbol=calc.Programa();
//            di.dibujarArbol(arbol);
            Acciones_Semanticas pasada1=new Acciones_Semanticas();
           // pasada1.setTablaSimbolos(getTablaSimbolos());
            pasada1.evaluar_arbol(arbol,1);
            setTablaSimbolos(pasada1.getTablaSimbolos());
        }
        catch (Exception e)
        {
            //txtAreaOut.setText("error in expression.\n"+ e.getMessage());
            System.out.println("Error en expresion.\n"+e.getMessage());
        }
        catch (Error e)
        {
            //txtAreaOut.setText("error in expression.\n"+ e.getMessage());
            System.out.println("Error en expresion.\n"+e.getMessage());
        }
        finally
        {}       

            }
        
         private String getTexto(String patito){

FileReader arcticMonkeys = null; //Lector.
BufferedReader coldplay = null; //Buffer.
String arcadeFire = ""; //Texto leído.
String brightEyes = ""; //Path
String cadena="";
 //limpio la caja de texto.
//edicion.setEditable(true); //permito que el usuario la pueda editar.

try { //INICIO TRY
brightEyes = patito;//franzFerdinand.getSelectedFile().getAbsolutePath(); //Obtengo path.

if(new File(brightEyes).exists()) { //Verifico si el fichero existe.


arcticMonkeys = new FileReader(brightEyes/*animalCollective*/); //Leera el fichero.
coldplay = new BufferedReader(arcticMonkeys); //Almacenara contenido de fichero.

try { //INICIO TRY

while((arcadeFire = coldplay.readLine())!=null) //Leo linea por linea.
{ //INICIO WHILE
cadena+=arcadeFire+"\n";
} //FIN WHILE
} //FIN TRY

catch (IOException ex)
{ //INICIO CATCH
//Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex); //Manejo de excepciones.
} // FIN CATCH
} //FIN IF

else
{ //INICIO ELSE
    System.out.println("El archivo seleccionado puede estar dañado");
    //JOptionPane.showMessageDialog("", "El archivo seleccionado puede estar dañado", "Error en lectura", JOptionPane.ERROR_MESSAGE); //Mensaje por si se prduce un error
} // FIN ELSE

} //FIN TRY

catch (FileNotFoundException ex)
{ //INICIO CATCH
//Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex); //Manejo de excepciones.
} //FIN CATCH

finally { //INICIO FINALLY

try { //INICIO TRY
if (null != coldplay) //Validación archivo.
coldplay.close(); //Cerrar archivo.
} //FIN TRY

catch (IOException ex)
{ //INICIO CATCH
//Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex); //Manejo de excepciones.
} //FIN CATCH

} //FIN FINALLY
return cadena;
}

       private String acceso(NodoArbol raiz)throws Exception{
           NodoArbol aux;
           aux=raiz.getHijoEn(0);
           return aux.getEtiqueta();
       }


        private static void Error(int linea,int columna,String tipoError, String descripcion) throws Exception{ 
                pruebasLienzo.imprimirConsola(linea,columna,tipoError,descripcion);
            }

        private void almacenar_variable(String nombreVar,Object val,String ambit,String acceso,String tipo,String tDato,String ubicacion,int eliminar) throws Exception{//falta implementar el conservar asi para que sea unico
         
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
         
             if (tablaSimbolos.size() == 0)
                {
                    tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,-1,tipo,tDato,getHeredado(),getPrioridad(),ubicacion));
                }
                else
                {
                    for (contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(contFor).ambito.equalsIgnoreCase(ambit)&& tablaSimbolos.get(contFor).ubicacion.equalsIgnoreCase(ubicacion) )
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
                        //imprimirConsola("Error semantico ya existe la variable "+nombreVar+"");
               //        Console.WriteLine("ya existe la variable " + nombreVar);
                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
                         tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,-1,tipo,tDato,getHeredado(),getPrioridad(),ubicacion));
                    }
            }
    }
      
      
         private void almacenar_parametros(String nombreVar,Object val,String ambit,String acceso,int pos,String tipo,String tDato) throws Exception{
         retornoExistenciaVariable = 0;
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
             if (tablaSimbolos.size() == 0)
                {
                    tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,pos,tipo,tDato,getHeredado(),getPrioridad(),"local"));
                     
                }
                else
                {
                    for (contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(contFor).ambito.equalsIgnoreCase(ambit))
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
                       
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
                         tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,pos,tipo,tDato,getHeredado(),getPrioridad(),"local"));
                    }
            }

    }
      
       
         private void almacenar_metodo_funcion(String nombreVar,Object val,String ambit,String acceso,int pos,String tipo,String tDato,String parametro,int tamanho,NodoArbol parametros,int eliminar)throws Exception{//falta implementar el conservar asi unico
         retornoExistenciaVariable = 0;
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
         tipo=tipo.toLowerCase();
             if (tablaSimbolos.isEmpty())
                {
                    tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,pos,tipo,tDato, parametro, tamanho,getHeredado(),getPrioridad(),parametros));
                     
                }
                else
                {
                    for (contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombreVar) && (tablaSimbolos.get(contFor).tamanho==tamanho) && (tablaSimbolos.get(contFor).parametros.equalsIgnoreCase(parametro)))
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
               
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);   
                         tablaSimbolos.add(new Nodo_variable(nombreVar,val,ambit,acceso,pos,tipo,tDato, parametro, tamanho,getHeredado(),getPrioridad(),parametros));
                    }
            }

    }
       
}//no tocar
