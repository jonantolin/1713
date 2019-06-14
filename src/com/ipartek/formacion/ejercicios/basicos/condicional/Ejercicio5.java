package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char caracter1, caracter2;

		System.out.println("Introduzca una letra: ");
		caracter1 = sc.next().charAt(0);
		
		System.out.println("Introduzca una letra: ");
		caracter2 = sc.next().charAt(0);
		
		if(Character.isLowerCase(caracter1)) {
			System.out.println(caracter1+ " Es una letra minúscula");
		}else {
			System.out.println(caracter1+" No es una letra minúscula");
		}
		
		if(Character.isLowerCase(caracter2)) {
			System.out.println(caracter2+ " Es una letra minúscula");
		}else {
			System.out.println(caracter2+" No es una letra minúscula");
		}
	}

}
