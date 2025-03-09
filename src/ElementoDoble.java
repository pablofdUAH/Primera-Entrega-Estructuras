public class ElementoDoble<T> {
    // ZONA DE ATRIBUTOS
    T dato;
    ElementoDoble<T> anterior;
    ElementoDoble<T> siguente;

    // ZONA DE METODOS
        // Constructor
    private ElementoDoble(){}

    public ElementoDoble(T dato){
        this.dato = dato;
    }

        // Métodos de la interfaz

        // Métodos propios
    public void setAnterior(ElementoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguente(ElementoDoble<T> siguente) {
        this.siguente = siguente;
    }

    public ElementoDoble<T> getAnterior() {
        return anterior;
    }

    public ElementoDoble<T> getSiguente() {
        return siguente;
    }

    public T getDato() {
        return dato;
    }
}
