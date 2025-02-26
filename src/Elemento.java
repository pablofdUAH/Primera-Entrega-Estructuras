public class Elemento<T> {
    private T dato;
    Elemento<T> siguente;
    private Elemento(){

    }
    public Elemento(T dato){
        this.dato = dato;
    }
    T getDato(){
        return dato;
    }
    void setDato(T dato){
        this.dato=dato;
    }
    Elemento<T> getSiguente(){
        return this.siguente;
    }
    void setSiguente(Elemento<T> siguente){
        this.siguente = siguente;
    }
}
