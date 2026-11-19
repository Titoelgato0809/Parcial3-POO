package GUII;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.historialBatalla;

public class HistorialBatallaTest {
    @Test
    void registrarAgregaLineas() {
        historialBatalla h = new historialBatalla();
        h.registrar("linea 1");
        h.registrar("linea 2");
        assertEquals(2, h.getRegistros().size());
        assertEquals("linea 2", h.getRegistros().get(1));
    }
    
        @Test
    void guardarEscribeUnaLineaPorRegistro() throws IOException {
        historialBatalla h = new historialBatalla();
        h.registrar("Mago Oscuro hizo 500 de daño a Dragon Blanco");
        h.registrar("Fin del duelo");

        File temporal = File.createTempFile("historial_test", ".txt");
        temporal.deleteOnExit();
        h.guardar(temporal.getAbsolutePath());

        List<String> lineas = Files.readAllLines(temporal.toPath(), StandardCharsets.UTF_8);
        assertEquals(2, lineas.size());
        assertEquals("Fin del duelo", lineas.get(1));
    }

    @Test
    void guardarConHistorialVacioCreaArchivoVacio() throws IOException {
        File temporal = File.createTempFile("historial_vacio", ".txt");
        temporal.deleteOnExit();
        new historialBatalla().guardar(temporal.getAbsolutePath());
        assertEquals(0, Files.size(temporal.toPath()));
    }
}
