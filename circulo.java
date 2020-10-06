package dibujarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class circulo {
  
//coordenadas
private int coordenada_x,coordenada_y;

//tama;o
private int radio;

//instancia de la clase color
private Color color;

//sentido en que se mueve 
private int sentido;

//sentidos posibles 
private final int ARRIBA=1;
private final int DERECHA_ARRIBA=2;
private final int DERECHA=3;
private final int DERECHA_ABAJO=4;
private final int ABAJO=5;
private final int IZQUIERDA_ABAJO=6;
private final int IZQUIERDA=7;
private final int IZQUIERDA_ARRIBA=8;

//Velocidad
private int velocidad;

//margenes de la ventana
private int minimo_x,minimo_y,maximo_x,maximo_y;

//Objeto random
private Random radom;

public circulo(int ancho, int alto,int radio,int velocidad){
    radom=new Random();
    color=new Color(
    radom.nextInt(255),
    radom.nextInt(255),
    radom.nextInt(255)
    );
    
    //definir coordenadas iniciales
    this.coordenada_x=this.radom.nextInt(ancho-radio);
    this.coordenada_y=this.radom.nextInt(alto-radio);
    
    //radio
    this.radio=radio;
    
    //sentido
    this.sentido=1+radom.nextInt(8);
    
    //velocidad 
    this.velocidad=velocidad;
    
    //definir coordenadas minimas
    this.minimo_x=0;
    this.minimo_y=0;
    
    //def. Maximos
    this.maximo_x=ancho;
    this.maximo_y=alto;
   }

public void dibujar(Graphics gr){
    
    gr.setColor(this.color);
    gr.fillOval(this.coordenada_x, 
               this.coordenada_y, 
               this.radio,
               this.radio);
    
}
 
public void animar(){
    //siguiente coordenadas 
    int x_positiva = this.coordenada_x + this.velocidad;
    int y_positiva = this.coordenada_y + this.velocidad;
    
    //siguientes coordenas negativas 
    int x_negativa = this.coordenada_x - this.velocidad;
    int y_negativa = this.coordenada_x - this.velocidad;
    
    //colisiones y sentidos
    switch(this.sentido){
        case ARRIBA:
            if(y_negativa>this.maximo_y){
              this.coordenada_y = y_negativa;  
            }else{
                this.sentido =  1 + radom.nextInt(0);
            }
            break;
            
        case DERECHA_ARRIBA:
        if((x_positiva<this.maximo_x)&(y_negativa>this.minimo_y)){
            this.coordenada_x= x_positiva;
            this.coordenada_y=y_negativa;
        }else{
            this.sentido =  1 + radom.nextInt(0);
        }
        break;
        
        case DERECHA:
        if(x_positiva<this.maximo_x){
            this.coordenada_x= x_positiva;
        }else{
            this.sentido =  1 + radom.nextInt(0);
        }    
         break;
         
          case DERECHA_ABAJO:
        if((x_positiva<this.maximo_x)&&(y_positiva<this.maximo_y)){
            this.coordenada_x= x_positiva;
            this.coordenada_y=y_negativa;
        }else{
            this.sentido =  1 + radom.nextInt(0);
        }    
         break;
        
          case ABAJO:
              if(y_positiva<this.maximo_y){
               this.coordenada_y=y_positiva;   
              }else{
              this.sentido =  1 + radom.nextInt(0);    
              }
        break;
        
          case IZQUIERDA_ABAJO:
              if(y_positiva<this.maximo_y && x_negativa>this.minimo_x){
                  this.coordenada_x=x_negativa;
                  this.coordenada_y=y_positiva;
              }else{
                  this.sentido=1 + this.radom.nextInt();
              }
          break;
          
          case IZQUIERDA:
          if(x_negativa > this.minimo_x ){
              this.coordenada_x=x_negativa;
          }else{
           this.sentido=1+this.radom.nextInt();
          }
          break;
          
          case IZQUIERDA_ARRIBA:
              if(x_negativa >this.maximo_x && y_negativa>this.minimo_y){
                  this.coordenada_x= x_positiva;
                  this.coordenada_y=y_positiva;
              }else{
                 this.sentido=1+this.radom.nextInt();
              }
              break;
    }
    
}
    
    
}
