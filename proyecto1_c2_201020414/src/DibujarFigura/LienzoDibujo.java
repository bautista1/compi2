/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DibujarFigura;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONObject;


/**
 *
 * @author Luis Fernando Leiva
 */
public class LienzoDibujo extends javax.swing.JDialog {

    private String archivo;
    private String pathImagen;
    private LinkedList<FiguraLienzo> figuras;
    private Lienzo lienzo;
    private Color colorFondo;
    private int transformacionRGB[]=new int[3]; 
    Frame pare;
    private String rutaASerializar="";

    /**
     * Creates new form LienzoDibujo
     *
     * @param parent
     * @param modal
     * @param archivo
     */
    public LienzoDibujo(java.awt.Frame parent, boolean modal, String archivo) {
        super(parent, modal);
        initComponents();
        pare=new Frame();
        figuras = new LinkedList<FiguraLienzo>();

        this.archivo = archivo;
        this.pathImagen = archivo;
        pare=parent;
        guardarLienzo();
        
        lienzo = new Lienzo();
        this.jpLienzo.add(lienzo);
        lienzo.setBounds(0, 0, 400, 400);
        colorFondo = new Color(255, 255, 255);
    }

    public class FiguraLienzo {

        private Shape figura;
        private Color color;
        private boolean fill;
        private boolean isOval;
        private boolean isTexto;
        private boolean isPoligono;
        private String texto;
        private int[] puntos;

        public FiguraLienzo(Shape figura, Color color, boolean fill) {
            this.figura = figura;
            this.color = color;
            this.fill = fill;
        }

        public Shape getFigura() {
            return figura;
        }

        public void setFigura(Shape figura) {
            this.figura = figura;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
        }

        public boolean isIsOval() {
            return isOval;
        }

        public void setIsOval(boolean isOval) {
            this.isOval = isOval;
        }

        public int[] getPuntos() {
            return puntos;
        }

        public void setPuntos(int[] puntos) {
            this.puntos = puntos;
        }

        public boolean isIsTexto() {
            return isTexto;
        }

        public void setIsTexto(boolean isTexto) {
            this.isTexto = isTexto;
        }

        public String getTexto() {
            return texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public boolean isIsPoligono() {
            return isPoligono;
        }

        public void setIsPoligono(boolean isPoligono) {
            this.isPoligono = isPoligono;
        }

    }

    public class Lienzo extends Canvas {

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            //dibujando el fondo...
            g2d.setColor(colorFondo);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            //pintando las figuras...
            for (FiguraLienzo figura : figuras) {
                if (figura.isOval) {
                    g2d.setColor(figura.getColor());
                    g2d.drawOval(figura.getPuntos()[0], figura.getPuntos()[1], figura.getPuntos()[2], figura.getPuntos()[3]);
                    if (figura.isFill()) {
                        g.fillOval(figura.getPuntos()[0], figura.getPuntos()[1], figura.getPuntos()[2], figura.getPuntos()[3]);
                    }
                } else if (figura.isTexto) {
                    g2d.setColor(figura.getColor());
                    g2d.drawString(figura.getTexto(), figura.getPuntos()[0], figura.getPuntos()[1]);
                } else if (figura.isPoligono) {

                } else {
                    g2d.setColor(figura.getColor());
                    g2d.draw(figura.getFigura());
                    if (figura.isFill()) {
                        g2d.fill(figura.getFigura());
                    }
                }
            }
        }

