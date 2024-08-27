package ejercicio2;

public class TestListaEnlazadaGenerica {

    public static void main(String[] args) {

        var estudiante1 = new Estudiante("valentin", "tordi", "$$$");
        var estudiante2 = new Estudiante("valentina", "tombesi", "$$$");
        var estudiante3 = new Estudiante("angel", "olivetti", "$$$");
        var estudiante4 = new Estudiante("bruno", "sosa", "$$$");

        var listaEnlazadaAgregacionManual = new ListaEnlazadaGenericaTP1<Estudiante>();
        listaEnlazadaAgregacionManual.agregarFinal(estudiante1);
        listaEnlazadaAgregacionManual.agregarFinal(estudiante2);
        listaEnlazadaAgregacionManual.agregarFinal(estudiante3);
        listaEnlazadaAgregacionManual.agregarFinal(estudiante4);

        tusDatos(listaEnlazadaAgregacionManual);
        var nodo = new NodoGenerico<Estudiante>();


        var listaEnlazadaAgregacionAutomatica = new ListaEnlazadaGenericaTP1<Estudiante>();
        Estudiante[] estudiantes = {estudiante1, estudiante2, estudiante3, estudiante4};
        listaEnlazadaAgregacionAutomatica.agregar(estudiantes);
        tusDatos(listaEnlazadaAgregacionAutomatica);
    }

    public static void tusDatos(ListaEnlazadaGenericaTP1<Estudiante> listaEnlazada){
        while(!listaEnlazada.fin()){
            System.out.println(listaEnlazada.proximo().toString());
        }
        System.out.println("---------------------------------------");
    }


}
