
public class IteradorDiccionario<K,V> implements Iterador<ElementoDiccionario<K,V>>{
    private ElementoDiccionario<K,V> actual;
    DiccionarioBasico<K,V> miLista;

    public IteradorDiccionario(DiccionarioBasico<K,V> diccionario){
        this.miLista=diccionario;
        this.actual=diccionario.getCabeza();
    }
    @Override
    public boolean hasNext(){
        return this.actual!=null;
    }
    @Override
    public ElementoDiccionario<K,V> next(){
        if (hasNext()){
            ElementoDiccionario<K,V> temporal = actual;
            if(actual.getSiguente()!=null){
                this.actual = this.actual.getSiguente();
            }
            actual = null;
            return temporal;
        }
        return null;
    }
    @Override
    public void delete(){
        if (actual!=null){
            this.miLista.delete(actual.getClave());
        }
    }
    public boolean hasPrevious(){
        return this.actual!=null;
    }
    public ElementoDiccionario<K,V> previous(){
        if (hasPrevious()){
            ElementoDiccionario<K,V> temporal = this.actual;
            if(actual.getAnterior()!=null){
                this.actual = this.actual.getAnterior();
            }
            actual = null;
            return temporal;
        }
        return null;
    }
}
