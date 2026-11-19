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
}
