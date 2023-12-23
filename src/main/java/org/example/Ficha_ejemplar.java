package org.example;

public class Ficha_ejemplar {
	private int _iD;
	private Object _idFicha;
	public Object _estado = new String();
	public Ejemplar ejemplar;

	public Boolean Comprobación_Libro(int id) {
		if (id == _iD){
			return true;
		}
		return false;
	}
}