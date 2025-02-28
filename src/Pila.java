public class Pila<T> {
    // ZONA DE ATRIBUTOS


    // ZONA DE METODOS
        // Constructor
    private ListaSimplementeEnlazada<T> pila = new ListaSimplementeEnlazada<T>();

        // Las colas no tienen metodos de interfaz porque no necesitan una

        // Metodos propios
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
