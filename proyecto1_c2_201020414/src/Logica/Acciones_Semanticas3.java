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
import DibujarFigura.LienzoDibujo.Lienzo;

/**
 *
 * @author Alberth
 */
public class Acciones_Semanticas3 {
    //-------------LO UTILIZADO PARA GRAFICAR----------------------
        LienzoDibujo lienzo ;
        
//        lienzo.dibujarOvalo(100, 100,50,100,"BA3519", 1);
//        lienzo.dibujarRectangulo(200, 200,50,100,"BA3519", 1);
//        lienzo.dibujarTexto("holita",100, 100,"BA3519");
//        lienzo.dibujarPunto(300, 300,"BA3519",50, 1);
//        lienzo.setVisible(true);
        //---------TERMINA LO UTILIZADO PARA DIBUJAR--------
    
    
    
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
    private int variableEncontrada=0;//0=indica que no existe una variable con ese nombre, 1=indica que existe una variable con ese nombre
    private String ambitoAuxMetodo="";//lleva el nombre de la clase en la cual se encuentra el metodo en este caso ambito

    public String getAmbitoAuxMetodo() {
        return ambitoAuxMetodo;
    }

    public void setAmbitoAuxMetodo(String ambitoAuxMetodo) {
        this.ambitoAuxMetodo = ambitoAuxMetodo;
    }
    public int getVariableEncontrada() {
        return variableEncontrada;
    }

    public void setVariableEncontrada(int variableEncontrada) {
        this.variableEncontrada = variableEncontrada;
    }
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
       ArrayList<Nodo_variable> tablaT=new ArrayList<>();
        for(int cont=0;cont<tablaSimbolo.size();cont++){
                        tablaSimbolos.add(new Nodo_variable(tablaSimbolo.get(cont).nombre ,tablaSimbolo.get(cont).valor,tablaSimbolo.get(cont).ambito,
                        tablaSimbolo.get(cont).acceso,tablaSimbolo.get(cont).posicion,tablaSimbolo.get(cont).tipo,tablaSimbolo.get(cont).tDato,
                        tablaSimbolo.get(cont).parametros,tablaSimbolo.get(cont).tamanho,tablaSimbolo.get(cont).heredado,
                        tablaSimbolo.get(cont).prioridad,tablaSimbolo.get(cont).nodoParametro,tablaSimbolo.get(cont).ubicacion));
        }//termina for
       // tablaSimbolos=tablaT;
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
    
    public Acciones_Semanticas3(){
        tablaSimbolos=new ArrayList<>();
        tablaSimbolosTemporal=new ArrayList<>();
    }
    
