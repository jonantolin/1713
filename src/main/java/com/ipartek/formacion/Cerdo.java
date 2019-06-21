package com.ipartek.formacion;

public class Cerdo implements Ordenable{
	
	
	private int peso;
	private String nombre;
	
	public Cerdo() {
		this.peso = 0;
		this.nombre = "Sin nombre";
	}
	
	public Cerdo(int peso) {
		this.peso = peso;
	}
	
	public Cerdo(String nombre, int peso) {
		this.nombre = nombre;
		this.peso = peso;
	}
	
	
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	@Override
	public String toString() {
		return "Cerdo [peso=" + peso + ", nombre=" + nombre + "]";
	}

	@Override
	public int getValor() {
		// TODO Auto-generated method stub
		return this.peso;
	}
	
}
