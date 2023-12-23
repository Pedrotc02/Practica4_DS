package org.example;

import org.example.Biblioteca;

public class Bibliotecario extends Usuario {
	private int _idBibliotecario;
	public Biblioteca biblioteca = new Biblioteca();

	/**
	 * Método de denegación de un préstamo. Comprueba si hay alguna penalización vigente en el usuario que realiza el préstamo
	 * o si no hay ningún ejemplar disponible de ese libro
	 * @param titulo: Título del libro que se desea realizar el préstamo
	 * @param idUsuario: Identificador del usuario que realiza el préstamo
	 * @return true si la operación del préstamo es denegado, false si se puede realizar
	 */
	public Boolean Denegar_préstamo(String titulo, int idUsuario) {
		Ejemplar ejemplar = biblioteca.getEjemplar(titulo);
		//Se comprueba si existe el ejemplar en la biblioteca
		if(ejemplar == null){
			System.out.println("No hay ningún ejemplar de este libro disponible");
			return true;
		}
		Usuario usuario = biblioteca.getUsuario(idUsuario);
		//Se comprueba si el usuario existe en la biblioteca o si tiene alguna penalización vigente
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