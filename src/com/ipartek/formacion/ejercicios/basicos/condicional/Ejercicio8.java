package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1, num2, num3;

		System.out.println("Introduzca 3 números");

		System.out.println("Numero 1: ");
		num1 = sc.nextInt();

		System.out.println("Numero 2: ");
		num2 = sc.nextInt();
		
		System.out.println("Numero 3: ");
		num3 = sc.nextInt();
		
		if(num1 > num2 && num1 > num3) {
			System.out.println(num3+ " Es el numero mayor de los 3");
		}else if(num2 > num3) {
			System.out.println(num2+ " Es el mayor número de los 3");
		}else {
			System.out.println(num3+ " Es el mayor número de los 3");
		}

	}

}
