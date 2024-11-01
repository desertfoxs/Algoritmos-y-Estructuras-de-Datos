package heap;

import clasesUtilizar.ListaEnlazadaGenerica;

public class TestHeap {

    public static void main(String[] args) {

        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        lista.agregarInicio(2);
        lista.agregarInicio(4);
        lista.agregarInicio(0);
        lista.agregarInicio(8);
        lista.agregarInicio(1);

        MinHeap<Integer> minHeap = new MinHeap<Integer>(lista);
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(lista);


        //System.out.println(maxHeap.tope());


        System.out.println(minHeap.tope());

        minHeap.eliminar();
        System.out.println(minHeap.tope());

        minHeap.eliminar();
        System.out.println(minHeap.tope());
    }

}
