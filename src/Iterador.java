public interface Iterador<T> {
    boolean hasNext();
    T next();
    void delete();
}
