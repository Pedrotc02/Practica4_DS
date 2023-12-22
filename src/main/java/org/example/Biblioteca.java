package org.example;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;


public class Biblioteca {
	public HashMap<Integer, Usuario> usuarios;
	public Bibliotecario bibliotecario;
	public HashMap<Integer, Préstamo> prestamos;
	public Catálogo catalogo;

	public void Devuelve_Libro(int idPrestamo, int idUsuario) {
		Préstamo presDevolver = prestamos.get(idPrestamo);
		Usuario usuarioDevuelve = usuarios.get(idUsuario);

		LocalDateTime fechaDevolucion = LocalDateTime.now();

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