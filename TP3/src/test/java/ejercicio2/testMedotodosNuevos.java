package ejercicio2;


import clasesBrindadas.tp03ab.ArbolBinario;

public class testMedotodosNuevos {

    public static void main(String[] args) {

        ArbolBinario raiz = new ArbolBinario(5);
        ArbolBinario nodo1 = new ArbolBinario(8);
        ArbolBinario nodo2 = new ArbolBinario(15);
        ArbolBinario nodo3 = new ArbolBinario(10);
        ArbolBinario nodo4 = new ArbolBinario(23);

        raiz.agregarHijoIzquierdo(nodo1);
        raiz.agregarHijoDerecho(nodo2);
        nodo1.agregarHijoDerecho(nodo3);
        nodo2.agregarHijoIzquierdo(nodo4);

        //ejercicio1(raiz);
        //ejercicio2(raiz);
        ejercicio3(raiz);

    }

    private static void imprimirArbol(ArbolBinario raiz) {
        System.out.println(raiz.getDato());

        if(raiz.tieneHijoIzquierdo()){
            imprimirArbol(raiz.getHijoIzquierdo());
        }

        if(raiz.tieneHijoDerecho()){
            imprimirArbol(raiz.getHijoDerecho());
        }

    }

    private static void ejercicio1(ArbolBinario raiz) {
        System.out.println("la cantidad de hojas es de: " + raiz.contarHojas());
    }

    private static void ejercicio2(ArbolBinario raiz) {
        imprimirArbol(raiz);
        System.out.println("");
        raiz = raiz.espejo();
        imprimirArbol(raiz);
    }

    private static void ejercicio3(ArbolBinario raiz) {
        raiz.entreNiveles(0,1);
    }



}
