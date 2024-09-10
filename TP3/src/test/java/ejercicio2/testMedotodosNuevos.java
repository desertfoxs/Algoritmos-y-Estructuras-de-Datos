package ejercicio2;


import clasesBrindadas.tp03ab.ArbolBinario;

public class testMedotodosNuevos {

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario(5);
        ArbolBinario nodo1 = new ArbolBinario(8);
        ArbolBinario nodo2 = new ArbolBinario(15);
        ArbolBinario nodo3 = new ArbolBinario(10);
        ArbolBinario nodo4 = new ArbolBinario(23);

        arbol.agregarHijoIzquierdo(nodo1);
        arbol.agregarHijoDerecho(nodo2);
        nodo1.agregarHijoDerecho(nodo3);
        nodo3.agregarHijoIzquierdo(nodo4);

        System.out.println("la cantidad de hojas es de: " + arbol.contarHojas());

    }

}
