import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiccionarioBasicoTest {
    DiccionarioBasico<Integer, String> diccionario;

    @BeforeEach
    public void setUp() {
        diccionario = new DiccionarioBasico<>();
    }

    @Test
    public void testAdd() {
        assertTrue(diccionario.add(1, "Uno"));
        assertTrue(diccionario.add(2, "Dos"));
        assertEquals(2, diccionario.getNumElementos());
        assertEquals("Uno", diccionario.get(1));
        assertEquals("Dos", diccionario.get(2));
    }

    @Test
    public void testDelete() {
        diccionario.add(1, "Uno");
        diccionario.add(2, "Dos");
        diccionario.add(3, "Tres");

        assertTrue(diccionario.delete(2));
        assertEquals(2, diccionario.getNumElementos());
        assertNull(diccionario.get(2));

        assertTrue(diccionario.delete(1));
        assertEquals(1, diccionario.getNumElementos());
        assertNull(diccionario.get(1));

        assertTrue(diccionario.delete(3));
        assertEquals(0, diccionario.getNumElementos());
        assertNull(diccionario.get(3));

        assertFalse(diccionario.delete(4));
    }

    @Test
    public void testGet() {
        diccionario.add(1, "Uno");
        diccionario.add(2, "Dos");

        assertEquals("Uno", diccionario.get(1));
        assertEquals("Dos", diccionario.get(2));
        assertNull(diccionario.get(3));
    }

    @Test
    public void testGetNumElementos() {
        assertEquals(0, diccionario.getNumElementos());
        diccionario.add(1, "Uno");
        assertEquals(1, diccionario.getNumElementos());
        diccionario.add(2, "Dos");
        assertEquals(2, diccionario.getNumElementos());
        diccionario.delete(1);
        assertEquals(1, diccionario.getNumElementos());
    }

    @Test
    public void testExist() {
        diccionario.add(1, "Uno");
        diccionario.add(2, "Dos");

        assertTrue(diccionario.exist(1));
        assertTrue(diccionario.exist(2));
        assertFalse(diccionario.exist(3));
    }

    @Test
    public void testGetIterador() {
        diccionario.add(1, "Uno");
        diccionario.add(2, "Dos");

        Iterador<ElementoDiccionario<Integer, String>> iterador = diccionario.getIterador();
        assertNotNull(iterador);

        assertTrue(iterador.hasNext());
        ElementoDiccionario<Integer, String> elemento = iterador.next();
        assertNotNull(elemento);
        assertEquals(2, elemento.getClave());
        assertEquals("Dos", elemento.getValor());

        assertTrue(iterador.hasNext());
        elemento = iterador.next();
        assertNotNull(elemento);
        assertEquals(1, elemento.getClave());
        assertEquals("Uno", elemento.getValor());

        assertFalse(iterador.hasNext());
    }

    @Test
    public void testSetCabezaCola() {
        ElementoDiccionario<Integer, String> cabeza = new ElementoDiccionario<>(0, "Cero");
        ElementoDiccionario<Integer, String> cola = new ElementoDiccionario<>(4, "Cuatro");

        diccionario.setCabeza(cabeza);
        diccionario.setCola(cola);

        assertEquals(cabeza, diccionario.getCabeza());
        assertEquals(cola, diccionario.getCola());
    }
}

