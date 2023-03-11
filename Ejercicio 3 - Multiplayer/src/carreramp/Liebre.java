/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreramp;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class Liebre extends Animal{
    
    
    @Override
    public void cambiaPosicion() {
        Random rand = new Random();
        int nuevaPosicion = posicion;
        int valorAvance = rand.nextInt(100)+1;
        
        //Duerme
        if (valorAvance <= 20){
            
            rellenaArreglo();
            System.out.println(toString());
            System.out.println(nombreJugador + ": Duerme \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Gran Salto
        if(valorAvance > 20 && valorAvance <= 40){
            
            int contador = 9;
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
            System.out.println(toString());
            System.out.println(nombreJugador + ": Gran Salto \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Resbalon Grande
        if(valorAvance > 40 && valorAvance <= 50){
            int contador = 12;
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
            System.out.println(toString());
            System.out.println(nombreJugador + ": Resbalon Grande \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        //Pequeno Salto
        if(valorAvance > 50 && valorAvance <= 80){
            
            nuevaPosicion++;
            setPosicion(nuevaPosicion);
            
            rellenaArreglo();
            System.out.println(toString());
            System.out.println(nombreJugador + ": Pequeno Salto \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        //Resbalon Pequeno
        if(valorAvance > 80 && valorAvance <= 100){
            int contador = 2;
            
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
            System.out.println(toString());
            System.out.println(nombreJugador + ": Resbalon Pequeno \n");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    public Liebre(int posicion, boolean ganador) {
        super(posicion, ganador);
    }

    
    @Override
    public void rellenaArreglo(){
        for(int i = 0; i < 70; i++){
            posicionActual[i] = "-";
        }
        posicionActual[posicion-1] = "L";
        
    }

     
    
}
