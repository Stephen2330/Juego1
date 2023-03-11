/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreramp;

import java.util.Arrays;

/**
 *
 * @author jonat
 */
public abstract class Animal {

    public int posicion;
    public String nombreJugador;
    public String[] posicionActual = new String[70];
    public boolean ganador;

    public Animal(int posicion, boolean ganador) {
        this.posicion = posicion;
        this.ganador = ganador;
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

    @Override
    public String toString() {
        String salida = Arrays.toString(posicionActual);
        salida = salida.replace(",", "");
        return getNombreJugador() + " // Posicion Actual: " + (posicion) + "\n" + salida;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
    
    
    

}
