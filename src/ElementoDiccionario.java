public class ElementoDiccionario<K,V> {
    private K clave;
    private V valor;
    private ElementoDiccionario<K,V> siguente;
    private ElementoDiccionario<K,V> anterior;

    public ElementoDiccionario<K, V> getAnterior() {
        return anterior;
    }

    public ElementoDiccionario<K, V> getSiguente() {
        return siguente;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setAnterior(ElementoDiccionario<K, V> anterior) {
        this.anterior = anterior;
    }

    public void setSiguente(ElementoDiccionario<K, V> siguente) {
        this.siguente = siguente;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
    private ElementoDiccionario(){

    };
    public ElementoDiccionario(K clave,V valor){
        this.clave=clave;
        this.valor=valor;
    }


}
