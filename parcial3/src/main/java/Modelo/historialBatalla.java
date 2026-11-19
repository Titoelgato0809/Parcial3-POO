/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public List<String> getRegistros() {
        return registros;
    }

    public void guardar() {
        guardar("historial_combate.txt");
    }

    public void guardar(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (String linea : registros) {
                pw.println(linea);
            }
            System.out.println("Historial guardado en " + ruta);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el historial: " + e.getMessage());
        }
    }
}