    public Acciones_Semanticas3(LienzoDibujo lienzo){
        this.lienzo=lienzo;//new LienzoDibujo(this, true, "C:\\Users\\Alberth\\Pictures");
        tablaSimbolos=new ArrayList<>();
        tablaSimbolosTemporal=new ArrayList<>();
    }
    public void evaluar_arbol(NodoArbol raizDeclaracion,int evaluador)throws Exception{
         NodoArbol aux;
         aux=raizDeclaracion.getHijoEn(0);
            setHeredado(evaluador);
           evaluar_lienzo(aux,evaluador);
           if(evaluador==0){
                lienzo.setVisible(true);
           }
          
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
           setAmbitoAuxMetodo(ambito);
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
//         for(c=0;c<raiz.getHijoEn(0).getCantidadHijos();c++){
//             aux=raiz.getHijoEn(0).getHijoEn(c);
//             path+=aux.getEtiqueta()+".lz";
//             compilar(path);
//            // System.out.println("lienzo --> "+path);
//             path="C:\\EntradasCompi2\\";
//         }
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
                           // evaluar_funcion(ambito,aux,0);
                        break;
                    case "metodo":
                            setPrioridad(0);
                            setPasada2(2);
                           // evaluar_metodo(ambito,aux,0);
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
                                setPasada2(2);
//                                System.out.println("pasada2--> "+getPasada2());
                                setAmbitoAuxMetodo("principal");
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
            Object valor=null;
            for(int c=0;c<raiz.getCantidadHijos();c++){
                aux=raiz.getHijoEn(c);
                cantH=aux.getCantidadHijos();
                if(cantH==1){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                    if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombreVar,"variable",0,"",getAmbito(),"GLOBAL");
                        if(existe==true){
                            //almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                            modificarAsignacion(nombreVar,valor,getAmbito());
                        }
                    }else if(getPasada2()==1){
                        //almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                    }
                   
                }else if(cantH==2){
                    nombreVar=aux.getHijoEn(0).getEtiqueta();
                   if(getPasada2()==2){
                        existe=verificar_funcion_metodo_variable_arreglo(nombreVar,"variable",0,"",getAmbito(),"GLOBAL");
                        valor=evaluar_op(aux.getHijoEn(1), ambito);
                                
                        if(existe==true){
                            //System.out.println("valor de "+nombreVar+" = "+valor.toString());
                            //almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                            modificarAsignacion(nombreVar,valor,getAmbito());
                        }
                    }else if(getPasada2()==1){
                        //almacenar_variable(nombreVar,null, ambito,getTipoAcceso(),"variable",tipo,ubicacion,eliminar);
                    }
                }
            }
          }
        
        
        
         private boolean verificar_funcion_metodo_variable_arreglo(String nombre,String tipo,int tamanho,String parametro,String ambito,String ubicacion){
        boolean existe=false;
            try{
                //System.out.println("tamaño de tabla temporal --> "+tablaSimbolosTemporal.size());
            if(tipo.equalsIgnoreCase("variable")){
                 for (int contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombre) && tablaSimbolos.get(contFor).ambito.equalsIgnoreCase(ambito)&& tablaSimbolos.get(contFor).ubicacion.equalsIgnoreCase(ubicacion) )
                        {
                            existe=true;
                            contFor=tablaSimbolos.size();
                        }
                    }
            }else if(tipo.equalsIgnoreCase("metodo") || tipo.equalsIgnoreCase("funcion")){
                 for (int contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase(nombre) && (tablaSimbolos.get(contFor).tamanho==tamanho) && (tablaSimbolos.get(contFor).parametros.equalsIgnoreCase(parametro)&& tablaSimbolos.get(contFor).ambito.equalsIgnoreCase(ambito)))
                        {
                            existe=true;
                            contFor=tablaSimbolos.size();
                        }
                    }
            }else if(nombre.equalsIgnoreCase("main") ){
               // System.out.println("entro a verificar main");
                 for (int contFor = 0; contFor < tablaSimbolos.size(); contFor++)
                    {
                        if (tablaSimbolos.get(contFor).nombre.equalsIgnoreCase("main"))
                        {
                            existe=true;
                            contFor=tablaSimbolos.size();
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
                            setPasada2(2);
//                            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "metodo", "" , parametrosCad, cantParametros,parametros,eliminar);
//                            evaluar_parametros_almacenar(nombre, parametros);
//                            evaluar_rellenoFuncion(nombre,relleno);
                            setPasada2(2);
                        }
                    }else if(getPasada2()==1){
//                        almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "metodo", "" , parametrosCad, cantParametros,parametros,eliminar);
//                        evaluar_parametros_almacenar(nombre, parametros);
//                        evaluar_rellenoFuncion(nombre,relleno);
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
                            setPasada2(2);
//                            almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "funcion", retorno, parametrosCad, cantParametros,parametros,eliminar);
//                            evaluar_parametros_almacenar(nombre, parametros);
//                            evaluar_rellenoFuncion(nombre,relleno);
                            if(getComprobarRetorno()==0){
////                                Error(parametros.getLinea(),parametros.getColumna(),"Error Semantico","No viene retorno para la funcion "+nombre );
                            }
                            setPasada2(2);
                        }
                    }else if(getPasada2()==1){
//                        almacenar_metodo_funcion( nombre, relleno, ambito, getTipoAcceso(), 0, "funcion", retorno, parametrosCad, cantParametros,parametros,eliminar);
//                        evaluar_parametros_almacenar(nombre, parametros);
//                        evaluar_rellenoFuncion(nombre,relleno);
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
        
        private int evaluar_parametros_con_valor(NodoArbol parametros){
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
                            Object valor=evaluar_op(aux.getHijoEn(1),ambito);
    //System.out.println("OP DO_MIENTRAS --> "+valor);

                    int conta=0;
                    if(valor instanceof Integer){
                        int oP=(int)valor;
                        boolean co=false;
                        
                        if(oP==1){
                            co=true;
                        }else{
                            co=false;
                        }
                             while(co==true){
                                    evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
                                    valor=evaluar_op(aux.getHijoEn(1),ambito);
                                    oP=(int)valor;
                                     if(oP==1){
                                        co=true;
                                      }else{
                                         co=false;
                                     }
                                     if(1==getSalir()){
                                         co=false;
                                     }
                                    //System.out.println("do_mientras --> "+conta);
                                    setContinuar(0);
                                    conta++;
                            }
                        
                    }else if(valor instanceof Boolean){
                        boolean op=(boolean)valor;
                        while(op==true){
                            evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
                            valor=evaluar_op(aux.getHijoEn(1),ambito);
                            op=(boolean)valor;
                            if(1==getSalir()){
                                         op=false;
                                     }
                          //  System.out.println("do_mientras --> "+conta);
                            setContinuar(0);
                                    conta++;
                        }
    //                    
                    }else{
    //                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
    //                    //imprimirConsola("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
                    }
    setSalir(0);
    }
    private void evaluar_paraNormal(NodoArbol aux,String ambito)throws Exception{
    setSalir(0);
            evaluar_asignacion(aux.getHijoEn(0), ambito);//por fuerza viene una asignacion
            Object valor=null;//por fuerza viene un OP
            String var=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
             Object valVar=null;
             valVar=buscarVariable(var, ambito);
             Object comparacion=evaluar_op(aux.getHijoEn(1), ambito);
             Object step=null;
             //System.out.println("for cond --> "+comparacion.toString());
             //evaluar_incremento(aux.getHijoEn(2),ambito);
    //         //imprimirConsola(""+comparacion);
    //         
             int c=0;
             boolean cierto=false;
             if(comparacion instanceof Boolean){
                 cierto=(boolean)comparacion;
                 while(cierto==true){
                     evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
                     //System.out.println("for --> "+c);
                     evaluar_incremento(aux.getHijoEn(2),ambito);
                     comparacion=evaluar_op(aux.getHijoEn(1), ambito);
                     cierto=(boolean)comparacion;
                     c++;
                     
                 }
             }
             else{
                 //imprimirConsola("Error semantico, el valor ingresado en el FOR no es de tipo entero "+comparacion);
             }
    setSalir(0);
    }
    private void evaluar_interruptorNormal(NodoArbol aux,String ambito,Object valorComp)throws Exception{
//    System.out.println("switch pos0 --> "+valorComp);
//    System.out.println("switch pos1 --> "+aux.getEtiqueta());
    setSalir(0);
    NodoArbol temp;
    int c=0;
            Object valorComparar=null;
            int op1=0;
            int op2=0;
    //          
    while(c<aux.getCantidadHijos()){
    temp=aux.getHijoEn(c);
    if(temp.getEtiqueta().equalsIgnoreCase("CASO")){
                    valorComparar=evaluar_op(temp.getHijoEn(0), ambito);
//                    System.out.println("switch caso valor --> "+valorComparar);
                    if((valorComp instanceof Integer) && (valorComparar instanceof Integer)){
                        op1=(int)valorComp;
                        op2=(int)valorComparar;
                        
                        if(op1==op2){
                        evaluar_rellenoFuncion( ambito,temp.getHijoEn(1));
                        }
                    }
                    
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
                Object valor=evaluar_op(aux.getHijoEn(0),ambito);
                //System.out.println("OP MIENTRAS --> "+valor);
//                //evaluar_rellenoFuncion(aux.getHijoEn(1), ambito);
                int conta=0;
                if(valor instanceof Integer){
                    int oP=(int)valor;
                    boolean co=false;
                    
                    if(oP==1){
                        co=true;
                    }else{
                        co=false;
                    }
                         while(co==true){
                                evaluar_rellenoFuncion(ambito,aux.getHijoEn(1));
                                valor=evaluar_op(aux.getHijoEn(0),ambito);
                                oP=(int)valor;
                                 if(oP==1){
                                    co=true;
                                  }else{
                                     co=false;
                                 }
                                 
                                 if(1==getSalir()){
                                     co=false;
                                 }
                              //  System.out.println("mientras --> "+conta);
                               setContinuar(0);
                                conta++;
                        }
                    
                }else if(valor instanceof Boolean){
                    boolean op=(boolean)valor;
                    while(op==true){
                       // System.out.println("mientras tutu -->"+aux.getHijoEn(1).getEtiqueta());
                        evaluar_rellenoFuncion(ambito,aux.getHijoEn(1));
                        valor=evaluar_op(aux.getHijoEn(0),ambito);
                        op=(boolean)valor;
                       
                        //System.out.println("mientras --> "+conta);
                                if(1==getSalir()){
                                     op=false;
                                 }
                                setContinuar(0);
                                conta++;
                    }
//                    
                }else{
//                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
//                    imprimirConsola("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
                }
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
        NodoArbol aux2=null;
        int x=0,y=0,ancho,alto,diametro=0;
        Object x1=null,y1=null,ancho1=null,alto1=null,diametro1=null,cadena1=null;
        String hexa="",opcion="",cadena="";
        boolean mismo=false;
          // System.out.println("evaluar_relleno --> "+relleno.getEtiqueta()+" ambito "+ambito);
        while(c<relleno.getCantidadHijos()){
            aux=relleno.getHijoEn(c);
//            System.out.println("EVALUAR RELLENO DE LA FUNCION --> "+ambito+","+aux.getEtiqueta());
            if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_PUNTO")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                              aux2=aux.getHijoEn(0);    
                            x1=evaluar_op(aux2, ambito);
                            mismo=evaluar_tipo_dato(x1,"entero");
                            
                            if(mismo==true){
                                mismo=false;
                                aux2=aux.getHijoEn(1);    
                                y1=evaluar_op(aux2, ambito);
                                mismo=evaluar_tipo_dato(y1,"entero");
                              //  System.out.println("x--> "+mismo);
                                x=(int)x1;
                                if(mismo==true){
                                    mismo=false;
                                    aux2=aux.getHijoEn(3);    
                                    diametro1=evaluar_op(aux2, ambito);
                                    mismo=evaluar_tipo_dato(diametro1,"entero");
                                  //  System.out.println("y--> "+mismo);
                                    y=(int)y1;
                                    if(mismo=true){
                                   //     System.out.println("diametro--> "+mismo);
                                        diametro=(int)diametro1;
                                        aux2=aux.getHijoEn(2);
                                        hexa=aux2.getEtiqueta();
                                        lienzo.dibujarPunto(x, y,hexa,diametro, 1);
                                    }
                                }
                            }
                        
                    }
                }
               
            }if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_OR")){
                
                if(0==getSalir()){
                    if(0==getContinuar()){
                        aux2=aux.getHijoEn(0);    
                            x1=evaluar_op(aux2, ambito);
                            mismo=evaluar_tipo_dato(x1,"entero");
                            
                            if(mismo==true){
                                mismo=false;
                                aux2=aux.getHijoEn(1);    
                                y1=evaluar_op(aux2, ambito);
                                mismo=evaluar_tipo_dato(y1,"entero");
                                x=(int)x1;
                               // System.out.println("x--> "+mismo+"_"+x);
                                if(mismo==true){
                                    mismo=false;
                                    aux2=aux.getHijoEn(3);    
                                    ancho1=evaluar_op(aux2, ambito);
                                    mismo=evaluar_tipo_dato(ancho1,"entero");
                                    y=(int)y1;
                                 //   System.out.println("y--> "+mismo+"_"+y);
                                    if(mismo=true){
                                   
                                        mismo=false;
                                        aux2=aux.getHijoEn(4);    
                                        alto1=evaluar_op(aux2, ambito);
                                        mismo=evaluar_tipo_dato(alto1,"entero");
                                        ancho=(int)ancho1;
                                   //     System.out.println("ancho--> "+mismo+"_"+ancho);
                                        if(mismo=true){
                                            //=aux2.getHijoEn(5).getEtiqueta();
                                            aux2=aux.getHijoEn(5);
                                            opcion=aux2.getEtiqueta();
                                            aux2=aux.getHijoEn(2);
                                            hexa=aux2.getEtiqueta();
                                            alto=(int)alto1;
                                        //    System.out.println("alto--> "+mismo+"_"+alto);
                                            if(opcion.equalsIgnoreCase("o")){
                                                lienzo.dibujarOvalo(x, y,ancho,alto,hexa, 1);
                                            }else if(opcion.equalsIgnoreCase("r")){
                                                lienzo.dibujarRectangulo(x, y,ancho,alto,hexa, 1);
                                            }
                                            
                                        }
                                        
                                    }
                                }
                            }
                        
                    }
                }
               
            }else if(aux.getEtiqueta().equalsIgnoreCase("PINTAR_CADENA")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                       aux2=aux.getHijoEn(0);    
                            x1=evaluar_op(aux2, ambito);
                            mismo=evaluar_tipo_dato(x1,"entero");
                            
                            if(mismo==true){
                                mismo=false;
                                aux2=aux.getHijoEn(1);    
                                y1=evaluar_op(aux2, ambito);
                                mismo=evaluar_tipo_dato(y1,"entero");
                              //  System.out.println("x--> "+mismo);
                                x=(int)x1;
                                if(mismo==true){
                                    mismo=false;
                                    aux2=aux.getHijoEn(3);    
                                    cadena1=evaluar_op(aux2, ambito);
                                    mismo=evaluar_tipo_dato(cadena1,"cadena");
                                  //  System.out.println("y--> "+mismo);
                                    y=(int)y1;
                                    if(mismo=true){
                                                cadena=(String)cadena1;
                                                aux2=aux.getHijoEn(2);
                                                hexa=aux2.getEtiqueta();
                                                lienzo.dibujarTexto(cadena,x, y,hexa);
                                        
                                }
                                }
                            }
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
                        //evaluar_declaracion(ambito,aux,"LOCAL",0);
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
                    Object valorComparar=evaluar_op(aux.getHijoEn(0), ambito);
                    evaluar_interruptorNormal(aux.getHijoEn(1), ambito,valorComparar);
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
                        evaluar_asignacion(aux, ambito);
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
                        setContinuar(1);
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
             else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_FUNM_CON")){
                if(0==getSalir()){
                    if(0==getContinuar()){
setSalir(0);
            setContinuar(0);
//            
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
            int cantParametros=evaluar_parametros_con_valor(aux.getHijoEn(1));
            //System.out.println("LLAMADA_FUNM_CON --> "+ambitoFuncion+"---"+cantParametros);
             Nodo_variable var=retornarNodo(ambitoFuncion, cantParametros);
//             System.out.println("fun--> "+var.nombre);
            if(var==null){
                //imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
                
              // mostrarParametros();
               // System.out.println("tipo funcion --> "+var.tipo);
               NodoArbol pa=(NodoArbol)var.nodoParametro;
                modificarParametros(aux.getHijoEn(1),pa,ambitoFuncion);
                pa=(NodoArbol)var.valor;
               evaluar_rellenoFuncion(ambitoFuncion,pa);
             Object va=buscarVariable("retorno", ambitoFuncion);
            
             NodoArbol pas=(NodoArbol)va;
             Object as=evaluar_op(pas, ambitoFuncion);
//                System.out.println("as --> "+as.toString());
//                 mostrarParametros();
//                
             
                   setSalir(0);
                    setContinuar(0);
               
               
            }
                    }
                }
            }else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_FUNM_SIN")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                        
                     setSalir(0);
            setContinuar(0);
//            
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
           // int cantParametros=evaluar_parametros_con_valor(aux.getHijoEn(1));
            //System.out.println("LLAMADA_FUNM_CON --> "+ambitoFuncion+"---"+cantParametros);
             Nodo_variable var=retornarNodo(ambitoFuncion, 0);
//             System.out.println("fun--> "+var.nombre);
            if(var==null){
                //imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
                
              // mostrarParametros();
               // System.out.println("tipo funcion --> "+var.tipo);
              
               NodoArbol pa=(NodoArbol)var.nodoParametro;
               // modificarParametros(aux.getHijoEn(1),pa,ambitoFuncion);
                pa=(NodoArbol)var.valor;
               evaluar_rellenoFuncion(ambitoFuncion,pa);
             Object va=buscarVariable("retorno", ambitoFuncion);
            
             NodoArbol pas=(NodoArbol)va;
             Object as=evaluar_op(pas, ambitoFuncion);
//        
            }
                    }
                }
            }
            
           
            c++;
        }
        
        
    }
   
        private void compilar(String path) throws Exception{                 
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
            
//            Acciones_Semanticas2 pasada2=new Acciones_Semanticas2(); 
//            pasada2.setTablaSimbolosTemporal(getTablaSimbolosTemporal());
//            pasada2.evaluar_arbol(arbol,1);
//            setTablaSimbolos(pasada2.getTablaSimbolos());
            
            Acciones_Semanticas3 pasada3=new Acciones_Semanticas3();
            pasada3.setTablaSimbolos(getTablaSimbolosTemporal());
            pasada3.evaluar_arbol(arbol,1);
            setTablaSimbolos(pasada3.getTablaSimbolos());
        }
        catch (Exception e)
        {
            //txtAreaOut.setText("error in expression.\n"+ e.getMessage());
            System.out.println("Error en expresion.\n"+e.getMessage());
            Error(0,0,"",e.getMessage().toString());
        }
        catch (Error e)
        {
            //txtAreaOut.setText("error in expression.\n"+ e.getMessage());
            System.out.println("Error en expresion.\n"+e.getMessage());
            Error(0,0,"",e.getMessage().toString());
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

        private void modificarAsignacion(String nombreVar,Object valor,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < tablaSimbolos.size(); c++)
            {
                if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(c).ambito.equalsIgnoreCase(ambito) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("variable"))
                {
                    tablaSimbolos.get(c).valor=valor;                    
                    bVar = 0;
                    setVariableEncontrada(1);
                    c = tablaSimbolos.size();
                }
                else
                {
                    bVar = 1;
                }
            }
                int bVarG=0;
            if (bVar == 1 && variableEncontrada == 0)
            {
                for (int c = 0; c < tablaSimbolos.size(); c++)
                {
                    if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(c).ambito.equalsIgnoreCase(ambito) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("variable"))
                 //   if (tablaSimbolos[c].nombre == nombreVar && tablaSimbolos[c].ambito == "global" && tablaSimbolos[c].rol == "global" && tablaSimbolos[c].tipoVar == "variable")
                    {
//                        //System.out.println("variable modificada --> "+nombreVar);
                                
                               tablaSimbolos.get(c).valor = valor;
                               bVarG=0;
                               setVariableEncontrada(1);
                               c=tablaSimbolos.size();
                    }
                        else
                        {
                            bVarG=1;
                        }
                    }
                }
            
           if (bVarG == 1 && variableEncontrada == 0)
            {
                for (int c = 0; c < tablaSimbolos.size(); c++)
                {
                    if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("global"))
                 //   if (tablaSimbolos[c].nombre == nombreVar && tablaSimbolos[c].ambito == "global" && tablaSimbolos[c].rol == "global" && tablaSimbolos[c].tipoVar == "variable")
                    {
//                        //System.out.println("variable modificada --> "+nombreVar);
                                
                               tablaSimbolos.get(c).valor = valor;
                               bVarG=0;
                               setVariableEncontrada(1);
                               c=tablaSimbolos.size();
                    }
                        else
                        {
                      //      Console.WriteLine("meterlo como error semantico no coinciden los tipos para asignar");
                        //    setErrorSemantico("No coinciden los tipos para asignar a la variable "+nombreVar);
                        }
                    }
                }

            }
         
            private Object evaluar_op(NodoArbol op,String ambito)throws Exception{
        NodoArbol aux=op;//.getHijoEn(0);
         if(aux.getEtiqueta().equalsIgnoreCase("ENTERO")){
            String te=aux.getHijoEn(0).getEtiqueta();
            return (Integer)Integer.parseInt(te);
        }else if(aux.getEtiqueta().equalsIgnoreCase("DECIMAL")){
            String te=aux.getHijoEn(0).getEtiqueta();
            return Double.parseDouble(te);
        } else if(aux.getEtiqueta().equalsIgnoreCase("FALSO")){
           return false;
        }else if(aux.getEtiqueta().equalsIgnoreCase("VERDADERO")){
           return true;
        }else if(aux.getEtiqueta().equalsIgnoreCase("CARACTER")){//pendientes
         //   System.out.println("ETIQUETA CHAR FKANSDÑFLKNASDLKFNAÑSLKDNFLKADSNFAD-->"+aux.getHijoEn(0).getEtiqueta());
            String te=aux.getHijoEn(0).getEtiqueta();
           te=te.replace("'", "");
        char w=te.charAt(0); 
            return (Character)w;
        }else if(aux.getEtiqueta().equalsIgnoreCase("CADENA")){
            String te=aux.getHijoEn(0).getEtiqueta();
            te=te.replace('"', ' ');
            te=te.trim();
            return (String)te;
        }else if(aux.getEtiqueta().equalsIgnoreCase("PARENTESIS")){
           // return evaluarParetesis(aux.getHijoEn(0),ambito);
        }else if(aux.getEtiqueta().equalsIgnoreCase("LLAVES")){
            //return evaluarParetesis(aux.getHijoEn(0),ambito);
        }else if(aux.getEtiqueta().equalsIgnoreCase("CORCHETES")){
          //  return evaluarParetesis(aux.getHijoEn(0),ambito);
        }
        //retorna datos
        else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_FUNM_CON")){
            setSalir(0);
            setContinuar(0);
//            
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
            int cantParametros=evaluar_parametros_con_valor(aux.getHijoEn(1));
            //System.out.println("LLAMADA_FUNM_CON --> "+ambitoFuncion+"---"+cantParametros);
             Nodo_variable var=retornarNodo(ambitoFuncion, cantParametros);
//             System.out.println("fun--> "+var.nombre);
            if(var==null){
                //imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
                
              // mostrarParametros();
               // System.out.println("tipo funcion --> "+var.tipo);
               if(var.tipo.equalsIgnoreCase("metodo")){
                   Error(0,0,"SEMANTICO","Se intenta acceder a un metodo desde una operacion con nombre: "+var.nombre);
               }else{
               NodoArbol pa=(NodoArbol)var.nodoParametro;
                modificarParametros(aux.getHijoEn(1),pa,ambitoFuncion);
                pa=(NodoArbol)var.valor;
               evaluar_rellenoFuncion(ambitoFuncion,pa);
             Object va=buscarVariable("retorno", ambitoFuncion);
            
             NodoArbol pas=(NodoArbol)va;
             Object as=evaluar_op(pas, ambitoFuncion);
//                System.out.println("as --> "+as.toString());
//                 mostrarParametros();
//                
             
                   setSalir(0);
                    setContinuar(0);
                if(as  instanceof Integer){
                    return (Integer)as;
                }else  if(as instanceof Double){
                    return (Double)as;
                }else  if(as instanceof Boolean){
                    return (Boolean)as;
                }else  if(as instanceof Character){
                    return (Character)as;
                }else  if(as instanceof String){
                    return (String)as;
                }
               }
            }
        }
        //RETORNA DATOS
         else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_FUNM_SIN")){
            setSalir(0);
            setContinuar(0);
