package ejercicio10;

import clasesBrindadas.tp03abb.ArbolBinarioDeBusqueda;

public class InmediatoMayor {

    private ArbolBinarioDeBusqueda<Integer> nodoEncontrado;
    private ArbolBinarioDeBusqueda<Integer> nodoPadreEncontrado;

    public int busquedaInmediatoMayor(ArbolBinarioDeBusqueda arbol, int dato){

        nodoEncontrado = null;
        nodoPadreEncontrado = null;

        buscarNodo(arbol, dato);

        if(nodoEncontrado == null){
            return -1;
        }
        else {
            if(nodoEncontrado.tieneHijoDerecho()){
                int numNodoHermano = nodoEncontrado.getHijoDerecho().getDato();
                return numNodoHermano;
            }
            else if(nodoPadreEncontrado != null){
                if(nodoPadreEncontrado.getDato() > nodoEncontrado.getDato()){
                    int numNodoPadre = nodoPadreEncontrado.getDato();
                    return numNodoPadre;
                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
    }

    private void buscarNodo(ArbolBinarioDeBusqueda arbol, int dato) {

        if((int)arbol.getDato() == dato){
            nodoEncontrado = arbol;
            return;
        }

        if(arbol.tieneHijoIzquierdo() && nodoEncontrado == null){
            buscarNodo(arbol.getHijoIzquierdo(), dato);
            if(nodoPadreEncontrado == null && !(nodoEncontrado == null)) {
                nodoPadreEncontrado = arbol;
            }

        }

        if(arbol.tieneHijoDerecho() && nodoEncontrado == null){
            buscarNodo(arbol.getHijoDerecho(), dato);
            if(nodoPadreEncontrado == null && !(nodoEncontrado == null)) {
                nodoPadreEncontrado = arbol;
            }
        }


    }

}
