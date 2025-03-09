

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
        ElementoDiccionario<K,V> elemento= new ElementoDiccionario<>(clave,valor);
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
            while(elementoIterador!=null && !elementoIterador.getClave().equals(clave)){
                elementoIterador = elementoIterador.getSiguente();
            }
            if (elementoIterador!=null){
                if (numElementos == 1) { // Caso 1: Único elemento en la lista
                    cabeza = null;
                    cola = null;
                } else if (cabeza == elementoIterador) { // Caso 2: Eliminar la cabeza
                    cabeza = elementoIterador.getSiguente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (cola == elementoIterador) { // Caso 3: Eliminar la cola
                    cola = elementoIterador.getAnterior();
                    if (cola != null) {
                        cola.setSiguente(null);
                    }
                } else { // Caso 4: Elemento en medio
                    elementoIterador.getAnterior().setSiguente(elementoIterador.getSiguente());
                    elementoIterador.getSiguente().setAnterior(elementoIterador.getAnterior());
                }
                numElementos -=1;
                result = true;
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
        return new IteradorDiccionario<K,V>(this);
    }

    @Override
    public boolean exist(K clave) {
        return this.get(clave) != null;
    }

}
