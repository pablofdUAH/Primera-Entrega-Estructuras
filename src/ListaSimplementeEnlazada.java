
public class ListaSimplementeEnlazada<T> implements Lista<T> {
    // ZONA DE ATRIBUTOS
    Elemento<T> cabeza;
    int numElementos = 0;


    // ZONA DE METODOS
        // Constructor

        // Metodos de la interfaz
    @Override
    public boolean add(T dato){
        boolean result = false;
        Elemento<T> elemento = new Elemento<T>(dato);
        if (cabeza != null) {
            elemento.setSiguente(this.cabeza);
        }
        this.cabeza = elemento;
        result=true;
        this.numElementos+=1;

        return result;
    }
    public boolean addAtEnd(T dato){
        boolean result = false;
        Elemento<T> elemento = new Elemento<T>(dato);
        Elemento<T> actual=cabeza;
        if (actual==null){
            cabeza = elemento;
            numElementos+=1;
            result=true;
        }else{
            while(actual.getSiguente() !=null){
                actual = actual.getSiguente();
            }
            actual.setSiguente(elemento);
            numElementos +=1;
            result=true;
        }
        return result;
    }
    @Override
    public boolean delete(T dato) {
        boolean result = false;
        if (cabeza != null) {
            if (cabeza.getDato().equals(dato)) { // Comparar con equals
                cabeza = cabeza.siguente;
                result = true;
                numElementos -= 1;
            } else {
                Elemento<T> elementoAnterior = cabeza;
                while (elementoAnterior.siguente != null && !elementoAnterior.siguente.getDato().equals(dato)) { // Comparar con equals
                    elementoAnterior = elementoAnterior.siguente;
                }
                if (elementoAnterior.siguente != null) {
                    elementoAnterior.siguente = elementoAnterior.siguente.siguente;
                    result = true;
                    numElementos -= 1;
                }
            }
        }
        return result;
    }

    @Override
    public Iterador<T> getIterador(){
        return new IteradorListaSimplementeEnlazada<T>(this);
    }
    @Override
    public int getNumElementos(){
        return this.numElementos;
    }

        // Metodos propios
}
