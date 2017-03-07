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
import java.util.*;
//import sun.net.www.protocol.http.AuthCacheValue;
/**
 *
 * @author Alberth
 */
public class Semantico {
    private Graphviz grafo;
     ArrayList<Logica.Nodo_variable> variables1;
     ArrayList<Logica.Nodo_Metodo_Funcion> metodosFunciones;
     ArrayList<Logica.Nodo_variable> temporalMetodoFuncion;
//     ArrayList<Logica.Nodo_Terminal> terminales;
//     ArrayList<Logica.Nodo_Terminal> NoTerminales;

    // ArrayList<String> conjuntoA;
     Hashtable<String,String> conjuntoA ;
     private String raiz="";

   
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
    ArrayList<Logica.Nodo_variables> listaClases;//contendra la lista de clases que se podran instanciar
    private String tDatoF="";

    public ArrayList<Nodo_Metodo_Funcion> getMetodosFunciones() {
        return metodosFunciones;
    }

    public void setMetodosFunciones(ArrayList<Nodo_Metodo_Funcion> metodosFunciones) {
        this.metodosFunciones = metodosFunciones;
    }

     public String getRaiz() {
        return raiz;
    }

    public void setRaiz(String raiz) {
        this.raiz = raiz;
    }
    public String gettDatoF() {
        return tDatoF;
    }

