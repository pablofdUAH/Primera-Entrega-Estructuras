import java.lang.classfile.ClassFile;

public class ListaSimplementeEnlazada<T> implements Lista<T> {
    Elemento<T> cabeza;
    int numElementos;
    @Override
    public boolean add(T dato){
        boolean result = false;
        Elemento<T> elemento = new Elemento<T>(dato);
        if (cabeza==null){
            this.cabeza = elemento;
            result=true;
            this.numElementos+=1;
        }else{
            elemento.setSiguente(this.cabeza);
            this.cabeza=elemento;
            result=true;
            this.numElementos+=1;
        }

        return result;
    }
    @Override
    public boolean delete(T dato){
        boolean result =false;
        if (cabeza!=null){
            Elemento<T> elementoAnterior = cabeza;
            if (elementoAnterior.getDato() == dato){
                cabeza = elementoAnterior.siguente;
                result = true;
                numElementos -=1;
            }else {
                while (elementoAnterior!=null&& elementoAnterior.siguente.getDato() != dato ) {
                    elementoAnterior = elementoAnterior.siguente;
                }
                if (elementoAnterior!=null){
                    elementoAnterior.siguente = elementoAnterior.siguente.siguente;
                    result=true;
                    numElementos-=1;
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
}
