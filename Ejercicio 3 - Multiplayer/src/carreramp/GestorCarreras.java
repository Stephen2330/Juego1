/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreramp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jonat
 */
public class GestorCarreras {
    private List<Tortuga> lisTortuga = new  ArrayList<>();
    private List<Liebre> lisLiebre = new  ArrayList<>();
    private List<String> lisJugadores = new  ArrayList<>();
    
    
public void animalAleatorio(String jugadorUno, String jugadorDos, Liebre liebreCarreraUno, Tortuga tortugaCarreraUno, int minimo){
    Random rand = new Random();
    int valorAnimal = rand.nextInt(2)+1;
    
    
    for (int i = 0; i < 1; i++) {
        if (valorAnimal == 1) { // 1 = Liebre / 2 = Tortuga //
            liebreCarreraUno.setNombreJugador(lisJugadores.get(minimo));
            tortugaCarreraUno.setNombreJugador(lisJugadores.get(minimo+1));
        } else {
            liebreCarreraUno.setNombreJugador(lisJugadores.get(minimo+1));
            tortugaCarreraUno.setNombreJugador(lisJugadores.get(minimo));
        }
    }
    
    
}

public void adminCarrerasCuatroJugadores(Liebre liebreCarreraUno, Tortuga tortugaCarreraUno, Liebre liebreCarreraDos, Tortuga tortugaCarreraDos){
    
}


public void defineAnimal(String jugador){
    Random rand = new Random();
    int valorAnimal = rand.nextInt(2)+1;
    
    if(valorAnimal == 1){
        
    }
}

    public List<Tortuga> getLisTortuga() {
        return lisTortuga;
    }

    public void setLisTortuga(List<Tortuga> lisTortuga) {
        this.lisTortuga = lisTortuga;
    }

    public List<String> getLisJugadores() {
        return lisJugadores;
    }

    public void setLisJugadores(List<String> lisJugadores) {
        this.lisJugadores = lisJugadores;
    }

    public List<Liebre> getLisLiebre() {
        return lisLiebre;
    }

    public void setLisLiebre(List<Liebre> lisLiebre) {
        this.lisLiebre = lisLiebre;
    }
    
    

    
    
}
