import java.util.Comparator;

public class DiccionarioOrdenado<K extends Comparable<K>,V> extends DiccionarioBasico<K,V> {
    private OrdenadorDiccionario<K,V> ordenador;
    public DiccionarioOrdenado(boolean ordenAscendente){
        this.ordenador = new OrdenadorDiccionario<>(ordenAscendente);
    }
    @Override
    public boolean add(K clave, V valor) {
        ElementoDiccionario<K, V> nuevoElemento = new ElementoDiccionario<>(clave, valor);

        if (getCabeza() == null) { // Si la lista está vacía, cabeza y cola apuntan al nuevo elemento
            setCabeza(nuevoElemento);
            setCola(nuevoElemento);
            return true;
        }

        Comparator<K> comparador;
        if (ordenador.getOrdenAscendente()){
            comparador = Comparator.naturalOrder();
        }else{
            comparador = Comparator.reverseOrder();
        }


        // Buscar la posición donde insertar
        ElementoDiccionario<K, V> actual = getCabeza();
        ElementoDiccionario<K, V> previo = null;

        while (actual != null && comparador.compare(actual.getClave(), clave) < 0) {
            previo = actual;
            actual = actual.getSiguente();
        }

        if (previo == null) { // Insertar al inicio (antes de la cabeza)
            nuevoElemento.setSiguente(getCabeza());
            getCabeza().setAnterior(nuevoElemento);
            setCabeza(nuevoElemento); // Actualizar la nueva cabeza
        } else if (actual == null) { // Insertar al final (después de la cola)
            previo.setSiguente(nuevoElemento);
            nuevoElemento.setAnterior(previo);
            setCola(nuevoElemento); // Actualizar la nueva cola
        } else { // Insertar en el medio
            previo.setSiguente(nuevoElemento);
            nuevoElemento.setAnterior(previo);
            nuevoElemento.setSiguente(actual);
            actual.setAnterior(nuevoElemento);
        }

        return true;
    }
}
