import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class OrdenadorDiccionarioTest {

    private OrdenadorDiccionario<Integer, String> diccionarioAscendente;
    private OrdenadorDiccionario<Integer, String> diccionarioDescendente;

    @BeforeEach
    public void setUp() {
        // Crear instancias de OrdenadorDiccionario con orden ascendente y descendente
        diccionarioAscendente = new OrdenadorDiccionario<>(true);  // Orden ascendente
        diccionarioDescendente = new OrdenadorDiccionario<>(false); // Orden descendente
    }

    @Test
    public void testConstructorAscendente() {
        // Verificar que el constructor con orden ascendente establece correctamente el valor
        assertTrue(diccionarioAscendente.getOrdenAscendente(), "El orden debería ser ascendente.");
    }

    @Test
    public void testConstructorDescendente() {
        // Verificar que el constructor con orden descendente establece correctamente el valor
        assertFalse(diccionarioDescendente.getOrdenAscendente(), "El orden debería ser descendente.");
    }

    @Test
    public void testGetOrdenAscendente() {
        // Verificar que el método getOrdenAscendente devuelve el valor correcto
        assertTrue(diccionarioAscendente.getOrdenAscendente(), "El orden debería ser ascendente.");
        assertFalse(diccionarioDescendente.getOrdenAscendente(), "El orden debería ser descendente.");
    }

    @Test
    public void testSetOrdenAscendente() {
        // Verificar si el setter actualiza correctamente el valor de ordenAscendente
        diccionarioAscendente.setOrdenAscendente(false);
        assertFalse(diccionarioAscendente.getOrdenAscendente(), "El orden debería ser descendente después de llamar al setter.");

        diccionarioDescendente.setOrdenAscendente(true);
        assertTrue(diccionarioDescendente.getOrdenAscendente(), "El orden debería ser ascendente después de llamar al setter.");
    }

    @Test
    public void testConstructorPrivado() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Usamos reflexión para invocar el constructor privado
        Constructor<OrdenadorDiccionario> constructorPrivado = OrdenadorDiccionario.class.getDeclaredConstructor();
        constructorPrivado.setAccessible(true);

        // Invocar el constructor privado
        OrdenadorDiccionario diccionario = constructorPrivado.newInstance();

        // Verificar que el objeto creado no tiene el valor por defecto (debería ser false, ya que el constructor privado no asigna nada)
        assertNotNull(diccionario, "El constructor privado debería crear una instancia.");
        assertFalse(diccionario.getOrdenAscendente(), "El valor por defecto de ordenAscendente debería ser false.");
    }
}
