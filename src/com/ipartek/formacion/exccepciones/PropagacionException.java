package com.ipartek.formacion.exccepciones;

import com.ipartek.formacion.Perro;

public class PropagacionException {

	public static void main(String[] args) throws Exception {
		System.out.println("Comienza main");
		metodoA();
		System.out.println("Termina main");
	}
	
	
	private static void metodoA() throws Exception {
		System.out.println("Comienza método A");
		
		Perro p = new Perro();
		p.setEdad(-1);
		System.out.println(p);
		
		System.out.println("Termina método A");
	}
	

}
