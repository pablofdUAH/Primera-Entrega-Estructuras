import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDoblementeEnlazadaTest {
    ListaDoblementeEnlazada<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaDoblementeEnlazada<>();
    }

    @Test
    public void testAdd() {
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    public void testInsertAtEnd() {
        assertTrue(lista.insertAtEnd(1)); // corregir el nombre del método
        assertTrue(lista.insertAtEnd(2)); // corregir el nombre del método
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    public void testDelete() {
        lista.add(1);
        lista.add(2);
        assertTrue(lista.delete(1));
        assertEquals(1, lista.getNumElementos());
        assertFalse(lista.delete(3));
        assertTrue(lista.delete(2));
        assertEquals(0, lista.getNumElementos());
    }

    @Test
    public void testGetNumElementos() {
        lista.add(1);
        lista.add(2);
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    public void testGetIterador() {
        lista.add(1);
        lista.add(2);
        Iterador<Integer> iterador = lista.getIterador();
        assertNotNull(iterador);
    }
}

