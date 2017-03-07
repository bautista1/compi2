/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DibujarFigura;

/**
 *
 * @author Alberth
 */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaTest{

public static void main (String [] args) {

//Método para cambiar la decoración de la ventana en sí,
//si ponemos el valor en falso la ventana se verá de la forma predeterminada de Windows
JFrame.setDefaultLookAndFeelDecorated(true);

//creamos el JFrame principal donde agregaremos el resto de objetos
JFrame frame = new JFrame ("JTextArea Test");
frame.setLayout (new FlowLayout ());
frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

String text = "Un objeto JTextArea es una área multilínea para escribir texto. "
+ "Se puede cambiar el número de líneas que se mostrarán, "
+ "y también el numero de columnas. Puedes cambiar las fuentes y tamaños de letras. "
+ "Y puedes agregar tu TextArea en un JScrollPane para poder mover las zonas de texto." ;

//creamos un area de texto normal no redimensionable
JTextArea textAreal = new JTextArea(text,20,10);
textAreal.setPreferredSize(new Dimension (10,100));

//creamos otra área de texto con un JScrollPane, sólo es agregado
JTextArea textArea2 = new JTextArea(text,20,10);
JScrollPane scroll = new JScrollPane(textArea2);
frame.getContentPane().add(scroll, BorderLayout.CENTER);
frame.add(scroll);

//El método setLineWrap lo que hace es ordenar las palabras para que no se salgan de los márgenes,
//si lo desactivamos(false), el texto se escribirá hacia el lado(en una línea) y no se vería todo si el //texto es muy largo
textAreal.setLineWrap (true);
textArea2.setLineWrap (true);
textAreal.setWrapStyleWord(true);
textArea2.setWrapStyleWord(true);

//agregamos los area de texto al frame principal,
//nota: el textArea2 está dentro de un JScrollPane, por eso éste es el que agregamos al frame
frame.add(textAreal);
frame.add(scroll);

//el metodo pack sirve para dejar todo dentro del frame
frame.pack();

//y finalmente el metodo setVisible es para que se visualice la ventana
frame.setVisible(true) ;
}
}