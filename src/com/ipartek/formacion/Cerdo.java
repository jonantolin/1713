package com.ipartek.formacion;

public class Cerdo implements Ordenable{
	
	
	int peso;
	
	public Cerdo() {
		this.peso = 0;
	}
	
	public Cerdo(int peso) {
		this.peso = peso;
	}
	
	@Override
	public int getValor() {
		// TODO Auto-generated method stub
		return peso;
	}
	
}
