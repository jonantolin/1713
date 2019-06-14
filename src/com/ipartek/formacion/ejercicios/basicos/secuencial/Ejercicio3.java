package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduzca un número: ");
		numero = sc.nextInt();
		
		System.out.println("Ha introducido "+numero+" \nEl dobre es: "+(numero*2)+
				"\nEl triple es: "+(numero*3));
		
		
	}

}
