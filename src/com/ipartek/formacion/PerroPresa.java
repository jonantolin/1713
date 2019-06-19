package com.ipartek.formacion;

public class PerroPresa extends Perro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ataque;
	
	public PerroPresa() {
		super();
		ataque = 50;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	/**
	 * 
	 * @param ataque determina los puntos de ataque
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/**
	 * Un método que sirve para atacar
	 */
	public void atacar() {
		System.out.println("Mordedura de "+ataque+" puntos de ataque.");
	}

	@Override
	public String toString() {
		return "PerroPresa [ataque=" + ataque + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza
				+ ", vacunado=" + vacunado + "]";
	}

	
	
	
	
	
	
}
