package heap;

import clasesUtilizar.ListaEnlazadaGenerica;

public class MaxHeap<T> implements ColaPrioridades<T> {


    private Comparable<T>[] datos;
    private int cantEltos;

    public MaxHeap() {
        cantEltos = 100;
        datos = new Comparable[100];
    }

    public MaxHeap(ListaEnlazadaGenerica<T> lista) {
        cantEltos = lista.tamanio();
        datos = new Comparable[cantEltos + 1];

        lista.comenzar();
        while(!(lista.fin())){
            agregar(lista.proximo());
        }
    }

    @Override
    public boolean esVacia() {
        return cantEltos == 0;
    }

    @Override
    public void eliminar() {

    }

    private void percolateUp(int DL){


        Comparable<T> datoAgregado = datos[DL];

        while(((DL / 2) > 0) && (datos[DL/2].compareTo((T) datoAgregado) < 0 )){
            datos[DL] = datos[DL/2];
            DL = DL/2;
        }

        datos[DL] = datoAgregado;

    }

    private void percolateDown(int dato){

    }


    @Override
    public boolean agregar(T dato) {

        int i = 1;

        while(i < cantEltos && datos[i]!=null){
            i++;
        }

        datos[i] = (Comparable<T>) dato;

        percolateUp(i);

        return true;
    }

    @Override
    public T tope() {
        return (T) datos[1];
    }
}
