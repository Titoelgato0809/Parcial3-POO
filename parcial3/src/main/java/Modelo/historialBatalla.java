/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Titoelgato
 */
public class historialBatalla {
    private List<String> registros = new ArrayList<>();
    
    public void registrar(String lineas) {
        registros.add(lineas);
        System.out.println("Registro añadido: " + lineas);
    }

    public void guardar() {
        System.out.println("Guardando historial de batalla en archivo .txt...");
    }
}
