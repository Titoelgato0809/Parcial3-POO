/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Titoelgato
 */
public class Jugador {
    public String nombre;
    public int Lp;
    public List<Monstruo> cartas = new ArrayList<>();

    public void agregarCarta(Monstruo m) {
        cartas.add(m);
        System.out.println(m.getNombre() + " ha sido agregado a las cartas de " + nombre);
    }

    public void recibirDanio(int cantidad) {
        this.Lp -= cantidad;
        System.out.println(nombre + " recibe " + cantidad + " de daño. LP restantes: " + this.Lp);
    }
}