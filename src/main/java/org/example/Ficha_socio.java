package org.example;

public class Ficha_socio {
	private int _iD;
	private Object _idSocio;
	private String _estado;
	public Usuario usuario;
	public Historial historial;

	public void Comprobar_usuario() {
		throw new UnsupportedOperationException();
	}

	public void Añadir_penalización() {
		_estado = "Penalizado";
	}

	public String get_estado(){return _estado;}

	public void set_estado(String e){ _estado = e; }

	public void Dar_de_baja() {
		throw new UnsupportedOperationException();
	}

	public void Modificar_ficha() {
		throw new UnsupportedOperationException();
	}
}