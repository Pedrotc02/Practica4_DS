package org.example;

import java.util.HashMap;

public class Historial {
	private int _iD;
	public Ficha_socio _unnamed_Ficha_socio_20;
	public HashMap<Integer, Préstamo> _prestamos;
	public Compra compra;

	public void Añadir_compra() {
		throw new UnsupportedOperationException();
	}

	public void Añadir_préstamo(Préstamo prestamo) {
		_prestamos.put(prestamo.get_iD(), prestamo);
	}
}