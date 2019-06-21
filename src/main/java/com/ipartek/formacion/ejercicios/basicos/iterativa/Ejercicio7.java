package com.ipartek.formacion.ejercicios.basicos.iterativa;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numero, numero2;
		
		System.out.println("Introduzca numero: ");
		numero = sc.nextInt();
		
		do {
			System.out.print(" " + numero);
			numero++;
		}while(numero >= 0);
		
		System.out.println("-----");
		
		while(numero <= 100) {
			System.out.print(" " + numero);
			numero++;
		}
		
		System.out.println("-----");
		
		for (int i = 0; i <= numero; i++) {
			System.out.print(" " + i);
		}
		
		System.out.println("Introduzca numero: ");
		numero2 = sc.nextInt();
		
		do {
			System.out.print(" " + numero2);
			numero2--;
		}while(numero2 >= 0);
		
		System.out.println("-----");
		
		while(numero2 >= 0) {
			System.out.print(" " + numero2);
			numero2--;
		}
		
		System.out.println("-----");
		
		/*for (numero2; numero2 >= 1; numero2--) {
			System.out.print(" " + numero2);
		}*/
		sc.close();
	}

}
