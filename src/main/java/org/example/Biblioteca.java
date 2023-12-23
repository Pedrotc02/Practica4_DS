package org.example;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;


public class Biblioteca {
	public HashMap<Integer, Usuario> usuarios = new HashMap<>();
	public Bibliotecario bibliotecario;
	public HashMap<Integer, Préstamo> prestamos = new HashMap<>();
	public Catálogo catalogo = new Catálogo();

	/**
	 * Método de devolución de un libro. Comprueba si la entrega se hace en fecha correcta, si no aplica una penalización
	 * al usuario
	 * @param idPrestamo: Identificación del préstamo a devolver
	 * @param idUsuario: Identificación del usuario que va a devolver el libro
	 */
	public void Devuelve_Libro(int idPrestamo, int idUsuario) {
		Préstamo presDevolver = prestamos.get(idPrestamo);
		Usuario usuarioDevuelve = usuarios.get(idUsuario);

		if (presDevolver == null || usuarioDevuelve == null)
			return;

		LocalDateTime fechaDevolucion = LocalDateTime.now();

		//Se comprueba si la fecha de devolución es posterior a la fecha máxima permitida de devolución, para aplicar penalización
		if(fechaDevolucion.isAfter(presDevolver._fechaTope)){
			usuarioDevuelve._unnamed_Ficha_socio_25.Añadir_penalización();
		}else{
			presDevolver._ejemplar.fichaEjemplar._estado = "Disponible";
		}

		presDevolver._ejemplar.fichaEjemplar.Comprobación_Libro(presDevolver._ejemplar.get_iD());
		usuarioDevuelve._unnamed_Ficha_socio_25.historial.Añadir_préstamo(presDevolver);
	}

	public Ejemplar getEjemplar(String idEjemplar){
		return catalogo.getLibro(idEjemplar);
	}

	public Usuario getUsuario(int id){
		return usuarios.get(id);
	}

	public void Coger_libro() {
		throw new UnsupportedOperationException();
	}
}