    public void settDatoF(String tDatoF) {
        this.tDatoF = tDatoF;
    }
    
    
    public ArrayList<Nodo_variables> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Nodo_variables> listaClases) {
        this.listaClases = listaClases;
    }
    public ArrayList<Nodo_variable> getVariables1() {
        return variables1;
    }

    public void setVariables1(ArrayList<Nodo_variable> variables1) {
        this.variables1 = variables1;
    }
    public String getAmbitoAuxMetodo() {
        return ambitoAuxMetodo;
    }

    public void setAmbitoAuxMetodo(String ambitoAuxMetodo) {
        this.ambitoAuxMetodo = ambitoAuxMetodo;
    }
    public String getAmbExtendida() {
        return ambExtendida;
    }

    public void setAmbExtendida(String ambExtendida) {
        this.ambExtendida = ambExtendida;
    }
    public int getCantParametros() {
        return cantParametros;
    }

    public void setCantParametros(int cantParametros) {
        this.cantParametros = cantParametros;
    }
    private int verificarExtendida=0;// 1 o 0, 1 indica que es extendida y 0 significa que no es extendida

    public int getVerificarExtendida() {
        return verificarExtendida;
    }

    public void setVerificarExtendida(int verificarExtendida) {
        this.verificarExtendida = verificarExtendida;
    }
    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
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
    public int getSalir() {
        return salir;
    }

    public void setSalir(int salir) {
        this.salir = salir;
    }

    public int getContinuar() {
        return continuar;
    }

    public void setContinuar(int continuar) {
        this.continuar = continuar;
    }
    private int continuar=0;//0=indica que sigue ejecutando y 1=indica que ya no ejecuta nada
    public int getValidaInstancia() {
        return validaInstancia;
    }

    public void setValidaInstancia(int validaInstancia) {
        this.validaInstancia = validaInstancia;
    }
    public int getValidarClase() {
        return validarClase;
    }

    public void setValidarClase(int validarClase) {
        this.validarClase = validarClase;
    }
    public int getValidarAtributoVariable() {
        return validarAtributoVariable;
    }

    public void setValidarAtributoVariable(int validarAtributoVariable) {
        this.validarAtributoVariable = validarAtributoVariable;
    }
    public int getValidarSobreEscritura() {
        return validarSobreEscritura;
    }

    public void setValidarSobreEscritura(int validarSobreEscritura) {
        this.validarSobreEscritura = validarSobreEscritura;
    }
    public int getValidacionSuper() {
        return validacionSuper;
    }

    public void setValidacionSuper(int validacionSuper) {
        this.validacionSuper = validacionSuper;
    }
     public Semantico(){
        grafo = new Graphviz();        
         variables1=new ArrayList();
         metodosFunciones=new ArrayList();
         temporalMetodoFuncion=new ArrayList();
//         terminales=new ArrayList();
//         NoTerminales=new ArrayList();
//       
         conjuntoA= new Hashtable();
         listaClases=new ArrayList();
    }
     
     public void evaluar_Declaracion(NodoArbol raizDeclaracion)throws Exception{
         NodoArbol aux;
         
         int c=0;
         
         for(c=0;c<raizDeclaracion.getCantidadHijos();c++){
             if(raizDeclaracion.getHijoEn(c).getEtiqueta().equalsIgnoreCase("LENGUAJE")){
                 int d=0;
                 String cadena;
                 aux=raizDeclaracion.getHijoEn(c);
                     //System.out.println(aux.getEtiqueta());
                    // evaluar_lenguaje(aux);
//                
             }else if(raizDeclaracion.getHijoEn(c).getEtiqueta().equalsIgnoreCase("CODIGO")){
                  int d=0;
                 String tipo;
                 String nombre="";
                // System.out.println("codigo ejecucion");
                 aux=raizDeclaracion.getHijoEn(c);
                 


                 evaluar_codigo(aux);
                 mostrarVariables();
                 mostrarMetodosFunciones();
                 
//                 for(d=0;d<aux.getCantidadHijos();d++){
//                    // tipo=aux.getHijoEn(d).getHijoEn(0).getEtiqueta();
//                     //listaNoTerminales(tipo,aux.getHijoEn(d).getHijoEn(1));
//                 }
                 
                 
             }

         }
     }
     
     private void evaluar_codigo(NodoArbol raiz)throws Exception{
//         System.out.println(raiz.getEtiqueta()+" "+raiz.getCantidadHijos());
         NodoArbol raizDeclaracion=null;
         raizDeclaracion=raiz;
         NodoArbol temp=null;
         NodoArbol aux=null;
         int c=0;
         String tDato="";
         String nombreVar="";
         int hijos=0;
       
         for(c=0;c<raizDeclaracion.getCantidadHijos();c++){
             if(raizDeclaracion.getHijoEn(c).getEtiqueta().equalsIgnoreCase("DECLARACION_VARIABLES")){
                 int d=0;
                 String cadena;
                 temp=raizDeclaracion.getHijoEn(c).getHijoEn(0);
                 tDato=raizDeclaracion.getHijoEn(c).getHijoEn(1).getHijoEn(0).getEtiqueta().toString();
                 tDato=tDato.toLowerCase();
                 
                 for(d=0;d<temp.getCantidadHijos();d++){
                     
                     nombreVar=temp.getHijoEn(d).getEtiqueta().toString();
                     nombreVar=nombreVar.toLowerCase();
                     almacenar_variable(nombreVar, tDato, "global", null);
                 }
                 
             }else if(raizDeclaracion.getHijoEn(c).getEtiqueta().equalsIgnoreCase("METODO")){
                  
                  hijos=0;
                temp=raizDeclaracion.getHijoEn(c);
                nombreVar=temp.getHijoEn(0).getEtiqueta().toString();
                aux=temp.getHijoEn(1);
                
                // System.out.println("metodo --> "+nombreVar+" "+aux.getEtiqueta().toString()+" cant hijos --> "+aux.getHijoEn(0).getCantidadHijos());
                 hijos=aux.getHijoEn(0).getCantidadHijos();
                 almacenar_metodo_funcion(nombreVar,"void","metodo",aux,hijos);
                 
             }else if(raizDeclaracion.getHijoEn(c).getEtiqueta().equalsIgnoreCase("FUNCION")){
                  tDato="";
                  hijos=0;
                temp=raizDeclaracion.getHijoEn(c);
                nombreVar=temp.getHijoEn(0).getEtiqueta().toString();
                aux=temp.getHijoEn(1);
                // System.out.println("metodo --> "+nombreVar+" "+aux.getEtiqueta().toString()+" cant hijos --> "+aux.getHijoEn(0).getCantidadHijos());
                 hijos=aux.getHijoEn(0).getCantidadHijos();
                 tDato=aux.getHijoEn(1).getHijoEn(0).getEtiqueta().toString();//extraigo tipo de dato
                 tDato=tDato.toLowerCase();
                 settDatoF(tDato);
                 //este area la voy a comentar
                 evaluar_parametros(aux.getHijoEn(0),nombreVar);//envio de parametros
                 evaluar_rellenoFuncion(nombreVar,aux.getHijoEn(2));
                 imprimirConsola(""+getComprobarRetorno());
                 //hasta aqui va a terminar la comentada
                 if(getComprobarRetorno()==1){
                       almacenar_metodo_funcion(nombreVar,tDato,"funcion",aux,hijos);
                        System.out.println("--------------------------------INICIO RELLENO DE FUNCION -------------------------------");
                        mostrarTablaTemporal();
                        System.out.println("--------------------------------FIN RELLENO DE FUNCION -------------------------------");

                 }else{
                     imprimirConsola("Error Semantico, No existe un retorno para la funcion "+ nombreVar);
                 }
                 
                
                
             }
         }
         
     }
     
     
     
     private void listaNoTerminales(String tipo,NodoArbol noterminales)throws Exception{
         
        // imprimirConsola(tipo+","+noterminales.getCantidadHijos());
         int c=0;
         NodoArbol aux;
         String nombre="";
         for(c=0;c<noterminales.getCantidadHijos();c++){
             aux=noterminales.getHijoEn(c);
             nombre=aux.getHijoEn(0).getEtiqueta();             
           //  pantallaPrincipal.agregarNoTerminal(tipo, nombre);
         }
     }
     
     
     public void compilarULX(String texto){
    NodoArbol instrucciones;
         // String texto="";
        try {
           // texto=texto;
             Reader reader = new StringReader(texto);
           // lexicoUlx scanner = new lexicoUlx(reader);
//            tabla_Errores=scanner.tabla_Errores;
            
           // sintacticoUlx parser = new sintacticoUlx(scanner);
          //  parser.parse();
            //mostrarErrores(tabla_Errores);

          //   instrucciones = parser.raiz;
             
        } catch (Exception ex) {
            //Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocurrio un error "+ex.getMessage());
        }
}//termina

     
     ////////////////////////////////////////////////////////////7PROHIBIDO TOCAR ////////////////////////////
     
     
     //no tocar de aqui hacia abajo
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
            return evaluarParetesis(aux.getHijoEn(0),ambito);
        }else if(aux.getEtiqueta().equalsIgnoreCase("LLAVES")){
            return evaluarParetesis(aux.getHijoEn(0),ambito);
        }else if(aux.getEtiqueta().equalsIgnoreCase("CORCHETES")){
            return evaluarParetesis(aux.getHijoEn(0),ambito);
        }
        //retorna datos
        else if(aux.getEtiqueta().equalsIgnoreCase("FUNCION_METODO_CON_PARAMETROS")){
            setSalir(0);
            setContinuar(0);
            
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
             Nodo_variables var=retornarNodo(ambitoFuncion, getAmbitoAuxMetodo());
            if(var.tDato.equalsIgnoreCase("VACIO")){
                imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
//               evaluar_llamada_funcion(aux.getHijoEn(1),ambito,ambitoFuncion);
             Object va=buscarVariable("retorno", ambitoFuncion);
             NodoArbol pa=(NodoArbol)va;
             Object as=evaluar_op(pa, ambitoFuncion);
             
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
        //RETORNA DATOS
         else if(aux.getEtiqueta().equalsIgnoreCase("FUNCION_METODO_SIN_PARAMETROS")){
            setSalir(0);
            setContinuar(0);
            String ambitoFuncion=aux.getHijoEn(0).getEtiqueta();
           
            Nodo_variables var=retornarNodo(ambitoFuncion, getAmbitoAuxMetodo());
            
           
            if(var.tDato.equalsIgnoreCase("VACIO")){
                imprimirConsola("La llamada a  "+ambitoFuncion.toUpperCase()+" no es posible ya que es un metodo y no retorna ningun valor");
            }else{
                
                 evaluar_fun_sin(ambito,ambitoFuncion);
                 Object va=buscarVariable("retorno", ambitoFuncion);
                  NodoArbol pa=(NodoArbol)va;
                 Object as=evaluar_op(pa, ambitoFuncion);
                // imprimirConsola("retorno"+", "+var.tDato+" , "+var.valor+"ñññ "+as.toString());
                  setSalir(0);
                 setContinuar(0);
                 if(as instanceof Integer){
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
        //CORCHETES    
        else if(aux.getEtiqueta().equalsIgnoreCase("CORCHETE")){
            return evaluarParetesis(aux.getHijoEn(0),ambito);
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
               }else if((tipo.equalsIgnoreCase("BOOL")&& (valo instanceof Boolean))){
                    return (Boolean) valo;
               }
              
        }
        //VIENE EL -- DECREMENTO
        else if(aux.getEtiqueta().equalsIgnoreCase("--")){
             //System.out.println("viene el incrermento puto --> "+aux.getHijoEn(0).getEtiqueta());
             
             if(aux.getHijoEn(0).getEtiqueta().equalsIgnoreCase("ID")){
                    String variable=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
                    Object valo=buscarVariable(variable, ambito);
                    String tipo=buscar_tipo_variable(variable,ambito);
                   // System.out.println("variable a incrementar --> "+variable);
                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
                        modificarAsignacion(variable,(Integer)valo-1,ambito);
                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
                        modificarAsignacion(variable,(Double)valo-1,ambito);
                    }
             }else{
                   Object na=evaluar_op(aux.getHijoEn(0), ambito);
                    if(na instanceof Double){
                        return (double)na-1;
                    }else if(na instanceof Integer){
                        return (Integer)na-1;
                    }else if(na instanceof Character){
                        Integer tutu=convertirCharInt((Character) na);
                        return (Integer)tutu-1;

                    }
             // System.err.println("el incremento trae este valor --> "+na);
             }
             
           
            
                //evaluar_incremento(aux,ambito);
        }
        //viene el incremento ++
         else if(aux.getEtiqueta().equalsIgnoreCase("++")){
            // System.out.println("viene el incrermento puto --> "+aux.getHijoEn(0).getEtiqueta());
             
             if(aux.getHijoEn(0).getEtiqueta().equalsIgnoreCase("ID")){
                    String variable=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
                    Object valo=buscarVariable(variable, ambito);
                    String tipo=buscar_tipo_variable(variable,ambito);
                   // System.out.println("variable a incrementar --> "+variable);
                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
                        modificarAsignacion(variable,(Integer)valo+1,ambito);
                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
                        modificarAsignacion(variable,(Double)valo+1,ambito);
                    }
             }else{
                   Object na=evaluar_op(aux.getHijoEn(0), ambito);
                    if(na instanceof Double){
                        return (double)na+1;
                    }else if(na instanceof Integer){
                        return (Integer)na+1;
                    }else if(na instanceof Character){
                        Integer tutu=convertirCharInt((Character) na);
                        return (Integer)tutu+1;

                    }
             // System.err.println("el incremento trae este valor --> "+na);
             }
             
           
            
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
                 imprimirConsola("ERROR SEMANTICO EN LA SUMA, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA RESTA, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                 imprimirConsola("ERROR SEMANTICO EN LA MULTIPLICACION, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Integer)e1/(Double)e2);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Integer)){
                    int op2=(int)e2;
                    if(op2==0){
                      //  System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Double)e1/(Integer)e2);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Character)){
                Integer tutu=convertirCharInt((Character) e2);
                 int op2=(int)tutu;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        return (Double)((Double)e2/tutu);
                    }
            }else if((e1 instanceof Double )&& (e2 instanceof Double)){
                    double op2=(double)e2;
                    if(op2==0.0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
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
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                        Double pO=(double)((Integer)e1/tutu);
                        return pO;
                    }
                  
            }
            else if((e1 instanceof Integer )&& (e2 instanceof Integer)){
                    int op2=(int)e2;
                    if(op2==0){
//                        System.out.println("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                        imprimirConsola("ERROR SEMANTICO, NO SE PUEDE DIVIDIR DENTRO DE 0");
                    }else{
                         Double pO=(double)((int)e1/(int)e2);
                         return pO;
                    }
            }
            else{
                imprimirConsola("ERROR SEMANTICO EN LA DIVISION, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA POTENCIA, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                    imprimirConsola("ERROR SEMANTICO EN EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
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
                    imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL ==, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                    imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
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
                    imprimirConsola("error semantico en EXPRESION RELACIONAL, NO PUEDE VENIR UN OPERADOR DISTINTO A 1/0 o true/false");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL !=, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL >=, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL <=, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL >, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL <, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                    imprimirConsola("error semantico cerca de AND tiene que venir una expresion boolea para poder evaluar");
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
                    imprimirConsola("error semantico cerca de AND tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 && op2){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL AND, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                    imprimirConsola("error semantico cerca de OR tiene que venir una expresion boolea para poder evaluar");
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
                    imprimirConsola("error semantico cerca de OR tiene que venir una expresion boolea para poder evaluar");
                }
                
                
                if(op1 || op2){
                    return true;
                }else{
                    return false;
                }
            }else{
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL OR, NO ES COMPATIBLE CON LO QUE SOLICITA");
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
                    imprimirConsola("Error semantico el NOT solo acepta 1/0 o true/false");
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
                    imprimirConsola("error semantico cerca de XOR tiene que venir una expresion boolea para poder evaluar");
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
                    imprimirConsola("error semantico cerca de XOR tiene que venir una expresion boolea para poder evaluar");
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
                imprimirConsola("ERROR SEMANTICO EN LA OPERACION RELACIONAL XOR, NO ES COMPATIBLE CON LO QUE SOLICITA");
                
             }
        }
        //no tocar
        //NO PASAR MAS DE AQUI
        return null;
    }
       private void evaluar_incremento(NodoArbol aux,String ambito)throws Exception{
        //   System.err.println("hijos del incremento --> "+aux.getCantidadHijos());
           Object valor=evaluar_op(aux, ambito);
           //System.out.println("valor del op(incremento) del for --> "+valor);
    }
   private void evaluar_MientrasNormal(NodoArbol aux,String ambito)throws Exception{
        setSalir(0);
                Object valor=evaluar_op(aux.getHijoEn(0),ambito);
                //System.out.println("OP MIENTRAS --> "+valor);
                //evaluar_rellenoFuncion(aux.getHijoEn(1), ambito);
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
                       
                      //  //System.out.println("mientras --> "+conta);
                                if(1==getSalir()){
                                     op=false;
                                 }
                                setContinuar(0);
                                conta++;
                    }
                    
                }else{
                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
                    imprimirConsola("error semantico se espera valor logico 1/0 o true/false en MIENTRAS");
                }
               setSalir(0);
    }
   
   
   
   private void evaluar_loop(NodoArbol aux, String ambito) throws Exception{
       ////System.out.println("------------------------------------------------------LOOP------------------------");
       evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
       boolean repeticion=true;
       setSalir(0);
       while(repeticion==true){
           evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
            if(getSalir()==1){
                repeticion=false;
            }else{
                repeticion=true;
            }
            
            
       }
       setSalir(0);
      
   }
      private void evaluar_siNormal(NodoArbol aux,String ambito)throws Exception{
                          
            Object valor=evaluar_op(aux.getHijoEn(0),ambito);
                if((valor instanceof Boolean)){
                    boolean cond=(boolean)valor;
                    
                    if(cond==true){
                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
                       
                    }else{
                        String siOp=aux.getHijoEn(2).getEtiqueta();
                        NodoArbol temp=aux.getHijoEn(2);
                        if(siOp.equalsIgnoreCase("ELSE_IF")){
                               int c=0;
                               while(c<temp.getCantidadHijos()){
                                   if(true==evaluar_Else_If(temp.getHijoEn(c),ambito)){
                                       c=temp.getCantidadHijos();
                                   }else{
                                        c++;
                                   }
                               }
                           // evaluar_rellenoFuncion( ambito,temp);
                        }else if(siOp.equalsIgnoreCase("ELSE")){
                            evaluar_rellenoFuncion(ambito,temp.getHijoEn(0));
                        }
                        
                    }
                 
                 
                }else if((valor instanceof Integer)){
                      int cond=(int)valor;
                    
                    if(cond==1){                        
                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
                       
                    }else if(cond==0){
                        String siOp=aux.getHijoEn(2).getEtiqueta();
                        NodoArbol temp=aux.getHijoEn(2);
                        if(siOp.equalsIgnoreCase("ELSE_IF")){
                           // evaluar_rellenoFuncion(ambito,temp);
                           int c=0;
                               while(c<temp.getCantidadHijos()){
                                   
                                   if(true==evaluar_Else_If(temp.getHijoEn(c),ambito)){
                                       c=temp.getCantidadHijos();
                                   }else{
                                        c++;
                                   }
                                  
                               }
                            
                        }else if(siOp.equalsIgnoreCase("ELSE")){
                            evaluar_rellenoFuncion( ambito,temp.getHijoEn(0));
                            
                        }
                        
                    }else{
                         //System.out.println("error semantico en SI, se requiere una expresion booleana");
                         imprimirConsola("error semantico en SI, se requiere una expresion booleana");
                    }
                }else{
                    //System.out.println("error semantico en SI, se requiere expresion booleana");
                    imprimirConsola("error semantico en SI, se requiere una expresion booleana");
                }
                
    }
      
       private boolean evaluar_Else_If(NodoArbol aux,String ambito)throws Exception{
           boolean res=false;
        
                    if(0==getContinuar()){
                        //System.out.println("evaluar_else_if --> "+aux.getEtiqueta()+" cant hijos --> "+aux.getCantidadHijos());
            Object valor=evaluar_op(aux.getHijoEn(0),ambito);
            //System.out.println("evaluar_else_if --> "+aux.getEtiqueta()+" "+valor.toString());
                if((valor instanceof Boolean)){
                    boolean cond=(boolean)valor;
                    
                    if(cond==true){
                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
                        res=true;
                    }
                 
                 
                }else if((valor instanceof Integer)){
                      int cond=(int)valor;
                    
                    if(cond==1){                        
                        evaluar_rellenoFuncion( ambito,aux.getHijoEn(1));
                        res=true;
                    }else{
                         //System.out.println("error semantico en SI, se requiere una expresion booleana");
                         imprimirConsola("error semantico en ELSE:IF, se requiere una expresion booleana");
                    }
                }else{
                    //System.out.println("error semantico en SI, se requiere expresion booleana");
                    imprimirConsola("error semantico en ELSE_IF, se requiere una expresion booleana");
                }
                
                    }
                
               return res;
    }
       
       
     public void evaluar_paraNormal(NodoArbol aux,String ambito)throws Exception{
        setSalir(0);
        evaluar_asignacion(aux.getHijoEn(0), ambito);//por fuerza viene una asignacion
        Object valor=null;//por fuerza viene un OP
        String var=aux.getHijoEn(0).getHijoEn(0).getEtiqueta();
         Object valVar=null;
         valVar=buscarVariable(var, ambito);
         Object comparacion=evaluar_op(aux.getHijoEn(1), ambito);
         Object step=null;
         //imprimirConsola(""+comparacion);
         
         if(comparacion instanceof Integer){
             int a=(int)valVar;
             int b=(int)comparacion;
             int co=0;
             if(a<b){
                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
                     while(a<b){
                        evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
                        valVar=buscarVariable(var, ambito);
                        a=(int)valVar;
                        valor=a+1;
                        modificarAsignacion(var, valor, ambito);
                        
                     }
                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
                     while(a<b){
                         evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
                        valVar=buscarVariable(var, ambito);
                        a=(int)valVar;
                        step=evaluar_op(aux.getHijoEn(2).getHijoEn(0), ambito);
                        co=(int)step;
                        valor=a+co;
                        modificarAsignacion(var, valor, ambito);
                        
                     }
                 }
             }else if(a>b){
                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
                      while(a>b){
                       evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
                        valVar=buscarVariable(var, ambito);
                        a=(int)valVar;
                        valor=a-1;
                        modificarAsignacion(var, valor, ambito);
                        
                     }
                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
                     while(a>b){
                         evaluar_rellenoFuncion(ambito, aux.getHijoEn(3));
                        valVar=buscarVariable(var, ambito);
                        a=(int)valVar;
                        step=evaluar_op(aux.getHijoEn(2).getHijoEn(0), ambito);
                        co=(int)step;
                        valor=a+co;
                        modificarAsignacion(var, valor, ambito);
                        
                     }
                 }
             }else if(a==b){
                 if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("vacio")){
                     
                 }else if(aux.getHijoEn(2).getEtiqueta().equalsIgnoreCase("step")){
                     while(a==b){
                         
                     }
                 }
             }
         }else{
             imprimirConsola("Error semantico, el valor ingresado en el FOR no es de tipo entero "+comparacion);
         }
        setSalir(0);
    }
    
    
       private void evaluar_repeat_until(NodoArbol aux,String ambito) throws Exception{
        setSalir(0);
        evaluar_rellenoFuncion( ambito,aux.getHijoEn(0));
                        Object valor=evaluar_op(aux.getHijoEn(1),ambito);
                //System.out.println("OP repeat_until --> "+valor);
                
                int conta=0;
                if(valor instanceof Integer){
                    int oP=(int)valor;
                    boolean co=false;
                    
                    if(oP==1){
                        co=false;
                    }else if(oP==0){
                        co=true;
                    }
                         while(co==false){
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
                                //System.out.println("repeat_until --> "+conta);
                                setContinuar(0);
                                conta++;
                        }
                    
                }else if(valor instanceof Boolean){
                    boolean op=(boolean)valor;
                    while(op==false){
                        evaluar_rellenoFuncion(ambito,aux.getHijoEn(0));
                        valor=evaluar_op(aux.getHijoEn(1),ambito);
                        op=(boolean)valor;
                        if(1==getSalir()){
                                     op=true;
                        }
                        //System.out.println("repeat_until --> "+conta);
                        setContinuar(0);
                                conta++;
                    }
                    
                }else{
                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en repeat_until");
                    imprimirConsola("Error semantico se espera valor logico 1/0 o true/false en repeat_until");
                }
                setSalir(0);
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
                        //System.out.println("do_mientras --> "+conta);
                        setContinuar(0);
                                conta++;
                    }
                    
                }else{
                    //System.out.println("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
                    imprimirConsola("error semantico se espera valor logico 1/0 o true/false en Hacer_Mientras");
                }
                setSalir(0);
    }
       public void evaluar_interruptorNormal(NodoArbol aux,String ambito,Object valorComp)throws Exception{
        //System.out.println("switch pos0 --> "+valorComp);
        //System.out.println("switch pos1 --> "+aux.getEtiqueta());
           setSalir(0);
        NodoArbol temp;
        int c=0;
        Object valorComparar=null;
        int op1=0;
        int op2=0;
          
        while(c<aux.getCantidadHijos()){
            temp=aux.getHijoEn(c);
            if(temp.getEtiqueta().equalsIgnoreCase("CASO")){
                valorComparar=evaluar_op(temp.getHijoEn(0), ambito);
                //System.out.println("switch caso valor --> "+valorComparar);
                if((valorComp instanceof Integer) && (valorComparar instanceof Integer)){
                    op1=(int)valorComp;
                    op2=(int)valorComparar;
                    
                    if(op1==op2){
                        evaluar_rellenoFuncion( ambito,temp.getHijoEn(1));
                    }
                }
                
            }else if(temp.getEtiqueta().equalsIgnoreCase("POR_DEFECTO")){
                            evaluar_rellenoFuncion( ambito,temp.getHijoEn(0));
            }
            
            
            c++;
        }
           setSalir(0);
    }
  
