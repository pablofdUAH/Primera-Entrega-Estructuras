

public class DiccionarioBasico<K,V> implements Diccionario<K,V> {
    private ElementoDiccionario<K,V> cola;
    private ElementoDiccionario<K,V> cabeza;
    private int numElementos=0;

    public ElementoDiccionario<K, V> getCabeza() {
        return cabeza;
    }

    public ElementoDiccionario<K, V> getCola() {
        return cola;
    }

    public void setCabeza(ElementoDiccionario<K, V> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(ElementoDiccionario<K, V> cola) {
        this.cola = cola;
    }

    @Override
    public boolean add(K clave, V valor) {
        boolean result = false;
        ElementoDiccionario<K,V> elemento= new ElementoDiccionario<K,V>(clave,valor);
        if (cabeza==null){
            cabeza = elemento;
            cola = elemento;
            numElementos = numElementos+1;
            result = true;
        }else{
            elemento.setSiguente(cabeza);
            cabeza.setAnterior(elemento);
            cabeza=elemento;
            result=true;
            numElementos = numElementos+1;
        }
        return result;
    }

    @Override
    public boolean delete(K clave) {
        boolean result = false;
        if (numElementos!=0){
            ElementoDiccionario<K,V> elementoIterador=this.cabeza;
            while(elementoIterador!=null && elementoIterador.getClave()!=clave){
                elementoIterador = elementoIterador.getSiguente();
            }
            if (elementoIterador!=null){
                if (numElementos==1){
                    cabeza=null;
                    cola=null;
                    numElementos -=1;
                    result = true;
                }else if (cabeza==elementoIterador||cola==elementoIterador){
                    if (cabeza==elementoIterador){
                        elementoIterador.getSiguente().setAnterior(null);
                        cabeza=elementoIterador.getSiguente();
                    }
                    if (cola==elementoIterador){
                        elementoIterador.getAnterior().setSiguente(null);
                        cola=elementoIterador.getAnterior();
                    }
                }else{
                    elementoIterador.getAnterior().setSiguente(elementoIterador.getSiguente());
                    elementoIterador.getSiguente().setAnterior(elementoIterador.getAnterior());
                    result=true;
                    numElementos -=1;
                }
            }
        }
        return result;
    }

    @Override
    public V get(K clave) {
        V devuelve=null;
        if (numElementos!=0){
            ElementoDiccionario<K,V> elementoIterador=this.cabeza;
            while(elementoIterador!=null && elementoIterador.getClave()!=clave){
                elementoIterador = elementoIterador.getSiguente();
            }
            if (elementoIterador!=null){
                devuelve = elementoIterador.getValor();
            }
        }
        return devuelve;
    }

    @Override
    public int getNumElementos() {
        return numElementos;
    }

    @Override
    public Iterador<ElementoDiccionario<K, V>> getIterador() {
        return null;
    }

    @Override
    public boolean exist(K clave) {
        boolean result = false;
        if (this.get(clave)!=null){
            result=true;
        }
        return result;
    }

}
