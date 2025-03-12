import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteradorListaSimplementeEnlazadaTest {
    ListaSimplementeEnlazada<Integer> lista;
    IteradorListaSimplementeEnlazada<Integer> iterador;

    @BeforeEach
    public void setUp() {
        lista = new ListaSimplementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        iterador = new IteradorListaSimplementeEnlazada<>(lista);
    }

    @Test
    public void testHasNext() {
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertFalse(iterador.hasNext());
    }

    @Test
    public void testNext() {
        assertEquals(3, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(1, iterador.next());
        assertNull(iterador.next());
    }

    @Test
    public void testDelete() {
        iterador.next(); // Avanzar al primer elemento
        iterador.delete(); // Eliminar el primer elemento
        assertEquals(2, lista.getNumElementos());

        iterador = new IteradorListaSimplementeEnlazada<>(lista);
        iterador.next(); // Avanzar al segundo elemento
        iterador.delete(); // Eliminar el segundo elemento
        assertEquals(1, lista.getNumElementos());

        iterador = new IteradorListaSimplementeEnlazada<>(lista);
        iterador.next(); // Avanzar al único elemento restante
        iterador.delete(); // Eliminar el único elemento restante
        assertEquals(1, lista.getNumElementos());
    }
}
