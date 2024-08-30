package ejercicio4;

import claseUtilizar.ArbolGeneral;

public class TestAnalizador {

    public static void main(String[] args) {

        AnalizadorArbol analizadorArbol = new AnalizadorArbol();

        ArbolGeneral<AreaEmpresa> arbolraiz = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 14));
        ArbolGeneral<AreaEmpresa> arbolnodo1 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13));
        ArbolGeneral<AreaEmpresa> arbolnodo2 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25));
        ArbolGeneral<AreaEmpresa> arbolnodo3 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10));
        ArbolGeneral<AreaEmpresa> arbolnodo4 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4));
        ArbolGeneral<AreaEmpresa> arbolnodo5 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7));
        ArbolGeneral<AreaEmpresa> arbolnodo6 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5));
        ArbolGeneral<AreaEmpresa> arbolnodo7 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6));
        ArbolGeneral<AreaEmpresa> arbolnodo8 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10));
        ArbolGeneral<AreaEmpresa> arbolnodo9 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18));
        ArbolGeneral<AreaEmpresa> arbolnodo10 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9));
        ArbolGeneral<AreaEmpresa> arbolnodo11 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12));
        ArbolGeneral<AreaEmpresa> arbolnodo12 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 19));

        arbolraiz.agregarHijo(arbolnodo1);
        arbolraiz.agregarHijo(arbolnodo2);
        arbolraiz.agregarHijo(arbolnodo3);

        arbolnodo1.agregarHijo(arbolnodo4);
        arbolnodo1.agregarHijo(arbolnodo5);
        arbolnodo1.agregarHijo(arbolnodo6);

        arbolnodo2.agregarHijo(arbolnodo7);
        arbolnodo2.agregarHijo(arbolnodo8);
        arbolnodo2.agregarHijo(arbolnodo9);

        arbolnodo3.agregarHijo(arbolnodo10);
        arbolnodo3.agregarHijo(arbolnodo11);
        arbolnodo3.agregarHijo(arbolnodo12);

        System.out.println("El maximo promedio por nivel es: " + analizadorArbol.devolverMaximoPromedio(arbolraiz));

    }
}
