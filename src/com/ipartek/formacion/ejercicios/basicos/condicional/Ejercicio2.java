package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numero;
		
		System.out.println("Introduzca un n�mero: ");
		numero = sc.nextInt();
		
		if(numero % 10 == 0) {
			System.out.println("Es un m�ltiplo de 10.");
		}else {
			System.out.println("No es un m�ltiplo de 10.");
		}

	}

}
