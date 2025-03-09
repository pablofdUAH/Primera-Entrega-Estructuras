public class OrdenadorDiccionario <K,V>{
    private boolean ordenAscendente;
    public OrdenadorDiccionario(boolean ordenAscendente){
        this.ordenAscendente = ordenAscendente;
    }
    private OrdenadorDiccionario(){};
    public boolean getOrdenAscendente(){
        return this.ordenAscendente;
    }

    public void setOrdenAscendente(boolean ordenAscendente) {
        this.ordenAscendente = ordenAscendente;
    }
}
