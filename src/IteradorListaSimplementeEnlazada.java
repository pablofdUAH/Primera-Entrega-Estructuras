public class IteradorListaSimplementeEnlazada<T>implements Iterador<T> {
    Elemento<T> actual;
    ListaSimplementeEnlazada<T> miLista;
    private IteradorListaSimplementeEnlazada(){}
    public IteradorListaSimplementeEnlazada(ListaSimplementeEnlazada<T> lista){
        this.miLista=lista;
        this.actual=lista.cabeza;
    }
    @Override
    public boolean hasNext(){
        return this.actual!=null;
    }
    @Override
    public T next(){
        T temporal = this.actual.getDato();
        this.actual = this.actual.siguente;
        return temporal;
    }
    @Override
    public void delete(){
        if (actual!=null){
            this.miLista.delete(actual.getDato());
        }
    }
}
