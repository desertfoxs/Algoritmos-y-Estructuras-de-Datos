package ejercicio10;

import clasesBrindadas.tp03abb.ArbolBinarioDeBusqueda;

public class TestInmediatoMayor {

    public static void main(String[] args) {
        InmediatoMayor inmediatoMayor = new InmediatoMayor();
        ArbolBinarioDeBusqueda<Integer> arbolC = new ArbolBinarioDeBusqueda<Integer>(37);
        arbolC.agregar(24);
        arbolC.agregar(42);
        arbolC.agregar(7);
        arbolC.agregar(32);
        arbolC.agregar(2);
        arbolC.agregar(44);
        arbolC.agregar(40);
        arbolC.agregar(120);

        int dato = inmediatoMayor.busquedaInmediatoMayor(arbolC, 37);
        System.out.println("el inmediato mayor es: " + dato);
    }

}
