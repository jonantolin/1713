package com.ipartek.formacion;

public class Alumno extends Person{

	private int numVecesElegido;
	
	public Alumno(String nombre) {
		super();
		setNombre(nombre);
		setNumVecesElegido(0);
	}
	
	
	public int getNumVecesElegido() {
		return numVecesElegido;
	}

	public void setNumVecesElegido(int numVecesElegido) {
		this.numVecesElegido = numVecesElegido;
	}
	
	
	
	
}
