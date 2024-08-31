package ejercicio6;

import claseUtilizar.ArbolGeneral;

public class TestArbolGeneralMejorado {

    public static void main(String[] args) {

        ArbolGeneralMejorado<String> arbolraizA = new ArbolGeneralMejorado<String>("A");
        ArbolGeneralMejorado<String> arbolnodoB = new ArbolGeneralMejorado<String>("B");
        ArbolGeneralMejorado<String> arbolnodoC = new ArbolGeneralMejorado<String>("C");
        ArbolGeneralMejorado<String> arbolnodoD = new ArbolGeneralMejorado<String>("D");
        ArbolGeneralMejorado<String> arbolnodoE = new ArbolGeneralMejorado<String>("E");
        ArbolGeneralMejorado<String> arbolnodoF = new ArbolGeneralMejorado<String>("F");
        ArbolGeneralMejorado<String> arbolnodoG = new ArbolGeneralMejorado<String>("G");
        ArbolGeneralMejorado<String> arbolnodoH = new ArbolGeneralMejorado<String>("H");
        ArbolGeneralMejorado<String> arbolnodoI = new ArbolGeneralMejorado<String>("I");
        ArbolGeneralMejorado<String> arbolnodoJ = new ArbolGeneralMejorado<String>("J");
        ArbolGeneralMejorado<String> arbolnodoK = new ArbolGeneralMejorado<String>("K");
        ArbolGeneralMejorado<String> arbolnodoL = new ArbolGeneralMejorado<String>("L");
        ArbolGeneralMejorado<String> arbolnodoM = new ArbolGeneralMejorado<String>("M");
        ArbolGeneralMejorado<String> arbolnodoN = new ArbolGeneralMejorado<String>("N");

        //arbolraizA.agregarHijo(arbolnodoB); //comentar este hijo para que este completo
        arbolraizA.agregarHijo(arbolnodoC);
        arbolraizA.agregarHijo(arbolnodoD);
        //arbolraizA.agregarHijo(arbolnodoE); //comentar este hijo para que este completo
        arbolnodoC.agregarHijo(arbolnodoF);
        arbolnodoC.agregarHijo(arbolnodoG);
        arbolnodoD.agregarHijo(arbolnodoH);
        //arbolnodoD.agregarHijo(arbolnodoI);
        //arbolnodoD.agregarHijo(arbolnodoJ); //comentar este hijo para que este completo
        //arbolnodoD.agregarHijo(arbolnodoK); //comentar este hijo para que este completo
        //arbolnodoG.agregarHijo(arbolnodoL); //comentar este hijo para que este completo
        //arbolnodoJ.agregarHijo(arbolnodoM); //comentar este hijo para que este completo
        //arbolnodoJ.agregarHijo(arbolnodoN); //comentar este hijo para que este completo

        //EJERCICIO 1
        //System.out.println("La altura es de: " + arbolraizA.altura());

        //EJERCICIO 2
        //System.out.println("el nivel del dato L es de: " + arbolraizA.nivel("L"));

        //EJERCICIO 3
        //System.out.println("El ancho del arbol es de: " + arbolraizA.ancho());

        //EJERCICIO 4
        /*String nodoA = "C";
        String nodoB = "L";
        if(arbolraizA.esAncestro(nodoA, nodoB)){
            System.out.println(nodoA + " es ancestro de " + nodoB);
        }
        else {
            System.out.println(nodoA + " no es ancestro de " + nodoB);
        }*/

        /*EJERCICIO 5
        if(arbolraizA.esArbolLleno()){
            System.out.println("El arbol esta lleno");
        }
        else{
            System.out.println("El arbol no esta lleno");
        }*/

        //EJERCICIO 6
        if(arbolraizA.esArbolCompleto()){
            System.out.println("El arbol esta lleno");
        }
        else{
            System.out.println("El arbol no esta lleno");
        }

    }

}
