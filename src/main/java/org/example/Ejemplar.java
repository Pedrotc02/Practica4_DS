package org.example;

import java.util.Vector;

public class Ejemplar {
	private int _iD;
	private Object _idInventario;
	private Object _fechaCompra;
	private Object _estado;
	private Object _precio;
	public Libro _unnamed_Libro2_;
	public Vector<Reserva> reservas = new Vector<Reserva>();
	public Vector<Préstamo> prestamos = new Vector<Préstamo>();
	public Ficha_ejemplar fichaEjemplar;

	public int get_iD() {
		return _iD;
	}
}