//          public void evaluar_asignacion_lista(NodoArbol aux,NodoArbol op,String ambito)throws Exception{
//                String variable=aux.getHijoEn(0).getEtiqueta();
//                Object valor=evaluar_op(op,ambito);//
//                String tDato=evaluar_tipo_dato(valor);
//                System.err.println(" tipo de dato --> "+tDato+","+valor+","+buscar_tipo_variable(variable,ambito));
//                System.out.println("la lista de variables tiene --> "+aux.getCantidadHijos());
//                int c=0;
//                while(c<aux.getCantidadHijos()){
//                    variable=aux.getHijoEn(c).getEtiqueta();
//                    System.err.println("VARIABLE ñacañaca --> "+variable+"--"+tDato+"//"+buscar_tipo_variable(variable, ambito)+"//"+valor);//op.getHijoEn(0).getEtiqueta());
//                    if(buscar_tipo_variable(variable,ambito).equalsIgnoreCase(tDato)){
//                        modificarAsignacion(variable, valor, ambito);
//                    }else{
//                        imprimirConsola("No se le pudo asignar el valor a la variable "+variable+" \n ya que no el valor a ingresar no es del mismo tipo" );
//                    }
//                    c++;
//                }
//                
//                
//                System.err.println("valor de "+variable+" --> "+valor);
//    }
////    
     public void evaluar_asignacion(NodoArbol aux,String ambito)throws Exception{
                String variable=aux.getHijoEn(0).getEtiqueta();
                Object valor=evaluar_op(aux.getHijoEn(1),ambito);//
                //System.out.println("valor de la operacion "+variable+" su valor es -> "+valor.toString());
                String tDato=evaluar_tipo_dato(valor);
                //System.err.println("1111111111111111 tipo de dato --> "+tDato+","+buscar_tipo_variable(variable,ambito));
                tDato=tDato.toLowerCase();
                int c=0;
                while(c<aux.getCantidadHijos()){
                  //  variable=aux.getHijoEn(c).getEtiqueta();
                    if(buscar_tipo_variable(variable,ambito).equalsIgnoreCase(tDato)){
                        modificarAsignacion(variable, valor, ambito);
                    }else{
                        imprimirConsola("No se le pudo asignar el valor a la variable "+variable+" \n ya que no el valor a ingresar no es del mismo tipo" );
                    }
                    c++;
                }
                
                
                //System.err.println("valor de "+variable+" --> "+valor);
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
            tDato="BOOL";
        }else if(valor instanceof String){
            tDato="CADENA";
        }
        return tDato;
    }
       private Object buscarVariable(String nombreVar,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            Object valor = null;
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < temporalMetodoFuncion.size(); c++)
            {
                //System.out.println("VARIABLE --> "+nombreVar);
                       if (temporalMetodoFuncion.get(c).nombre.equalsIgnoreCase(nombreVar) )
                        {
                            //System.out.println("encontro "+nombreVar);
                                valor = temporalMetodoFuncion.get(c).valor;
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
                for (int c = 0; c < variables1.size(); c++)
                {
                    
                        if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar))
                        {
                            //System.out.println("esto ya se cocio con "+nombreVar);
                            valor = variables1.get(c).valor;
                            setVariableEncontrada(1);
                        }
                }
                
            }

            return valor;

        }
       
       
    private String buscar_tipo_variable(String nombreVar,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            String valor = "";
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < temporalMetodoFuncion.size(); c++)
            {
                
                       if (temporalMetodoFuncion.get(c).nombre.equalsIgnoreCase(nombreVar)  && temporalMetodoFuncion.get(c).ambito.equalsIgnoreCase(ambito) && (getVariableEncontrada()==0))
                        {
                            //System.out.println("encontro "+nombreVar);
                                valor = temporalMetodoFuncion.get(c).tDato;
                                bVar = 0;
                                setVariableEncontrada(1);
                                c=temporalMetodoFuncion.size();
                        }
                       else
                       {
                           bVar = 1;
                       }
            }
            //System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < variables1.size(); c++)
                {
                    //System.err.println("buscar_tipo_variable >> "+nombreVar+"/"+variables1.get(c).nombre.equalsIgnoreCase(nombreVar));
                    if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar)&& (getVariableEncontrada()==0))
                    {
                        //System.out.println("esto ya se cocio con "+nombreVar);
                        valor = variables1.get(c).tDato;
                        setVariableEncontrada(1);
                    }
                }
                
            }

            return valor;

        }
   
    
