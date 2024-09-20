package ejercicio3;

import clasesBrindadas.tp01.ListaEnlazadaGenerica;
import clasesBrindadas.tp03ab.ArbolBinario;

public class ContadorArbol {

    ArbolBinario<Integer> arbol;
    ListaEnlazadaGenerica<Integer> listaResultados;

    public ContadorArbol() {
        this.arbol = new ArbolBinario<Integer>();
        this.listaResultados = new ListaEnlazadaGenerica<Integer>();
    }


    public ListaEnlazadaGenerica<Integer> numerosPares(ArbolBinario<Integer> arbol){

        listaResultados.comenzar();
        //recorridoInOrden(arbol);
        recorridoPostOrden(arbol);

        return listaResultados;
    }

    private void recorridoInOrden(ArbolBinario<Integer> arbol) {

        if(arbol.tieneHijoIzquierdo()){
            recorridoInOrden(arbol.getHijoIzquierdo());
        }

        int num = arbol.getDato() % 2;
        if(num == 0){
            listaResultados.agregarFinal(arbol.getDato());
        }

        if(arbol.tieneHijoDerecho()){
            recorridoInOrden(arbol.getHijoDerecho());
        }
    }

    private void recorridoPostOrden(ArbolBinario<Integer> arbol) {

        if(arbol.tieneHijoIzquierdo()){
            recorridoPostOrden(arbol.getHijoIzquierdo());
        }

        if(arbol.tieneHijoDerecho()){
            recorridoPostOrden(arbol.getHijoDerecho());
        }

        int num = arbol.getDato() % 2;
        if(num == 0){
            listaResultados.agregarFinal(arbol.getDato());
        }


    }

}
