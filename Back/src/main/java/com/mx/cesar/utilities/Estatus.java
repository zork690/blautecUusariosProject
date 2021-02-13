package com.mx.cesar.utilities;

public enum Estatus {

	 ACTIVO(1),
	 DESACTIVADO(0);
	
	private int valor;
	
	Estatus(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
