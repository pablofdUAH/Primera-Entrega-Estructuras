public class IteradorDoblementeEnlazada<T> implements Iterador<T> {
    // ZONA DE ATRIBUTOS
    private ElementoDoble<T> actual;
    private ListaDoblementeEnlazada<T> miLista;

    // Constructor
    public IteradorDoblementeEnlazada(ListaDoblementeEnlazada<T> lista) {
        this.miLista = lista;
        this.actual = lista.cabeza; // Comenzar en la cabeza de la lista
    }

    // Métodos de la interfaz
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        T temporal = actual.getDato();
        actual = actual.getSiguente(); // Avanzar sin anular actual = null
        return temporal;
    }

    @Override
    public void delete() {
        if (actual != null) {
            ElementoDoble<T> aEliminar = actual;
            actual = actual.getSiguente(); // Mover actual antes de eliminar
            miLista.delete(aEliminar.getDato());
        }
    }

    // Métodos propios
    public boolean hasPrevious() {
        return actual != null && actual.getAnterior() != null;
    }

    public T previous() {
        if (!hasPrevious()) {
            return null;
        }
        actual = actual.getAnterior(); // Retroceder sin anular actual = null
        return actual.getDato();
    }
}

