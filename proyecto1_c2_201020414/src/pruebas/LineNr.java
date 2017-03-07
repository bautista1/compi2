/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Alberth
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
public class LineNr extends JPanel
{
   public JTextArea pane;
    JLabel lblLiniaColumna;
  public JScrollPane scrollPan;
 
   int contLineas=1;
    int fila=0;
    int col=0;
    int posAbs=0;
                   
  
  public LineNr ()
  {
    
      super ();
     try {
      setMinimumSize (new Dimension (30, 30));
    setPreferredSize (new Dimension (30, 30));
    setMinimumSize (new Dimension (30, 30));
    pane = new JTextArea ()	// we need to override paint so that thelinenumbers stay in sync
    {
      public void paint (Graphics g)
      {
	super.paint (g);
            
	LineNr.this.repaint ();
      }
      
      
    };
       
            pane.getDocument().insertString(0, "", null);
        Font font = new Font("Verdana", Font.PLAIN, 10);
        pane.setFont(font);
    lblLiniaColumna=new JLabel();
    fiCol(pane);
    scrollPan = new JScrollPane (pane);
    scrollPan.add(lblLiniaColumna);
    } catch (BadLocationException ex) {
            Logger.getLogger(LineNr.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
 
  public void paint (Graphics g)
  {
    super.paint (g);
    int start =
      pane.viewToModel (scrollPan.getViewport ().getViewPosition ());
    int end =
      pane.
      viewToModel (new
		   Point (scrollPan.getViewport ().getViewPosition ().x +
			  pane.getWidth (),
			  scrollPan.getViewport ().getViewPosition ().y +
			  pane.getHeight ()));
    Document doc = pane.getDocument ();
    int startline = doc.getDefaultRootElement ().getElementIndex (start);
    int endline = doc.getDefaultRootElement ().getElementIndex (end);
    int fontHeight = g.getFontMetrics (pane.getFont ()).getHeight ();	// font
     // System.out.println("starline --> "+startline+", endline-> "+endline+", font --> "+fontHeight);
    for (int line = startline, y = 0; line <= endline;
	 line++, y += fontHeight)
      {
	g.drawString (Integer.toString (line), 0, y);
      }
 
  }
 
//  public static void main (String[]args)
//  {
//    JFrame frame = new JFrame ();
//    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//   // frame.getContentPane ().setLayout (new BorderLayout ());
//    final LineNr nr = new LineNr ();
//    frame.getContentPane ().add (nr, BorderLayout.WEST);
//    frame.getContentPane ().add (nr.scrollPan, BorderLayout.CENTER);
//    frame.pack ();
//    frame.setSize (new Dimension (400, 400));
//frame.show();
//    frame.setVisible (true);
//  }

  void fiCol(final JTextArea re) {
    //jTextArea2.addCaretListener(new CaretListener(){
    re.addCaretListener(new CaretListener(){
        @Override
    public void caretUpdate(CaretEvent ching){
            try {
                //int posAbs=jTextArea2.getCaretPosition();//toma la posicion absoluta de la letra encontrada
                     posAbs=re.getCaretPosition();//.getCaretPosition();//toma la posicion absoluta de la letra encontrada
                        //int fila=jTextArea2.getLineOfOffset(posAbs);//encuentra la fila donde se encuentra
                         fila=re.getLineOfOffset(posAbs);//encuentra la fila donde se encuentra
                       // int col=posAbs-jTextArea2.getLineStartOffset(fila);//muestra en pantalla columna y fila de ubicacion de la letra
                          col=posAbs-re.getLineStartOffset(fila);//muestra en pantalla columna y fila de ubicacion de la letra
                     //   System.out.println("Col: " +col+"|"+"Fil "+fila);//muestra en pantalla columna y fila de ubicacion de la letra
            } catch (BadLocationException ex) {
                Logger.getLogger(pruebasLienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
}
 
  public void agregarTexto(String texto){
      pane.setText(pane.getText()+texto);
  }
  
}