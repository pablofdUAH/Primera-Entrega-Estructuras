import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PilaTest {
    Pila<Integer> pila;

    @BeforeEach
    public void setUp() {
        pila = new Pila<>();
    }

    @Test
    public void testPushAndPop() {
        pila.push(1);
        pila.push(2);
        assertEquals(2, pila.pop());
        assertEquals(1, pila.pop());
        assertNull(pila.pop());
    }

    @Test
    public void testPopOnEmptyStack() {
        assertNull(pila.pop());
    }

    @Test
    public void testPushAndPopMixed() {
        pila.push(1);
        pila.push(2);
        assertEquals(2, pila.pop());
        pila.push(3);
        assertEquals(3, pila.pop());
        assertEquals(1, pila.pop());
        assertNull(pila.pop());
    }
}
