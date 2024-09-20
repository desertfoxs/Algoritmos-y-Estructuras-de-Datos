package clasesBrindadas.tp03abb;

import clasesBrindadas.tp01.ListaEnlazadaGenerica;
import clasesBrindadas.tp01.ListaGenerica;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
	private T dato;
	private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
	private ArbolBinarioDeBusqueda<T> hijoDerecho;
	private boolean encontroNodo;
	private ListaEnlazadaGenerica<T> listaDatosMayores;
	private ListaGenerica<Integer> listaNumeros;
	private boolean datoEncontrado;

	public ArbolBinarioDeBusqueda() {
		super();
	}
	public ArbolBinarioDeBusqueda(T dato) {
		this.dato = dato;
	}

	//---------------------------------------------------------------------
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() { return this.hijoDerecho; }
	
	private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoIzquierdo = hijo;

	}

	private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoDerecho = hijo;

	}

	public boolean incluye (Comparable<T> dato){
		return this.buscar(dato, this) != null;
	}
	 
	
	public ArbolBinarioDeBusqueda<T> buscar (Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol){
		if (arbol != null) {
			if (x.compareTo(arbol.getDato()) < 0) {
				arbol = this.buscar(x, arbol.getHijoIzquierdo());
			} else if (x.compareTo(arbol.getDato()) > 0) {
				arbol = this.buscar(x, arbol.getHijoDerecho());
			} else
				; // Se encontro el dato, asi que es arbol
			return arbol;
		} else {
			return null;
		}
	}
	 
	public void agregar (Comparable<T> dato){

		agregar(dato, this);

	} 
	
	private void agregar (Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol){

		if(arbol.esHoja()){
			ArbolBinarioDeBusqueda<T> arbolNuevo = new ArbolBinarioDeBusqueda<T>((T) dato);

			if( (arbol.getDato().compareTo((T) dato)) > 0 ){
				arbol.setHijoIzquierdo(arbolNuevo);
			}

			if(((arbol.getDato().compareTo((T) dato)) < 0) || ((arbol.getDato().compareTo((T) dato)) == 0)){
				arbol.setHijoDerecho(arbolNuevo);
			}

			return;
		}

		if((arbol.getDato().compareTo((T) dato)) > 0){
			if(arbol.tieneHijoIzquierdo()){
				agregar(dato, arbol.getHijoIzquierdo());
			}
			else{
				ArbolBinarioDeBusqueda<T> arbolNuevo = new ArbolBinarioDeBusqueda<T>((T) dato);
				arbol.setHijoIzquierdo(arbolNuevo);
			}
		}

		if(((arbol.getDato().compareTo((T) dato)) < 0) || ((arbol.getDato().compareTo((T) dato)) == 0)){
			if(arbol.tieneHijoDerecho()){
				agregar(dato, arbol.getHijoDerecho());
			}
			else{
				ArbolBinarioDeBusqueda<T> arbolNuevo = new ArbolBinarioDeBusqueda<T>((T) dato);
				arbol.setHijoDerecho(arbolNuevo);
			}
		}
		
	} 
	
	public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores (ArbolBinarioDeBusqueda<T> arbol) {
		//re veer esto
		T datoMayor = null;

		listaDatosMayores = new ListaEnlazadaGenerica<T>();
		listaNodos(arbol.getHijoIzquierdo());
		listaDatosMayores.comenzar();

		datoMayor = listaDatosMayores.proximo();
		while(!listaDatosMayores.fin()){

			T datoAux = listaDatosMayores.proximo();
			if(datoMayor.compareTo(datoAux) < 0){
				datoMayor = datoAux;
			}
		}

		return arbol.buscar(datoMayor, arbol);
	}

	private void listaNodos(ArbolBinarioDeBusqueda<T> arbol) {
		listaDatosMayores.agregarFinal(arbol.getDato());

		if(arbol.tieneHijoIzquierdo()){
			buscarMayorDeLosMenores(arbol.getHijoIzquierdo());
		}

		if(arbol.tieneHijoDerecho()){
			buscarMayorDeLosMenores(arbol.getHijoDerecho());
		}

	}

	public ArbolBinarioDeBusqueda<T> buscarMayor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	//--------------- EJERCICIO 9 -------------------

	public ListaEnlazadaGenerica<Integer> caminoRecorrido (ArbolBinarioDeBusqueda<Integer> arbol){

		listaNumeros = new ListaEnlazadaGenerica<Integer>();
		listaNumeros.comenzar();
		datoEncontrado = false;

		recorrerArbol((T) arbol.getDato(), this);

		if(datoEncontrado){
			return (ListaEnlazadaGenerica<Integer>) listaNumeros;
		}
		else{
			listaNumeros.agregarFinal(-1);
			return (ListaEnlazadaGenerica<Integer>) listaNumeros;
		}

	}

	private void recorrerArbol(T dato, ArbolBinarioDeBusqueda<T> tArbol) {

		if(dato == tArbol.dato){
			datoEncontrado = true;
			return;
		}

		if(tArbol.tieneHijoIzquierdo() && !datoEncontrado){
			recorrerArbol(dato, tArbol.getHijoIzquierdo());

			if(datoEncontrado){
				listaNumeros.agregarFinal(-(Integer) tArbol.getDato());
			}

		}

		if(tArbol.tieneHijoDerecho() && !datoEncontrado){
			recorrerArbol(dato, tArbol.getHijoDerecho());

			if(datoEncontrado){
				listaNumeros.agregarFinal((Integer) tArbol.getDato());
			}

		}

	}


	//preguntar si se puede hacer esto

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public boolean eliminarElemento(Comparable<T> dato) {

		ArbolBinarioDeBusqueda<T> arbol = buscar(dato, this);
		encontroNodo = false;

		if(arbol != null){
			if(arbol.esHoja()){
				eliminarHoja(dato, this);
				return true;
			}
			if(!arbol.tieneHijoIzquierdo()){
				ArbolBinarioDeBusqueda<T> arbolDer = arbol.getHijoDerecho();

				arbol.setHijoDerecho(arbolDer.getHijoDerecho());
				arbol.setHijoIzquierdo(arbolDer.getHijoIzquierdo());
				arbol.setDato(arbolDer.getDato());
				return true;
			}
			if(!arbol.tieneHijoDerecho()){
				ArbolBinarioDeBusqueda<T> arbolIzq = arbol.getHijoIzquierdo();

				arbol.setHijoDerecho(arbolIzq.getHijoDerecho());
				arbol.setHijoIzquierdo(arbolIzq.getHijoIzquierdo());
				arbol.setDato(arbolIzq.getDato());
				return true;
			}

			//solucionar el problema de que el nodo que remplaza el verdadero sigue existiendo
			ArbolBinarioDeBusqueda<T> arbolMayorIzq = arbol.buscarMayorDeLosMenores(arbol);
			arbol.setDato(arbolMayorIzq.getDato());
			arbolMayorIzq.setDato(null);
		}

		return false;
	}

	private void eliminarHoja(Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {

		if(arbol.getDato().compareTo((T) dato) == 0){
			arbol.setDato(null);
			return;
		}

		if(this.getDato().compareTo((T) dato) > 0  && !encontroNodo){
			if(arbol.tieneHijoIzquierdo()){
				eliminarHoja(dato, arbol.getHijoIzquierdo());
				arbol.setHijoIzquierdo(null);
				encontroNodo = true;
			}
		}

		if(this.getDato().compareTo((T) dato) < 0 && !encontroNodo){
			if(arbol.tieneHijoDerecho()){
				eliminarHoja(dato, arbol.getHijoDerecho());
				arbol.setHijoDerecho(null);
				encontroNodo = true;
			}
		}

		if(encontroNodo){
			return;
		}

	}
}
