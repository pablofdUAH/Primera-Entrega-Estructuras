public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    void testListaBasica(){
        ListaBasica<Integer> lista = new ListaBasica<Integer>(6);
        lista.add(8);
        Iterador<Integer> iterador = lista.getIterador();


    }
}