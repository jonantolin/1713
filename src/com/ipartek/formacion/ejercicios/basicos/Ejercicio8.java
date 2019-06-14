package com.ipartek.formacion.ejercicios.basicos;


/**
 * 
 * @author Jon Antolin Gonzalez
 *
 */
public class Ejercicio8 {
	
	/* Uso del condicional "? : "
	 * Muestra si una entero A es par o impar
	 *  
	 *  */
	public static void main(String[] args) {
		
		int a = 15;
		int b= 14;
		
		System.out.println("Ejercicio 8");
		
		System.out.println(a + ((a % 2 == 0) ? " Es un número par." : " Es un número impar."));
		
		System.out.println(b + ((b % 2 == 0) ? " Es un número par." : " Es un número impar."));
		
		System.out.printf("El número %s es %s", b, (b % 2 == 0) ? " Es un número par." : " Es un número impar.");
		
		float numero = 3.142726327f;
		
		System.out.printf("numero %f con 2 decimales %.2f", numero, numero);
		
	}

}
