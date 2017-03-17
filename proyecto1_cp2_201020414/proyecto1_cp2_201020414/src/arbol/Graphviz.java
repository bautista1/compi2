/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Alberth Bautista
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

public class Graphviz {
       
    private Formatter salida;
    private String archivoEntrada;
    private String archivoSalida;
    private String ext;

    public Graphviz(){
        archivoEntrada = "";
        archivoSalida = "";
        ext = "";
    }         
    
    private void crearArchivo(){
        
        File archivoCodigo = new File (archivoEntrada);
    	try {
            if (archivoCodigo.createNewFile())
                System.out.println("Archivo creado correctamente");
            else
                System.out.println("No se ha podido crear el archivo");
	} catch (IOException ioe) {

        }
    }
    
    private void abrirArchivo(){
        try{
            salida = new Formatter(archivoEntrada);
        }catch ( SecurityException securityException ){
            System.err.println("No tiene acceso de escritura a este archivo." );
            System.exit( 1 );
        }catch ( FileNotFoundException filesNotFoundException ){
            System.err.println( "Error al crear el archivo." );
            crearArchivo();
            abrirArchivo();
        }
    }
    
    public void dibujar(String texto,String nombreArchivo,String ext){
        this.ext = ext;
        archivoEntrada = "C:\\EDD2_2013\\"+nombreArchivo+".txt";
        archivoSalida = "C:\\EDD2_2013\\"+nombreArchivo+"."+ext;
        abrirArchivo();
        salida.format(texto);
        cerrarArchivo();
        generarGrafico();
        abrirGrafico();
    }
    
    private void cerrarArchivo(){
        if ( salida != null )
            salida.close();
    }
    
    private void generarGrafico(){        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
         String tParam = "-T"+ext;
         String tOParam = "-o";
       
        try {
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = archivoEntrada;
            cmd[3] = tOParam;
            cmd[4] = archivoSalida;

            Runtime rt = Runtime.getRuntime();

            rt.exec( cmd );

         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
         }
    }
    
    private void abrirGrafico(){                
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + archivoSalida);
        }catch (IOException e) {
	    e.printStackTrace();
        }
    }
    
    
     public void dibujarArbol(NodoArbol raiz){
        if (raiz != null){
            String texto = "digraph{\nnode [shape = box];\n";        
            texto += dibujarNodo(raiz);                
            texto += "}";          
            dibujar(texto,"grafo","pdf");
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

