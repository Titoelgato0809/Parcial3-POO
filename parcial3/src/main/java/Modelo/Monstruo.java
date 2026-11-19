/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Titoelgato
 */
public class Monstruo {
    protected String nombre;
    protected int ATQ;
    protected int DEF;
    protected boolean posicion;

    public String getNombre() {
        return nombre;
    }

    public int getATQ() {
        return ATQ;
    }

    public int getDEF() {
        return DEF;
    }

    public boolean isPosicion() {
        return posicion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setATQ(int ATQ) {
        this.ATQ = ATQ;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void setPosicion(boolean posicion) {
        this.posicion = posicion;
    }
    
    
}
