package ejercicio1c;

import clasesUsar.tp06.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {

    T dato;
    int posicion;

    public VerticeImplListAdy(T dato, int posicion) {
        this.dato = dato;
        this.posicion = posicion;
    }

    @Override
    public T dato() {
        return this.dato;
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
