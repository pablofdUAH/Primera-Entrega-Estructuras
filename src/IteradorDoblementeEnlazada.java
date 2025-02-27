public class IteradorDoblementeEnlazada<T> implements Iterador<T>{
    ElementoDoble<T>actual;
    ListaDoblementeEnlazada<T>miLista;
    private IteradorDoblementeEnlazada(){}
    public IteradorDoblementeEnlazada(ListaDoblementeEnlazada<T>lista){
        this.miLista=lista;
        this.actual=lista.cabeza;
    }
    @Override
    public boolean hasNext(){
        return this.actual!=null;
    }
    @Override
    public T next(){
        if (hasNext()){
            T temporal = this.actual.getDato();
            if(actual.getSiguente()!=null){
                this.actual = this.actual.getSiguente();
            }
            actual = null;
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
    public boolean hasPrevious(){
        return this.actual!=null;
    }
    public T previous(){
        if (hasPrevious()){
            T temporal = this.actual.getDato();
            if(actual.getAnterior()!=null){
                this.actual = this.actual.getAnterior();
            }
            actual = null;
            return temporal;
        }
        return null;
    }
}
