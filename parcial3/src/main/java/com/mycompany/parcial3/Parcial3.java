/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial3;
import Modelo.Jugador;
import Modelo.Comunes;
import Modelo.Magico;
import Vista.VistaBatalla;
import Controlador.ControoladorBatalla;

/**
 *
 * @author Titoelgato
 */
public class Parcial3 {

    public static void main(String[] args) {
        Jugador j1 = new Jugador();
        j1.nombre = "Yugi";
        j1.Lp = 4000;

        Jugador j2 = new Jugador();
        j2.nombre = "Kaiba";
        j2.Lp = 4000;

   
        Comunes m1 = new Comunes("Mago Oscuro", 2500, 2100, true);
        
        Magico m2 = new Magico(); 
        m2.setNombre("Dragón Blanco de Ojos Azules");
        m2.setATQ(3000);
        m2.setDEF(2500);
        m2.setPosicion(true);

     
        j1.agregarCarta(m1);
        j2.agregarCarta(m2);

   
        VistaBatalla vista = new VistaBatalla();
        ControoladorBatalla controlador = new ControoladorBatalla(vista, j1, j2);
        controlador.iniciar();

        vista.setVisible(true);

 
        System.out.println("\n--- GENERANDO REPORTES ---");
        reporteMonstruosPorJugador(j1);
        reporteMonstruosPorJugador(j2);
        reporteMonstruos();
    }

    public static void reporteMonstruosPorJugador(Jugador j) {
        System.out.println("\nCartas en el mazo de " + j.nombre + ":");
        for (int i = 0; i < j.cartas.size(); i++) {
            System.out.println("- " + j.cartas.get(i).getNombre() + " (ATQ: " + j.cartas.get(i).getATQ() + " / DEF: " + j.cartas.get(i).getDEF() + ")");
        }
    }

    public static void reporteMonstruos() {
        System.out.println("\nReporte general de batalla finalizado.");
    }
}
