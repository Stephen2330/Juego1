/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreramp;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jonat
 */
public class CarreraMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Bienvenido al Juego de la Liebre y la Tortuga \n");
        int opcionSalida = 0;
        do {
            System.out.println("Ingrese 1 para iniciar la carrera");
            System.out.println("Ingrese 2 para salir del programa");

            Pattern pattern = Pattern.compile("[12]");
            String ingreso = leerAlfanumerico("Ingrese la opción que desea ejecutar: \n");

            Matcher mat = pattern.matcher(ingreso);
            if (mat.matches()) {
                System.out.println("");
            } else {
                System.out.println("Digite una opción correcta al programa!!! \n");
            }

            switch (ingreso) {
                case "1":
                    System.out.println("Menú para asignar la cantidad de parejas en juego multiplayer \n");
                    System.out.println("Opción 1: 1 pareja de jugadores");
                    System.out.println("Opción 2: 2 parejas de jugadores");
                    System.out.println("Opción 3: 3 parejas de jugadores");
                    System.out.println("Opción 4: 4 parejas de jugadores");
                    System.out.println("Opción 5: 5 parejas de jugadores");
                    System.out.println("Opción 6: 6 parejas de jugadores \n");

                    //Validación cantidad de jugadores
                    Pattern pat2 = Pattern.compile("[123456]");
                    String cantidadJugadores = leerAlfanumerico("Ingrese la cantidad de parejas a jugar:");
                    Matcher mat2 = pat2.matcher(cantidadJugadores);

                    if (mat2.matches()) {
                        System.out.println("");
                    } else {
                        System.out.println("Digite una opción correcta para ingresar la cantidad de jugadores!!!");
                    }

                    switch (cantidadJugadores) {
                        case "1":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            GestorCarreras objGes = new GestorCarreras();

                            int numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 3) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }

                            int minimo = 0;
                            for (int i = 0; i < 1; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            int contadorRonda = 1;
                            boolean validador = true;
                            int contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 1; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 1; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    } 
                                    
                                    if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            boolean encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                        case "2":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            objGes = new GestorCarreras();

                            numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 5) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }
                            minimo = 0;
                            for (int i = 0; i < 2; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            contadorRonda = 1;
                            validador = true;
                            contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 2; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();                                   
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 2; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                        case "3":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            objGes = new GestorCarreras();

                            numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 7) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }
                            minimo = 0;
                            for (int i = 0; i < 3; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            contadorRonda = 1;
                            validador = true;
                            contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 3; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();                                   
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 3; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    }
                                    if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                        case "4":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            objGes = new GestorCarreras();

                            numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 9) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }

                            minimo = 0;
                            for (int i = 0; i < 4; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            contadorRonda = 1;
                            validador = true;
                            contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 4; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();                                    
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 4; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    }
                                    if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                        case "5":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            objGes = new GestorCarreras();

                            numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 11) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }

                            minimo = 0;
                            for (int i = 0; i < 5; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            contadorRonda = 1;
                            validador = true;
                            contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 5; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();                                    
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 5; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    } 
                                    if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                        case "6":
                            System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                            objGes = new GestorCarreras();

                            numeroJugador = 1;

                            //Validación nombres
                            while (numeroJugador < 13) {
                                Pattern pat3 = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,20}[a-zA-Z0-9]$");
                                String nombreJugadores = leerAlfanumerico("Ingrese el nombre del jugador " + numeroJugador);
                                Matcher mat3 = pat3.matcher(nombreJugadores);

                                if (mat3.matches()) {
                                    System.out.println("JUGADOR: " + nombreJugadores + " -> AGREGRADO");
                                    objGes.getLisJugadores().add(nombreJugadores);
                                    numeroJugador++;
                                } else {
                                    System.out.println("Digite un caracter valido para el nombre!!!");
                                }
                            }
                            minimo = 0;
                            for (int i = 0; i < 6; i++) {
                                Tortuga objTor = new Tortuga(1, false);
                                Liebre objLie = new Liebre(1, false);
                                objGes.getLisTortuga().add(objTor);
                                objGes.getLisLiebre().add(objLie);
                                int tamannoLista = objGes.getLisJugadores().size() - 1;
                                objGes.animalAleatorio(objGes.getLisJugadores().get(tamannoLista - 1), objGes.getLisJugadores().get(tamannoLista), objLie, objTor, minimo);
                                minimo += 2;
                            }

                            contadorRonda = 1;
                            validador = true;
                            contadorGanadores = 0;

                            while (validador != false) {
                                System.out.println("Ronda: " + contadorRonda);

                                for (int i = 0; i < 6; i++) {
                                    objGes.getLisTortuga().get(i).cambiaPosicion();                                    
                                    objGes.getLisLiebre().get(i).cambiaPosicion();

                                    if (objGes.getLisTortuga().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisTortuga().get(i).setGanador(true);
                                        contadorGanadores++;

                                    }

                                    if (objGes.getLisLiebre().get(i).posicion == 70) {
                                        validador = false;
                                        objGes.getLisLiebre().get(i).setGanador(true);
                                        contadorGanadores++;
                                    }
                                }

                                contadorRonda++;
                            }

                            if (contadorGanadores > 1) {
                                System.out.println("Ha habido un empate de los siguientes jugadores: ");
                                for (int i = 0; i < 6; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                    }
                                    if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                    }
                                }
                            }

                            encuentraGanador = false;
                            if (contadorGanadores == 1) {
                                for (int i = 0; encuentraGanador == false; i++) {
                                    if (objGes.getLisTortuga().get(i).isGanador() == true) {
                                        System.out.println("Ganador/a: " + objGes.getLisTortuga().get(i).nombreJugador + " - Tortuga");
                                        encuentraGanador = true;
                                    } else if (objGes.getLisLiebre().get(i).isGanador() == true) {
                                        System.out.println(objGes.getLisLiebre().get(i).nombreJugador + " - Liebre");
                                        encuentraGanador = true;
                                    }
                                }
                            }

                            break;
                    }
                    System.out.println("-----FIN DE LA CARRERA-----");
                    break;
                case "2":
                    opcionSalida = 1;
                    System.out.println("--------GRACIAS POR JUGAR-------");
                    break;
                default:
                    System.out.println("Las opciones válidas son 1 y 2. \n");
                    break;
            }
        } while (opcionSalida == 0);
    }
     
                     

    private static String leerAlfanumerico(String msj) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(msj);
        String ingreso = entrada.nextLine();
        return ingreso;
    }

    private static int leerEntero(String msj) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(msj);
        int ingreso = entrada.nextInt();
        return ingreso;
    }

    private static double leerDecimal(String msj) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(msj);
        double ingreso = entrada.nextDouble();
        return ingreso;
    }
    
}