//            
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
           // int cantParametros=evaluar_parametros_con_valor(aux.getHijoEn(1));
            //System.out.println("LLAMADA_FUNM_CON --> "+ambitoFuncion+"---"+cantParametros);
             Nodo_variable var=retornarNodo(ambitoFuncion, 0);
//             System.out.println("fun--> "+var.nombre);
            if(var==null){
                //imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
                
              // mostrarParametros();
               // System.out.println("tipo funcion --> "+var.tipo);
               if(var.tipo.equalsIgnoreCase("metodo")){
                   Error(0,0,"SEMANTICO","Se intenta acceder a un metodo desde una operacion con nombre: "+var.nombre);
               }else{
               NodoArbol pa=(NodoArbol)var.nodoParametro;
               // modificarParametros(aux.getHijoEn(1),pa,ambitoFuncion);
                pa=(NodoArbol)var.valor;
               evaluar_rellenoFuncion(ambitoFuncion,pa);
             Object va=buscarVariable("retorno", ambitoFuncion);
            
             NodoArbol pas=(NodoArbol)va;
             Object as=evaluar_op(pas, ambitoFuncion);
//                System.out.println("as --> "+as.toString());
//                 mostrarParametros();
//                
             
                   setSalir(0);
                    setContinuar(0);
                if(as  instanceof Integer){
                    return (Integer)as;
                }else  if(as instanceof Double){
                    return (Double)as;
                }else  if(as instanceof Boolean){
                    return (Boolean)as;
                }else  if(as instanceof Character){
                    return (Character)as;
                }else  if(as instanceof String){
                    return (String)as;
                }
               }
            }
        }
        //CORCHETES    
        else if(aux.getEtiqueta().equalsIgnoreCase("CORCHETE")){
          //  return evaluarParetesis(aux.getHijoEn(0),ambito);
        }
        // VARIABLES
        else if(aux.getEtiqueta().equalsIgnoreCase("ID")){
                String variable=aux.getHijoEn(0).getEtiqueta();
                
                Object valo=buscarVariable(variable, ambito);
                
                String tipo=buscar_tipo_variable(variable,ambito);
                tipo=tipo.toLowerCase();
               // System.out.println("prosti --> "+variable+","+valo+","+tipo);
                if((tipo.equalsIgnoreCase("ENTERO") && (valo instanceof Integer))){
                    return (Integer) valo;
               }else if((tipo.equalsIgnoreCase("DOUBLE") && (valo instanceof Double))){
                    return (Double) valo;
               }else if((tipo.equalsIgnoreCase("CADENA") && (valo instanceof String))){
                  //  System.out.println("valor string --> "+valo);
                   return (String) valo;
               }else if((tipo.equalsIgnoreCase("CARACTER")&& (valo instanceof Character))){
                   return (Character) valo;
               }else if((tipo.equalsIgnoreCase("BOOLEAN")&& (valo instanceof Boolean))){
                    return (Boolean) valo;
               }               
//              
        }
        //VIENE EL -- DECREMENTO
        else if(aux.getEtiqueta().equalsIgnoreCase("--")){
             //System.out.println("viene el incrermento puto --> "+aux.getHijoEn(0).getEtiqueta());
             
//             if(aux.getHijoEn(0).getEtiqueta().equalsIgnoreCase("ID")){
//                    String variable=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
//                    Object valo=buscarVariable(variable, ambito);
//                    String tipo=buscar_tipo_variable(variable,ambito);
//                   // System.out.println("variable a incrementar --> "+variable);
//                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
//                        modificarAsignacion(variable,(Integer)valo-1,ambito);
//                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
//                        modificarAsignacion(variable,(Double)valo-1,ambito);
//                    }
//             }else{
//                   Object na=evaluar_op(aux.getHijoEn(0), ambito);
//                    if(na instanceof Double){
//                        return (double)na-1;
//                    }else if(na instanceof Integer){
//                        return (Integer)na-1;
//                    }else if(na instanceof Character){
//                        Integer tutu=convertirCharInt((Character) na);
//                        return (Integer)tutu-1;
//
//                    }
//             // System.err.println("el incremento trae este valor --> "+na);
//             }
//             
//           
            
                //evaluar_incremento(aux,ambito);
        }
        //viene el incremento ++
         else if(aux.getEtiqueta().equalsIgnoreCase("++")){
            // System.out.println("viene el incrermento puto --> "+aux.getHijoEn(0).getEtiqueta());
//             
//             if(aux.getHijoEn(0).getEtiqueta().equalsIgnoreCase("ID")){
//                    String variable=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
//                    Object valo=buscarVariable(variable, ambito);
//                    String tipo=buscar_tipo_variable(variable,ambito);
//                   // System.out.println("variable a incrementar --> "+variable);
//                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
//                        modificarAsignacion(variable,(Integer)valo+1,ambito);
//                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
//                        modificarAsignacion(variable,(Double)valo+1,ambito);
//                    }
//             }else{
//                   Object na=evaluar_op(aux.getHijoEn(0), ambito);
//                    if(na instanceof Double){
//                        return (double)na+1;
//                    }else if(na instanceof Integer){
//                        return (Integer)na+1;
//                    }else if(na instanceof Character){
//                        Integer tutu=convertirCharInt((Character) na);
//                        return (Integer)tutu+1;
//
//                    }
//             // System.err.println("el incremento trae este valor --> "+na);
//             }
//             
//           
            
                //evaluar_incremento(aux,ambito);
        }
        
        
        
            //VIENE LA SUMA
        else if(aux.getEtiqueta().equalsIgnoreCase("+")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
           
            //RESULTADO DOUBLE
            if((e1 instanceof Integer )&& (e2 instanceof Double)){
                return (Double)((Integer)e1+(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                return (Double)((Double)e1+(Integer)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Character)){
                Integer tutu=convertirCharInt((Character) e2);
                Double pu=(Double)e1+(Integer)tutu;
                String pe=Double.toString(pu);
                return String.valueOf(pe);
            }else if((e1 instanceof Character )&& (e2 instanceof Double)){
                Integer tutu=convertirCharInt((Character) e1);
                return (Double)(tutu+(Double)e2);
            }else if((e1 instanceof Boolean )&& (e2 instanceof Double)){
                Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)(tutu+(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)((Double)e2+tutu);
            }else if((e1 instanceof Double )&& (e2 instanceof Double)){
                return (Double)((Double)e1+(Double)e2);
            }
            //RESULTADOS ENTEROS
            else if((e1 instanceof Integer )&& (e2 instanceof Character)){
                 Integer tutu=convertirCharInt((Character) e2);
                 Integer pO=(int)e1+(int)tutu;
                return pO;
              
            }
            else if((e1 instanceof Character )&& (e2 instanceof Integer)){
                 Integer tutu=convertirCharInt((Character) e1);
                 Integer pO=(int)tutu+(int)e2;
                return pO; 
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Integer)){
                 Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)tutu+(int)e2;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)e1+(int)tutu;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                Integer pO=(int)e1+(int)e2;
                return pO;
            }
            //RETORNA STRING
            else if((e1 instanceof String )&& (e2 instanceof Integer)){
                String t=(String)e1; 
                String t1=Integer.toString((int) e2); 
                String t2=t.concat(t1); 
                return t2;
            }
            else if((e1 instanceof String )&& (e2 instanceof Double)){
                String t=(String)e1; 
                String t1=Double.toString((double) e2); 
                String t2=t.concat(t1); 
                return t2;
            }
            else if((e1 instanceof Double )&& (e2 instanceof String)){
                String t=(String)e2; 
                String t1=Double.toString((double) e1); 
                String t2=t1.concat(t); 
                return t2;
            }else if((e1 instanceof Integer )&& (e2 instanceof String)){
                String t=(String)e2; 
                String t1=Integer.toString((int) e1); 
                String t2=t1.concat(t); 
                return t2;
            }
            
            //MAS DE STRING CON CHAR
            else if((e1 instanceof String )&& (e2 instanceof Character)){
                String t=(String)e1; 
                String t1=Character.toString((char) e2); 
                String t2=t.concat(t1); 
                return (String)t2;
            }
            else if((e1 instanceof Character )&& (e2 instanceof String)){
                String t=(String)e2; 
                String t1=Character.toString((char) e1); 
                String t2=t1.concat(t); 
                return (String)t2;
            }
            else if((e1 instanceof String )&& (e2 instanceof String)){
                String t=(String)e1; 
                String t1=(String)e2; 
                String t2=t.concat(t1); 
                return (String) t2;
            }
            
            //RETORNA BOOL
             else if((e1 instanceof Boolean )&& (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                Boolean op3=false;
                
                if((op1==true) && (op2==true)){
                    op3=true;
                }else if((op1==false) && (op2==true)){
                    op3=true;
                }else if((op1==true) && (op2==false)){
                    op3=true;
                }else if((op1==false) && (op2==false)){
                    op3=false;
                }
                return op3;
            }else{
                 //METERLO COMO ERROR SEMANTICO EN LA SUMA, NO ES COMPATIBLE CON LO QUE SOLICITA
                 //System.out.println("METERLO COMO ERROR SEMANTICO EN LA SUMA, NO ES COMPATIBLE CON LO QUE SOLICITA");
              //   imprimirConsola("ERROR SEMANTICO EN LA SUMA, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE LA RESTA
        else if(aux.getEtiqueta().equalsIgnoreCase("-")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
           
            //RESULTADO DOUBLE
            if((e1 instanceof Integer )&& (e2 instanceof Double)){
                return (Double)((Integer)e1-(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                return (Double)((Double)e1-(Integer)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Character)){
                Integer tutu=convertirCharInt((Character) e2);
                Double pu=(Double)e1-(Integer)tutu;
                String pe=Double.toString(pu);
                return String.valueOf(pe);
            }else if((e1 instanceof Character )&& (e2 instanceof Double)){
                Integer tutu=convertirCharInt((Character) e1);
                return (Double)(tutu-(Double)e2);
            }else if((e1 instanceof Boolean )&& (e2 instanceof Double)){
                Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)(tutu-(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)((Double)e2-tutu);
            }else if((e1 instanceof Double )&& (e2 instanceof Double)){
                return (Double)((Double)e1-(Double)e2);
            }
            //RESULTADOS ENTEROS
            else if((e1 instanceof Integer )&& (e2 instanceof Character)){
                 Integer tutu=convertirCharInt((Character) e2);
                 Integer pO=(int)e1-(int)tutu;
                return pO;
              
            }
            else if((e1 instanceof Character )&& (e2 instanceof Integer)){
                 Integer tutu=convertirCharInt((Character) e1);
                 Integer pO=(int)tutu-(int)e2;
                return pO; 
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Integer)){
                 Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)tutu-(int)e2;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)e1-(int)tutu;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                Integer pO=(int)e1-(int)e2;
                return pO;
            }
            else{
                 //METERLO COMO ERROR SEMANTICO EN LA RESTA, NO ES COMPATIBLE CON LO QUE SOLICITA
               // imprimirConsola("ERROR SEMANTICO EN LA RESTA, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE LA MULTIPLICACION
        else if(aux.getEtiqueta().equalsIgnoreCase("*")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
           
            //RESULTADO DOUBLE
            if((e1 instanceof Integer )&& (e2 instanceof Double)){
                return (Double)((Integer)e1*(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                return (Double)((Double)e1*(Integer)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Character)){
                Integer tutu=convertirCharInt((Character) e2);
                Double pu=(Double)e1*(Integer)tutu;
                String pe=Double.toString(pu);
                return String.valueOf(pe);
            }else if((e1 instanceof Character )&& (e2 instanceof Double)){
                Integer tutu=convertirCharInt((Character) e1);
                return (Double)(tutu*(Double)e2);
            }else if((e1 instanceof Boolean )&& (e2 instanceof Double)){
                Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)(tutu*(Double)e2);
            }else if((e1 instanceof Double )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                return (Double)((Double)e2*tutu);
            }else if((e1 instanceof Double )&& (e2 instanceof Double)){
                return (Double)((Double)e1*(Double)e2);
            }
            //RESULTADOS ENTEROS
            else if((e1 instanceof Integer )&& (e2 instanceof Character)){
                 Integer tutu=convertirCharInt((Character) e2);
                 Integer pO=(int)e1*(int)tutu;
                return pO;
              
            }
            else if((e1 instanceof Character )&& (e2 instanceof Integer)){
                 Integer tutu=convertirCharInt((Character) e1);
                 Integer pO=(int)tutu*(int)e2;
                return pO; 
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Integer)){
                 Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)tutu*(int)e2;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                Integer pO=(int)e1*(int)tutu;
                return pO;
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                Integer pO=(int)e1*(int)e2;
                return pO;
            }
            //MULTIPLICACION ENTRE BOOLEANOS
            else if((e1 instanceof Boolean )&& (e2 instanceof Boolean)){
                Boolean p1=false;
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if((op1==true) && (op2==true)){
                    p1=true;
                }else{
                    p1=false;
                }
                //System.out.println("ME FALTA REALIZAR LO DE LA DIVISION, AND, NOT, OR ESO Y DARLE VIDA AAL MAIN");//ELIMINARLO CUANDO YA ESTE
                return p1;
            }
            
            else{
                 //METERLO COMO ERROR SEMANTICO EN LA RESTA, NO ES COMPATIBLE CON LO QUE SOLICITA
                 //imprimirConsola("ERROR SEMANTICO EN LA MULTIPLICACION, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE LA DIVISION
        else if(aux.getEtiqueta().equalsIgnoreCase("/")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
           
            //RESULTADO DOUBLE
            if((e1 instanceof Integer )&& (e2 instanceof Double)){
                    double op2=(double)e2;
                    if(op2==0.0){
                        //System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                     //   imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Integer)e1/(Double)e2);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                    int op2=(int)e2;
                    if(op2==0){
                      //  System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                     //   imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Double)e1/(Integer)e2);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Character)){
                Integer tutu=convertirCharInt((Character) e2);
                 int op2=(int)tutu;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                      //  imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        Double pu=(Double)e1/(Integer)tutu;
                        String pe=Double.toString(pu);
                        return String.valueOf(pe);
                    }
                
                
            }else if((e1 instanceof Character )&& (e2 instanceof Double)){
                Integer tutu=convertirCharInt((Character) e1);
                double op2=(double)e2;
                    if(op2==0.0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                      //  imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                       return (Double)(tutu/(Double)e2);
                    }
                
                
            }else if((e1 instanceof Boolean )&& (e2 instanceof Double)){
                Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    
                     double op2=(double)e2;
                    if(op2==0.0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                     //   imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                         return (Double)(tutu/(Double)e2);
                    }
               
            }else if((e1 instanceof Double )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    
                    int op2=(int)tutu;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                      //  imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Double)e2/tutu);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Double)){
                    double op2=(double)e2;
                    if(op2==0.0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                       // imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Double)e1/(Double)e2);
                    }
            }
            //RESULTADOS DOBULE con enteros de operadores
            else if((e1 instanceof Integer )&& (e2 instanceof Character)){
                 Integer tutu=convertirCharInt((Character) e2);
                 int op2=(int)tutu;
                    if(op2==0){
                      //  System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                       // imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        
                        Double pu=(double)((Integer)e1/tutu);
                        return pu;
                    }
                 
              
            }
            else if((e1 instanceof Character )&& (e2 instanceof Integer)){
                 Integer tutu=convertirCharInt((Character) e1);
                 
                    int op2=(int)e2;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                      //  imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        Double pu=(double)(tutu/(Integer)e2);
                        return pu;
                        
                    }
                
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Integer)){
                 Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    
                    int op2=(int)e2;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        //imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                     //   System.out.println(tutu/(Integer)e2);
                         Double pu=(double)(tutu/(Integer)e2);
                         
                        return pu;
                        
                    }
                
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    int op2=(int)tutu;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        //imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        Double pO=(double)((Integer)e1/tutu);
                        return pO;
                    }
                  
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                    int op2=(int)e2;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        //imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                         Double pO=(double)((int)e1/(int)e2);
                         return pO;
                    }
            }
            else{
                //imprimirConsola("ERROR SEMANTICO EN LA DIVISION, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE LA POTENCIACION 
        else if(aux.getEtiqueta().equalsIgnoreCase("^")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
           
            //RESULTADO DOUBLE
            if((e1 instanceof Integer )&& (e2 instanceof Double)){
                    
                    return (Double)(Math.pow((Integer) e1, (Double) e2));
                    
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                   return (Double)(Math.pow((Double) e1, (Integer) e2));
            }
            else if((e1 instanceof Double )&& (e2 instanceof Character)){//pendiente
                Integer tutu=convertirCharInt((Character) e2);
                return (Double)(Math.pow((Double) e1, tutu));
            }
            else if((e1 instanceof Character )&& (e2 instanceof Double)){
                Integer tutu=convertirCharInt((Character) e1);
               return (Double)(Math.pow(tutu, (Double)e2));
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Double)){
                Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    return (Double)(Math.pow(tutu, (Double)e2));
            }else if((e1 instanceof Double )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    
                    return (Double)(Math.pow((Double)e1,tutu));
            }
            else if((e1 instanceof Double )&& (e2 instanceof Double)){
                    return (Double)(Math.pow((Double)e1,(Double)e2));
            }
            //RESULTADOS ENTERO
            else if((e1 instanceof Integer )&& (e2 instanceof Character)){
                 Integer tutu=convertirCharInt((Character) e2);
                 Integer a=(int)(Math.pow((Integer)e1,tutu));
                 return a;
            }
            else if((e1 instanceof Character )&& (e2 instanceof Integer)){
                 Integer tutu=convertirCharInt((Character) e1);
             //    System.out.println(""+tutu+","+(Integer)e2+"-->"+Math.pow(tutu,(int)e2));
                 int a=(int)(Math.pow(tutu,(int)e2));
              //  System.out.println("P-->"+a);
                 return a;
            }
            else if((e1 instanceof Boolean )&& (e2 instanceof Integer)){
                 Integer tutu;
                boolean t=(boolean)e1;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    
                    int op2=(int)e2;
                    
                        System.out.println(tutu/(Integer)e2);
                         int pu=(int)(Math.pow(tutu,(int)e2));
                         
                        return pu;
                        
                    
                
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Boolean)){
                 Integer tutu;
                boolean t=(boolean)e2;
                
                    if(t==true){
                        tutu=1;
                    }else{
                        tutu=0;
                    }
                    int op2=(int)tutu;
                    
                        int pO=(int)(Math.pow(tutu,op2));//(double)((Integer)e1/tutu);
                        return pO;
                    
                  
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                Integer a=   (int)(Math.pow((Integer)e1,(Integer)e2));
                return a;
            }
            else{
                //imprimirConsola("ERROR SEMANTICO EN LA POTENCIA, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        
        //VIENEN  LAS EXPRESIONES RELACIONALES
        else if(aux.getEtiqueta().equalsIgnoreCase("==")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Boolean) && (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
            }
             else if((e1 instanceof  Boolean) && (e2 instanceof Integer)){
                boolean op1=(boolean)e1;
                int op3=(int)e2;
                boolean op2=false;
                if(op3==1){
                    op2=true;
                }else if(op3==1){
                    op2=false;
                }else{
                    //.out.println("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                    //imprimirConsola("ERROR SEMANTICO EN EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                }
                
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
            }
            
            else if((e1 instanceof  Integer) && (e2 instanceof Boolean)){
                boolean op2=(boolean)e2;
                int op3=(int)e1;
                boolean op1=false;
                if(op3==1){
                    op2=true;
                }else if(op3==1){
                    op2=false;
                }else{
                    //System.out.println("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                    //imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                }
                                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
            }
            
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
               // System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
              //  System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1==op2){
                    return true;
                }else{
                    return false;
                }
            }
             else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL ==, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
             
        }
        //VIENE DIFERENTE
        else if(aux.getEtiqueta().equalsIgnoreCase("!=")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Boolean) && (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
            }
             else if((e1 instanceof  Boolean) && (e2 instanceof Integer)){
                boolean op1=(boolean)e1;
                int op3=(int)e2;
                boolean op2=false;
                if(op3==1){
                    op2=true;
                }else if(op3==1){
                    op2=false;
                }else{
                    //System.out.println("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                    //imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                }
                
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
            }
            
            else if((e1 instanceof  Integer) && (e2 instanceof Boolean)){
                boolean op2=(boolean)e2;
                int op3=(int)e1;
                boolean op1=false;
                if(op3==1){
                    op2=true;
                }else if(op3==1){
                    op2=false;
                }else{
                   // System.out.println("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                    //imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
                }
                                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
            }
            
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
               // System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
              //  System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1!=op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL !=, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE >=
        else if(aux.getEtiqueta().equalsIgnoreCase(">=")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1>=op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1>=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1>=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1>=op2){
                    return true;
                }else{
                    return false;
                }
                
            }           
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
//                System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
//                System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1>=op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL >=, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE <=
        else if(aux.getEtiqueta().equalsIgnoreCase("<=")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1<=op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1<=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1<=op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1<=op2){
                    return true;
                }else{
                    return false;
                }
                
            }           
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
//                System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
//                System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1<=op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL <=, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE >
        else if(aux.getEtiqueta().equalsIgnoreCase(">")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1>op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1>op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1>op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1>op2){
                    return true;
                }else{
                    return false;
                }
                
            }           
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
//                System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
//                System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1>op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL >, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        
        //VIENE <
        else if(aux.getEtiqueta().equalsIgnoreCase("<")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Integer) && (e2 instanceof Integer)){
                int op1=(int)e1;
                int op2=(int)e2;
                
                if(op1<op2){
                    return true;
                }else{
                    return false;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Double)){
                int op1=(int)e1;
                double op2=(double)e2;
                
                if(op1<op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Integer)){
                double op1=(double)e1;
                int op2=(int)e2;
                
                if(op1<op2){
                    return true;
                }else{
                    return false;
                }
                
            }
            else if((e1 instanceof  Double) && (e2 instanceof Double)){
                double op1=(double)e1;
                double op2=(double)e2;
                
                if(op1<op2){
                    return true;
                }else{
                    return false;
                }
                
            }           
             else if((e1 instanceof  String) && (e2 instanceof String)){
                Integer t1=0;
                Integer t2=0;
                
                String te1=(String)e1;
                String te2=(String)e2;
                int j=0;
                int i=0;
                 int op1=0;
                 int op2=0;
//                System.out.println("-----------------te1");
                for(i=0;i<te1.length();i++){  
                    t1=convertirCharInt((Character)(te1.charAt(i)));
                    op1+=(int)t1;
                }
                
//                System.out.println("-------------------te2");
                for(j=0;j<te2.length();j++){
                    
                     t2=convertirCharInt((Character)(te2.charAt(j)));
                    op2+=(int)t2;
                }
                
                
                if(op1<op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL <, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        //VIENE &&
        else if(aux.getEtiqueta().equalsIgnoreCase("AND")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Boolean) && (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if(op1 && op2){
                    return true;
                }else{
                    return false;
                }
            }else if((e1 instanceof  Boolean) && (e2 instanceof Integer)){
                boolean op1=(boolean)e1;
                boolean op2=false;
                int op3=(int)e2;
                
                if(op3==1){
                    op2=true;
                }else if(op3==0){
                    op2=false;
                }else{
                   // System.out.println("error semantico cerca de && tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de AND tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 && op2){
                    return true;
                }else{
                    return false;
                }
            }else if((e1 instanceof  Integer) && (e2 instanceof Boolean)){
                boolean op2=(boolean)e2;
                boolean op1=false;
                int op3=(int)e1;
                
                if(op3==1){
                    op1=true;
                }else if(op3==0){
                    op1=false;
                }else{
                   // System.out.println("error semantico cerca de && tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de AND tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 && op2){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL AND, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        
        //VIENE ||
        
        else if(aux.getEtiqueta().equalsIgnoreCase("OR")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Boolean) && (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if(op1 || op2){
                    return true;
                }else{
                    return false;
                }
            }else if((e1 instanceof  Boolean) && (e2 instanceof Integer)){
                boolean op1=(boolean)e1;
                boolean op2=false;
                int op3=(int)e2;
                
                if(op3==1){
                    op2=true;
                }else if(op3==0){
                    op2=false;
                }else{
                  //  System.out.println("error semantico cerca de && tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de OR tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 || op2){
                    return true;
                }else{
                    return false;
                }
            }else if((e1 instanceof  Integer) && (e2 instanceof Boolean)){
                boolean op2=(boolean)e2;
                boolean op1=false;
                int op3=(int)e1;
                
                if(op3==1){
                    op1=true;
                }else if(op3==0){
                    op1=false;
                }else{
                    //System.out.println("error semantico cerca de && tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de OR tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 || op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL OR, NO ES COMPATIBLE CON LO QUE SOLICITA");
             }
        }
        
        //VIENE ¡ NOT
        else if(aux.getEtiqueta().equalsIgnoreCase("NOT")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            
            if((e1 instanceof Boolean)){
                boolean op1=(boolean)e1;
               
                if(op1==true){
                    return false;
                }else{
                    return true;
                }
                
            }else if((e1 instanceof Integer)){
                int op1=(int)e1;
               
                if(op1==1){
                    return false;
                }else if(op1==0){
                    return true;
                }else{
                  //  System.out.println("Error semantico el NOT solo acepta 1/0 o true/false");
                    //imprimirConsola("Error semantico el NOT solo acepta 1/0 o true/false");
                }
                
            }
          
        }
        //VIENE ?? XOR
        else if(aux.getEtiqueta().equalsIgnoreCase("XOR")){
            Object e1=evaluar_op(aux.getHijoEn(0),ambito);
            Object e2=evaluar_op(aux.getHijoEn(1),ambito);
            
            
            if((e1 instanceof  Boolean) && (e2 instanceof Boolean)){
                boolean op1=(boolean)e1;
                boolean op2=(boolean)e2;
                
                if((op1==true) && (op2==true)){
                    return false;
                }else if((op1==false) && (op2==false)){
                    return false;
                }else if((op1==true) && (op2==false)){
                    return true;
                }else if((op1==false) && (op2==true)){
                    return true;
                }
                
                
               
            }else if((e1 instanceof  Boolean) && (e2 instanceof Integer)){
                boolean op1=(boolean)e1;
                boolean op2=false;
                int op3=(int)e2;
                
                if(op3==1){
                    op2=true;
                }else if(op3==0){
                    op2=false;
                }else{
                    //System.out.println("error semantico cerca de ?? tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de XOR tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if((op1==true) && (op2==true)){
                    return false;
                }else if((op1==false) && (op2==false)){
                    return false;
                }else if((op1==true) && (op2==false)){
                    return true;
                }else if((op1==false) && (op2==true)){
                    return true;
                }
                
            }else if((e1 instanceof  Integer) && (e2 instanceof Boolean)){
                boolean op2=(boolean)e2;
                boolean op1=false;
                int op3=(int)e1;
                
                if(op3==1){
                    op1=true;
                }else if(op3==0){
                    op1=false;
                }else{
                    //System.out.println("error semantico cerca de ?? tiene que venir una expresion boolea para poder evaluar");
                    //imprimirConsola("error semantico cerca de XOR tiene que venir una expresion boolea para poder evaluar");
                }
                
                
               if((op1==true) && (op2==true)){
                    return false;
                }else if((op1==false) && (op2==false)){
                    return false;
                }else if((op1==true) && (op2==false)){
                    return true;
                }else if((op1==false) && (op2==true)){
                    return true;
                }
            }else{
                //imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL XOR, NO ES COMPATIBLE CON LO QUE SOLICITA");
                
             }
        }
        //no tocar
        //NO PASAR MAS DE AQUI
        return null;
    }
            
            private Integer convertirCharInt(Character con){
                char c = con;
                int i = (int)c;
                        //System.out.println("caracter --> "+i);
                return (Integer)i;
}    
            
                 private Object buscarVariable(String nombreVar,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            Object valor = null;
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < tablaSimbolos.size(); c++)
            {
                //System.out.println("VARIABLE --> "+nombreVar);
                       if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(c).ambito.equalsIgnoreCase(ambito) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("variable")&& tablaSimbolos.get(c).acceso.equalsIgnoreCase("privado") )
                        {
                            //System.out.println("encontro "+nombreVar);
                                valor = tablaSimbolos.get(c).valor;
                                //System.out.println(nombreVar+"--> "+valor);
                                bVar = 0;
                                setVariableEncontrada(1);
                        }
                       
                       else
                       {
                           bVar = 1;
                       }
            }
            //System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < tablaSimbolos.size(); c++)
                {
                    
                        if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar))
                        {
                            //System.out.println("esto ya se cocio con "+nombreVar);
                            valor = tablaSimbolos.get(c).valor;
                            setVariableEncontrada(1);
                        }
                }
                
            }

            return valor;

        }
     
                 
                  private Nodo_variable retornarNodo(String nombreVar,int tamanho)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            Nodo_variable valor = null;
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < tablaSimbolos.size(); c++)
            {
             //   System.out.println("VARIABLE --> "+nombreVar+","+getAmbitoAuxMetodo());
//                System.out.println("funcion --> "+c+tablaSimbolos.get(c).nombre+"_"+tablaSimbolos.get(c).tamanho+"_"+ tablaSimbolos.get(c).tipo);
                       if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar)  && (tablaSimbolos.get(c).tamanho==tamanho ) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("funcion"))
                        {
                   //         System.out.println("encontro "+nombreVar);
                            
                                valor = tablaSimbolos.get(c);
                                bVar = 0;
                                setVariableEncontrada(1);
                            
                                
                     //           System.out.println(nombreVar+"--> "+valor);
                                
                        }else if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar)  && (tablaSimbolos.get(c).tamanho==tamanho ) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("metodo"))
                        {
                   //         System.out.println("encontro "+nombreVar);
                            
                                valor = tablaSimbolos.get(c);
                                bVar = 0;
                                setVariableEncontrada(1);
                            
                                
                     //           System.out.println(nombreVar+"--> "+valor);
                                
                        }
                            
                       
                       else
                       {
                           bVar = 1;
                       }
            }
          //  System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < tablaSimbolos.size(); c++)
                {
                    
                    if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar) && tablaSimbolos.get(c).tipo.equalsIgnoreCase("variable") )
                    {
                  //      System.out.println("esto ya se cocio con "+nombreVar);
                        valor = tablaSimbolos.get(c);
                        setVariableEncontrada(1);
                    }
                }
                
            }

            return valor;

        }

        private void mostrarParametros(){
            for(int c=0;c<tablaSimbolos.size();c++){
                System.out.println(tablaSimbolos.get(c).nombre+"_"+tablaSimbolos.get(c).valor);
            }
        }
                  
       private void modificarParametro(int index,Object valor,String ambito)
        {
            setVariableEncontrada(0);
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < tablaSimbolos.size(); c++)
            {
               // System.out.println(tablaSimbolos.get(c).nombre+" , "+tablaSimbolos.get(c).posicion+" ,"+index);
                if (tablaSimbolos.get(c).posicion==index && tablaSimbolos.get(c).ambito.equalsIgnoreCase(ambito) && tablaSimbolos.get(c).acceso.equalsIgnoreCase("privado") && tablaSimbolos.get(c).tipo.equalsIgnoreCase("variable"))
                {
                        tablaSimbolos.get(c).valor=valor;                    
                    bVar = 0;
                    setVariableEncontrada(1);
                    c = tablaSimbolos.size();
                }
                else
                {
                    bVar = 1;
                }
            }


         }

    private void modificarParametros(NodoArbol raiz,NodoArbol temporal,String ambito) throws Exception{
       // System.out.println(" modificar parametros --> "+raiz.getEtiqueta());
        Object valor=null;
        NodoArbol aux=null;
        NodoArbol aux1=null;
        String tipo="";
        for(int c=0;c<raiz.getCantidadHijos();c++){
            aux=raiz.getHijoEn(c);
            aux1=temporal.getHijoEn(c);
            valor=evaluar_op(aux, ambito);
            tipo=aux1.getHijoEn(0).getEtiqueta();
            boolean mismoTipo=evaluar_tipo_dato(valor,tipo);
            if(mismoTipo==true){
                modificarParametro(c,valor,ambito);
            }else{
                Error(0,0,"SEMANTICO","No coinciden los tipos en la funcion "+ambito);
            }
           // System.out.println("valor de "+c+" --> "+valor.toString()+" tipo --> "+tipo);
        }
    }
    
    
    private  boolean evaluar_tipo_dato(Object valor,String tipo){
        //System.out.println("Tipo de dato --> "+valor);
        boolean mismo=false;
         if((valor instanceof Integer) && tipo.equalsIgnoreCase("ENTERO")){
            mismo=true;
        }else if(valor instanceof Double && tipo.equalsIgnoreCase("DOBLE")){
            mismo=true;
        }else if(valor instanceof Character && tipo.equalsIgnoreCase("CARACTER")){
            mismo=true;
        }else if(valor instanceof Boolean && tipo.equalsIgnoreCase("BOOLEAN")){
            mismo=true;
        }else if(valor instanceof String && tipo.equalsIgnoreCase("CADENA")){
            mismo=true;
        }
        return mismo;
    }

     private  String evaluar_tipo_dato(Object valor){
        //System.out.println("Tipo de dato --> "+valor);
        String tDato="";
         if((valor instanceof Integer)){
            tDato="ENTERO";
        }else if(valor instanceof Double){
            tDato="DOUBLE";
        }else if(valor instanceof Character){
            tDato="CARACTER";
        }else if(valor instanceof Boolean){
            tDato="BOOLEAN";
        }else if(valor instanceof String){
            tDato="CADENA";
        }
        return tDato;
    }
      private String buscar_tipo_variable(String nombreVar,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            String valor = "";
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < tablaSimbolos.size(); c++)
            {
                
                       if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar)  && tablaSimbolos.get(c).ambito.equalsIgnoreCase(ambito) && (getVariableEncontrada()==0))
                        {
                            //System.out.println("encontro "+nombreVar);
                                valor = tablaSimbolos.get(c).tDato;
                                bVar = 0;
                                setVariableEncontrada(1);
                                c=tablaSimbolos.size();
                        }
                       else
                       {
                           bVar = 1;
                       }
            }
            //System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < tablaSimbolos.size(); c++)
                {
                    //System.err.println("buscar_tipo_variable >> "+nombreVar+"/"+tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar));
                    if (tablaSimbolos.get(c).nombre.equalsIgnoreCase(nombreVar)&& (getVariableEncontrada()==0))
                    {
                        //System.out.println("esto ya se cocio con "+nombreVar);
                        valor = tablaSimbolos.get(c).tDato;
                        setVariableEncontrada(1);
                    }
                }
                
            }

            return valor;

        }
   
    public void evaluar_asignacion(NodoArbol aux,String ambito)throws Exception{
       
                String variable=aux.getHijoEn(0).getEtiqueta();
                 
                Object valor=evaluar_op(aux.getHijoEn(1),ambito);//
                
//                System.out.println("valor de la operacion "+variable+" su valor es -> "+valor.toString());
                String tDato=evaluar_tipo_dato(valor);
//                System.err.println("1111111111111111 tipo de dato --> "+tDato+","+buscar_tipo_variable(variable,ambito));
                tDato=tDato.toLowerCase();
                
                int c=0;
                while(c<aux.getCantidadHijos()){
                    variable=aux.getHijoEn(c).getEtiqueta();
                    if(buscar_tipo_variable(variable,ambito).equalsIgnoreCase(tDato)){
                        modificarAsignacion(variable, valor, ambito);
                    }else{
                       // imprimirConsola("No se le pudo asignar el valor a la variable "+variable+" \n ya que no el valor a ingresar no es del mismo tipo" );
                    }
                    c++;
                }
               // System.out.println("asignacion --> "+variable+"_ "+ambito+"_ "+valor.toString()+" _ "+tDato);
                
                //System.err.println("valor de "+variable+" --> "+valor);
    }

    private void evaluar_incremento(NodoArbol raiz, String ambito) throws Exception{
         Object valVar=evaluar_op(raiz.getHijoEn(1), ambito);;
         Object te=null;
         int a=0;
         Object valor=null;//por fuerza viene un OP
        String var=raiz.getHijoEn(0).getEtiqueta();
       // System.out.println("variable --> "+var);
        
                          if(raiz.getEtiqueta().equalsIgnoreCase("INCREMENTO")){
                              te=buscarVariable(var, ambito);
                            a=(int)te;
                            valor=a+(int)valVar;
                            modificarAsignacion(var, valor, ambito);
                          }else if(raiz.getEtiqueta().equalsIgnoreCase("DECREMENTO")){
                              te=buscarVariable(var, ambito);
                            a=(int)te;
                            valor=a-(int)valVar;
                            modificarAsignacion(var, valor, ambito);
                          }
                            
    }
      
    
}//no tocar