        public void exportImage(String imageName) {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            paint(graphics);
            try {
                FileOutputStream out = new FileOutputStream(imageName);
                ImageIO.write(image, "png", out);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            graphics.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLienzo = new javax.swing.JPanel();
        btnOublicar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LIENZO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpLienzo.setBackground(new java.awt.Color(255, 255, 255));
        jpLienzo.setPreferredSize(new java.awt.Dimension(400, 400));
        jpLienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpLienzoMouseMoved(evt);
            }
        });
        jpLienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpLienzoMouseClicked(evt);
            }
        });
        jpLienzo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpLienzoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jpLienzoLayout = new javax.swing.GroupLayout(jpLienzo);
        jpLienzo.setLayout(jpLienzoLayout);
        jpLienzoLayout.setHorizontalGroup(
            jpLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpLienzoLayout.setVerticalGroup(
            jpLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        btnOublicar.setText("Publicar Lienzo");
        btnOublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOublicarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Comentario: ");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOublicar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 700, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOublicar)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        File arch = new File(archivo);
        if (this.archivo != null && arch.exists()) {
//            Interprete interprete = new Interprete(this);
//            interprete.interpretar(arch);
            lienzo.exportImage(pathImagen + ".png");
        } else {
            JOptionPane.showMessageDialog(this, "El archivo no existe o es invalido: " + archivo);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnOublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOublicarActionPerformed
//        guardarLienzo();
        serealizarImagen();
    }//GEN-LAST:event_btnOublicarActionPerformed

    private void jpLienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLienzoMouseMoved
        //System.out.println("x: "+evt.getX()+" Y: "+evt.getY());
       // this.jpLienzo.setToolTipText("x: "+evt.getX()+" Y: "+evt.getY());
//        Point p = MouseInfo.getPointerInfo().getLocation();
       this.jLabel1.setText("x: "+evt.getX()+" Y: "+evt.getY());
    }//GEN-LAST:event_jpLienzoMouseMoved

    private void jpLienzoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLienzoMouseClicked
//       this.jpLienzo.setToolTipText("x: "+evt.getX()+" Y: "+evt.getY());
//       Point p = MouseInfo.getPointerInfo().getLocation();
       this.jLabel1.setText("x: "+evt.getX()+" Y: "+evt.getY());
    }//GEN-LAST:event_jpLienzoMouseClicked

    private void jpLienzoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpLienzoPropertyChange
       
    }//GEN-LAST:event_jpLienzoPropertyChange

    public void printInConsole(boolean isChar, int val) {
        if (isChar) {
            txtComentario.setText(txtComentario.getText() + ((char) val));
        } else {
            txtComentario.setText(txtComentario.getText() + val);
        }
    }

    public void printInConsole(boolean isChar, float val) {
        if (isChar) {
            txtComentario.setText(txtComentario.getText() + ((char) val));
        } else {
            txtComentario.setText(txtComentario.getText() + val);
        }
    }

    public void printInConsole(String string) {
        txtComentario.setText(txtComentario.getText() + string + "\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOublicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpLienzo;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

  

  

    public void dibujarRectangulo(int x, int y, int alto, int ancho, String hexadecimalColor, int fill) {
        hexadecimalColor=hexadecimalColor.replace("#", "");
        transformacionRGB=getRGB(hexadecimalColor);
        figuras.add(new FiguraLienzo(new Rectangle2D.Float(x, y, ancho, alto), new Color(transformacionRGB[0], transformacionRGB[1], transformacionRGB[2]), fill == 1));
        lienzo.repaint();
    }

    public void dibujarOvalo(int x, int y, int ancho, int alto, String hexadecimalColor, int fill) {
        hexadecimalColor=hexadecimalColor.replace("#", "");
        transformacionRGB=getRGB(hexadecimalColor);
        int[] puntos = {x, y, ancho, alto};
        FiguraLienzo figura = new FiguraLienzo(null, new Color(transformacionRGB[0], transformacionRGB[1], transformacionRGB[2]), fill == 1);
        figura.setIsOval(true);
        figura.setPuntos(puntos);
        figuras.add(figura);
        lienzo.repaint();
    }

    public void dibujarTexto(String texto, int x, int y,  String hexadecimalColor) {
        hexadecimalColor=hexadecimalColor.replace("#", "");
        transformacionRGB=getRGB(hexadecimalColor);
        int[] puntos = {x, y};
        FiguraLienzo figura = new FiguraLienzo(null, new Color(transformacionRGB[0], transformacionRGB[1], transformacionRGB[2]), false);
        figura.setIsTexto(true);
        figura.setTexto(texto);
        figura.setPuntos(puntos);
        figuras.add(figura);
        lienzo.repaint();
    }

    public void cambiarLienzo(int ancho, int alto, int r, int g, int b) {
        colorFondo = new Color(r, g, b);
        int diferenciax = ancho - this.jpLienzo.getWidth();
        int diferenciay = alto - this.jpLienzo.getHeight();
        this.setSize(this.jpLienzo.getWidth() + diferenciax, this.jpLienzo.getHeight() + diferenciay);
        this.lienzo.setSize(ancho, alto);
        lienzo.repaint();
    }
    
    public void dibujarPunto(int x,int y,String hexadecimalColor, int diametro,int fill){
        hexadecimalColor=hexadecimalColor.replace("#", "");
        transformacionRGB=getRGB(hexadecimalColor);
        int ancho=diametro/2;
        int alto=diametro/2;
        int[] puntos = {x, y, ancho, alto};
        FiguraLienzo figura = new FiguraLienzo(null, new Color(transformacionRGB[0], transformacionRGB[1], transformacionRGB[2]), fill == 1);
        figura.setIsOval(true);
        figura.setPuntos(puntos);
        figuras.add(figura);
        lienzo.repaint();
    }
            
            
    
private  int[] getRGB(final String rgb)
{
    final int[] ret = new int[3];
    for (int i = 0; i < 3; i++)
    {
        ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
//        System.out.println("color "+i +" --> "+ret[i]);
    }
    return ret;
}

public void guardarLienzo(){
    this.archivo = archivo;
        this.pathImagen = archivo;
    JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Imagen a guardar...");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG Images", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(pare);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.pathImagen = chooser.getSelectedFile().getPath();
            this.rutaASerializar=pathImagen;
        }
        
        lienzo = new Lienzo();
        this.jpLienzo.add(lienzo);
        lienzo.setBounds(0, 0, 400, 400);
        colorFondo = new Color(255, 255, 255);
}

public void serealizarImagen() {
    rutaASerializar+=".png";
try{
        
            File file = new File(rutaASerializar);
            System.out.println(file.exists() + "!!");
            
            FileInputStream fis;
        
            fis = new FileInputStream(file);
        String cad="",horal="";
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum); 
                    //el bos tiene lo serializado
                    cad=(String)bos.toString();
                    System.out.println("read " + bos.toString() + " bytes,");
                }
            } catch (IOException ex) {
                //Logger.getLogger(ByteArrayImage.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en arch");
            }
            Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        horal= dia + "/" + (mes+1) + "/" + año;
        horal+=hora+":"+ minuto+":"+ segundo;
            
            Json(cad, horal);
            //con esto lo tomaria 
             //bytes is the ByteArray we need
            byte[] bytes = bos.toByteArray();
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            
            File newFile= new File(rutaASerializar+System.currentTimeMillis()+".jpg");
            BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(imag, "jpg", newFile);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}


 public void Json(String cadenaconvertida, String fechacreacion){
        //contenedor de objetos para los Json
        JSONObject contenedorjson = new JSONObject();
        JSONObject contenedor2json = new JSONObject();
    //creando la estructura del Json
        contenedorjson.put(txtNombre.getText(), contenedor2json);
    //contiene la segunda parte del Json comentario
        contenedor2json.put("Comentario", txtComentario.getText());
    //coontiene la segunda parte del Json imagen    
        contenedor2json.put("Imagen", cadenaconvertida);
     //contiene la segunda parte del Json Fecha   
        contenedor2json.put("Fecha", fechacreacion);
        
        //Envia el Json para que lo reciba en el server
       System.out.println("COMPROBACION: "+contenedorjson.toString());
        enviarOBJETOJS(contenedorjson.toString(), txtNombre.getText());
        
        System.out.println(contenedorjson);
        
    }
    public void enviarOBJETOJS(String objeto, String name ){
        String cadenEnviar = name +objeto;
       
        
       System.out.println(cadenEnviar);
//        cl = new Cliente();
//        cl.initClient(cadenEnviar);
        
    }
}//no tocar
