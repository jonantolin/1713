package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char caracter;

		System.out.println("Introduzca una letra: ");
		caracter = sc.next().charAt(0);
		
		if(Character.isDigit(caracter)) {
			System.out.println("Es un número");
		}else {
			System.out.println("No es un número");
		}
		
		sc.close();
	}

}