private Integer convertirCharInt(Character con){
                char c = con;
                int i = (int)c;
                        //System.out.println("caracter --> "+i);
                return (Integer)i;
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
                        imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
                    }
                }
                
                        
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("VARIABLE_ASIGNACION_SIMPLE")){
              if(0==getSalir()){
                    if(0==getContinuar()){
                            tipoDato=aux.getHijoEn(0).getEtiqueta().toString();
                            setValidarAtributoVariable(1);
//                            evaluar_variables_crear(ambito,"PRIVADO", tipoDato, aux.getHijoEn(1),"variable");
                          //  evaluar_asignacion_lista(aux.getHijoEn(1),aux.getHijoEn(2),ambito);
                            setValidarAtributoVariable(0);
                    }
              }
                    
                
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("VARIABLE_ASIGNACION_COMPUESTA")){
               if(0==getSalir()){
                    if(0==getContinuar()){
                        imprimirConsola("No se puede declarar una variable con tipo \n de acceso dentro de un metodo o funcion");
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
                    evaluar_paraNormal(aux, ambito);
                    }
                }
               
            }
            //LOOP
            else if(aux.getEtiqueta().equalsIgnoreCase("LOOP")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                    evaluar_loop(aux, ambito);
                 
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
                          Object hola=evaluar_op(aux.getHijoEn(0), ambito);
                           String ho=(String)hola.toString();
                         imprimirConsola(ho);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("ASIGNACION_VARIABLE")){
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
                        //setContinuar(1);
                    }
                }
            }
            else if(aux.getEtiqueta().equalsIgnoreCase("RETORNO")){
                  if(0==getSalir()){
                    
                      if(0==getContinuar()){
                 
                 Object valo=null;//evaluar_op(aux.getHijoEn(0), ambito);
                 String tipo=getTipoRetorno();
                 tipo=tipo.toLowerCase();
                 Object existe=buscarVariable("retorno", ambito);
                        if(existe!=null){
                            valo=evaluar_op(aux.getHijoEn(0), ambito);
                        }else{
                            almacenar_parametros("retorno",aux.getHijoEn(0),ambito,"privado",0,"variable",gettDatoF());         
                           setComprobarRetorno(1);
                            setSalir(1);
                            }
                          
                    if((tipo.equalsIgnoreCase("entero") && (valo instanceof Integer))){
                        if(existe!=null){
                            modificarAsignacion("retorno", valo, ambito);
                        }else{
                                                      
                            }
                        
                    }else if((tipo.equalsIgnoreCase("double") && (valo instanceof Double))){
                          if(existe!=null){
                            modificarAsignacion("retorno", valo, ambito);
                        }else{
                           
                            
                            }
                    }else if((tipo.equalsIgnoreCase("string") && (valo instanceof String))){
                         if(existe!=null){
                            modificarAsignacion("retorno", valo, ambito);
                        }else{
                           
                            
                            }
                    }else if((tipo.equalsIgnoreCase("char")&& (valo instanceof Character))){
                          if(existe!=null){
                            modificarAsignacion("retorno", valo, ambito);
                        }else{
                            
                            
                            }
                    }else if((tipo.equalsIgnoreCase("bool")&& (valo instanceof Boolean))){
                         if(existe!=null){
                            modificarAsignacion("retorno", valo, ambito);
                        }else{
                           
                            
                            
                            }
                    }else{
                       // imprimirConsola("EL TIPO DE DATO EN EL RETORNO NO ES VALIDO EN LA FUNCION "+ambito);
                    }
                  }
                  }
            }
             else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_CONSTRUCTOR_CON_PARAMETROS")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                        if(1==getValidacionSuper()){
                            JOptionPane.showConfirmDialog(null, "me falta terminarlo", "super", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            imprimirConsola("NO PUEDE EXISTIR LA PALABRA SUPER YA QUE NO ES UNA CLASE EXTENDIDA");
                        }
                    }
                }
            }else if(aux.getEtiqueta().equalsIgnoreCase("LLAMADA_CONSTRUCTOR_SIN_PARAMETROS")){
                if(0==getSalir()){
                    if(0==getContinuar()){
                        if(1==getValidacionSuper()){
                            JOptionPane.showConfirmDialog(null, "me falta terminarlo", "super", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            imprimirConsola("NO PUEDE EXISTIR LA PALABRA SUPER YA QUE NO ES UNA CLASE EXTENDIDA");
                        }
                    }
                }
            }
            
           
            c++;
        }
        
        
    }
       
       
       private void modificarAsignacion(String nombreVar,Object valor,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < temporalMetodoFuncion.size(); c++)
            {
                if (temporalMetodoFuncion.get(c).nombre.equalsIgnoreCase(nombreVar) && temporalMetodoFuncion.get(c).ambito.equalsIgnoreCase(ambito) && temporalMetodoFuncion.get(c).tipo.equalsIgnoreCase("variable"))
                {
                    temporalMetodoFuncion.get(c).valor=valor;                    
                    bVar = 0;
                    setVariableEncontrada(1);
                    c = temporalMetodoFuncion.size();
                }
                else
                {
                    bVar = 1;
                }
            }
                int bVarG=0;
            if (bVar == 1 && variableEncontrada == 0)
            {
                for (int c = 0; c < temporalMetodoFuncion.size(); c++)
                {
                    if (temporalMetodoFuncion.get(c).nombre.equalsIgnoreCase(nombreVar) && temporalMetodoFuncion.get(c).ambito.equalsIgnoreCase(ambito) && temporalMetodoFuncion.get(c).tipo.equalsIgnoreCase("atributo"))
                 //   if (temporalMetodoFuncion[c].nombre == nombreVar && temporalMetodoFuncion[c].ambito == "global" && temporalMetodoFuncion[c].rol == "global" && temporalMetodoFuncion[c].tipoVar == "variable")
                    {
//                        //System.out.println("variable modificada --> "+nombreVar);
                                
                               temporalMetodoFuncion.get(c).valor = valor;
                               bVarG=0;
                               setVariableEncontrada(1);
                               c=temporalMetodoFuncion.size();
                    }
                        else
                        {
                            bVarG=1;
                        }
                    }
                }
            
           if (bVarG == 1 && variableEncontrada == 0)
            {
                for (int c = 0; c < variables1.size(); c++)
                {
                    if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar) && variables1.get(c).tipo.equalsIgnoreCase("global"))
                 //   if (variables1[c].nombre == nombreVar && variables1[c].ambito == "global" && variables1[c].rol == "global" && variables1[c].tipoVar == "variable")
                    {
//                        //System.out.println("variable modificada --> "+nombreVar);
                                
                               variables1.get(c).valor = valor;
                               bVarG=0;
                               setVariableEncontrada(1);
                               c=variables1.size();
                    }
                        else
                        {
                      //      Console.WriteLine("meterlo como error semantico no coinciden los tipos para asignar");
                        //    setErrorSemantico("No coinciden los tipos para asignar a la variable "+nombreVar);
                        }
                    }
                }

            }

