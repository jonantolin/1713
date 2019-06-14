package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre;
		
		System.out.println("Introduzca nombre: ");
		nombre = teclado.next();
		
		System.out.println("Buenos días "+nombre);
	}

}
