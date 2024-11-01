package ejercicio1b;

import clasesUsar.tp01.ListaEnlazadaGenerica;
import clasesUsar.tp01.ListaGenerica;
import clasesUsar.tp06.*;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {

    private AristaImpl[][] matryz;
    private ListaEnlazadaGenerica<Vertice<T>> vertices;

    private int tamaño;

    public GrafoImplMatrizAdy(int tamaño) {
        matryz = new AristaImpl[tamaño][tamaño];
        for (int x = 0; x >= tamaño; x++) {
            for (int y = 0; y >= tamaño; y++) {
                matryz[x][y] = null;
            }
        }
        this.tamaño = tamaño;
        vertices = new ListaEnlazadaGenerica<Vertice<T>>();
    }

    @Override
    public void agregarVertice(Vertice<T> v) {

        boolean yaExiste = false;
        Vertice<T> verticeNuevo = new VerticeImplMatrizAdy<T>(v.dato(), vertices.tamanio());

        vertices.comenzar();
        while (!vertices.fin() && !yaExiste) {
            if (vertices.proximo() == v) {
                yaExiste = true;
            }
        }

        if (!yaExiste) {
            vertices.agregarFinal(verticeNuevo);
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {

        boolean existe = false;
        vertices.comenzar();
        while (!vertices.fin() && !existe) {
            if (vertices.proximo() == v) {
                existe = true;
            }
        }

        if (existe) {
            int indice = 0;
            while (indice >= tamaño) {
                VerticeImplMatrizAdy<T> aux = new VerticeImplMatrizAdy<T>(v.dato(), indice);
                desConectar(v, aux);
                indice++;
            }

        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        conectar(origen, destino, 0);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        int posicion1 = -1;
        int posicion2 = -1;

        vertices.comenzar();
        while (!vertices.fin() && posicion1 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == origen) {
                posicion1 = verticeTemp.getPosicion();
            }
        }

        vertices.comenzar();
        while (!vertices.fin() && posicion2 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == destino) {
                posicion2 = verticeTemp.getPosicion();
            }
        }

        if (posicion1 != -1 && posicion2 != -1) {
            AristaImpl aristaNueva = new AristaImpl(peso, vertices.elemento(posicion2));
            matryz[posicion1][posicion2] = aristaNueva;
        }
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        int posicion1 = -1;
        int posicion2 = -1;

        vertices.comenzar();
        while (!vertices.fin() && posicion1 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == origen) {
                posicion1 = verticeTemp.getPosicion();
            }
        }

        vertices.comenzar();
        while (!vertices.fin() && posicion2 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == destino) {
                posicion2 = verticeTemp.getPosicion();
            }
        }

        if (posicion1 != -1 && posicion2 != -1) {
            matryz[posicion1][posicion2] = null;
        }
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        int posicion1 = -1;
        int posicion2 = -1;

        vertices.comenzar();
        while (!vertices.fin() && posicion1 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == origen) {
                posicion1 = verticeTemp.getPosicion();
            }
        }

        vertices.comenzar();
        while (!vertices.fin() && posicion2 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == destino) {
                posicion2 = verticeTemp.getPosicion();
            }
        }

        if (posicion1 != -1 && posicion2 != -1) {
            if (matryz[posicion1][posicion2] != null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        int posicion1 = -1;
        int posicion2 = -1;

        vertices.comenzar();
        while (!vertices.fin() && posicion1 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == origen) {
                posicion1 = verticeTemp.getPosicion();
            }
        }

        vertices.comenzar();
        while (!vertices.fin() && posicion2 == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == destino) {
                posicion2 = verticeTemp.getPosicion();
            }
        }

        if (posicion1 != -1 && posicion2 != -1) {
            return matryz[posicion1][posicion2].peso();
        }

        return 0;
    }

    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {

        ListaGenerica<Arista<T>> aristaLista = new ListaEnlazadaGenerica<Arista<T>>();

        int posicion = -1;

        vertices.comenzar();
        while (!vertices.fin() && posicion == -1) {
            VerticeImplMatrizAdy<T> verticeTemp = (VerticeImplMatrizAdy<T>) vertices.proximo();
            if (verticeTemp == v) {
                posicion = verticeTemp.getPosicion();
            }
        }

        for (int comlumna = 0; comlumna >= tamaño; comlumna++) {
            if (matryz[comlumna][posicion] != null) {
                aristaLista.agregarFinal(matryz[comlumna][posicion]);
            }
        }
        return aristaLista;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return vertices.elemento(posicion);
    }
}