//    
//    private void evaluar_variables_crear(String nombreClase,String acceso,String tipoDato,NodoArbol raiz,String tipo)throws Exception{
//        int c=0;
//        System.out.println("cantidad de variables --> "+raiz.getCantidadHijos());
//        System.out.println("cantidad de variables instancia --> "+raiz.getEtiqueta());
//        int cantV=0;
//        if(getValidaInstancia()==1){
//            while(cantV<raiz.getCantidadHijos()){
//                nomVar=raiz.getHijoEn(cantV).getEtiqueta().toString();
//                 if(getValidarClase()==1){
//                     almacenar_variable(nomVar,nombreClase,acceso,null,0,tipo,tipoDato,"si");
//                 }else if(getValidarClase()==0){
//                     almacenar_variable(nomVar,nombreClase,acceso,null,0,tipo,tipoDato,"no");
//                 }
//                cantV++;
//            }
//        }else{
//           
//            while(c<raiz.getCantidadHijos()){
//                nomVar=raiz.getHijoEn(c).getEtiqueta().toString();
//                //System.out.println("variable --> "+raiz.getHijoEn(c).getEtiqueta());
//                 if(getValidarClase()==1){
//                     almacenar_variable(nomVar,nombreClase,acceso,null,0,tipo,tipoDato,"si");
//                 }else if(getValidarClase()==0){
//                     almacenar_variable(nomVar,nombreClase,acceso,null,0,tipo,tipoDato,"no");
//                 }
//                c++;
//            }
//        }
//    } //termina de crear variables
////   
////    
    public void evaluarSentencias(String nombreClase,NodoArbol raiz)throws Exception{
          //System.out.println("SENTENCIAS --> "+raiz.getEtiqueta());
          
         NodoArbol aux;
         NodoArbol aux1;
         String tipoDato,tipoAcceso="";
         aux=raiz.getHijoEn(0);
        
        int c=0;
      while(c<aux.getCantidadHijos()){
            
            //System.out.println("SENTENCIA --> "+aux.getHijoEn(c).getEtiqueta());
           
            if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("VARIABLE_SIMPLE")){
               aux1=aux.getHijoEn(c);
                tipoDato=aux1.getHijoEn(0).getEtiqueta().toString();
                ////System.out.println("variable_simple --> "+aux1.getHijoEn(0).getEtiqueta()+","+aux1.getHijoEn(1).getEtiqueta());
//                evaluar_variables_crear(nombreClase,"PUBLICO",tipoDato , aux1.getHijoEn(1),"atributo");
            }
            
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("VARIABLE_COMPUESTA")){
                aux1=aux.getHijoEn(c);
                tipoAcceso=aux1.getHijoEn(0).getEtiqueta().toString();
                tipoDato=aux1.getHijoEn(1).getEtiqueta().toString();
              ////System.out.println("variable_compuesta --> "+tipoAcceso+","+tipoDato+","+aux1.getHijoEn(2));
                setValidarAtributoVariable(1);
//                evaluar_variables_crear(nombreClase,tipoAcceso, tipoDato, aux1.getHijoEn(2),"atributo");
                setValidarAtributoVariable(0);
            }
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("VARIABLE_ASIGNACION_SIMPLE")){
                aux1=aux.getHijoEn(c);
             //   tipoAcceso=aux1.getHijoEn(0).getEtiqueta().toString();
                tipoDato=aux1.getHijoEn(0).getEtiqueta().toString();
//              //System.err.println("variable_simple --> "+tipoAcceso+","+tipoDato+","+aux1.getHijoEn(2));
                setValidarAtributoVariable(1);
//                evaluar_variables_crear(nombreClase,"PUBLICO", tipoDato, aux1.getHijoEn(1),"atributo");
//                evaluar_asignacion_lista(aux1.getHijoEn(1),aux1.getHijoEn(2),nombreClase);
                setValidarAtributoVariable(0);
            }
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("VARIABLE_ASIGNACION_COMPUESTA")){
                aux1=aux.getHijoEn(c);
                tipoAcceso=aux1.getHijoEn(0).getEtiqueta().toString();
                tipoDato=aux1.getHijoEn(1).getEtiqueta().toString();
              ////System.out.println("variable_compuesta --> "+tipoAcceso+","+tipoDato+","+aux1.getHijoEn(2));
                setValidarAtributoVariable(1);
                
//                evaluar_variables_crear(nombreClase,tipoAcceso, tipoDato, aux1.getHijoEn(2),"atributo");
//                evaluar_asignacion_lista(aux1.getHijoEn(2),aux1.getHijoEn(3),nombreClase);
                setValidarAtributoVariable(0);
            }
            
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("INSTANCIA_SIN_PARAMETROS")){
//                aux1=aux.getHijoEn(c);
//                tipoAcceso=aux1.getHijoEn(0).getEtiqueta().toString();
//                tipoDato=aux1.getHijoEn(1).getEtiqueta().toString();
//              ////System.out.println("variable_compuesta --> "+tipoAcceso+","+tipoDato+","+aux1.getHijoEn(2));
//                setValidarAtributoVariable(1);
//                evaluar_variables_crear(nombreClase,tipoAcceso, tipoDato, aux1.getHijoEn(2),"atributo");
//                setValidarAtributoVariable(0);
            }
            
             else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("INSTANCIA_CON_PARAMETROS")){
//                aux1=aux.getHijoEn(c);
//                tipoAcceso=aux1.getHijoEn(0).getEtiqueta().toString();
//                tipoDato=aux1.getHijoEn(1).getEtiqueta().toString();
//              ////System.out.println("variable_compuesta --> "+tipoAcceso+","+tipoDato+","+aux1.getHijoEn(2));
//                setValidarAtributoVariable(1);
//                evaluar_variables_crear(nombreClase,tipoAcceso, tipoDato, aux1.getHijoEn(2),"atributo");
//                setValidarAtributoVariable(0);
            }
             
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("INSTANCIA_NULA")){
//                aux1=aux.getHijoEn(c);
//                System.out.println("instancia nula --> "+aux1.getCantidadHijos()+","+aux1.getHijoEn(0).getEtiqueta().toString()+","+aux1.getHijoEn(1).getEtiqueta().toString());
//                tipoDato=aux1.getHijoEn(0).getEtiqueta().toString();
//                setValidaInstancia(1);
//                evaluar_variables_crear(nombreClase,tipoAcceso, tipoDato, aux1.getHijoEn(1),"atributo");
//                setValidaInstancia(0);
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("ARREGLOS_COMPUESTA")){
               //me falta
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("ARREGLOS_SIMPLE")){
               //me falta
            }
            /////////////////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("FUNCION_SIMPLE_SIN_PARAMETROS")){
                  aux1=aux.getHijoEn(c);
                  setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                String tDato=aux1.getHijoEn(0).getEtiqueta();
                String amb=aux1.getHijoEn(1).getEtiqueta();
                amb=amb.toLowerCase();
                setTipoRetorno(tDato);
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(2));  
                setAmbitoAuxMetodo(nombreClase);
//                  JOptionPane.showConfirmDialog(null, "FUNCION_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    
                  if(tDato.equalsIgnoreCase("VACIO")){
                                    if(1==getComprobarRetorno()){
                                         imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                                     }else if(0==getComprobarRetorno()){
                     //                    JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                                         if(amb.equalsIgnoreCase(nombreClase)){
//                                            almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(2), 0, "constructor", "VACIO", "no");
                                        }else{
//                                            almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(2), 0, "metodo", "VACIO", "no");
                                        }
                                         

                                     }
                  }else{
                      if(1==getComprobarRetorno()){
//                         almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(2), 0, "funcion", tDato, "no");                          
                     }else if(0==getComprobarRetorno()){
     //                    JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                         imprimirConsola("No se encontro la palabra reservada RETORNO en la función "+amb);
                     }
                  }
                  setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
            }
            /////////////////////////////////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("FUNCION_SIMPLE_CON_PARAMETROS")){
                  aux1=aux.getHijoEn(c);
                  setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String tDato=aux1.getHijoEn(0).getEtiqueta();
                String amb=aux1.getHijoEn(1).getEtiqueta();
                amb=amb.toLowerCase();
                setTipoRetorno(tDato);
                setCantParametros(0);
//                evaluar_parametros(aux1.getHijoEn(2),amb);
//                evaluar_rellenoFuncion(amb,aux1.getHijoEn(3));  
             
//                  JOptionPane.showConfirmDialog(null, "FUNCION_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    
                  if(tDato.equalsIgnoreCase("VACIO")){                             
                       if(1==getComprobarRetorno()){
                             imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                         }else if(0==getComprobarRetorno()){
                             //System.out.println("constructor "+amb+"->"+nombreClase);
                             if(amb.equalsIgnoreCase(nombreClase)){
//                                almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(3), getCantParametros(), "constructor", "VACIO", "no");
                            }else{
//                                almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(3), getCantParametros(), "metodo", "VACIO", "no");
                            }
                             
                         }
                  }else{                      
                      if(1==getComprobarRetorno()){
//                              almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(3), getCantParametros(), "funcion", tDato, "no");
                         }else if(0==getComprobarRetorno()){
                             imprimirConsola("No se encontro la palabra reservada RETORNO en la función "+amb);
                         }
                  }
                  setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
            }
            ///////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("METODO_SIMPLE_SIN_PARAMETROS")){
                aux1=aux.getHijoEn(c);
                setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String amb=aux1.getHijoEn(0).getEtiqueta();
                amb=amb.toLowerCase();
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(1));
              if(1==getComprobarRetorno()){
                    imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                }else if(0==getComprobarRetorno()){
//                    JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    if(amb.equalsIgnoreCase(nombreClase)){
//                        almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(1), 0, "constructor", "VACIO", "no");                    
                    }else{
//                        almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(1), 0, "metodo", "VACIO", "no");                    
                    }
                    
                }
                setSalir(0);
                setContinuar(0);
            }
            ////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("METODO_SIMPLE_CON_PARAMETROS")){
               aux1=aux.getHijoEn(c);
                setSalir(0);
                  setContinuar(0);
                String amb=aux1.getHijoEn(0).getEtiqueta();
                amb=amb.toLowerCase();
                setAmbitoAuxMetodo(nombreClase);
                setCantParametros(0);
//                evaluar_parametros(aux1.getHijoEn(1),amb);
                
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(2));
              if(1==getComprobarRetorno()){
                    imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                }else if(0==getComprobarRetorno()){
//                    JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_CON_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    
                    if(amb.equalsIgnoreCase(nombreClase)){
//                        almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(2), getCantParametros(), "constructor", "VACIO", "no");                  
                    }else{
//                        almacenar_variable(amb, nombreClase, "PUBLICO", aux1.getHijoEn(2), getCantParametros(), "metodo", "VACIO", "no");                  
                    }
                }
              setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
            }
            ///////////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("FUNCION_COMPUESTO_SIN_PARAMETROS")){
                  aux1=aux.getHijoEn(c);
                  setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String acceso=aux1.getHijoEn(0).getEtiqueta();
                String tDato=aux1.getHijoEn(1).getEtiqueta();
                String amb=aux1.getHijoEn(2).getEtiqueta();
                amb=amb.toLowerCase();
                setTipoRetorno(tDato);
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(3));  
              
