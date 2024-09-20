package ejercicio4;

import clasesBrindadas.tp03ab.ArbolBinario;

public class TestRetardo {

    public static void main(String[] args) {
        var retardo = new RedBinariaLlena();

        ArbolBinario raiz = new ArbolBinario(5);
        ArbolBinario nodo1 = new ArbolBinario(8);
        ArbolBinario nodo2 = new ArbolBinario(15);
        ArbolBinario nodo3 = new ArbolBinario(10);
        ArbolBinario nodo4 = new ArbolBinario(23);
        ArbolBinario nodo5 = new ArbolBinario(12);
        ArbolBinario nodo6 = new ArbolBinario(3);
        ArbolBinario nodo7 = new ArbolBinario(29);
        ArbolBinario nodo8 = new ArbolBinario(26);
        ArbolBinario nodo9 = new ArbolBinario(19);
        ArbolBinario nodo10 = new ArbolBinario(7);
        ArbolBinario nodo11 = new ArbolBinario(35);
        ArbolBinario nodo12 = new ArbolBinario(2);
        ArbolBinario nodo13 = new ArbolBinario(28);
        ArbolBinario nodo14 = new ArbolBinario(14);


        raiz.agregarHijoIzquierdo(nodo1);
        raiz.agregarHijoDerecho(nodo2);

        nodo1.agregarHijoIzquierdo(nodo3);
        nodo1.agregarHijoDerecho(nodo4);

        nodo2.agregarHijoIzquierdo(nodo5);
        nodo2.agregarHijoDerecho(nodo6);

        nodo3.agregarHijoIzquierdo(nodo7);
        nodo3.agregarHijoDerecho(nodo8);

        nodo4.agregarHijoIzquierdo(nodo9);
        nodo4.agregarHijoDerecho(nodo10);

        nodo5.agregarHijoIzquierdo(nodo11);
        nodo5.agregarHijoDerecho(nodo12);

        nodo6.agregarHijoIzquierdo(nodo13);
        nodo6.agregarHijoDerecho(nodo14);

        System.out.println(retardo.retardoReenvio(raiz));
    }

}
