import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaSimplementeEnlazadaTest {
    ListaSimplementeEnlazada<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaSimplementeEnlazada<>();
    }

    @Test
    public void testAdd() {
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    public void testAddAtEnd() {
        assertTrue(lista.addAtEnd(1));
        assertTrue(lista.addAtEnd(2));
        assertEquals(2, lista.getNumElementos());
        lista.add(8);
        lista.addAtEnd(7);
        assertEquals(4, lista.getNumElementos());
    }

    @Test
    public void testDelete() {
        // Caso cuando la lista está vacía
        assertFalse(lista.delete(1));

        // Caso cuando hay un solo elemento en la lista
        lista.add(1);
        assertTrue(lista.delete(1));
        assertEquals(0, lista.getNumElementos());

        // Caso cuando hay múltiples elementos en la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertTrue(lista.delete(2));
        assertEquals(2, lista.getNumElementos());

        // Caso cuando se elimina un elemento que no está en la lista
        assertFalse(lista.delete(4));

        // Eliminar los elementos restantes
        assertTrue(lista.delete(1));
        assertEquals(1, lista.getNumElementos());
        assertTrue(lista.delete(3));
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
