package ejercicio5;

import claseUtilizar.ArbolGeneral;
import ejercicio4.AreaEmpresa;

public class TestCaudal {

    public static void main(String[] args) {

        RedDeAguaPotable redDeAguaPotable = new RedDeAguaPotable();

        ArbolGeneral<String> arbolraizA = new ArbolGeneral<String>("A");
        ArbolGeneral<String> arbolnodoB = new ArbolGeneral<String>("B");
        ArbolGeneral<String> arbolnodoC = new ArbolGeneral<String>("C");
        ArbolGeneral<String> arbolnodoD = new ArbolGeneral<String>("D");
        ArbolGeneral<String> arbolnodoE = new ArbolGeneral<String>("E");
        ArbolGeneral<String> arbolnodoF = new ArbolGeneral<String>("F");
        ArbolGeneral<String> arbolnodoG = new ArbolGeneral<String>("G");
        ArbolGeneral<String> arbolnodoH = new ArbolGeneral<String>("H");
        ArbolGeneral<String> arbolnodoI = new ArbolGeneral<String>("I");
        ArbolGeneral<String> arbolnodoJ = new ArbolGeneral<String>("J");
        ArbolGeneral<String> arbolnodoK = new ArbolGeneral<String>("K");
        ArbolGeneral<String> arbolnodoL = new ArbolGeneral<String>("L");
        ArbolGeneral<String> arbolnodoM = new ArbolGeneral<String>("M");
        ArbolGeneral<String> arbolnodoN = new ArbolGeneral<String>("N");

        arbolraizA.agregarHijo(arbolnodoB);
        arbolraizA.agregarHijo(arbolnodoC);
        arbolraizA.agregarHijo(arbolnodoD);
        arbolraizA.agregarHijo(arbolnodoE);
        arbolnodoC.agregarHijo(arbolnodoF);
        arbolnodoC.agregarHijo(arbolnodoG);
        arbolnodoD.agregarHijo(arbolnodoH);
        arbolnodoD.agregarHijo(arbolnodoI);
        arbolnodoD.agregarHijo(arbolnodoJ);
        arbolnodoD.agregarHijo(arbolnodoK);
        arbolnodoG.agregarHijo(arbolnodoL);
        arbolnodoJ.agregarHijo(arbolnodoM);
        arbolnodoJ.agregarHijo(arbolnodoN);

        System.out.println("El caudal minimo es: " + redDeAguaPotable.minimoCaudal(1000, arbolraizA));


    }

}
