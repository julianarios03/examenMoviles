package org.example;

import org.example.controladores.Jugador;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();


        int seleccion = 0;

        System.out.println("Menu Del Programa  jugadores: \n");
        System.out.println("1. Ingresa jugador");
        System.out.println("2. Busca jugador");
        System.out.println("3. Corregir informacion del Jugador");
        System.out.println("4. Mostrar jugadores");
        System.out.println("5. Salir\n");

        do {
            System.out.print("Elige una opcion del menu: ");
            seleccion = read.nextInt();
            switch (seleccion)

            {
                case 1:
                    if (jugadores.size()<=1)
                    {
                        Jugador objetoJugador = new Jugador();
                        objetoJugador.agregarJugador();
                        jugadores.add(objetoJugador);
                    }

                    else
                    {
                        System.out.println("No se permitido otro jugadores");
                    }
                    break;
                case 2:

                    String busquedaCamiseta;
                    System.out.print("Ingrese  numero de la camiseta: ");
                    busquedaCamiseta = read.next();
                    String nombreJugador = "";

                    for (Jugador jugador : jugadores)
                    {
                        if (jugador.getNumeroCamiseta().equals(busquedaCamiseta))
                        {
                            nombreJugador = jugador.getNombre();
                            System.out.println("El nombre del jugador por numero de camiseta es: "+nombreJugador);
                            break;
                        }
                    }

                    if (nombreJugador.equals(""))
                    {
                        System.out.println("El jugador no existe");
                    }

                    break;
                case 3:
                {
                    busquedaCamiseta="";
                    System.out.print("Ingrese numero de la camiseta del jugador: ");
                    busquedaCamiseta = read.next();
                    boolean editJugador = false;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getNumeroCamiseta().equals(busquedaCamiseta))
                        {
                            System.out.println("El nombre del jugador es: "+jugador.getNombre()+"la posicion del jugador es : "+jugador.getPosicion()+"; Ingrese una nueva posicion: ");
                            jugador.setPosicion(read.next());
                            System.out.println("La nueva posicion del jugador es:  "+jugador.getPosicion());
                            editJugador=true;
                            break;
                        }
                    }
                    if (!editJugador)
                    {
                        System.out.println("El jugador no existe");
                    }
                }
                break;
                case 4:
                    System.out.println("La formacion de jugadores seleccionados para el encuentro es la siguiente: \n");
                    for (Jugador jugador : jugadores)
                    {
                        System.out.println(jugador.getNombre()+" "+jugador.getPosicion()+" numero "+jugador.getNumeroCamiseta());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.print("Ingresa una opción valida para el menu");
            }
        }
        while (seleccion != 5);
    }
}