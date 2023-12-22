package org.example;

import org.example.Biblioteca;

public class Bibliotecario extends Usuario {
	private int _idBibliotecario;
	public Biblioteca biblioteca;

	public Boolean Denegar_préstamo(String titulo, int idUsuario) {
		Ejemplar ejemplar = biblioteca.getEjemplar(titulo);
		if(ejemplar == null){
			System.out.println("No hay ningún ejemplar de este libro disponible");
			return true;
		}
		Usuario usuario = biblioteca.getUsuario(idUsuario);
		if(usuario == null || usuario._unnamed_Ficha_socio_25.get_estado() == "Penalizado"){
			System.out.println("El usuario está penalizado");
			return true;
		}
		return false;
	}

	public void Aceptar_préstamo() {
		throw new UnsupportedOperationException();
	}
}