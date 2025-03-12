import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IteradorDoblementeEnlazadaTest {
    private ListaDoblementeEnlazada<String> lista;
    private IteradorDoblementeEnlazada<String> iterador;

    @BeforeEach
    void setUp() {
        // Crear lista y agregar elementos en orden correcto
        lista = new ListaDoblementeEnlazada<>();
        lista.add("elemento1");
        lista.add("elemento2");
        lista.add("elemento3");

        // Inicializar el iterador
        iterador = new IteradorDoblementeEnlazada<>(lista);
    }

    @Test
    void testHasNext() {
        assertTrue(iterador.hasNext()); // Debería haber un siguiente
        iterador.next(); // Avanza al segundo elemento
        assertTrue(iterador.hasNext()); // Aún hay un elemento
        iterador.next(); // Avanza al tercero
        assertTrue(iterador.hasNext()); // Último elemento
        iterador.next(); // Avanza a null
        assertFalse(iterador.hasNext()); // No hay más elementos
    }

    @Test
    void testNext() {
        assertEquals("elemento3", iterador.next()); // Primer elemento (último añadido)
        assertEquals("elemento2", iterador.next()); // Segundo elemento
        assertEquals("elemento1", iterador.next()); // Tercer elemento
        assertNull(iterador.next()); // Ya no hay más elementos
    }

    @Test
    void testHasPrevious() {
        iterador.next(); // Moverse al segundo
        iterador.next(); // Moverse al tercero
        assertTrue(iterador.hasPrevious()); // Hay elementos anteriores
    }

    @Test
    void testPrevious() {
        iterador.next(); // Moverse al segundo
        iterador.next(); // Moverse al tercero
        assertEquals("elemento2", iterador.previous()); // Retrocede al segundo
        assertEquals("elemento3", iterador.previous()); // Retrocede al primero
        assertNull(null, iterador.previous()); // Se queda en el primero
    }

    @Test
    void testDelete() {
        iterador.next(); // Posicionado en el primer elemento
        iterador.delete(); // Eliminar el primer elemento
        assertTrue(lista.delete("elemento3")); // Verifica que ya no existe
    }
}