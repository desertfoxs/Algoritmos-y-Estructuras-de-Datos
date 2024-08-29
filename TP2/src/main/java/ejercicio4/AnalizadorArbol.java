package ejercicio4;

import claseUtilizar.ArbolGeneral;
import claseUtilizar.ColaGenerica;
import claseUtilizar.ListaEnlazadaGenerica;
import claseUtilizar.ListaGenerica;
import ejercicio3.RecorridosAG;

public class AnalizadorArbol {

    public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol){
        ListaGenerica<Integer> listaInNivel = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> listaNodosMismoNivel = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();
        listaInNivel = recorridoPorNiveles(arbol);

        listaInNivel.comenzar();
        int contador = 0;

        while(!(listaInNivel.fin())){
            int dato = listaInNivel.proximo();
            if(dato == -1){
                int aux = 0;
                listaNodosMismoNivel.comenzar();
                contador = 0;
                while(!(listaNodosMismoNivel.fin())){
                    aux += listaNodosMismoNivel.proximo();
                    contador++;
                }

                if(contador !=0){
                    resultado.agregarFinal(aux/contador);
                }


                vaciarLista(listaNodosMismoNivel);
            }
            else{
                listaNodosMismoNivel.agregarFinal(dato);
            }
        }

        int num = resultado.proximo();
        while(!(resultado.fin())){
            int num2 = resultado.proximo();
            if(num < num2){
                num = num2;
            }
        }

        return num;
    }

    private void vaciarLista(ListaGenerica<Integer> listaNodosMismoNivel) {

        while(!(listaNodosMismoNivel.esVacia())){
            listaNodosMismoNivel.eliminarEn(listaNodosMismoNivel.tamanio());
        }

    }


    private ListaGenerica< Integer > recorridoPorNiveles(ArbolGeneral<AreaEmpresa> arbol){
        ListaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<Integer>();
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
        ColaGenerica<ArbolGeneral<AreaEmpresa>> colaAux = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();

        ArbolGeneral<AreaEmpresa> arbolAux = null;

        cola.encolar(arbol);
        cola.encolar(null);

        while(!cola.esVacia()){
            arbolAux = cola.desencolar();
            if(!(arbolAux == null)){
                listaResultado.agregarFinal(arbolAux.getDato().getTardanza());
            }
            else{
                listaResultado.agregarFinal(-1);
            }

            if(!(arbolAux == null)) {
                if (arbolAux.tieneHijos()) {
                    encolarHijos(arbolAux, colaAux);
                }
            }

            if(cola.tope() == null){
                encolarColaConCola(cola, colaAux);
                cola.encolar(null);
            }

            if(listaResultado.elemento(listaResultado.tamanio()) == -1 && listaResultado.elemento(listaResultado.tamanio() - 1) == -1){
                return listaResultado;
            }
        }

        return listaResultado;
    }

    private void encolarColaConCola(ColaGenerica<ArbolGeneral<AreaEmpresa>> cola, ColaGenerica<ArbolGeneral<AreaEmpresa>> colaAux) {
        while(!colaAux.esVacia()){
            cola.encolar(colaAux.desencolar());
        }
    }

    private void encolarHijos(ArbolGeneral<AreaEmpresa> arbol, ColaGenerica<ArbolGeneral<AreaEmpresa>> cola) {
        ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();

        while(!listaHijos.fin()){
            cola.encolar(listaHijos.proximo());
        }
    }

}
