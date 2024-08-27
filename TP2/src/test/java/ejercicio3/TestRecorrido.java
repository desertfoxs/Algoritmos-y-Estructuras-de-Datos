package ejercicio3;

import claseUtilizar.ArbolGeneral;
import claseUtilizar.ListaEnlazadaGenerica;
import claseUtilizar.ListaGenerica;

public class TestRecorrido {


    public static void main(String[] args) {
        ListaGenerica<Integer> listaPreOrden = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> listaPostOrden = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> listaInOrden = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> listaInNivel = new ListaEnlazadaGenerica<>();

        RecorridosAG recorridosAG = new RecorridosAG();

        ArbolGeneral<Integer> arbolraiz = new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> arbolnodo1 = new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> arbolnodo2 = new ArbolGeneral<Integer>(3);
        ArbolGeneral<Integer> arbolnodo3 = new ArbolGeneral<Integer>(13);
        ArbolGeneral<Integer> arbolnodo4 = new ArbolGeneral<Integer>(27);
        ArbolGeneral<Integer> arbolnodo5 = new ArbolGeneral<Integer>(31);
        ArbolGeneral<Integer> arbolnodo6 = new ArbolGeneral<Integer>(35);
        ArbolGeneral<Integer> arbolnodo7 = new ArbolGeneral<Integer>(41);

        arbolraiz.agregarHijo(arbolnodo1);
        arbolraiz.agregarHijo(arbolnodo2);

        arbolnodo1.agregarHijo(arbolnodo3);
        arbolnodo3.agregarHijo(arbolnodo4);
        arbolnodo3.agregarHijo(arbolnodo7);

        arbolnodo2.agregarHijo(arbolnodo5);
        arbolnodo2.agregarHijo(arbolnodo6);


        //recorridosAG.numerosImparesMayoresQuePreOrden(arbolraiz, 2, listaPreOrden);
        //recorridosAG.numerosImparesMayoresQuePostOrden(arbolraiz,2, listaPostOrden);
        //recorridosAG.numerosImparesMayoresQueInOrden(arbolraiz, 2, listaInOrden);
        listaInNivel = recorridosAG.numerosImparesMayoresQuePorNiveles(arbolraiz, 2);

        //imprimir(listaPreOrden);
        //System.out.println("");
        imprimir(listaInNivel);

    }

    private static void imprimir(ListaGenerica<Integer> lista) {
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }

    }

}
