package clasesUsar.tp06;

public class AristaImpl<T> implements Arista<T>{

    private int peso;
    private Vertice<T> verticeDestino;

    public AristaImpl(int peso, Vertice<T> verticeDestino) {
        this.peso = peso;
        this.verticeDestino = verticeDestino;
    }


    @Override
    public Vertice<T> verticeDestino() {
        return verticeDestino;
    }

    @Override
    public int peso() {
        return 0;
    }
}
