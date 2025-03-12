import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class DiccionarioOrdenadoTest {

    private DiccionarioOrdenado<Integer, String> diccionarioAscendente;
    private DiccionarioOrdenado<Integer, String> diccionarioDescendente;

    @BeforeEach
    public void setUp() {
        // Inicializar diccionarios ordenados
        diccionarioAscendente = new DiccionarioOrdenado<>(true);
        diccionarioDescendente = new DiccionarioOrdenado<>(false);
    }

    @Test
    public void testConstructor() {
        // Verificar que el constructor establece correctamente el orden ascendente o descendente
        assertTrue(diccionarioAscendente.getOrdenador().getOrdenAscendente(), "El diccionario debe estar ordenado ascendentemente.");
        assertFalse(diccionarioDescendente.getOrdenador().getOrdenAscendente(), "El diccionario debe estar ordenado descendentemente.");
    }

    @Test
    public void testAddAscendente() {
        // Verificar la inserción de elementos en orden ascendente
        diccionarioAscendente.add(3, "Tres");
        diccionarioAscendente.add(1, "Uno");
        diccionarioAscendente.add(2, "Dos");

        // Verificar que los elementos están en el orden correcto (ascendente)
        assertEquals("Uno", diccionarioAscendente.getCabeza().getValor(), "La cabeza debe ser 'Uno'.");
        assertEquals("Dos", diccionarioAscendente.getCabeza().getSiguente().getValor(), "El siguiente elemento debe ser 'Dos'.");
        assertEquals("Tres", diccionarioAscendente.getCola().getValor(), "La cola debe ser 'Tres'.");
    }

    @Test
    public void testAddDescendente() {
        // Verificar la inserción de elementos en orden descendente
        diccionarioDescendente.add(3, "Tres");
        diccionarioDescendente.add(1, "Uno");
        diccionarioDescendente.add(2, "Dos");

        // Verificar que los elementos están en el orden correcto (descendente)
        assertEquals("Tres", diccionarioDescendente.getCabeza().getValor(), "La cabeza debe ser 'Tres'.");
        assertEquals("Dos", diccionarioDescendente.getCabeza().getSiguente().getValor(), "El siguiente elemento debe ser 'Dos'.");
        assertEquals("Uno", diccionarioDescendente.getCola().getValor(), "La cola debe ser 'Uno'.");
    }

    @Test
    public void testAddElementoUnico() {
        // Verificar la inserción de un único elemento
        diccionarioAscendente.add(1, "Uno");

        assertEquals("Uno", diccionarioAscendente.getCabeza().getValor(), "La cabeza debe ser 'Uno'.");
        assertEquals("Uno", diccionarioAscendente.getCola().getValor(), "La cola debe ser 'Uno'.");
    }

    @Test
    public void testAddElementoVariosIguales() {
        // Verificar que se manejan correctamente varios elementos con claves iguales
        diccionarioAscendente.add(2, "Dos");
        diccionarioAscendente.add(1, "Uno");
        diccionarioAscendente.add(2, "OtroDos"); // Duplicado clave 2

        // Verificar que los elementos con la misma clave se gestionan correctamente
        assertEquals("Uno", diccionarioAscendente.getCabeza().getValor(), "La cabeza debe ser 'Uno'.");
        assertEquals("OtroDos", diccionarioAscendente.getCabeza().getSiguente().getValor(), "El siguiente elemento debe ser 'Dos'.");
        assertEquals("Dos", diccionarioAscendente.getCabeza().getSiguente().getSiguente().getValor(), "El siguiente siguiente elemento debe ser 'OtroDos'.");
    }
}