//                  JOptionPane.showConfirmDialog(null, "FUNCION_SIMPLE_CON_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    
                  if(tDato.equalsIgnoreCase("VACIO")){                 
                      if(1==getComprobarRetorno()){
                            imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                        }else if(0==getComprobarRetorno()){
                            
                            if(amb.equalsIgnoreCase(nombreClase)){
//                                    almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(3), 0, "constructor", "VACIO", "no");
                                }else{
//                                    almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(3), 0, "metodo", "VACIO", "no");
                                }
                            
                        }
                  }else{
                      
                      if(1==getComprobarRetorno()){
//                            almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(3), 0, "funcion", tDato, "no");
                        }else if(0==getComprobarRetorno()){
                            imprimirConsola("No se encontro la palabra reservada RETORNO en la función "+amb);
                        }
                      
                  }
                  setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("FUNCION_COMPUESTO_CON_PARAMETROS")){
                aux1=aux.getHijoEn(c);
                  setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String acceso=aux1.getHijoEn(0).getEtiqueta();
                String tDato=aux1.getHijoEn(1).getEtiqueta();
                String amb=aux1.getHijoEn(2).getEtiqueta();
                amb=amb.toLowerCase();
                setTipoRetorno(tDato);
                setCantParametros(0);
//                evaluar_parametros(aux1.getHijoEn(3),amb);
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(4));  
               
                  
                        if(tDato.equalsIgnoreCase("VACIO")){
                             if(1==getComprobarRetorno()){
                                 imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                             }else if(0==getComprobarRetorno()){
                                 
                                 if(amb.equalsIgnoreCase(nombreClase)){
                                    //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(4), getCantParametros(), "constructor", "VACIO", "no");
                                }else{
                                    //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(4), getCantParametros(), "metodo", "VACIO", "no");
                                }
                             }
                        }else{
                            
                             if(1==getComprobarRetorno()){
                                 //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(4), getCantParametros(), "funcion", tDato, "no");
                             }else if(0==getComprobarRetorno()){
                                 imprimirConsola("No se encontro la palabra reservada RETORNO en la función "+amb);

                             }
                        }
                        setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
                
                
            }
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("METODO_COMPUESTO_SIN_PARAMETROS")){
               
                 aux1=aux.getHijoEn(c);
                setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String acceso=aux1.getHijoEn(0).getEtiqueta();
                String amb=aux1.getHijoEn(1).getEtiqueta();
                amb=amb.toLowerCase();
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(2));
              if(1==getComprobarRetorno()){
                    imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                }else if(0==getComprobarRetorno()){
                  //  JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_SIN_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    if(amb.equalsIgnoreCase(nombreClase)){
                        //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(2), 0, "constructor", "VACIO", "no");
                    }else{
                        //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(2), 0, "metodo", "VACIO", "no");
                    }
                    
                        
                    
                }
              setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
                
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("METODO_COMPUESTO_CON_PARAMETROS")){
                aux1=aux.getHijoEn(c);
                setSalir(0);
                  setContinuar(0);
                  setComprobarRetorno(0);
                  setAmbitoAuxMetodo(nombreClase);
                String acceso=aux1.getHijoEn(0).getEtiqueta();
                String amb=aux1.getHijoEn(1).getEtiqueta();
                amb=amb.toLowerCase();
                setCantParametros(0);
//                evaluar_parametros(aux1.getHijoEn(2),amb);
                evaluar_rellenoFuncion(amb,aux1.getHijoEn(3));
              if(1==getComprobarRetorno()){
                    imprimirConsola("NO PUEDE VENIR LA PALABRA RESERVADA RETORNO EN METODO "+amb);
                }else if(0==getComprobarRetorno()){
                 //   JOptionPane.showConfirmDialog(null, "METODO_SIMPLE_CON_PARAMETROS", "METODOS", JOptionPane.INFORMATION_MESSAGE);
                    if(amb.equalsIgnoreCase(nombreClase)){
                        //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(3), getCantParametros(), "constructor", "VACIO", "no");
                    }else{
                        //almacenar_variable(amb, nombreClase, acceso, aux1.getHijoEn(3), getCantParametros(), "metodo", "VACIO", "no");
                    }
                    
                    
                }
              setComprobarRetorno(0);
                setSalir(0);
                setContinuar(0);
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("SOBREESCRITURA")){
               
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("IMPRIMIR")){
                
//                Object hola=evaluar_op(aux.getHijoEn(c).getHijoEn(0), nombreClase);
//                String ho=(String)hola.toString();
//                System.out.println(" imprimir --> "+ho);
//                         imprimirConsola(ho);
//                
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("ASIGNACION")){
//                        evaluar_asignacion(aux.getHijoEn(c), nombreClase);  
            }
           
            
            c++;
        }
    }
     
    public void evaluarClaseS(NodoArbol clases) throws Exception{
       // System.out.println("CLASE --> "+clases.getHijoEn(0).getEtiqueta()+","+clases.getHijoEn(1).getEtiqueta());
         NodoArbol aux;
        String nombreClase=clases.getHijoEn(0).getEtiqueta().toString();
        int c=0;
       if(clases.getHijoEn(1).getEtiqueta().equalsIgnoreCase("SENTENCIAS")){
           //System.out.println("SENTENCIAS");
           aux=clases.getHijoEn(1);
           evaluarSentencias(nombreClase, aux);
       }else if(clases.getHijoEn(1).getEtiqueta().equalsIgnoreCase("IMPORTACION")){
           //System.out.println("IMPORTACION");
       }
        
    } //termina lo de la evaluacion de clases
    
    public void evaluarCod(NodoArbol raiz) throws Exception{
        //System.out.println(raiz.getEtiqueta());
        int c=0;
        NodoArbol aux;
        String nombreClase="";
        while(c<raiz.getCantidadHijos()){
           // aux=raiz.getHijoEn(c);
          //  System.out.println("LENGUAJE INTERNO --> "+raiz.getHijoEn(c).getEtiqueta());
            
           if(raiz.getHijoEn(c).getEtiqueta().equalsIgnoreCase("CLASE_SIMPLE")){
                setValidacionSuper(0);
                setValidarClase(0);
                
                aux=raiz.getHijoEn(c);
                nombreClase=aux.getHijoEn(0).getEtiqueta().toString();
                //System.out.println("cantidad de hijos de la clase "+nombreClase+","+aux.getCantidadHijos());
                
                //almacenar_variable(nombreClase, "NINGUNA", "PUBLICO", aux.getHijoEn(1), 0, "clase", "NINGUNA", "no");
//                almacenar_clases(nombreClase, "NINGUNA", "PUBLICO", aux.getHijoEn(1), 0, "clase", "NINGUNA", "no");
                evaluarClaseS(raiz.getHijoEn(c));
                
                setValidacionSuper(1);
                setValidarClase(1);
            }else if(raiz.getHijoEn(c).getEtiqueta().equalsIgnoreCase("CLASE_EXTENDIDA")){                
                 setValidacionSuper(1);
                setValidarClase(1);
                
                aux=raiz.getHijoEn(c);
               // imprimirConsola("clase extendida "+nombreClase+"--"+getAmbExtendida()+"--"+aux.getEtiqueta());
                nombreClase=aux.getHijoEn(0).getEtiqueta().toString();
                //ambExtendida=aux.getHijoEn(1).getEtiqueta().toString();
                setAmbExtendida(aux.getHijoEn(1).getEtiqueta().toString());
                setAmbitoAuxMetodo(aux.getHijoEn(1).getEtiqueta().toString());
                //System.out.println("cantidad de hijos de la clase "+nombreClase+","+aux.getCantidadHijos());
                
                //almacenar_variable(nombreClase, getAmbExtendida(), "PUBLICO", aux.getHijoEn(2), 0, "clase", "NINGUNA", "si");
//                almacenar_clases(nombreClase, getAmbExtendida(), "PUBLICO", aux.getHijoEn(2), 0, "clase", "NINGUNA", "si");
                evaluarClaseS(raiz.getHijoEn(c));
                
                setValidacionSuper(0);
                setValidarClase(0);
                
            }
            
            c++;
        }
    }//termina de evaluar el codigo
    
     
    public void mostrarVariables(){
           
         System.out.println("nombre,tDato,tipo,valor");
        for(int c=0;c<variables1.size();c++){
            System.out.println(variables1.get(c).nombre+" , "+variables1.get(c).tDato+" , "+variables1.get(c).tipo+" , "+variables1.get(c).valor);
        }
    }
    
//    public void mostrarTerminales(){
//           
//         System.out.println("nombre,tDato");
//        for(int c=0;c<terminales.size();c++){
////            System.out.println(terminales.get(c).nombre+" , "+terminales.get(c).tDato);
//        }
//    }
//     public void mostrarNoTerminales(){
//           
//         System.out.println("nombre,tDato");
//        for(int c=0;c<NoTerminales.size();c++){
////            System.out.println(NoTerminales.get(c).nombre+" , "+NoTerminales.get(c).tDato);
//        }
//    }
      public void mostrarMetodosFunciones(){
       
         System.out.println("nombre,tDato,tipo,valor,cantHijos");
        for(int c=0;c<metodosFunciones.size();c++){
            System.out.println(metodosFunciones.get(c).nombre+" , "+metodosFunciones.get(c).tDato+" , "+metodosFunciones.get(c).tipo+" , "+metodosFunciones.get(c).valor+" , "+metodosFunciones.get(c).cantHijos);
        }
    }
      
      public void mostrarTablaTemporal(){
       
         System.out.println("nombre,valor,ambito,acceso,posicion,tipo,tDato");
        for(int c=0;c<temporalMetodoFuncion.size();c++){
            System.out.println(temporalMetodoFuncion.get(c).nombre+" , "+temporalMetodoFuncion.get(c).valor+" , "+temporalMetodoFuncion.get(c).ambito+" , "+temporalMetodoFuncion.get(c).acceso+" , "+temporalMetodoFuncion.get(c).posicion+" , "+temporalMetodoFuncion.get(c).tipo+" , "+temporalMetodoFuncion.get(c).tDato);
        }
    }
