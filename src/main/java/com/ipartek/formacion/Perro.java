package com.ipartek.formacion;

import java.io.Serializable;

public class Perro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int edad;
	protected String raza;
	protected boolean vacunado;
	
	public Perro() {
		
		nombre = "Sin nombre";
		raza = "Cruce";
		edad = 0;
		vacunado = false;
	}
	
	public Perro(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Perro(String nombre, int edad, String raza, boolean vacunado) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.vacunado = vacunado;
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {

			return edad;	
	}
	/**
	 * 
	 * @param edad
	 * @throws Exception Edad menor que 0
	 */
	public void setEdad(int edad) throws Exception {
		if(edad < 0) {
			// this.edad = 0;
			throw new PerroException(PerroException.ERROR_EDAD);
		}else {
			this.edad = edad;
		}
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean isVacunado() { // Con booleanos es "isVariable" en vez de "getVariable"
		return vacunado;
	}
	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}
	
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", vacunado=" + vacunado + "]";
	}
	
	
	
}
