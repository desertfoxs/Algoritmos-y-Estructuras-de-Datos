package ejercicio1;

public class TestListaDeEnterosConArreglos {

    public static void main(String[] args){

        var arreglo = new ListaDeEnterosConArreglos();
        int numerosRecividos = 458962;

        while(numerosRecividos != 0){
            int num = numerosRecividos % 10;
            arreglo.agregarFinal(num);
            numerosRecividos = numerosRecividos / 10;
        }

        System.out.println("imprimir con el while:");
        arreglo.comenzar();
        while(!arreglo.fin()){
            System.out.println(arreglo.proximo());
        }

        System.out.println("");
        System.out.println("imprimir con el metodo recursivo:");
        arreglo.comenzar();
        imprimir(arreglo);
    }

    public static void imprimir(ListaDeEnterosConArreglos arreglo){
        System.out.println(arreglo.proximo());
        if(!arreglo.fin()){
            imprimir(arreglo);
        }
    }

}
