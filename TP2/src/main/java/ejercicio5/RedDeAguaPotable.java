package ejercicio5;

import claseUtilizar.ArbolGeneral;
import claseUtilizar.ListaEnlazadaGenerica;
import claseUtilizar.ListaGenerica;

public class RedDeAguaPotable {

    private ListaEnlazadaGenerica<Double> listaResultado;

    public double minimoCaudal(double caudal, ArbolGeneral<String> arbol){
        double caudalMenor1;
        double caudalMenor2;
        listaResultado = new ListaEnlazadaGenerica<>();
        procesarPostOrden(caudal, arbol);

        listaResultado.comenzar();
        caudalMenor1 = listaResultado.proximo();
        while(!listaResultado.fin()){
            caudalMenor2 = listaResultado.proximo();
            if(caudalMenor1 > caudalMenor2){
                caudalMenor1 = caudalMenor2;
            }
        }

        imprimir(listaResultado);

        return caudalMenor1;
    }

    private void procesarPostOrden(double caudal, ArbolGeneral<String> arbol){
        ListaGenerica<ArbolGeneral<String>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();

        double caudalNuevo;
        int cantHijos;

        if(arbol.esHoja()){
            listaResultado.agregarFinal(caudal);
        }

        listaHijos = arbol.getHijos();
        listaHijos.comenzar();
        cantHijos = listaHijos.tamanio();
        caudalNuevo = caudal/cantHijos;

        while(!(listaHijos.fin())){
            ArbolGeneral<String> arbolNodo = listaHijos.proximo();
            procesarPostOrden(caudalNuevo, arbolNodo);
        }


    }

    private static void imprimir(ListaGenerica<Double> lista) {
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }

    }

}
