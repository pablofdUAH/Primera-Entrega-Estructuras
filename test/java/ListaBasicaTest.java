import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaBasicaTest {

    ListaBasica<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaBasica<>(5);
    }

    @Test
    public void testAdd() {
        assertTrue(lista.add(10));
        assertTrue(lista.add(20));
        assertTrue(lista.add(30));
        assertTrue(lista.add(40));
        assertTrue(lista.add(50));
        assertFalse(lista.add(60)); // Exceeds max capacity
        assertEquals(5, lista.getNumElementos());
    }

    @Test
    public void testDelete() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);

        assertTrue(lista.delete(30));
        assertFalse(lista.delete(60)); // Element not in the list
        assertEquals(4, lista.getNumElementos());
    }

    @Test
    public void testGetNumElementos() {
        assertEquals(0, lista.getNumElementos());
        lista.add(10);
        assertEquals(1, lista.getNumElementos());
        lista.add(20);
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    public void testGetIterador() {
        lista.add(10);
        lista.add(20);
        Iterador<Integer> iterador = lista.getIterador();

        assertTrue(iterador.hasNext());
        assertEquals(Integer.valueOf(10), iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(Integer.valueOf(20), iterador.next());
        assertFalse(iterador.hasNext());
    }
}
