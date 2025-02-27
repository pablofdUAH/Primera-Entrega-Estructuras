public class Cola<T> {
    private ListaSimplementeEnlazada<T> cola = new ListaSimplementeEnlazada<T>();
    void enqueue(T dato){
        cola.add(dato);
    }
    T dequeue(){
        Iterador<T>iterator=cola.getIterador();
        T dato = null;
        while (iterator.hasNext()){
            dato = iterator.next();
        }
        cola.delete(dato);
        return dato;
    }
}