//       public void mostrarClases(){
//           
//         System.out.println("nombreClase,valor,ambito,acceso,posicion,tipo,tDato,extendida");
//        for(int c=0;c<listaClases.size();c++){
//            System.out.println(listaClases.get(c).nombre+" , "+listaClases.get(c).ambito+" ,"+listaClases.get(c).tDato);
//        }
//    }
      
       private void almacenar_variable(String nombreVar,String tDato,String ambito,Object valor) throws Exception{
         retornoExistenciaVariable = 0;
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
             if (variables1.size() == 0)
                {
//                    variables1.add(new Nodo_variables(nombreVar,tDato,ambito,valor));
                     
                }
                else
                {
                    for (contFor = 0; contFor < variables1.size(); contFor++)
                    {
                        if (variables1.get(contFor).nombre.equalsIgnoreCase(nombreVar) && variables1.get(contFor).tipo.equalsIgnoreCase(ambito))
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
                        imprimirConsola("Error semantico ya existe la variable "+nombreVar+"");
               //        Console.WriteLine("ya existe la variable " + nombreVar);
                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
//                         variables1.add(new Nodo_variables(nombreVar,tDato,ambito,valor));
                    }
            }

    }
      
      
         private void almacenar_parametros(String nombreVar,Object valor,String ambito,String acceso,int posicion,String tipo,String tDato) throws Exception{
         retornoExistenciaVariable = 0;
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
             if (temporalMetodoFuncion.size() == 0)
                {
                    temporalMetodoFuncion.add(new Nodo_variable(nombreVar,valor,ambito,acceso,posicion,tipo,tDato,1,1,"global"));
                     
                }
                else
                {
                    for (contFor = 0; contFor < temporalMetodoFuncion.size(); contFor++)
                    {
                        if (temporalMetodoFuncion.get(contFor).nombre.equalsIgnoreCase(nombreVar) && temporalMetodoFuncion.get(contFor).ambito.equalsIgnoreCase(ambito))
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
                        imprimirConsola("Error semantico ya existe la variable "+nombreVar+"");
               //        Console.WriteLine("ya existe la variable " + nombreVar);
                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
                         temporalMetodoFuncion.add(new Nodo_variable(nombreVar,valor,ambito,acceso,posicion,tipo,tDato,1,1,"global"));
                    }
            }

    }
      
       
         private void almacenar_metodo_funcion(String nombreVar,String tDato,String tipo,NodoArbol valor,int hijos){
         retornoExistenciaVariable = 0;
         nombreVar=nombreVar.toLowerCase();
         int contFor=0;
             if (metodosFunciones.isEmpty())
                {
                    metodosFunciones.add(new Nodo_Metodo_Funcion(nombreVar,tDato,tipo,valor,hijos));
                     
                }
                else
                {
                    for (contFor = 0; contFor < metodosFunciones.size(); contFor++)
                    {
                        if (metodosFunciones.get(contFor).nombre.equalsIgnoreCase(nombreVar) && (metodosFunciones.get(contFor).cantHijos==hijos))
                        {
                            retornoExistenciaVariable = 1;// existe la variable
                        }
                    }

                    if (retornoExistenciaVariable == 1)
                    {
               //        Console.WriteLine("ya existe la variable " + nombreVar);
                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
                    }
                    else
                    {
                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
                         metodosFunciones.add(new Nodo_Metodo_Funcion(nombreVar,tDato,tipo,valor,hijos));
                    }
            }

    }
       
       
//    private void almacenar_clases(String nombreVar,String ambito,String acceso,Object valor,int pos,String tipo,String tipoDato,String extendida){
//         retornoExistenciaVariable = 0;
//         nombreVar=nombreVar.toLowerCase();
//         int contFor=0;
//             if (listaClases.size() == 0)
//                {
//                    listaClases.add(new Nodo_variables(nombreVar,valor,ambito,acceso,pos,tipo,tipoDato,extendida));
//                     
//                }
//                else
//                {
//                    for (contFor = 0; contFor < listaClases.size(); contFor++)
//                    {
//                        if (listaClases.get(contFor).nombre.equalsIgnoreCase(nombreVar)  && listaClases.get(contFor).tipo.equalsIgnoreCase(tipo)  && listaClases.get(contFor).ambito.equalsIgnoreCase(ambito))
//                        {
//                            retornoExistenciaVariable = 1;// existe la variable
//                        }
//                    }
//
//                    if (retornoExistenciaVariable == 1)
//                    {
//               //        Console.WriteLine("ya existe la variable " + nombreVar);
//                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
//                    }
//                    else
//                    {
//                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
//                         listaClases.add(new Nodo_variables(nombreVar,valor,ambito,acceso,pos,tipo,tipoDato,extendida));
//                    }
//            }
//
//    }
////      
    private void evaluar_parametros(NodoArbol parametro,String ambito) throws Exception{
        int c=0;
        NodoArbol aux;
        String variable="";
        String tipoD="";
         
          
        while(c<parametro.getCantidadHijos()){
            aux=parametro.getHijoEn(c);
//            System.out.println("parametro --> "+c);
            if(aux.getEtiqueta().equalsIgnoreCase("PARAMETRO")){
                variable=aux.getHijoEn(0).getEtiqueta();
                variable=variable.toLowerCase();
                
                tipoD=aux.getHijoEn(1).getHijoEn(0).getEtiqueta();
                tipoD=tipoD.toLowerCase();
                
                almacenar_parametros(variable, null, ambito, "privado", c, "atributo", tipoD);
              //   System.out.println(ambito+" "+variable+" "+tipoD);
                //almacenar_parametros(am);
                //cantParametros++;
            }
            
            c++;
        }
    }
//     
//    
//    private void evaluar_llamada_funcion(NodoArbol hijoEn, String ambito, String ambitoFuncion) throws Exception{
//       
//        int c=0;
//       String nombre="";
//       Object valor=null;
//        System.out.println("padre --> ");//+padre.nombre);
//       Nodo_variables padre=retornarNodo(ambitoFuncion,getAmbitoAuxMetodo());
//          System.out.println("padre ---> "+padre.nombre+",hijos --> "+padre.posicion+", hijoEN --> "+hijoEn.getCantidadHijos());
//       while(c<hijoEn.getCantidadHijos()){
//           
//           valor=evaluar_op(hijoEn.getHijoEn(c), ambito);
//           System.err.println("ambito llamada funcion --> "+ambito+","+c+","+valor);
//           modificarParametro(c,valor,ambitoFuncion);
//           c++;
//       }
//       
//        evaluar_rellenoFuncion(ambitoFuncion,(NodoArbol) padre.valor);
//    }
//      
    public void evaluar_fun_sin( String ambito, String ambitoFuncion) throws Exception{
       Nodo_variables padre=retornarNodo(ambitoFuncion,getAmbitoAuxMetodo());
        imprimirConsola("entro a la clase evaluar_fun_sin de la clase semantico");
        evaluar_rellenoFuncion( ambitoFuncion,(NodoArbol) padre.valor);
    }
    
    public void evaluar_fun_sin_instancia( String ambito, String ambitoFuncion) throws Exception{
        Nodo_variables padre=retornarNodoObjeto(ambito,ambitoFuncion);
        NodoArbol padreH=(NodoArbol)padre.valor;
        evaluar_rellenoFuncion(ambito,padreH);
    }
//    
//  public void modificarParametro(int index,Object valor,String ambito)
//        {
//            setVariableEncontrada(0);
//            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
//            for (int c = 0; c < variables1.size(); c++)
//            {
//                System.out.println(variables1.get(c).nombre+" , "+variables1.get(c).posicion+" ,"+index);
//                if (variables1.get(c).posicion==index && variables1.get(c).ambito.equalsIgnoreCase(ambito) && variables1.get(c).acceso.equalsIgnoreCase("privado") && variables1.get(c).tipo.equalsIgnoreCase("variable"))
//                {
//                        variables1.get(c).valor=valor;                    
//                    bVar = 0;
//                    setVariableEncontrada(1);
//                    c = variables1.size();
//                }
//                else
//                {
//                    bVar = 1;
//                }
//            }
//
//
//         }
//    
       private Nodo_variables retornarNodo(String nombreVar,String ambito)
        {
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            Nodo_variables valor = null;
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < variables1.size(); c++)
            {
             //   System.out.println("VARIABLE --> "+nombreVar+","+getAmbitoAuxMetodo());
                       if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar)  && variables1.get(c).tipo.equalsIgnoreCase(getAmbitoAuxMetodo()) )
                        {
                   //         System.out.println("encontro "+nombreVar);
//                                valor = variables1.get(c);
                     //           System.out.println(nombreVar+"--> "+valor);
                                bVar = 0;
                                setVariableEncontrada(1);
                        }
                       
                       else
                       {
                           bVar = 1;
                       }
            }
          //  System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < variables1.size(); c++)
                {
                    
                    if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar) && variables1.get(c).tipo.equalsIgnoreCase("no") )
                    {
                  //      System.out.println("esto ya se cocio con "+nombreVar);
//                        valor = variables1.get(c);
                        setVariableEncontrada(1);
                    }
                }
                
            }

            return valor;

        }
          private Nodo_variables retornarNodoObjeto(String nombreVar,String ambito) throws Exception
        {
            imprimirConsola("nodo_Variables --> "+nombreVar+"_"+ambito);
            nombreVar=nombreVar.toLowerCase();
            setVariableEncontrada(0);
            Nodo_variables valor = null;
            int bVar = 0;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
            for (int c = 0; c < variables1.size(); c++)
            {
              //  System.out.println("VARIABLE --> "+nombreVar+","+getAmbitoAuxMetodo());
                       if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar)  && variables1.get(c).tipo.equalsIgnoreCase(ambito) )
                        {
                //            System.out.println("encontro "+nombreVar);
//                                valor = variables1.get(c);
                  //              System.out.println(nombreVar+"--> "+valor);
                                bVar = 0;
                                setVariableEncontrada(1);
                        }
                       
                       else
                       {
                           bVar = 1;
                       }
            }
          //  System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
            if (bVar == 1 && variableEncontrada==0)
            {
                for (int c = 0; c < variables1.size(); c++)
                {
                    
                    if (variables1.get(c).nombre.equalsIgnoreCase(nombreVar) && variables1.get(c).tipo.equalsIgnoreCase("no") )
                    {
             //           System.out.println("esto ya se cocio con "+nombreVar);
//                        valor = variables1.get(c);
                        setVariableEncontrada(1);
                    }
                }
                
            }

            return valor;

        }
  
      public Object evaluarParetesis(NodoArbol raiz,String ambito) throws Exception{
        NodoArbol aux=raiz;
        return evaluar_op(aux,ambito);
      //  System.out.println("auxiliar --> "+aux.getEtiqueta() +" valor--> "+ho);
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
    
    private static void imprimirConsola(String error) throws Exception{
       // System.out.println(error);
        
//        principal.imprimirConsola("\""+error+"\"");
    }

    private void evaluar_lenguaje(NodoArbol aux) throws Exception{
        
        int c=0;
        NodoArbol temp=null;
        for(c=0;c<aux.getCantidadHijos();c++){
            if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("TERMINALES")){
                temp=aux.getHijoEn(c);
                evaluar_terminales(temp);
//                mostrarTerminales();
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("NOTERMINALES")){
             //   System.out.println("NOTERMINALES");
                temp=aux.getHijoEn(c);
                evaluar_No_Terminales(temp);
//                mostrarNoTerminales();
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("PRECEDENCIA_ASOCIATIVIDAD")){
                System.out.println("PRECEDENCIA_ASOCIATIVIDAD");
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("INICIO")){
                
                String nombre="";
                temp=aux.getHijoEn(c);
                nombre=temp.getHijoEn(0).getEtiqueta().toString();
                nombre=nombre.toLowerCase();
                System.out.println("INICIO -> "+nombre);
//                if(true==buscarNoTerminal(nombre)){
//                    setRaiz(nombre);
//                }else{
//                    imprimirConsola("ERROR SEMANTICO, No a sido declarado "+nombre+" en los No Terminales");
//                }
                    
                //buscarNoTerminal();
                
            }else if(aux.getHijoEn(c).getEtiqueta().equalsIgnoreCase("GRAMATICAS")){
                temp=aux.getHijoEn(c);
                evaluar_gramaticas(temp);
               
            }
        }
    }

    private void evaluar_terminales(NodoArbol temp) throws Exception{
        
        
        int d=0;
        for(d=0;d<temp.getCantidadHijos();d++){
          //  System.out.println(temp.getHijoEn(d).getEtiqueta());
            evaluar_terminal(temp.getHijoEn(d));
        }
        
    }

    private void evaluar_terminal(NodoArbol ter) throws Exception{
        String tDato="";
        String nTerminal="";
        if(ter.getHijoEn(1).getEtiqueta().equalsIgnoreCase("VACIO")){
            tDato="null";    
        }else{
            tDato=ter.getHijoEn(1).getHijoEn(0).getEtiqueta().toString();
        }
        int d=0;
        NodoArbol temp=null;
        temp=ter.getHijoEn(0);
        for(d=0;d<temp.getCantidadHijos();d++){
                     
                     nTerminal=temp.getHijoEn(d).getEtiqueta().toString();
                     nTerminal=nTerminal.toLowerCase();
                 //    System.out.println(nTerminal+","+tDato);
//                     almacenar_terminales(nTerminal, tDato);
                 }
        
    }

