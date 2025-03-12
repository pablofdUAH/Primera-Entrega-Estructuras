import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElementoDiccionarioTest {

    private ElementoDiccionario<Integer, String> elemento;

    @BeforeEach
    public void setUp() {
        // Crear un nuevo elemento diccionario antes de cada prueba
        elemento = new ElementoDiccionario<>(1, "Valor 1");
    }

    @Test
    public void testConstructor() {
        // Verificar que el constructor asigna correctamente los valores
        assertNotNull(elemento, "El objeto ElementoDiccionario no debe ser null.");
        assertEquals(1, elemento.getClave(), "La clave debe ser 1.");
        assertEquals("Valor 1", elemento.getValor(), "El valor debe ser 'Valor 1'.");
    }

    @Test
    public void testSettersYGetters() {
        // Probar los getters y setters
        elemento.setClave(2);
        elemento.setValor("Valor 2");

        // Verificar que los setters han actualizado los valores correctamente
        assertEquals(2, elemento.getClave(), "La clave debe ser 2.");
        assertEquals("Valor 2", elemento.getValor(), "El valor debe ser 'Valor 2'.");

        // Probar los setters de los nodos anteriores y siguientes
        ElementoDiccionario<Integer, String> anterior = new ElementoDiccionario<>(0, "Valor anterior");
        ElementoDiccionario<Integer, String> siguiente = new ElementoDiccionario<>(3, "Valor siguiente");

        elemento.setAnterior(anterior);
        elemento.setSiguente(siguiente);

        // Verificar que las referencias anteriores y siguientes están correctamente asignadas
        assertEquals(anterior, elemento.getAnterior(), "El nodo anterior debe ser el esperado.");
        assertEquals(siguiente, elemento.getSiguente(), "El nodo siguiente debe ser el esperado.");
    }

    @Test
    public void testElementoVacio() {
        // Crear un elemento vacío con el constructor público
        ElementoDiccionario<Integer, String> elementoVacio = new ElementoDiccionario<>(null, null);

        assertNull(elementoVacio.getClave(), "La clave de un elemento vacío debe ser null.");
        assertNull(elementoVacio.getValor(), "El valor de un elemento vacío debe ser null.");
        assertNull(elementoVacio.getAnterior(), "El anterior de un elemento vacío debe ser null.");
        assertNull(elementoVacio.getSiguente(), "El siguiente de un elemento vacío debe ser null.");
    }

    @Test
    public void testConstructorPrivado() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Usar reflexión para acceder al constructor privado
        Constructor<ElementoDiccionario> constructor = ElementoDiccionario.class.getDeclaredConstructor();
        constructor.setAccessible(true); // Hacer que el constructor privado sea accesible
        ElementoDiccionario<Integer, String> elementoPrivado = constructor.newInstance(); // Crear una instancia

        // Verificar que el objeto creado mediante reflexión no es null
        assertNotNull(elementoPrivado, "El objeto creado con el constructor privado no debe ser null.");

        // Verificar que los valores por defecto son null
        assertNull(elementoPrivado.getClave(), "La clave del objeto creado con el constructor privado debe ser null.");
        assertNull(elementoPrivado.getValor(), "El valor del objeto creado con el constructor privado debe ser null.");
        assertNull(elementoPrivado.getAnterior(), "El anterior del objeto creado con el constructor privado debe ser null.");
        assertNull(elementoPrivado.getSiguente(), "El siguiente del objeto creado con el constructor privado debe ser null.");
    }
}

