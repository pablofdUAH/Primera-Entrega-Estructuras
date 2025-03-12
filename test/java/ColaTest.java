import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    @Test
    void testEnqueueDequeue() {
        Cola<Integer> cola = new Cola<>();

        // Agregar elementos a la cola
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);

        // Verificar que se extraen en orden FIFO
        assertEquals(1, cola.dequeue());
        assertEquals(2, cola.dequeue());
        assertEquals(3, cola.dequeue());
    }

    @Test
    void testDequeueEmpty() {
        Cola<String> cola = new Cola<>();
        assertNull(cola.dequeue(), "Dequeue en una cola vacía debe retornar null");
    }

    @Test
    void testSingleElement() {
        Cola<Double> cola = new Cola<>();
        cola.enqueue(5.5);
        assertEquals(5.5, cola.dequeue());
        assertNull(cola.dequeue());
    }
}
