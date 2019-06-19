package com.ipartek.formacion;

public abstract class ObjetoGrafico {

	public void mover(int x, int y) {
		System.out.println("Movemos el objeto a su nueva posicion");
	}
	
	public abstract void dibujar(); // Esto es un "prototipo" - > Metodo abstracto sin implementar
}
