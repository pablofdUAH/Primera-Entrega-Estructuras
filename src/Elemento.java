public class Elemento<T> {
    // ZONA DE ATRIBUTOS
    private T dato;
    Elemento<T> siguente;


    // ZONA DE METODOS
        // Constructor
    private Elemento(){}

    public Elemento(T dato){
        this.dato = dato;
    }

        // Métodos de la interfaz

        // Metodos propios
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
