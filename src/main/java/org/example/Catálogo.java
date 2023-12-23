package org.example;

import java.util.HashMap;

public class Catálogo {
	public Biblioteca biblioteca;
	public HashMap<String, Libro> libros = new HashMap<>();

	public void Buscar_libro() {
		throw new UnsupportedOperationException();
	}

	public Ejemplar getLibro(String titulo){
		Libro l = libros.get(titulo);
		if (l != null)
			return l.getEjemplar();
		return null;
	}
}