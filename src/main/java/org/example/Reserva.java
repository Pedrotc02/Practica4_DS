package org.example;

public class Reserva {
	private Object _fecha;
	public Lector _lector2s;
	public Ejemplar _ejemplarS;

	public void setLector2s(Lector aLector2s) {
		this._lector2s = aLector2s;
	}

	public Lector getLector2s() {
		return this._lector2s;
	}

	public void setEjemplar2s(Ejemplar aEjemplarS) {
		this._ejemplarS = aEjemplarS;
	}

	public Ejemplar getEjemplar2s() {
		return this._ejemplarS;
	}
}