package ejercicio1c;

import clasesUsar.tp01.ListaEnlazadaGenerica;
import clasesUsar.tp01.ListaGenerica;
import clasesUsar.tp06.Arista;
import clasesUsar.tp06.Grafo;
import clasesUsar.tp06.Vertice;


public class GrafoImplListAdy<T> implements Grafo<T> {

    ListaGenerica<ListaEnlazadaGenerica<Vertice<T>>> lista;

    public GrafoImplListAdy(){
        lista = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>>();
    }


    @Override
    public void agregarVertice(Vertice<T> v) {

    }

    @Override
    public void eliminarVertice(Vertice<T> v) {

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {

    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {

    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return null;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return null;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return null;
    }
}
