package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Introduzca dos números");
		
		num1 = teclado.nextInt();
		num2 = teclado.nextInt();
		
		System.out.println("Has introducido "+num1+" y "+num2);
		
		teclado.close();
	}

}
