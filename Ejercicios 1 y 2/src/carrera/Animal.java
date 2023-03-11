/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.Arrays;

/**
 *
 * @author jonat
 */
public abstract class Animal {

    public int posicion;
    public String nombreJugador;
    public String[] posicionActual = new String[70];

    public Animal(int posicion) {
        this.posicion = posicion;
    }

    public abstract void cambiaPosicion();

    public abstract void rellenaArreglo();

    public int getPosicion() {
        return 1;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String[] getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(String[] posicionActual) {
        this.posicionActual = posicionActual;
    }

    public String toString() {

//        for (int i = 0; i < 10; i++) {
//            
//        }
        String salida = Arrays.toString(posicionActual);
        salida = salida.replace(",", "");
        return "Posicion Actual: " + (posicion) + "\n" + salida;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    

}
