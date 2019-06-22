package com.ipartek.formacion;

public class Alumno extends Person implements Comparable<Alumno>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numVecesElegido=0;
	
	public Alumno(String nombre) {
		super();
		setNombre(nombre);
		setNumVecesElegido(0);
	}
	
	public Alumno(int id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
		setNumVecesElegido(0);
	}
	
	
	public int getNumVecesElegido() {
		return numVecesElegido;
	}

	public void setNumVecesElegido(int numVecesElegido) {
		this.numVecesElegido = numVecesElegido;
	}


	@Override
	public int compareTo(Alumno o) {
		
		return o.getNumVecesElegido() - this.getNumVecesElegido();
	}
	
	
	
	
}
