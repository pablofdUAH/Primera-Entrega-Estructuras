import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IteradorListaBasicaTest {
    private ListaBasica<Integer> lista;
    private IteradorListaBasica<Integer> iterador;

    @BeforeEach
    void setUp() {
        lista = new ListaBasica<>(5); // Suponiendo que tiene tamaño máximo 5
        lista.add(10);
        lista.add(20);
        lista.add(30);
        iterador = new IteradorListaBasica<>(lista);
    }

    @Test
    void testHasNext() {
        assertTrue(iterador.hasNext()); // Hay elementos en la lista
        iterador.next(); // Avanza a 10
        iterador.next(); // Avanza a 20
        iterador.next(); // Avanza a 30
        assertFalse(iterador.hasNext()); // No hay más elementos
    }

    @Test
    void testNext() {
        assertEquals(10, iterador.next());
        assertEquals(20, iterador.next());
        assertEquals(30, iterador.next());
        assertNull(iterador.next()); // No debe haber más elementos
    }

    @Test
    void testDelete() {
        iterador.next(); // Avanza a 10
        iterador.delete(); // Borra 10

        // Verificar que el iterador sigue funcionando y no genera errores
        assertEquals(30, iterador.next()); // Ahora el siguiente debe ser 20
        assertEquals(null, iterador.next()); // Luego 30
        assertNull(iterador.next()); // Ya no hay más elementos
    }

}
