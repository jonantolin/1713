package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		char caracter;
		
		System.out.println("Introduzca una letra: ");
		caracter = sc.next().charAt(0);
		
		if(Character.isLowerCase(caracter)) {
			System.out.println("Es una letra mayúscula");
		}else {
			System.out.println("No es una letra mayúscula");
		}
		
		
	}

}
