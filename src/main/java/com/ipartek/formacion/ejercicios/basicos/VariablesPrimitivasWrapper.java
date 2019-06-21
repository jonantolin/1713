package com.ipartek.formacion.ejercicios.basicos;

import java.util.Scanner;

/**
 * @see http://www.campus.formacion.ipartek.com/moodle/mod/page/view.php?id=882
 * @author Curso
 *
 */
public class VariablesPrimitivasWrapper {

	public static void main(String[] args) {
		
		// declarar todas los posibles tipos primitivos
		
		// números enteros
		/*
		byte b = 2;
		short s = 4;
		int i = 0;
		long l = 8;
		
		
		// numeros reales o con decimales
		
		float f = 2.34f;
		double lo = 4.56;
		
		
		// otros
		
		char c = 'a'; // Se usan comillas simples
		boolean b1 = true; // or false
		
		*/
		// Clases Wrapper 
		
		int numeroParseado = Integer.parseInt("3"); //Devuelve un String como entero 
		
		System.out.println(numeroParseado);
		
		System.out.printf("El rango de un int %d %d \n\n\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		// Indicar si el caracter introducido es mayusculas o minusculas
		// Letra o numero
		
		
		
		
		System.out.println("Por favor introduce un caracter: ");
		
		Scanner teclado = new Scanner(System.in);
		
		char caracterIntroducido = teclado.next().charAt(0);
		
		System.out.println("Has escrito "+ caracterIntroducido);
		
		teclado.close();
		
		if(Character.isLetterOrDigit(caracterIntroducido)) {
			
			if(Character.isDigit(caracterIntroducido)) {
				System.out.println("El caracter introducido "+caracterIntroducido+" es un número");
			}else {
				if(Character.isUpperCase(caracterIntroducido)) {
					System.out.println("El caracter introducido "+caracterIntroducido+" Es una letra mayúscula");
				}else {
					System.out.println("El caracter introducido "+caracterIntroducido+" Es una letra minúscula");
				}
				
			}
		}else {
			System.out.println("El caracter introducido "+caracterIntroducido+" No es una letra ni un número");
		}

	}

}
