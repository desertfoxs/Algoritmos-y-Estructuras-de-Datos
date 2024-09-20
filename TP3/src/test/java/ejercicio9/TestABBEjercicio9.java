package ejercicio9;

import clasesBrindadas.tp01.ListaEnlazadaGenerica;
import clasesBrindadas.tp03abb.ArbolBinarioDeBusqueda;

public class TestABBEjercicio9 {

    public static void main(String[] args) {
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        ArbolBinarioDeBusqueda<Integer> arbolC = new ArbolBinarioDeBusqueda<Integer>(37);
        arbolC.agregar(24);
        arbolC.agregar(42);
        arbolC.agregar(7);
        arbolC.agregar(32);
        arbolC.agregar(2);
        arbolC.agregar(42);
        arbolC.agregar(44);
        arbolC.agregar(40);
        arbolC.agregar(120);


        ArbolBinarioDeBusqueda<Integer> nodoBuscar = new ArbolBinarioDeBusqueda<Integer>(40);
        lista = arbolC.caminoRecorrido(nodoBuscar);
        imprimirLista(lista);
    }

    private static void imprimirLista(ListaEnlazadaGenerica<Integer> lista) {

        while(!(lista.fin())){
            System.out.print(lista.proximo() + ", ");
        }
        System.out.println("");
    }

    private static void imprimirArbol(ArbolBinarioDeBusqueda<Integer> arbol) {

        System.out.println(arbol.getDato());

        if(arbol.tieneHijoIzquierdo()){
            imprimirArbol(arbol.getHijoIzquierdo());
        }

        if(arbol.tieneHijoDerecho()){
            imprimirArbol(arbol.getHijoDerecho());
        }

    }




}
