/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DibujarFigura.*;
import arbol.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import DibujarFigura.*;
/**
 *
 * @author Alberth
 */
public class Acciones_Semanticas2 {

    //INICIA TABLA DE SIMBOLOS
    ArrayList<Nodo_variable> tablaSimbolos;
    ArrayList<Nodo_variable> tablaSimbolosTemporal;
    int retornoExistenciaVariable=0;
    //FINALIZA TABLA DE SIMBOLOS
    private int salir=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    private int continuar=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    private int heredado=0;//0= indica que puede almacenar el main, 1 indica que es extendida y no almacena el main
    private String tipoAcceso="";//publico,protegido, privado no existe ya que no pueden acceder a ese lienzo
    private int prioridad=0;//0 indica que no tiene prioridad,1 indica que tiene prioridad sobre metodo,funcion,variable,arreglo
    private int pasada2=0;//2 indica que es la segunda pasada
    private String tDatoFuncion="";//va a obtener el tipo de dato que tiene que retornar la funcion
    private int comprobarRetorno=0;//0=indica que no viene ningun retorno y 1=indica que viene un retorno

    public int getComprobarRetorno() {
        return comprobarRetorno;
    }

    public void setComprobarRetorno(int comprobarRetorno) {
        this.comprobarRetorno = comprobarRetorno;
    }
    
    private String gettDatoFuncion() {
        return tDatoFuncion;
    }

    private void settDatoFuncion(String tDatoFuncion) {
        this.tDatoFuncion = tDatoFuncion;
    }
    
    private int getPasada2() {
        return pasada2;
    }

    private void setPasada2(int pasada2) {
        this.pasada2 = pasada2;
    }
    
    
    
    public ArrayList<Nodo_variable> getTablaSimbolosTemporal() {
        return tablaSimbolosTemporal;
    }

