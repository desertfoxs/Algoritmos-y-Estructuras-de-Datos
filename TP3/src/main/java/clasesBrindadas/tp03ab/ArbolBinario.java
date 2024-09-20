package clasesBrindadas.tp03ab;

import clasesBrindadas.tp01.ColaGenerica;
import clasesBrindadas.tp01.ListaEnlazadaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	//modulos nuevos!

	public int contarHojas() {
		int numHojas = procesadorContadorHojas(0);
		return numHojas;

	}

	private int procesadorContadorHojas(int cant) {

		if(esHoja()){
			return cant + 1;
		}
		if(tieneHijoIzquierdo()){
			cant = this.getHijoIzquierdo().procesadorContadorHojas(cant);
		}
		if(tieneHijoDerecho()){
			cant = this.getHijoDerecho().procesadorContadorHojas(cant);
		}

		return cant;
	}


	public ArbolBinario<T> espejo() {


		return voltearArbol(this);

	}

	private ArbolBinario<T> voltearArbol(ArbolBinario<T> arbol) {

		if(esHoja()){
			return null;
		}

		if(tieneHijoIzquierdo()){
			arbol.getHijoIzquierdo().voltearArbol(arbol.getHijoIzquierdo());
			if(!tieneHijoDerecho()){
				hijoDerecho = hijoIzquierdo;
				hijoIzquierdo = null;
			}
		}
		if(tieneHijoDerecho()){
			arbol.getHijoDerecho().voltearArbol(arbol.getHijoDerecho());
			ArbolBinario<T> aux = hijoIzquierdo;
			hijoIzquierdo = hijoDerecho;
			hijoDerecho = aux;
		}

		return arbol;
	}


	public void entreNiveles(int n, int m){

		int contadorNivel = 0;

		ListaEnlazadaGenerica<T> lista = recorridoNiveles(this);
		lista = recorridoNiveles(this);
		lista.comenzar();

		while(!lista.fin()){
			T dato = lista.proximo();

			if(contadorNivel >= n && contadorNivel <= m){
				System.out.println(dato);
			}
			if(dato == null){
				contadorNivel++;
			}
		}
	}

	private ListaEnlazadaGenerica<T> recorridoNiveles(ArbolBinario<T> arbol) {

		ListaEnlazadaGenerica<T> listaResultado = new ListaEnlazadaGenerica<T>();
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		ColaGenerica<ArbolBinario<T>> colaAux = new ColaGenerica<ArbolBinario<T>>();

		ArbolBinario<T> arbolAux = null;

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
				if (arbolAux.tieneHijoDerecho()) {
					colaAux.encolar(arbolAux.getHijoDerecho());

				}
				if (arbolAux.tieneHijoIzquierdo()){
					colaAux.encolar(arbolAux.getHijoIzquierdo());
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

	private void encolarColaConCola(ColaGenerica<ArbolBinario<T>> cola, ColaGenerica<ArbolBinario<T>> colaAux) {
		while(!colaAux.esVacia()){
			cola.encolar(colaAux.desencolar());
		}
	}
}
