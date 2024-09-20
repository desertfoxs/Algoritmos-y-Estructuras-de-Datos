package ejercicio3;

import clasesBrindadas.tp01.ListaEnlazadaGenerica;
import clasesBrindadas.tp03ab.ArbolBinario;

public class TestContadorArbol {

    public static void main(String[] args) {
        ContadorArbol contadorArbol = new ContadorArbol();

        ArbolBinario raiz = new ArbolBinario(5);
        ArbolBinario nodo1 = new ArbolBinario(8);
        ArbolBinario nodo2 = new ArbolBinario(15);
        ArbolBinario nodo3 = new ArbolBinario(10);
        ArbolBinario nodo4 = new ArbolBinario(23);

        raiz.agregarHijoIzquierdo(nodo1);
        raiz.agregarHijoDerecho(nodo2);
        nodo1.agregarHijoDerecho(nodo3);
        nodo2.agregarHijoIzquierdo(nodo4);

        imprimirLista(contadorArbol.numerosPares(raiz));

    }

    private static void imprimirLista(ListaEnlazadaGenerica<Integer> lista) {
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}