    public void setTablaSimbolosTemporal(ArrayList<Nodo_variable> tablaSimbolo) {
        for(int cont=0;cont<tablaSimbolo.size();cont++){
                       tablaSimbolosTemporal.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
        }
    }
    
    
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
        for(int cont=0;cont<tablaSimbolo.size();cont++){
                        tablaSimbolos.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
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
    
    public Acciones_Semanticas2(){
        tablaSimbolos=new ArrayList<>();
        tablaSimbolosTemporal=new ArrayList<>();
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
                accion=aux.getEtiqueta();
                accion=accion.toLowerCase();
                switch(accion){
                    case "conserva":
                            setPrioridad(1);
                            evaluar_conserva(ambito,aux,1);
                        break;
                    case "declaracion":
                        setPrioridad(0);
                         setPasada2(2);
                        evaluar_declaracion(ambito,aux,"GLOBAL",0);
                        break;
                    case "funcion":
                            setPrioridad(0);
                            setPasada2(2);
                           // System.out.println("funcion tabla simbolos --> "+aux.getEtiqueta());
                            evaluar_funcion(ambito,aux,0);
                        break;
                    case "metodo":
                            setPrioridad(0);
                            setPasada2(2);
                            evaluar_metodo(ambito,aux,0);
                        break;
                    case "main":
                            setPrioridad(0);
                        if(getHeredado()==0){//va a almacenar el main
                            boolean existe=false;
                            existe=verificar_funcion_metodo_variable_arreglo("main","principal",-1, "", getAmbito(), accion);
//                            System.out.println("existe sisi--> "+existe);
                            if(existe==true){
                                almacenar_metodo_funcion("main", null, getAmbito(), "publico", -1, "principal", "", "", 0, null, 0);
                               // setPrioridad(0);
                                setPasada2(1);
//                                System.out.println("pasada2--> "+getPasada2());
                                evaluar_rellenoFuncion("principal", aux.getHijoEn(0));
                                setPasada2(2);
                            }
                            
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
                setPasada2(2);
                evaluar_funcion(ambito,aux,eliminar);
            }else if(aux.getEtiqueta().equalsIgnoreCase("metodo")){
                //System.out.println("metodo "+ambito);
                setPasada2(2);
                evaluar_metodo(ambito,aux,eliminar);
            }else if(aux.getEtiqueta().equalsIgnoreCase("declaracion")){
                //System.out.println("declaracion "+ambito);
                setPasada2(2);
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
                if(tipo.equalsIgnoreCase("vacio")){
                    
                }else{
                    evaluar_variable(ambito,tipo,aux,ubicacion,eliminar);
                }
            }else{//lista de arreglos
                
            }
        }
        
        private void evaluar_variable(String ambito,String tipo,NodoArbol raiz,String ubicacion,int eliminar) throws Exception{
            //System.out.println("Cantidad variables --> "+raiz.getCantidadHijos()+" de tipo "+tipo);
            String nombreVar="";
            NodoArbol aux=null;
            int cantH=0;
            Boolean existe=false;
            for(int c=0;c<raiz.getCantidadHijos();c++){
                aux=raiz.getHijoEn(c);
                cantH=aux.getCantidadHijos();
                if(cantH==1){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                    if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombreVar,"variable",0,"",getAmbito(),"GLOBAL");
                        if(existe==true){
                            almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                        }
                    }else if(getPasada2()==1){
                        almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                    }
                   
                }else if(cantH==2){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                   if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombreVar,"variable",0,"",getAmbito(),"GLOBAL");
                        if(existe==true){
                            almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                        }
                    }else if(getPasada2()==1){
                        almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                    }
                }
            }
          }
        
        
        
        private boolean verificar_funcion_metodo_variable_arreglo(String nombre,String tipo,int tamanho,String parametro,String ambito,String ubicacion){
        boolean existe=false;
            try{
                //System.out.println("tamaño de tabla temporal --> "+tablaSimbolosTemporal.size());
            if(tipo.equalsIgnoreCase("variable")){
                 for (int contFor = 0; contFor < tablaSimbolosTemporal.size(); contFor++)
                    {
                        if (tablaSimbolosTemporal.get(contFor).nombre.equalsIgnoreCase(nombre) && tablaSimbolosTemporal.get(contFor).ambito.equalsIgnoreCase(ambito)&& tablaSimbolosTemporal.get(contFor).ubicacion.equalsIgnoreCase(ubicacion) )
                        {
                            existe=true;
                            contFor=tablaSimbolosTemporal.size();
                        }
                    }
            }else if(tipo.equalsIgnoreCase("metodo") || tipo.equalsIgnoreCase("funcion")){
                 for (int contFor = 0; contFor < tablaSimbolosTemporal.size(); contFor++)
                    {
                        if (tablaSimbolosTemporal.get(contFor).nombre.equalsIgnoreCase(nombre) && (tablaSimbolosTemporal.get(contFor).tamanho==tamanho) && (tablaSimbolosTemporal.get(contFor).parametros.equalsIgnoreCase(parametro)&& tablaSimbolosTemporal.get(contFor).ambito.equalsIgnoreCase(ambito)))
                        {
                            existe=true;
                            contFor=tablaSimbolosTemporal.size();
                        }
                    }
            }else if(nombre.equalsIgnoreCase("main") ){
               // System.out.println("entro a verificar main");
                 for (int contFor = 0; contFor < tablaSimbolosTemporal.size(); contFor++)
                    {
                        if (tablaSimbolosTemporal.get(contFor).nombre.equalsIgnoreCase("main"))
                        {
                            existe=true;
                            contFor=tablaSimbolosTemporal.size();
                        }
                    }
            }else if(tipo.equalsIgnoreCase("arreglo")){
                System.err.println("falta arreglos en VERIFICAR_FUNCION_METODO_VARIABLE_ARREGLO");
            }
        }catch (Exception er){
            System.out.println("ocurrio un problema en verificar");
        }
            return existe;
        }
        
        private void evaluar_metodo(String ambito,NodoArbol raiz,int eliminar) throws Exception{
           // String retorno=raiz.getHijoEn(0).getEtiqueta();
            String nombre=raiz.getHijoEn(0).getEtiqueta();
            NodoArbol parametros=raiz.getHijoEn(1);
            NodoArbol relleno=raiz.getHijoEn(2);
            String parametrosCad=evaluar_parametros_cadena(parametros);
           // System.out.println("parametros cadena --> "+parametrosCad+" ambito: "+nombre);
            int cantParametros=evaluar_parametros_tamanho(parametros);
           // System.out.println("cantidad parametros --> "+cantParametros);
            boolean existe=false;
                    if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombre,"funcion",cantParametros,parametrosCad,getAmbito(),"");
                       // System.out.println("existe --> "+existe);
                        if(existe==true){
                            setPasada2(1);
                            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "metodo", "" , parametrosCad, cantParametros,parametros,eliminar);
                            evaluar_parametros_almacenar(nombre, parametros);
                            evaluar_rellenoFuncion(nombre,relleno);
                            setPasada2(2);
                        }
                    }else if(getPasada2()==1){
                        almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "metodo", "" , parametrosCad, cantParametros,parametros,eliminar);
                        evaluar_parametros_almacenar(nombre, parametros);
                        evaluar_rellenoFuncion(nombre,relleno);
                    }
