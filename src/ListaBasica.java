import java.sql.Array;

public class ListaBasica<T> implements Lista<T>{
    // ZONA DE ATRIBUTOS
    int maxElementos;
    int numElementos=0;
    T[] elementos;


    // ZONA DE METODOS
        // Constructor (evitar el constructor por defecto)
    public ListaBasica(int Tamano_Maximo){
        this.maxElementos = Tamano_Maximo;
        this.elementos = (T[]) new Object[Tamano_Maximo];
    }
    private ListaBasica(){}

        //Métodos de la interfaz
    @Override
    public boolean add(T elemento) {
        boolean result=false;
        if (numElementos<maxElementos){
            this.elementos[getNumElementos()] = elemento;
            this.numElementos = this.numElementos+1;
            result = true;
        }
        return result;
    }
    @Override
    public boolean delete(T elemento) {
        boolean result=false;
        if (numElementos != 0){
            int pos= 0;
            for (T i :this.elementos){
                if (i==elemento){
                    this.elementos[pos]= null;
                    this.elementos[pos]=this.elementos[numElementos-1];
                    this.elementos[numElementos-1]=null;
                    result = true;
                    numElementos = numElementos-1;
                }
                pos = pos+1;
            }
        }
        return result;
    }
    @Override
    public int getNumElementos() {
        return this.numElementos;
    }
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaBasica(this);
    }

        //Métodos propios
}
