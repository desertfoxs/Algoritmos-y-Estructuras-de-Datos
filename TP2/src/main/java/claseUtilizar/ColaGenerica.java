package claseUtilizar;

import ejercicio3.ListaEnlazadaGenericaTP1;

public class ColaGenerica<T> {

    private ListaEnlazadaGenericaTP1<T> datos;

    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenericaTP1<T>();
    }

    public void encolar(T elem){
        datos.agregarFinal(elem);
    }

    public T desencolar(){
        datos.comenzar();
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;
    }

    public T tope(){
        datos.comenzar();
        return datos.elemento(1);
    }

    public boolean esVacia(){
        return datos.esVacia();
    }

}
