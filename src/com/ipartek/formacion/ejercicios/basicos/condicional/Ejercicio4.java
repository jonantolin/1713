package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char a, b;
		
		System.out.println("Introduzca dos caracteres");
		
		System.out.println("Primer caracter: ");
		a = sc.next().charAt(0);
		
		System.out.println("Segundo caracter: ");
		b = sc.next().charAt(0);
		
		if(a == b) {
			System.out.println("Los caracteres "+a+" y "+b+" son iguales");
		}else {
			System.out.println("Los caracteres "+a+" y "+b+" no son iguales");
		}
	}

}
