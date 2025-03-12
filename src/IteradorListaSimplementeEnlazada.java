public class IteradorListaSimplementeEnlazada<T>implements Iterador<T> {
    // ZONA DE ATRIBUTOS
    Elemento<T> actual;
    ListaSimplementeEnlazada<T> miLista;


    // ZONA DE METODOS
        // Constructor
    private IteradorListaSimplementeEnlazada(){}
    public IteradorListaSimplementeEnlazada(ListaSimplementeEnlazada<T> lista){
        this.miLista=lista;
        this.actual=lista.cabeza;
    }

        // Métodos de la interfaz
    @Override
    public boolean hasNext(){
        return this.actual!=null;
    }
    @Override
    public T next() {
        if (hasNext()) {
            T temporal = this.actual.getDato();
            this.actual = this.actual.getSiguente();
            return temporal;
        }
        return null;
    }
    @Override
    public void delete(){
        if (actual!=null){
            this.miLista.delete(actual.getDato());
        }
    }

        // Métodos propios
}
