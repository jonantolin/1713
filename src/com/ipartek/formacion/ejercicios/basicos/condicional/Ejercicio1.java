package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduzca un número: ");
		numero = sc.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("El número es par.");
		}else {
			System.out.println("El número es impar");
		}
		
		
	}

}
