/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.Monstruo;
/**
 *
 * @author Titoelgato
 */
public class Magico extends Monstruo{
    public String efecto;

    @Override
    public void atacar(){
        System.out.println(nombre +"ataca con:"+ ATQ +" de daño");
    }
    
    public void atacar(int bono) {
        int ataqueTotal = ATQ + bono;
        System.out.println(nombre + " realiza un ataque mágico potenciado. Daño total: " + ataqueTotal);
    }
}
