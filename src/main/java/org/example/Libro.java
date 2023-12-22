package org.example;

import java.util.Vector;

public class Libro {
	private Object _título;
	private Object _autores;
	private Object _año;
	private Object _iSBN;
	private Object _páginas;
	private Object _género;
	public Catálogo catalogo;
	public Vector<Ejemplar> ejemplares = new Vector<Ejemplar>();

	public Ejemplar getEjemplar(){
		for (Ejemplar e: ejemplares){
			if (e.fichaEjemplar._estado == "Disponible"){
				return e;
			}
		}
		return null;
	}
}