//            evaluar_parametros_almacenar(nombre,parametros);
//            evaluar_rellenoFuncion(nombre,relleno);
            //System.out.println("funcion --> acceso: "+raiz.getHijoEn(0).getEtiqueta()+" nombre: "+raiz.getHijoEn(1).getEtiqueta()+" paraetros: "+raiz.getHijoEn(2).getEtiqueta()+" relleno: "+raiz.getHijoEn(3).getEtiqueta());
        }
        
        
        
        private void evaluar_funcion(String ambito,NodoArbol raiz,int eliminar) throws Exception{
            String retorno=raiz.getHijoEn(0).getEtiqueta();
            settDatoFuncion(retorno);
            String nombre=raiz.getHijoEn(1).getEtiqueta();
            NodoArbol parametros=raiz.getHijoEn(2);
            NodoArbol relleno=raiz.getHijoEn(3);
            String parametrosCad=evaluar_parametros_cadena(parametros);
           // System.out.println("parametros cadena --> "+parametrosCad+" ambito: "+nombre);
            int cantParametros=evaluar_parametros_tamanho(parametros);
            boolean existe=false;
            
                    if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombre,"funcion",cantParametros,parametrosCad,getAmbito(),"");
//                        System.out.println("existe --> "+existe);
                        if(existe==true){
                            setPasada2(1);
                            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "funcion", retorno, parametrosCad, cantParametros,parametros,eliminar);
                            evaluar_parametros_almacenar(nombre, parametros);
                            evaluar_rellenoFuncion(nombre,relleno);
                            if(getComprobarRetorno()==0){
                                Error(parametros.getLinea(),parametros.getColumna(),"Error Semantico","No viene retorno para la funcion "+nombre );
                            }
                            setPasada2(2);
                        }
                    }else if(getPasada2()==1){
                        almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "funcion", retorno, parametrosCad, cantParametros,parametros,eliminar);
                        evaluar_parametros_almacenar(nombre, parametros);
                        evaluar_rellenoFuncion(nombre,relleno);
                    }
            
           // System.out.println("cantidad parametros --> "+cantParametros);
            
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
    private void evaluar_doWhileNormal(NodoArbol aux,String ambito) throws Exception{
    setSalir(0);
    evaluar_rellenoFuncion( ambito,aux.getHijoEn(0));
    //                        Object valor=evaluar_op(aux.getHijoEn(1),ambito);
    //System.out.println("OP DO_MIENTRAS --> "+valor);

    //                int conta=0;
    //                if(valor instanceof Integer){
    //                    int oP=(int)valor;
    //                    boolean co=false;
    //                    
    //                    if(oP==1){
    //                        co=true;
    //                    }else{
    //                        co=false;
    //                    }
    //                         while(co==true){
    //                                evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
    //                                valor=evaluar_op(aux.getHijoEn(1),ambito);
    //                                oP=(int)valor;
    //                                 if(oP==1){
    //                                    co=true;
    //                                  }else{
    //                                     co=false;
    //                                 }
    //                                 if(1==getSalir()){
    //                                     co=false;
    //                                 }
    //                                //System.out.println("do_mientras --> "+conta);
    //                                setContinuar(0);
    //                                conta++;
    //                        }
    //                    
    //                }else if(valor instanceof Boolean){
    //                    boolean op=(boolean)valor;
    //                    while(op==true){
    //                        evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
    //                        valor=evaluar_op(aux.getHijoEn(1),ambito);
    //                        op=(boolean)valor;
    //                        if(1==getSalir()){
    //                                     op=false;
    //                                 }
    //                        //System.out.println("do_mientras --> "+conta);
    //                        setContinuar(0);
    //                                conta++;
    //                    }
    //                    
    //                }else{
    //                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
    //                    imprimirConsola("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
    //                }
    setSalir(0);
    }
    private void evaluar_paraNormal(NodoArbol aux,String ambito)throws Exception{
    setSalir(0);
    //        evaluar_asignacion(aux.getHijoEn(0), ambito);//por fuerza viene una asignacion
    //        Object valor=null;//por fuerza viene un OP
    //        String var=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
    //         Object valVar=null;
    //         valVar=buscarVariable(var, ambito);
    //         Object comparacion=evaluar_op(aux.getHijoEn(1), ambito);
    //         Object step=null;
    //         //imprimirConsola(""+comparacion);
    //         
    //         if(comparacion instanceof Integer){
    //             int a=(int)valVar;
    //             int b=(int)comparacion;
    //             int co=0;
    //             if(a<b){
    //                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
    //                     while(a<b){
            evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
    //                        valVar=buscarVariable(var, ambito);
    //                        a=(int)valVar;
    //                        valor=a+1;
    //                        modificarAsignacion(var, valor, ambito);
    //                        
    //                     }
    //                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
    //                     while(a<b){
    //                         evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
    //                        valVar=buscarVariable(var, ambito);
    //                        a=(int)valVar;
    //                        step=evaluar_op(aux.getHijoEn(2).getHijoEn(0), ambito);
    //                        co=(int)step;
    //                        valor=a+co;
    //                        modificarAsignacion(var, valor, ambito);
    //                        
    //                     }
    //                 }
    //             }else if(a>b){
    //                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
    //                      while(a>b){
    //                       evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
    //                        valVar=buscarVariable(var, ambito);
    //                        a=(int)valVar;
    //                        valor=a-1;
    //                        modificarAsignacion(var, valor, ambito);
    //                        
    //                     }
    //                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
    //                     while(a>b){
    //                         evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
    //                        valVar=buscarVariable(var, ambito);
    //                        a=(int)valVar;
    //                        step=evaluar_op(aux.getHijoEn(2).getHijoEn(0), ambito);
    //                        co=(int)step;
    //                        valor=a+co;
    //                        modificarAsignacion(var, valor, ambito);
    //                        
    //                     }
    //                 }
    //             }else if(a==b){
    //                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
    //                     
    //                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
    //                     while(a==b){
    //                         
    //                     }
    //                 }
    //             }
    //         }else{
    //             imprimirConsola("Error semantico, el valor ingresado en el FOR no es de tipo entero "+comparacion);
    //         }
    setSalir(0);
    }
    private void evaluar_interruptorNormal(NodoArbol aux,String ambito,Object valorComp)throws Exception{
    //System.out.println("switch pos0 --> "+valorComp);
    //System.out.println("switch pos1 --> "+aux.getEtiqueta());
    setSalir(0);
    NodoArbol temp;
    int c=0;
    //        Object valorComparar=null;
    //        int op1=0;
    //        int op2=0;
    //          
    while(c<aux.getCantidadHijos()){
    temp=aux.getHijoEn(c);
    if(temp.getEtiqueta().equalsIgnoreCase("CASO")){
    //                valorComparar=evaluar_op(temp.getHijoEn(0), ambito);
    //                //System.out.println("switch caso valor --> "+valorComparar);
    //                if((valorComp instanceof Integer) && (valorComparar instanceof Integer)){
    //                    op1=(int)valorComp;
    //                    op2=(int)valorComparar;
    //                    
    //                    if(op1==op2){
            evaluar_rellenoFuncion( ambito,temp.getHijoEn(1));
    //                    }
    //                }
    //                
    }else if(temp.getEtiqueta().equalsIgnoreCase("DEFAULT")){
                evaluar_rellenoFuncion( ambito,temp.getHijoEn(0));
    }
    //            
    //            
    c++;
    }
    setSalir(0);
    }
    private void evaluar_MientrasNormal(NodoArbol aux,String ambito)throws Exception{
        setSalir(0);
//                Object valor=evaluar_op(aux.getHijoEn(0),ambito);
//                //System.out.println("OP MIENTRAS --> "+valor);
//                //evaluar_rellenoFuncion(aux.getHijoEn(1), ambito);
//                int conta=0;
//                if(valor instanceof Integer){
//                    int oP=(int)valor;
//                    boolean co=false;
//                    
//                    if(oP==1){
//                        co=true;
//                    }else{
//                        co=false;
//                    }
//                         while(co==true){
                                evaluar_rellenoFuncion(ambito,aux.getHijoEn(1));
//                                valor=evaluar_op(aux.getHijoEn(0),ambito);
//                                oP=(int)valor;
//                                 if(oP==1){
//                                    co=true;
//                                  }else{
//                                     co=false;
//                                 }
//                                 
//                                 if(1==getSalir()){
//                                     co=false;
//                                 }
//                              //  System.out.println("mientras --> "+conta);
//                               setContinuar(0);
//                                conta++;
//                        }
//                    
//                }else if(valor instanceof Boolean){
//                    boolean op=(boolean)valor;
//                    while(op==true){
//                       // System.out.println("mientras tutu -->"+aux.getHijoEn(1).getEtiqueta());
//                        evaluar_rellenoFuncion(ambito,aux.getHijoEn(1));
//                        valor=evaluar_op(aux.getHijoEn(0),ambito);
//                        op=(boolean)valor;
//                       
//                      //  //System.out.println("mientras --> "+conta);
//                                if(1==getSalir()){
//                                     op=false;
//                                 }
//                                setContinuar(0);
//                                conta++;
//                    }
//                    
//                }else{
//                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
//                    imprimirConsola("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
//                }
               setSalir(0);
    }
    private void evaluar_siNormal(NodoArbol aux,String ambito)throws Exception{
             String cantS="";
             cantS=aux.getHijoEn(2).getEtiqueta();
//            Object valor=evaluar_op(aux.getHijoEn(0),ambito);
//                if((valor instanceof Boolean)){
//                    boolean cond=(boolean)valor;
//                    
//                    if(cond==true){
             if(cantS.equalsIgnoreCase("vacio")){
                 evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
             }else  if(cantS.equalsIgnoreCase("sino")){
                 evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
                 evaluar_Else_If(aux.getHijoEn(2), ambito);
             }
                        
                       
//                    }else{
//                        String siOp=aux.getHijoEn(2).getEtiqueta();
//                        NodoArbol temp=aux.getHijoEn(2);
//                        if(siOp.equalsIgnoreCase("ELSE_IF")){
//                               int c=0;
//                               while(c<temp.getCantidadHijos()){
//                                   if(true==evaluar_Else_If(temp.getHijoEn(c),ambito)){
//                                       c=temp.getCantidadHijos();
//                                   }else{
//                                        c++;
//                                   }
//                               }
//                           // evaluar_rellenoFuncion( ambito,temp);
//                        }else if(siOp.equalsIgnoreCase("ELSE")){
//                            evaluar_rellenoFuncion(ambito,temp.getHijoEn(0));
//                        }
//                        
//                    }
                 
                 
//                }else if((valor instanceof Integer)){
//                      int cond=(int)valor;
//                    
//                    if(cond==1){                        
//                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
//                       
//                    }else if(cond==0){
//                        String siOp=aux.getHijoEn(2).getEtiqueta();
//                        NodoArbol temp=aux.getHijoEn(2);
//                        if(siOp.equalsIgnoreCase("ELSE_IF")){
//                           // evaluar_rellenoFuncion(ambito,temp);
//                           int c=0;
//                               while(c<temp.getCantidadHijos()){
//                                   
//                                   if(true==evaluar_Else_If(temp.getHijoEn(c),ambito)){
//                                       c=temp.getCantidadHijos();
//                                   }else{
//                                        c++;
//                                   }
//                                  
//                               }
//                            
//                        }else if(siOp.equalsIgnoreCase("ELSE")){
//                            evaluar_rellenoFuncion( ambito,temp.getHijoEn(0));
//                            
//                        }
//                        
//                    }else{
//                         //System.out.println("error semantico en SI, se requiere una expresion booleana");
//                         imprimirConsola("error semantico en SI, se requiere una expresion booleana");
//                    }
//                }else{
//                    //System.out.println("error semantico en SI, se requiere expresion booleana");
//                    imprimirConsola("error semantico en SI, se requiere una expresion booleana");
//                }
//                
    }
    private boolean evaluar_Else_If(NodoArbol aux,String ambito)throws Exception{
           boolean res=false;
        
//                    if(0==getContinuar()){
//                        //System.out.println("evaluar_else_if --> "+aux.getEtiqueta()+" cant hijos --> "+aux.getCantidadHijos());
//            Object valor=evaluar_op(aux.getHijoEn(0),ambito);
//            //System.out.println("evaluar_else_if --> "+aux.getEtiqueta()+" "+valor.toString());
//                if((valor instanceof Boolean)){
//                    boolean cond=(boolean)valor;
//                    
//                    if(cond==true){
                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(0));
