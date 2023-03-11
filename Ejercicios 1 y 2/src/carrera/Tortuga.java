/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class Tortuga extends Animal{
  
    @Override
    public void cambiaPosicion() {
        Random rand = new Random();
        
        int nuevaPosicion = posicion;
        int valorAvance = rand.nextInt(100)+1;
        
        
        //Avance Rapido
        if (valorAvance <= 50) {
            
            int contador = 3;

            while (contador > 0) {
                if(nuevaPosicion >= 70){
                    contador = 0;
                }   
                    if(nuevaPosicion != 70){
                    nuevaPosicion += 1; 
                    contador--;
                }
            
            }
            setPosicion(nuevaPosicion);
            
            rellenaArreglo();
            System.out.println(toString()); System.out.println("Avance Rapido");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Resbalon
        if(valorAvance > 50 && valorAvance <= 70){
            
            int contador = 6;
            while (contador > 0) {
                if(nuevaPosicion != 1){
                    nuevaPosicion -= 1;
                    contador--;
                }else{
                    contador = 0;
                }   
                
            }
            setPosicion(nuevaPosicion);
            rellenaArreglo();
            System.out.println(toString()); System.out.println("Resbalon \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        //Avance Lento

        if (valorAvance > 70 && valorAvance <= 100) {
            nuevaPosicion++;
            setPosicion(nuevaPosicion);

            rellenaArreglo();
            System.out.println(toString());
            System.out.println("Avance Lento \n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public Tortuga(int posicion) {
        super(posicion);
    }

    @Override
    public void rellenaArreglo(){
        for(int i = 0 ; i < 70; i++){
            posicionActual[i] = "-";
        }
        posicionActual[posicion-1] = "T";
        
    }

    
    

  
}
