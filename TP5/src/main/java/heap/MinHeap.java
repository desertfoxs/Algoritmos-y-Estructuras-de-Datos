package heap;

import clasesUtilizar.ListaEnlazadaGenerica;

public class MinHeap<T> implements ColaPrioridades<T> {

    private Comparable<T>[] datos;
    private int cantEltos;

    public MinHeap() {
        cantEltos = 100;
        datos = new Comparable[100];
    }

    public MinHeap(ListaEnlazadaGenerica<T> lista) {
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

        int DL = 1;
        while(DL < cantEltos && datos[DL]!=null){
            DL++;
        }

        if(cantEltos > 0){
            datos[1] = datos[DL];
            DL -= 1;
            percolateDown(DL, 1);
        }

    }

    private void percolateUp(int DL){


        Comparable<T> datoAgregado = datos[DL];

        while(((DL / 2) > 0) && (datos[DL/2].compareTo((T) datoAgregado) > 0 )){
                datos[DL] = datos[DL/2];
                DL = DL/2;
        }

        datos[DL] = datoAgregado;

    }

    private void percolateDown(int dl, int indice){

        while(true){
            int hijoIzq = 2 * indice;
            int hijoDer = 2 * indice + 2;
            int largest = indice;

            if(hijoIzq < dl && datos[hijoIzq].compareTo((T) datos[indice]) > 0){
                largest = hijoIzq;
            }

            if(hijoDer < dl && datos[hijoDer].compareTo((T) datos[indice]) > 0){
                largest = hijoDer;
            }

            if(largest == indice){
                break;
            }

            Comparable<T> temp = datos[indice];
            datos[indice] = datos[largest];
            datos[largest] = temp;

            indice = largest;


        }


    }


    @Override
    public boolean agregar(T dato) {

        int DL = 1;

        while(DL < cantEltos && datos[DL]!=null){
            DL++;
        }

        datos[DL] = (Comparable<T>) dato;

        percolateUp(DL);

        return true;
    }

    @Override
    public T tope() {
        return (T) datos[1];
    }
}
