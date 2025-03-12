import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElementoDobleTest {

    private ElementoDoble<String> elementoConDato;
    private ElementoDoble<String> siguienteElemento;
    private ElementoDoble<String> anteriorElemento;

    @BeforeEach
    public void setUp() {
        // Inicializar los elementos
        elementoConDato = new ElementoDoble<>("Dato de prueba");
        siguienteElemento = new ElementoDoble<>("Siguiente dato");
        anteriorElemento = new ElementoDoble<>("Anterior dato");
    }

    @Test
    public void testConstructorConDato() {
        // Verificar que el constructor con parámetro establece correctamente el valor de dato
        assertEquals("Dato de prueba", elementoConDato.getDato(), "El dato debería ser 'Dato de prueba'");
    }

    @Test
    public void testGetDato() {
        // Verificar que el getter de dato devuelve el valor correcto
        assertEquals("Dato de prueba", elementoConDato.getDato(), "El getter debería devolver 'Dato de prueba'");
    }

    @Test
    public void testSetDato() {
        // Verificar que el setter de dato actualiza el valor correctamente
        elementoConDato.setDato("Nuevo dato");
        assertEquals("Nuevo dato", elementoConDato.getDato(), "El setter debería haber actualizado el dato.");
    }

    @Test
    public void testGetAnterior() {
        // Verificar que el getter de anterior devuelve el valor correcto
        elementoConDato.setAnterior(anteriorElemento);
        assertEquals(anteriorElemento, elementoConDato.getAnterior(), "El anterior elemento debería ser el que se ha asignado.");
    }

    @Test
    public void testSetAnterior() {
        // Verificar que el setter de anterior actualiza el valor correctamente
        elementoConDato.setAnterior(anteriorElemento);
        assertEquals(anteriorElemento, elementoConDato.getAnterior(), "El setter debería haber actualizado el anterior elemento.");
    }

    @Test
    public void testGetSiguente() {
        // Verificar que el getter de siguiente devuelve el valor correcto
        elementoConDato.setSiguente(siguienteElemento);
        assertEquals(siguienteElemento, elementoConDato.getSiguente(), "El siguiente elemento debería ser el que se ha asignado.");
    }

    @Test
    public void testSetSiguente() {
        // Verificar que el setter de siguiente actualiza el valor correctamente
        elementoConDato.setSiguente(siguienteElemento);
        assertEquals(siguienteElemento, elementoConDato.getSiguente(), "El setter debería haber actualizado el siguiente elemento.");
    }

    @Test
    public void testConstructorPrivado() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Usamos reflexión para invocar el constructor privado
        Constructor<ElementoDoble> constructorPrivado = ElementoDoble.class.getDeclaredConstructor();
        constructorPrivado.setAccessible(true); // Hacemos el constructor privado accesible

        // Invocar el constructor privado
        ElementoDoble<String> elemento = constructorPrivado.newInstance();

        // Verificar que el objeto creado tiene el dato nulo
        assertNull(elemento.getDato(), "El dato debería ser null ya que se utiliza el constructor privado.");
    }
}
