/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.JTextArea;

/**
 *
 * @author Alberth
 */
public class Debugger extends Thread{
        private String s; //MENSAJES
    private int val;  //INDICA EL TIEMPO
    public boolean continuar = true; //PERMITE DETENER LA EJECUCION
    private int CL;

    public Debugger(String ms, int tiempo, int tiempo1){
        s=ms;
        val=tiempo;
        CL = tiempo1;
    }
    
    //****METODO PARA EJECUTAR EL HILO
    public void run(){
        //do{
        for(int i = 0; i<CL;i++){
            try {
                 sleep(val);
                System.out.println("Debuggeando -> "+i);
              //    tx.debug(CL, s, JTA);
               //   pi.debug(CL, s, JTA);
               // pi.debug(CL, s);
               // tx.contenido.setText("hola" + i + "\n");
                                            
              
               
            } catch (InterruptedException e) {
                System.out.println("*****"+e);
            }
           
        }
        
        //}while(continuar);
        
       
        
        
    }
    
    //****METODO PARA DETENER EL HILO
    public void StopH(boolean a){
        continuar = a;
        System.out.println("//PAUSANDO DEBUG");
    }
}