//                        res=true;
//                    }
//                 
//                 
//                }else if((valor instanceof Integer)){
//                      int cond=(int)valor;
//                    
//                    if(cond==1){                        
//                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
//                        res=true;
//                    }else{
//                         //System.out.println("error semantico en SI, se requiere una expresion booleana");
//                         imprimirConsola("error semantico en ELSE:IF, se requiere una expresion booleana");
//                    }
//                }else{
//                    //System.out.println("error semantico en SI, se requiere expresion booleana");
//                    imprimirConsola("error semantico en ELSE_IF, se requiere una expresion booleana");
//                }
//                
//                    }
                
               return res;
    }
       
    
    
   private void evaluar_rellenoFuncion(String ambito,NodoArbol relleno)throws Exception{
        int c=0;
        NodoArbol aux;
        NodoArbol aux1=null;
        String tipoDato="";
          // System.out.println("evaluar_relleno --> "+relleno.getEtiqueta()+" ambito "+ambito);
        while(c<relleno.getCantidadHijos()){
            aux=relleno.getHijoEn(c);
//            System.out.println("EVALUAR RELLENO DE LA FUNCION --> "+ambito+","+aux.getEtiqueta());
            if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_PUNTO")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                            tipoDato=aux.getHijoEn(0).getEtiqueta().toString();
//                           evaluar_variables_crear(ambito,"PRIVADO",tipoDato , aux.getHijoEn(1),"variable");
                    }
                }
               
            }if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_OR")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                            tipoDato=aux.getHijoEn(0).getEtiqueta().toString();
