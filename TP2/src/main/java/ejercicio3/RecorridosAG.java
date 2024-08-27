package ejercicio3;

import claseUtilizar.ArbolGeneral;
import claseUtilizar.ColaGenerica;
import claseUtilizar.ListaEnlazadaGenerica;
import claseUtilizar.ListaGenerica;

public class RecorridosAG {

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> arbol, int num, ListaGenerica<Integer> listaNumeros){
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();

        if(condicion(num, arbol.getDato())){
            listaNumeros.agregarFinal(arbol.getDato());
        }

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();

        while(!(listaHijos.fin())){
            ArbolGeneral<Integer> arbolNodo = listaHijos.proximo();
            numerosImparesMayoresQuePreOrden(arbolNodo, num, listaNumeros);
        }

        return listaNumeros;
    }


    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> arbol, Integer num, ListaGenerica<Integer> listaNumeros){
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        boolean aux = false;

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();

        while(!(listaHijos.fin())){
            ArbolGeneral<Integer> arbolNodo = listaHijos.proximo();
            numerosImparesMayoresQueInOrden(arbolNodo, num, listaNumeros);

            if(condicion(num, arbol.getDato()) && !aux){
                listaNumeros.agregarFinal(arbol.getDato());
                aux = true;
            }

        }

        if(arbol.esHoja()){
            if(condicion(num, arbol.getDato())){
                listaNumeros.agregarFinal(arbol.getDato());
            }
        }

        return listaNumeros;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> arbol, int num, ListaGenerica<Integer> listaNumeros){
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();

        while(!(listaHijos.fin())){
            ArbolGeneral<Integer> arbolNodo = listaHijos.proximo();
            numerosImparesMayoresQuePostOrden(arbolNodo, num, listaNumeros);
        }

        if(condicion(num, arbol.getDato())){
            listaNumeros.agregarFinal(arbol.getDato());
        }

        return listaNumeros;
    }

    public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> arbol, Integer num){
        ListaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<Integer>();
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
        ArbolGeneral<Integer> arbolAux = null;

        cola.encolar(arbol);

        while(!cola.esVacia()){
            arbolAux = cola.desencolar();

            listaResultado.agregarFinal(arbolAux.getDato()); //aca tendria que guardar el resultado en una nueva lista

            if(arbolAux.tieneHijos()){
                encolarHijos(arbolAux, cola);
            }

        }

        return listaResultado;
    }

    private void encolarHijos(ArbolGeneral<Integer> arbol, ColaGenerica<ArbolGeneral<Integer>> cola) {
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();
        while(!listaHijos.fin()){
            cola.encolar(listaHijos.proximo());
        }

    }

    private boolean condicion(int num, int dato){

        if(dato > num){
            int modulo = dato % 2;
            if(modulo == 1){
                return true;
            }
        }
        return false;
    }

    private void agregarLista(ListaGenerica<Integer> listaResultado, ListaGenerica<Integer> listaNumeros) {
        listaResultado.comenzar();
        while(!(listaResultado.fin())){
            listaNumeros.agregarFinal(listaResultado.proximo());
        }
    }
}
