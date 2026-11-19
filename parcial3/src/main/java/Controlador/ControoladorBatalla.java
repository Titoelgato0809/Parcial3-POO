/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Monstruo;
import Modelo.historialBatalla;
/**
 *
 * @author Titoelgato
 */
public class ControoladorBatalla {
    
    private historialBatalla historial = new historialBatalla();
    
    public void calcularDanio(Monstruo atacante, Monstruo defensor) {
        int danio = atacante.getATQ() - defensor.getDEF();
        if (danio > 0) {
            historial.registrar(atacante.getNombre() + " hizo " + danio + " de daño a " + defensor.getNombre());
        } else {
            historial.registrar(atacante.getNombre() + " atacó a " + defensor.getNombre() + " pero no hizo daño.");
        }
    }
}
