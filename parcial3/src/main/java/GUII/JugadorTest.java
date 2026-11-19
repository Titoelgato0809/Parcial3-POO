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
        @Test
    void recibirDanioReduceLP() {
        jugador.recibirDanio(500);
        assertEquals(3500, jugador.Lp);
    }

    @Test
    void recibirDanioVariasVeces() {
        jugador.recibirDanio(1000);
        jugador.recibirDanio(1500);
        assertEquals(1500, jugador.Lp);
    }

    @Test
    void lpNuncaQuedaNegativo() {
        jugador.recibirDanio(9999);
        assertEquals(0, jugador.Lp);
    }

    @Test
    void estaDerrotadoSoloConLPEnCero() {
        assertFalse(jugador.estaDerrotado());
        jugador.recibirDanio(4000);
        assertTrue(jugador.estaDerrotado());
    }

    @Test
    void agregarCartaLaGuardaEnLaLista() {
        assertFalse(jugador.tieneMonstruos());
        jugador.agregarCarta(carta);
        assertTrue(jugador.tieneMonstruos());
        assertEquals(1, jugador.cartas.size());
        assertSame(carta, jugador.cartas.get(0));
    }

    @Test
    void eliminarCartaLaQuitaDeLaLista() {
        jugador.agregarCarta(carta);
        jugador.eliminarCarta(carta);
        assertFalse(jugador.tieneMonstruos());
    }
}
