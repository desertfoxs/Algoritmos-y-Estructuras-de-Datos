package ejercicio4;

import clasesBrindadas.tp01.ListaEnlazadaGenerica;
import clasesBrindadas.tp03ab.ArbolBinario;

public class RedBinariaLlena{

    private ListaEnlazadaGenerica<Integer> listaRetardos;

    public int retardoReenvio(ArbolBinario<Integer> arbol){
        int retardoMax;
        int retardo;
        listaRetardos = new ListaEnlazadaGenerica<Integer>();

        listaRetardos.comenzar();
        calculoRetardoDato(arbol,0);

        listaRetardos.comenzar();
        retardoMax = listaRetardos.proximo();
        while(!(listaRetardos.fin())){
            retardo = listaRetardos.proximo();
            if (retardoMax < retardo){
                retardoMax = retardo;
            }
        }

        return retardoMax;
    }

    private void calculoRetardoDato(ArbolBinario<Integer> arbol, int retardoAcumulativo) {

        if(arbol.tieneHijoDerecho()){
            if(arbol.getHijoDerecho().esHoja()){

                if(arbol.tieneHijoIzquierdo()){
                    if(arbol.getHijoIzquierdo().esHoja()){
                        listaRetardos.agregarFinal(retardoAcumulativo);
                    }
                }
            }
        }

        if(arbol.tieneHijoIzquierdo()){
            calculoRetardoDato(arbol.getHijoIzquierdo(), retardoAcumulativo + arbol.getHijoIzquierdo().getDato());
        }

        if(arbol.tieneHijoDerecho()){
            calculoRetardoDato(arbol.getHijoDerecho(), retardoAcumulativo + arbol.getHijoDerecho().getDato());
        }

    }

}
