package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float num1, num2;

		System.out.println("Introduzca dos números");
		
		System.out.println("Numero 1: ");
		num1 = sc.nextFloat();
		
		System.out.println("Numero 2: ");
		num2 = sc.nextFloat();
		
		if(num2 == 0) {
			System.out.println("No se puede dividir entre 0");
		}else {
			System.out.println("La división es "+(num1/num2));
		}
		sc.close();

	}

}
