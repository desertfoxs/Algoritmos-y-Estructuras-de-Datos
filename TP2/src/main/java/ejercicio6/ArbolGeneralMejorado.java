package ejercicio6;

import claseUtilizar.ArbolGeneral;
import claseUtilizar.ColaGenerica;
import claseUtilizar.ListaEnlazadaGenerica;
import claseUtilizar.ListaGenerica;
import ejercicio4.AreaEmpresa;

public class ArbolGeneralMejorado<T> {

	private T dato;

	private static boolean nivelEncontrado;
	private static boolean nodoAEncontrado;
	private static boolean nodoBEncontrado;

	private static int cantHijos;
	private static boolean encontroHijo;
	private ListaGenerica<ArbolGeneralMejorado<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneralMejorado<T>>();
	private static boolean guardoHijo;


	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneralMejorado<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneralMejorado<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneralMejorado(T dato) {
		this.dato = dato;
	}

	public ArbolGeneralMejorado(T dato, ListaGenerica<ArbolGeneralMejorado<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneralMejorado<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneralMejorado<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneralMejorado<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneralMejorado<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneralMejorado<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}


	public Integer altura() {
		hijos.comenzar();
		return procesarAltura();
	}

	private int procesarAltura() {
		int altura = 0;

		if(hijos.esVacia()){
			return 0;
		}

		while(!(hijos.fin())){
			ArbolGeneralMejorado<T> arbolNodo = hijos.proximo();

			int alturaHijo = arbolNodo.procesarAltura();
			if(alturaHijo > altura){
				altura = alturaHijo;
			}
		}

		return altura + 1;
	}

	public Integer nivel(T dato) {

		hijos.comenzar();
		nivelEncontrado = false;
		int alturaProcesada = procesarNivel(dato);

		if(!nivelEncontrado){
			return -1;
		}
		else {
			return alturaProcesada;
		}


	}

	private int procesarNivel(T dato) {
		int nivel = 0;

		if(this.dato == dato){
			nivelEncontrado = true;
			return nivel;
		}

		while(!(hijos.fin()) && !nivelEncontrado){
			ArbolGeneralMejorado<T> arbolNodo = hijos.proximo();
			 nivel = arbolNodo.procesarNivel(dato);
		}

		return nivel + 1;
	}

	public Integer ancho() {

		ListaGenerica<T> listaInNivel = new ListaEnlazadaGenerica<T>();
		listaInNivel = recorridoPorNiveles(this);

		int contador = 0;
		int contadorMayor = 0;

		while(!(listaInNivel.fin())){

			T dato = listaInNivel.proximo();

			if(dato != null){
				contador++;
			}
			else {
				if(contadorMayor < contador){
					contadorMayor = contador;
					contador = 0;
				}
			}

		}

		return contadorMayor;
	}

	public Boolean esAncestro(T a, T b){
		hijos.comenzar();
		nodoAEncontrado = false;
		ArbolGeneralMejorado<T> arbolA = buscarNodo(a);

		if(arbolA == null){
			return false;
		}

		nodoBEncontrado = false;
		return arbolA.contiene(b);

	}

	private Boolean contiene(T b) {

		if(this.dato.equals(b)){
			nodoBEncontrado = true;
			return true;
		}

		while(!(hijos.fin()) && !nodoBEncontrado){
			hijos.proximo().contiene(b);
		}

		if(nodoBEncontrado){
			return true;
		}
		else{
			return false;
		}

	}

	private ArbolGeneralMejorado<T> buscarNodo(T a) {

		ArbolGeneralMejorado<T> nodo = null;

		if(this.dato.equals(a)){
			nodoAEncontrado = true;
			return this;
		}

		while(!(hijos.fin()) && !nodoAEncontrado){
			nodo = hijos.proximo().buscarNodo(a);
		}

		if(nodoAEncontrado){
			return nodo;
		}
		else{
			return null;
		}
	}

	public Boolean esArbolLleno(){

		int altura = altura();
		int numHijos = hijos.tamanio();
		hijos.comenzar();
		return procesarArbolLleno(0, altura, numHijos);
	}

	private Boolean procesarArbolLleno(int nivelActual, int altura, int numHijos) {

		if (this.hijos.esVacia()){
            return nivelActual == altura - 1;
		}

		if(this.hijos.tamanio() != numHijos){
			return false;
		}

		while(!(this.hijos.fin())){
			if(!hijos.proximo().procesarArbolLleno(nivelActual + 1, altura, numHijos)){
				return false;
			}
		}
		return true;
	}

