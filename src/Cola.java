public class Cola<T> {
    // ZONA DE ATRIBUTOS


    // ZONA DE METODOS
        // Constructor
    private ListaSimplementeEnlazada<T> cola = new ListaSimplementeEnlazada<T>();

        // Las colas no tienen metodos de interfaz porque no necesitan una

        // Metodos propios
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
