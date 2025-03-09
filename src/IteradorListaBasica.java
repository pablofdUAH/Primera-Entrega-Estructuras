public class IteradorListaBasica<T> implements Iterador<T>{
    // ZONA DE ATRIBUTOS
    ListaBasica<T> milista;
    int posElemento=0;

    // ZONA DE METODOS
        //Constructor
    public IteradorListaBasica(ListaBasica<T> lista){
        this.milista = lista;
    }

        //Métodos de la interfaz:
    @Override
    public boolean hasNext() {
        boolean result = false;
        if(posElemento < milista.maxElementos){
            result = milista.elementos[posElemento]!=null;
        }
        return result;
    }

    @Override
    public T next() {
        T elemento=null;
        if (hasNext()) {
            elemento = milista.elementos[posElemento];
            posElemento = posElemento + 1;
        }
        return elemento;
    }

    @Override
    public void delete() {
        this.milista.delete(milista.elementos[posElemento]);

    }

        // Métodos propios
}
