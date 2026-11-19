/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Jugador;
import Modelo.Monstruo;
import Modelo.historialBatalla;
import Vista.VistaBatalla;
/**
 *
 * @author Titoelgato
 */
public class ControoladorBatalla {
    
    private historialBatalla historial = new historialBatalla();
    private VistaBatalla vista;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoJugador1 = true;

    public ControoladorBatalla(VistaBatalla vista, Jugador jugador1, Jugador jugador2) {
        this.vista = vista;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    // Enlaza el evento del botón de la vista con la lógica de este controlador
    public void iniciar() {
        vista.agregarListener(e -> ejecutarTurno());
        vista.actualizarLP(jugador1.Lp, jugador2.Lp);
        vista.mostrar("Turno de " + jugador1.nombre);
    }

    private void ejecutarTurno() {
        Jugador atacante = turnoJugador1 ? jugador1 : jugador2;
        Jugador defensor = turnoJugador1 ? jugador2 : jugador1;

        if (!atacante.tieneMonstruos()) {
            vista.mostrar(atacante.nombre + " no tiene monstruos para atacar.");
        } else {
            Monstruo monstruoAtacante = atacante.cartas.get(0);
            if (defensor.tieneMonstruos()) {
                calcularDanio(atacante, monstruoAtacante, defensor, defensor.cartas.get(0));
            } else {
                ataqueDirecto(atacante, monstruoAtacante, defensor);
            }
        }

        vista.actualizarLP(jugador1.Lp, jugador2.Lp);
        guardarHistorialBatalla();

        if (jugador1.estaDerrotado() || jugador2.estaDerrotado()) {
            Jugador ganador = jugador1.estaDerrotado() ? jugador2 : jugador1;
            registrar("Fin del duelo. Gana " + ganador.nombre + ".");
            vista.habilitarAtaque(false);
            guardarHistorialBatalla();
            return;
        }

        turnoJugador1 = !turnoJugador1;
        vista.mostrar("Turno de " + (turnoJugador1 ? jugador1.nombre : jugador2.nombre));
    }

 
    public void calcularDanio(Monstruo atacante, Monstruo defensor) {
        int danio = atacante.calcularDiferencia(defensor);
        if (danio > 0) {
            registrar(atacante.getNombre() + " hizo " + danio + " de daño a " + defensor.getNombre());
        } else {
            registrar(atacante.getNombre() + " atacó a " + defensor.getNombre() + " pero no hizo daño.");
        }
    }

    
    public void calcularDanio(Jugador duenoAtacante, Monstruo atacante, Jugador duenoDefensor, Monstruo defensor) {
        int diferencia = atacante.calcularDiferencia(defensor);
        boolean defensorEnAtaque = defensor.isPosicion();

        if (diferencia > 0) {
            duenoDefensor.eliminarCarta(defensor);
            if (defensorEnAtaque) {
                duenoDefensor.recibirDanio(diferencia);
                registrar(atacante.getNombre() + " destruyó a " + defensor.getNombre()
                        + " y " + duenoDefensor.nombre + " pierde " + diferencia + " LP.");
            } else {
                registrar(atacante.getNombre() + " destruyó a " + defensor.getNombre()
                        + " (en defensa). No hay daño a los LP.");
            }
        } else if (diferencia < 0) {
            if (defensorEnAtaque) {
                duenoAtacante.eliminarCarta(atacante);
                duenoAtacante.recibirDanio(-diferencia);
                registrar(defensor.getNombre() + " destruyó a " + atacante.getNombre()
                        + " y " + duenoAtacante.nombre + " pierde " + (-diferencia) + " LP.");
            } else {
                duenoAtacante.recibirDanio(-diferencia);
                registrar(atacante.getNombre() + " no superó la defensa de " + defensor.getNombre()
                        + ". " + duenoAtacante.nombre + " pierde " + (-diferencia) + " LP.");
            }
        } else {
            if (defensorEnAtaque) {
                duenoAtacante.eliminarCarta(atacante);
                duenoDefensor.eliminarCarta(defensor);
                registrar(atacante.getNombre() + " y " + defensor.getNombre() + " se destruyeron mutuamente.");
            } else {
                registrar(atacante.getNombre() + " atacó a " + defensor.getNombre() + " pero no pasó nada.");
            }
        }
    }

    public void ataqueDirecto(Jugador duenoAtacante, Monstruo atacante, Jugador duenoDefensor) {
        duenoDefensor.recibirDanio(atacante.getATQ());
        registrar(atacante.getNombre() + " atacó directamente a " + duenoDefensor.nombre
                + " y le quitó " + atacante.getATQ() + " LP.");
    }

    private void registrar(String linea) {
        historial.registrar(linea);
        vista.mostrar(linea);
    }

    public void guardarHistorialBatalla() {
        historial.guardar();
    }
}
