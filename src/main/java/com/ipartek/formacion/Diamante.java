package com.ipartek.formacion;

public class Diamante implements Ordenable{

	private int kilates;
	private String color;
	
	public Diamante() {
		this.kilates = 0;
	}
	
	public Diamante(int kilates) {
		this.kilates = kilates;
	}
	
	public Diamante(String color, int kilates) {
		this.color = color;
		this.kilates = kilates;
	}
	
	
	
	public int getKilates() {
		return kilates;
	}

	public void setKilates(int kilates) {
		this.kilates = kilates;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	@Override
	public String toString() {
		return "Diamante [kilates=" + kilates + ", color=" + color + "]";
	}

	@Override
	public int getValor() {
		
		return this.kilates;
	}
}
