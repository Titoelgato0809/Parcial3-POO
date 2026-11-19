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
import Modelo.Comunes;
import Modelo.Magico;
public class MonstruoTest {
    
    private Comunes atacante;   
    private Magico magico;      

    @BeforeEach
    void preparar() {
        atacante = new Comunes("Mago Oscuro", 2500, 2100, true);
        magico = new Magico();
        magico.setNombre("Dragon Blanco");
        magico.setATQ(3000);
        magico.setDEF(2500);
        magico.setPosicion(true);
    }

    @Test
    void constructorAsignaAtributos() {
        assertEquals("Mago Oscuro", atacante.getNombre());
        assertEquals(2500, atacante.getATQ());
        assertEquals(2100, atacante.getDEF());
        assertTrue(atacante.isPosicion());
    }

    @Test
    void settersModificanAtributos() {
        atacante.setNombre("Otro");
        atacante.setATQ(100);
        atacante.setDEF(200);
        atacante.setPosicion(false);
        assertEquals("Otro", atacante.getNombre());
        assertEquals(100, atacante.getATQ());
        assertEquals(200, atacante.getDEF());
        assertFalse(atacante.isPosicion());
    }

    @Test
    void toStringContieneDatosDeLaCarta() {
        assertEquals("Carta: Mago Oscuro - ATQ: 2500 - DEF: 2100", atacante.toString());
    }

    @Test
    void ataqueContraAtaqueGanaElMasFuerte() {
        // 3000 - 2500 = 500 a favor del atacante
        assertEquals(500, magico.calcularDiferencia(atacante));
        // 2500 - 3000 = -500 a favor del defensor
        assertEquals(-500, atacante.calcularDiferencia(magico));
    }

    @Test
    void ataqueContraAtaqueIgualEsEmpate() {
        Comunes igual = new Comunes("Igual", 2500, 0, true);
        assertEquals(0, atacante.calcularDiferencia(igual));
    }

    @Test
    void ataqueContraDefensaUsaLaDEFDelDefensor() {
        magico.setPosicion(false); // defensa, DEF 2500
        // 2500 - 2500 = 0
        assertEquals(0, atacante.calcularDiferencia(magico));
        magico.setDEF(2000);
        assertEquals(500, atacante.calcularDiferencia(magico));
        magico.setDEF(3000);
        assertEquals(-500, atacante.calcularDiferencia(magico));
    }
}