	public Boolean esArbolCompleto(){

		if(procesarArbolCompletoMenosHijos(0)){
			return procesarArbolCompletoConHijos(this);
		}

        return false;
	}

	private Boolean procesarArbolCompletoConHijos(ArbolGeneralMejorado<T> arbol) {

		ListaGenerica<ArbolGeneralMejorado<T>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneralMejorado<T>>();
		listaHijos = arbol.hijos;
		listaHijos.comenzar();

		if(listaHijos.esVacia()){
			encontroHijo = true;
			return true;
		}

		while(!(listaHijos.fin())){
			ArbolGeneralMejorado<T> arbolNodo = listaHijos.proximo();
			procesarArbolCompletoConHijos(arbolNodo);

			if(encontroHijo && !guardoHijo){
				cantHijos = arbol.hijos.tamanio();
				guardoHijo = true;
				encontroHijo = false;
			}

			if(encontroHijo && guardoHijo){
				if(cantHijos > arbol.hijos.tamanio()){
					return false;
				}
				if((cantHijos > arbol.hijos.tamanio())){
					//CONTINUAR DESPUES
					return true;
				}
			}

		}


		return false;
	}

	private boolean procesarArbolCompletoMenosHijos(int nivel) {
		ListaGenerica<T> listaPorNivel = new ListaEnlazadaGenerica<T>();
		ListaGenerica<T> listaInNivel = new ListaEnlazadaGenerica<T>();
		int cantHijos = 1;
		int cantHijosAux;
		listaInNivel = recorridoPorNiveles(this);
		listaInNivel.comenzar();

		while(!(listaInNivel.fin())){
			T dato = listaInNivel.proximo();

			if(dato == null){
				cantHijosAux = listaPorNivel.tamanio();

				if(cantHijos * cantHijos == cantHijosAux || nivel == 1){
					cantHijos = cantHijosAux;
				}
				else{
					if(listaInNivel.proximo() == null){
						return true; // esto esta bien porque esta parado sobre el nivel de hojas
					}
					else{
						return false; // esto esta mal porque no esta lleno
					}
				}
				vaciarLista(listaPorNivel);
				nivel++;
			}

			listaPorNivel.agregarFinal(dato);


		}

		return false;

    }

	private void vaciarLista(ListaGenerica<T> lista) {

		int i = 0;

		while(!lista.esVacia()){
			lista.eliminarEn(lista.tamanio() - i);
			i++;
		}

	}


	//--------------------------RECORRIDOS------------------------------

	private ListaGenerica<T> recorridoPorNiveles(ArbolGeneralMejorado<T> arbol){
		ListaGenerica<T> listaResultado = new ListaEnlazadaGenerica<T>();
		ColaGenerica<ArbolGeneralMejorado<T>> cola = new ColaGenerica<ArbolGeneralMejorado<T>>();
		ColaGenerica<ArbolGeneralMejorado<T>> colaAux = new ColaGenerica<ArbolGeneralMejorado<T>>();

		ArbolGeneralMejorado<T> arbolAux = null;

		cola.encolar(arbol);
		cola.encolar(null);

		while(!cola.esVacia()){
			arbolAux = cola.desencolar();
			if(!(arbolAux == null)){
				listaResultado.agregarFinal(arbolAux.getDato());
			}
			else{
				listaResultado.agregarFinal(null);
			}

			if(!(arbolAux == null)) {
				if (arbolAux.tieneHijos()) {
					encolarHijos(arbolAux, colaAux);
				}
			}

			if(cola.tope() == null){
				encolarColaConCola(cola, colaAux);
				cola.encolar(null);
			}

			if(listaResultado.elemento(listaResultado.tamanio()) == null && listaResultado.elemento(listaResultado.tamanio() - 1) == null){
				return listaResultado;
			}
		}

		return listaResultado;
	}

	private void encolarColaConCola(ColaGenerica<ArbolGeneralMejorado<T>> cola, ColaGenerica<ArbolGeneralMejorado<T>> colaAux) {
		while(!colaAux.esVacia()){
			cola.encolar(colaAux.desencolar());
		}
	}

	private void encolarHijos(ArbolGeneralMejorado<T> arbol, ColaGenerica<ArbolGeneralMejorado<T>> cola) {
		ListaGenerica<ArbolGeneralMejorado<T>> listaHijos = new ListaEnlazadaGenerica<ArbolGeneralMejorado<T>>();

		listaHijos = arbol.getHijos();
		listaHijos.comenzar();

		while(!listaHijos.fin()){
			cola.encolar(listaHijos.proximo());
		}
	}

}