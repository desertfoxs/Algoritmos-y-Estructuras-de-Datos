package ejercicio4;

import ejercicio3.ListaEnlazadaGenericaTP1;

public class PilaGenerica<T> {

    private ListaEnlazadaGenericaTP1<T> datos;

    public PilaGenerica() {
        this.datos = new ListaEnlazadaGenericaTP1<T>();
    }

    public void apilar(T elem){
        datos.agregarInicio(elem);
    }

    public T desapilar(){
        datos.comenzar();
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;
    }

    public T tope(){
        datos.comenzar();
        return datos.elemento(datos.tamanio());
    }

    public boolean esVacia(){
        return datos.esVacia();
    }

}
