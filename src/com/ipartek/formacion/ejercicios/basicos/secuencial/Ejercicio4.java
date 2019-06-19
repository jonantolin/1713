package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float grados;
		
		System.out.println("Introduzca grados centígrados: ");
		grados = sc.nextFloat();
		
		// F = 32 + ( 9 * C / 5)
		
		float gradosFarenheit = 32 + ( 9 * grados / 5);
		
		System.out.println("Los "+grados+" grados centígrados son "+gradosFarenheit+" grados Farenheit.");
		
		sc.close();
	}

}
