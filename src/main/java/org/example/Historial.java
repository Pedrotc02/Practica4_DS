package org.example;

import java.util.HashMap;

public class Historial {
	private int _iD;
	public Ficha_socio fichaSocio;
	public HashMap<Integer, Préstamo> _prestamos = new HashMap<>();
	public Compra compra;

	public void Añadir_compra() {
		throw new UnsupportedOperationException();
	}

	public void Añadir_préstamo(Préstamo prestamo) {
		_prestamos.put(prestamo.get_iD(), prestamo);
	}
}