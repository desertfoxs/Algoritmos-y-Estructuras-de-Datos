package ejercicio4;

import ejercicio3.ListaEnlazadaGenerica;

public class PilaGenerica<T> {

    private ListaEnlazadaGenerica<T> datos;

    public PilaGenerica() {
        this.datos = new ListaEnlazadaGenerica<T>();
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
