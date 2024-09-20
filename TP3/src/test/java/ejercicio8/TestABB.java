package ejercicio8;

import clasesBrindadas.tp03abb.ArbolBinarioDeBusqueda;

public class TestABB {

    public static void main(String[] args) {

        ArbolBinarioDeBusqueda<Integer> arbolA = new ArbolBinarioDeBusqueda<Integer>(2);
        arbolA.agregar(7);
        arbolA.agregar(24);
        arbolA.agregar(32);
        arbolA.agregar(37);
        arbolA.agregar(40);
        arbolA.agregar(42);
        arbolA.agregar(44);
        arbolA.agregar(120);

        //imprimirArbol(arbolA);
        //System.out.println("");

        ArbolBinarioDeBusqueda<Integer> arbolB = new ArbolBinarioDeBusqueda<Integer>(120);
        arbolB.agregar(44);
        arbolB.agregar(42);
        arbolB.agregar(40);
        arbolB.agregar(37);
        arbolB.agregar(32);
        arbolB.agregar(24);
        arbolB.agregar(7);
        arbolB.agregar(2);

        //imprimirArbol(arbolB);
        //.out.println("");

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

        imprimirArbol(arbolC);
        System.out.println("");

        arbolC.eliminarElemento(120);
        //arbolC.eliminarElemento(2);
        //arbolC.eliminarElemento(37);

        imprimirArbol(arbolC);
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
