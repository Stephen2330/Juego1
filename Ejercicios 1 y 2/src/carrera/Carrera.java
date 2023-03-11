/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jonat
 */
public class Carrera {

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
                    System.out.println("--------INICIA LA CARRERA MAS ESPERADA DEL AÑO------");
                    Tortuga objTor = new Tortuga(1);
                    Liebre objLie = new Liebre(1);

                    int contadorRonda = 1;

                    while (objTor.posicion < 70 && objLie.posicion < 70) {
                        System.out.println("Ronda: " + contadorRonda);
                        objTor.cambiaPosicion();
                        objLie.cambiaPosicion();

                        if (objTor.posicion == 70 && objLie.posicion == 70) {
                            System.out.println("Empate! \n");
                            System.out.println("--------DE VUELTA AL MENU PRINCIPAL;");
                        } else {
                            if (objLie.posicion == 70) {
                                System.out.println("Gana liebre \n");
                                System.out.println("--------DE VUELTA AL MENU PRINCIPAL;");
                            } else if (objTor.posicion == 70) {
                                System.out.println("Gana tortuga \n");
                                System.out.println("--------DE VUELTA AL MENU PRINCIPAL;");
                            }
                        }

                        contadorRonda++;
                    }
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
        
        
        

//        int opcionSalida = 0;
//        int opcionMenu = 0;

//        while (opcionSalida != 2) {
//            System.out.println("Bienvenido al juego de la Liebre Y la Tortuga, version multijugador: \n"
//                    + "1 - Version de 4 jugadores. \n"
//                    + "2 - Version de 6 jugadores. \n"
//                    + "3 - Version de 8 jugadores. \n"
//                    + "4 - Version de 10 jugadores. \n"
//                    + "5 - Version de 12 jugadores. \n"
//                    + "6 - Salir del juego");
//            opcionMenu = leerEntero("");
//            switch (opcionMenu) {
//                case 1:
//                    System.out.println("Indique el nombre de los jugadores: ");
//                    
//                    
//                    break;
//                case 2:
//                    
//                    break;
//            }
//
//        }
//    }
        

    