//    private void almacenar_terminales(String nombreVar, String tDato) throws Exception{
//        retornoExistenciaVariable = 0;
//         nombreVar=nombreVar.toLowerCase();
//         int contFor=0;
//             if (terminales.size() == 0)
//                {
//                    terminales.add(new Nodo_Terminal(nombreVar,tDato));
//                     
//                }
//                else
//                {
//                    for (contFor = 0; contFor < terminales.size(); contFor++)
//                    {
//                        if (terminales.get(contFor).nombre.equalsIgnoreCase(nombreVar))
//                        {
//                            retornoExistenciaVariable = 1;// existe la variable
//                        }
//                    }
//
//                    if (retornoExistenciaVariable == 1)
//                    {
//                        
//                        imprimirConsola("Error semantico ya existe el terminal "+nombreVar+"");
//               //        Console.WriteLine("ya existe la variable " + nombreVar);
//                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
//                    }
//                    else
//                    {
//                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
//                         terminales.add(new Nodo_Terminal(nombreVar,tDato));
//                    }
//                }
//    }

    private void evaluar_No_Terminales(NodoArbol temp) throws Exception{
         
        int d=0;
        for(d=0;d<temp.getCantidadHijos();d++){
          //  System.out.println(temp.getHijoEn(d).getEtiqueta());
            evaluar_Noterminal(temp.getHijoEn(d));
        }
    }

    private void evaluar_Noterminal(NodoArbol ter)throws Exception{
         String tDato="";
        String nTerminal="";
        if(ter.getHijoEn(1).getEtiqueta().equalsIgnoreCase("VACIO")){
            tDato="null";    
        }else{
            tDato=ter.getHijoEn(1).getHijoEn(0).getEtiqueta().toString();
        }
        int d=0;
        NodoArbol temp=null;
        temp=ter.getHijoEn(0);
        for(d=0;d<temp.getCantidadHijos();d++){
                     
                     nTerminal=temp.getHijoEn(d).getEtiqueta().toString();
                     nTerminal=nTerminal.toLowerCase();
                  //   System.out.println(nTerminal+","+tDato);
//                     almacenar_Noterminales(nTerminal, tDato);
                 }
    }

//    private void almacenar_Noterminales(String nombreVar, String tDato)  throws Exception{
//          retornoExistenciaVariable = 0;
//         nombreVar=nombreVar.toLowerCase();
//         int contFor=0;
//         
//         if(true==buscarTerminal(nombreVar)){
//             imprimirConsola("Error semantico ya existe el TERMINAL "+nombreVar+" con el mismo nombre");
//         }else
//         {
//         
//             if (NoTerminales.size() == 0)
//                {
//                    NoTerminales.add(new Nodo_Terminal(nombreVar,tDato));
//                     
//                }
//                else
//                {
//                    for (contFor = 0; contFor < NoTerminales.size(); contFor++)
//                    {
//                        if (NoTerminales.get(contFor).nombre.equalsIgnoreCase(nombreVar))
//                        {
//                            retornoExistenciaVariable = 1;// existe la variable
//                        }
//                    }
//
//                    if (retornoExistenciaVariable == 1)
//                    {
//                        
//                        imprimirConsola("Error semantico ya existe el No Terminal "+nombreVar+"");
//               //        Console.WriteLine("ya existe la variable " + nombreVar);
//                     //   Console.WriteLine("Parametro --> " + nombreVar + "," + ambito);
//                    }
//                    else
//                    {
//                     //   Console.WriteLine("Parametro --> "+nombreVar+","+ambito);                     
//                         NoTerminales.add(new Nodo_Terminal(nombreVar,tDato));
//                    }
//                }
//         }
//    }
//    
//     private boolean buscarTerminal(String nombreVar)
//        {
//            nombreVar=nombreVar.toLowerCase();
//            setVariableEncontrada(0);
//            boolean valor = false;
//            int bVar = 1;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
//            for (int c = 0; c < terminales.size(); c++)
//            {
//              //  System.out.println("VARIABLE --> "+nombreVar);
//                       if ( terminales.get(c).nombre.equalsIgnoreCase(nombreVar) && (bVar==1))
//                        {
//                          //  System.out.println("encontro "+nombreVar);
//                               valor=true;
//                               // System.out.println(nombreVar+"--> "+valor);
//                                bVar = 0;
//                                setVariableEncontrada(1);
//                        }
//                       
//                       else
//                       {
//                           bVar = 1;
//                       }
//            }
//            //System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
//
//            return valor;
//
//        }
//       
//     private boolean buscarNoTerminal(String nombreVar)
//        {
//            nombreVar=nombreVar.toLowerCase();
//            setVariableEncontrada(0);
//            boolean valor = false;
//            int bVar = 1;//0= indica busqueda en metodo, 1=indica la busqueda en las variables globales
//            for (int c = 0; c < NoTerminales.size(); c++)
//            {
//              //  System.out.println("VARIABLE --> "+nombreVar);
//                       if ( NoTerminales.get(c).nombre.equalsIgnoreCase(nombreVar) && (bVar==1))
//                        {
//                          //  System.out.println("encontro "+nombreVar);
//                               valor=true;
//                               // System.out.println(nombreVar+"--> "+valor);
//                                bVar = 0;
//                                setVariableEncontrada(1);
//                        }
//                       
//                       else
//                       {
//                           bVar = 1;
//                       }
//            }
//            //System.out.println("bvar --> "+bVar+" variableEncontrada --> "+variableEncontrada+ "  "+nombreVar);
//
//            return valor;
//
//        }

    private void evaluar_gramaticas(NodoArbol raiz) throws Exception{
        
        int d=0;
        for(d=0;d<raiz.getCantidadHijos();d++){
            evaluar_gramatica(raiz.getHijoEn(d));
        }
        
        String nombre="";
        String producciones="";
        
        
//        for(d=0;d<tablaPrincipal.size();d++){
//            nombre=tablaPrincipal.get(d).getNombre().toUpperCase();
//           listaProduccionesC.add(new Produccion(nombre, tablaPrincipal.get(d).getProduccion()));
//            
//        }
//        
//        tablaPrincipal.clear();
        
//        for(d=0;d<listaProduccionesC.size();d++){
//            nombre=listaProduccionesC.get(d).getNombre();
//            producciones=mostrarProduccion(listaProduccionesC.get(d).getProduccion());
//            System.err.println(nombre+" -> "+producciones);
//        }
        nombre=getRaiz();
        NodoArbol nada=new NodoArbol(getRaiz().toUpperCase());
        NodoArbol nada1=new NodoArbol("null");
        
       
       
        //listaProducciones=new ArrayList();
        
        
        int codigo=0;
        String cod="";
        
        
        
        
        
       
        //LA PRODUCCION QUE VA A EMPEZAR A TRABAJAR
     
    }

   
    
    
    private void evaluar_gramatica(NodoArbol raiz) throws Exception{
        NodoArbol aux=raiz.getHijoEn(0);
        evaluar_producciones(aux);
    }

    private void evaluar_producciones(NodoArbol aux) throws Exception{
        String nombreProduccion="";
        nombreProduccion=aux.getHijoEn(0).getEtiqueta().toString();
        //aqui es donde se van a almacenar todas las producciones que va a traer la lista
//         if(true==buscarNoTerminal(nombreProduccion)){
//             evaluar_produccion(aux.getHijoEn(1),nombreProduccion);
//         }else{
//             imprimirConsola("Error semantico, no se declaro el NO TERMINAL "+nombreProduccion);
//         }       
        
        
    }

    private void evaluar_produccion(NodoArbol raiz,String nombre) throws Exception{
        
        int d=0;
      //  listaProducciones=new ArrayList();
      
        
    }

  
 

 
    
   
   

    
    
    
}//no tocar
