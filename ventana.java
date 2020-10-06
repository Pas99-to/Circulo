
package dibujarObjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ventana extends JPanel{
 
 private JFrame ventana;
 private Container contenedor;
    
 //Arreglo de circulos
 private circulo circulos[]; 
 
public ventana(){
        ventana = new JFrame("Animado Objetos");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this,BorderLayout.CENTER);   
       //Definir arreglo
       int tama=5;
       this.circulos=new circulo [tama];
       
       //llenar for

      for (int i = 0;i<tama;i++) {
     this.circulos[i]=new circulo(800,600,25,10);
     }
}
     @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        for (circulo circulo1 : circulos) {
            circulo1.dibujar(grphcs);
        }
    }
    
    public void animar(){
        while(this.ventana.isVisible()){
            for(circulo circul:circulos){
                circul.animar();
            }
            try{
            Thread.sleep(50);
            }catch(Exception e){
            }
            repaint();
            
        }
    }
    
}
