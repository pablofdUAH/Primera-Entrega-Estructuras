public class Pila<T> {
    private ListaSimplementeEnlazada<T> pila = new ListaSimplementeEnlazada<T>();
    void push(T dato){
        pila.addAtEnd(dato);
    }
    T pop(){
        Iterador<T>iterator=pila.getIterador();
        T dato = null;
        while (iterator.hasNext()){
            dato = iterator.next();
        }
        pila.delete(dato);
        return dato;
    }
}
