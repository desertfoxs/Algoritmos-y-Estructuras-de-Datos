package ejercicio1b;

import clasesUsar.tp06.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {

    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato, int posicion){
        this.dato = dato;
        this.posicion = posicion;
    }


    @Override
    public T dato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }
}