//                           evaluar_variables_crear(ambito,"PRIVADO",tipoDato , aux.getHijoEn(1),"variable");
                    }
                }
               
            }else if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_CADENA")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                      //  imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
                    }
                }
                
                        
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("ORDENAR")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                      //  imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
                    }
                }
                
                        
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("SUMARIZAR")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                      //  imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
                    }
                }
                
                        
            }
            
            
            else if(aux.getEtiqueta().equalsIgnoreCase("DECLARACION")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                        evaluar_declaracion(ambito,aux,"LOCAL",0);
                    }
                }
                   
            }
            
            //FOR
            else if(aux.getEtiqueta().equalsIgnoreCase("FOR")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    evaluar_paraNormal(aux, ambito);
                    }
                }
               
            }
            
            //DO WHILE
            else if(aux.getEtiqueta().equalsIgnoreCase("DO_WHILE")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    evaluar_doWhileNormal(aux,ambito);   
                    }
                }
               
            }
            //INTERRUPTOR
            else if(aux.getEtiqueta().equalsIgnoreCase("SWITCH")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                    Object valorComparar=evaluar_op(aux.getHijoEn(0), ambito);
                    evaluar_interruptorNormal(aux.getHijoEn(1), ambito,null);
                    }
                }
               
            }
            //MIENTRAS
            else if(aux.getEtiqueta().equalsIgnoreCase("WHILE")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    evaluar_MientrasNormal(aux,ambito);
                    }
                }
                
            }
            //SI
            else if(aux.getEtiqueta().equalsIgnoreCase("IF")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    evaluar_siNormal(aux,ambito);
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
            else if(aux.getEtiqueta().equalsIgnoreCase("ASIGNACION")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                        evaluar_asignacion(aux, ambito);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("BREAK")){
                if(0==getSalir()){
                    if(0==getContinuar()){
//                        setSalir(1);
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
                          almacenar_variable("retorno",aux.getHijoEn(0),ambito,getTipoAcceso(),"variable",gettDatoFuncion(),"local",0);
//                 Object valo=null;//evaluar_op(aux.getHijoEn(0), ambito);
//                 String tipo=getTipoRetorno();
//                 tipo=tipo.toLowerCase();
//                 Object existe=buscarVariable("retorno", ambito);
//                        if(existe!=null){
//                            valo=evaluar_op(aux.getHijoEn(0), ambito);
//                        }else{
//                            almacenar_parametros("retorno",aux.getHijoEn(0),ambito,"privado",0,"variable",gettDatoF());         
                           setComprobarRetorno(1);
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
//            Acciones_Semanticas pasada1=new Acciones_Semanticas();
//            pasada1.evaluar_arbol(arbol,1);
//            setTablaSimbolos(pasada1.getTablaSimbolos());
            
            Acciones_Semanticas2 pasada2=new Acciones_Semanticas2(); 
            pasada2.setTablaSimbolosTemporal(getTablaSimbolosTemporal());
            pasada2.evaluar_arbol(arbol,1);
//            tablaSimbolos.clear();
            setTablaSimbolos(pasada2.getTablaSimbolos());
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
         ubicacion=ubicacion.toLowerCase();
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
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(contFor).ambito.equalsIgnoreCase(ambit) &&  tablaSimbolos.get(contFor).tDato.equalsIgnoreCase(tDato))
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
