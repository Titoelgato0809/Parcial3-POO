/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUII;

/**
 *
 * @author Titoelgato
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Jugador;
import Modelo.Comunes;

public class JugadorTest {

    private Jugador jugador;
    private Comunes carta;

    @BeforeEach
    void preparar() {
        jugador = new Jugador();
        jugador.nombre = "Yugi";
        jugador.Lp = 4000;
        carta = new Comunes("Mago Oscuro", 2500, 2100, true);
    }
