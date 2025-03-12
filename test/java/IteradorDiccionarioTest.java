import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IteradorDiccionarioTest {
    private DiccionarioBasico<String, String> diccionario;
    private IteradorDiccionario<String, String> iterador;

    @BeforeEach
    void setUp() {
        // Crear diccionario y agregar elementos
        diccionario = new DiccionarioBasico<>();
        diccionario.add("clave1", "valor1");
        diccionario.add("clave2", "valor2");

        // Inicializar el iterador
        iterador = new IteradorDiccionario<>(diccionario);
    }

    @Test
    void testHasNext() {
        assertTrue(iterador.hasNext()); // Debería haber un siguiente
        iterador.next(); // Avanza al segundo elemento
        assertTrue(iterador.hasNext()); // Aún hay un elemento
        iterador.next(); // Avanza a null
        assertFalse(iterador.hasNext()); // No hay más elementos
    }

    @Test
    void testNext() {
        assertEquals("clave2", iterador.next().getClave()); // Primer elemento
        assertEquals("clave1", iterador.next().getClave()); // Segundo elemento
        assertNull(iterador.next()); // Ya no hay más elementos
    }

    @Test
    void testHasPrevious() {
        assertTrue(iterador.hasPrevious()); // Siempre devuelve true
        iterador.next(); // Avanza al segundo elemento
        assertTrue(iterador.hasPrevious());
    }

    @Test
    void testPrevious() {
        iterador.next(); // Avanza al segundo elemento
        assertEquals("clave1", iterador.previous().getClave()); // Retrocede al primero
        assertEquals("clave2", iterador.previous().getClave()); // Debería quedarse en el primero
        assertNull(iterador.previous());
    }

    @Test
    void testDelete() {
        iterador.delete(); // Eliminará el actual (cabeza)
        assertTrue(diccionario.exist("clave1")); // Verifica que se eliminó
    }
}

