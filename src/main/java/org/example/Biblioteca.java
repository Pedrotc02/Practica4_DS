package org.example;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;


public class Biblioteca {
	public Usuario usuario;
	public Bibliotecario bibliotecario;
	public HashMap prestamo;
	public Catálogo catalogo;

	public void Devuelve_Libro(int idPrestamo) {
		LocalDateTime fechaDevolucion = prestamo._fechaDev;


		if(fechaDevolucion.isAfter(prestamo._fechaTope)){
			usuario._unnamed_Ficha_socio_25.Añadir_penalización();
		}else{
			prestamo._ejemplar._unnamed_Ficha_ejemplar2_17._estado = "Disponible";
		}

		prestamo._fechaDev = LocalDateTime.now();
		prestamo._ejemplar._unnamed_Ficha_ejemplar2_17.Comprobación_Libro();
		usuario._unnamed_Ficha_socio_25._unnamed_Historial2_19.Añadir_préstamo();

	}

	public void Coger_libro() {
		throw new UnsupportedOperationException();
	}
}